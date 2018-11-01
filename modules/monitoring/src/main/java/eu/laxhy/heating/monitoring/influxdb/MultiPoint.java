package eu.laxhy.heating.monitoring.influxdb;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Libor Laichmann.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MultiPoint {

  //measurement
  String value() default "";

  String discriminantName() default "discriminant";

  String pointValueName() default "value";

}
