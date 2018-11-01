package eu.laxhy.heating.monitoring;

import eu.laxhy.heating.monitoring.influxdb.InfluxDbConnection;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Libor Laichmann.
 */
@Configuration
@Slf4j
public class InfluxDBConfig {

  @Value("${laxhy.influxdb.connection}")
  private String influxDbConnection;
  @Value("${laxhy.influxdb.username}")
  private String username;
  @Value("${laxhy.influxdb.password}")
  private String password;
  @Value("${laxhy.heating.influxdb.database}")
  private String database;
  @Value("${laxhy.heating.influx.retention.policy.name}")
  private String policyName;
  @Value("${laxhy.heating.influx.retention.policy.duration}")
  private String duration;

  @Bean
  InfluxDbConnection getConnection() {
    return  new InfluxDbConnection(InfluxDBFactory.connect(influxDbConnection, username, password));
  }

  @PostConstruct
  void createDatabaseIfNotExists() {
    InfluxDbConnection connection = getConnection();

    String createDatabaseQueryStr = String.format("CREATE DATABASE \"%s\"", database);
    Query createDatabaseQuery = new Query(createDatabaseQueryStr, database, true);
    QueryResult result = connection.query(createDatabaseQuery);
    log.info("Result " + result.getError());

    String retentionPolicyQueryStr = String.format( "CREATE RETENTION POLICY \"%s\" ON \"%s\" DURATION %s REPLICATION 1 DEFAULT", policyName, database, duration);
    Query retentionPolicyQuery = new Query(retentionPolicyQueryStr, database, true);
    QueryResult resultRetention = connection.query(retentionPolicyQuery);
    log.info("Result " + resultRetention.getError());

    connection.setRetentionPolicy(policyName);
    connection.setDatabase(database);
  }

}
