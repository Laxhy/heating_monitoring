package eu.laxhy.heating.monitoring.influxdb;

import eu.laxhy.heating.monitoring.service.Tariff;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Point.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

/**
 * Created by Libor Laichmann.
 */
@Service
public class InfluxDbStorageEngine {

  @Autowired
  private InfluxDbConnection connection;

  public void store(Object object) throws IllegalAccessException {
    final SinglePoint annotationSinglePoint = AnnotationUtils.findAnnotation(object.getClass(), SinglePoint.class);

    if (annotationSinglePoint != null) {
      String measurement = annotationSinglePoint.measurement().isEmpty() ? object.getClass().getSimpleName() : annotationSinglePoint.measurement();
      Map<String, String> tags = getTags(object);
      Map<String, Object> values = getValues(object);
      Point influxPoint = getInfluxPoint(measurement, tags, values);
      connection.write(influxPoint);

    } else {
      final MultiPoint annotationMultiPoint = AnnotationUtils.findAnnotation(object.getClass(), MultiPoint.class);
      if (annotationMultiPoint != null) {
        BatchPoints batchPoints = BatchPoints.database(connection.getDatabase()).retentionPolicy(connection.getRetentionPolicy()).build();
        String measurement = annotationMultiPoint.value().isEmpty() ? object.getClass().getSimpleName() : annotationMultiPoint.value();
        Map<String, String> tags = getTags(object);
        Map<String, Object> values = getValues(object);
        Map<String, Object> points = getPoints(object);
        for (String discriminant : points.keySet()) {
          batchPoints.point((getInfluxPoint(annotationMultiPoint.discriminantName(), discriminant, annotationMultiPoint.pointValueName(), points.get(discriminant), measurement, tags, values)));
        }
        connection.write(batchPoints);
      } else {
        throw new UnsupportedOperationException("Object not annotated by Inlfux DB annotations.");
      }
    }
  }

  private Builder addTags(final Builder builder, final Map<String, String> tags) {
    for (String tagName : tags.keySet()) {
      builder.tag(tagName, tags.get(tagName));
    }
    return builder;
  }

  private Builder addValues(Builder builder, Map<String, Object> values) {
    for (String valueName : values.keySet()) {
      if (values.get(valueName) != null) {
        if (values.get(valueName) instanceof Long) {
          builder.addField(valueName, ((Long) values.get(valueName)).longValue());
        } else if (values.get(valueName) instanceof Boolean) {
          // fixed problem with interpret in the grafana
          builder.addField(valueName, ((Boolean) values.get(valueName)).booleanValue() ? 1 : 0);
        } else if (values.get(valueName) instanceof Double) {
          builder.addField(valueName, ((Double) values.get(valueName)).doubleValue());
        } else if (values.get(valueName) instanceof Integer) {
          builder.addField(valueName, ((Integer) values.get(valueName)).longValue());
        } else {
          builder.addField(valueName, values.get(valueName).toString());
        }
      }
    }
    return builder;
  }

  private Point getInfluxPoint(String discriminantName, String discriminant, String pointValueName, Object pointValue, final String measurement, final Map<String, String> tags, Map<String, Object> values)
      throws IllegalAccessException {
    Builder pointBuilder = Point.measurement(measurement);
    pointBuilder.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    tags.put(discriminantName, discriminant);
    values.put(pointValueName, pointValue);
    addValues(addTags(pointBuilder, tags), values);
    return pointBuilder.build();
  }


  private Point getInfluxPoint(final String measurement, final Map<String, String> tags, Map<String, Object> values) throws IllegalAccessException {
    Builder pointBuilder = Point.measurement(measurement);
    pointBuilder.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    addValues(addTags(pointBuilder, tags), values);
    return pointBuilder.build();
  }

  private Map<String, String> getTags(Object object) throws IllegalAccessException {
    Map<String, String> tags = new HashMap<>();
    for (Field field : object.getClass().getDeclaredFields()) {
      if (field.isAnnotationPresent(Tag.class)) {
        String tagName = field.getAnnotation(Tag.class).value().isEmpty() ? field.getName() : field.getAnnotation(Tag.class).value();
        field.setAccessible(true);
        tags.put(tagName, field.get(object).toString());
      }
    }
    return tags;
  }

  private Map<String, Object> getPoints(Object object) throws IllegalAccessException  {
    Map<String, Object> points = new HashMap<>();
    for (Field field : object.getClass().getDeclaredFields()) {
      if (field.isAnnotationPresent(PointValue.class)) {
        String pointName = field.getAnnotation(PointValue.class).value().isEmpty() ?
            field.getName() :
            field.getAnnotation(PointValue.class).value();
        points.put(pointName, getValueByType(object, field));
      }
    }
    return points;
  }

  private Object getValueByType(final Object object, final Field field) throws IllegalAccessException {
    field.setAccessible(true);
    return field.get(object);
  }

  private Map<String, Object> getValues(final Object object) throws IllegalAccessException {
    Map<String, Object> values = new HashMap<>();
    for (Field field : object.getClass().getDeclaredFields()) {
      if (field.isAnnotationPresent(Value.class)) {
        String valueName = field.getAnnotation(Value.class).value().isEmpty() ?
            field.getName() :
            field.getAnnotation(Value.class).value();
        values.put(valueName, getValueByType(object, field));
      }
    }
    return values;
  }
}
