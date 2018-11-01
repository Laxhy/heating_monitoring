package eu.laxhy.heating.monitoring.influxdb;

import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.influxdb.BatchOptions;
import org.influxdb.InfluxDB;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Pong;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;

/**
 * Created by Libor Laichmann.
 */
public class InfluxDbConnection implements InfluxDB {

  private InfluxDB connection;
  private String database;
  private String retentionPolicy;

  public InfluxDbConnection(InfluxDB connection) {
    this.connection = connection;
  }

  public String getDatabase() {
    return database;
  }

  public String getRetentionPolicy() {
    return retentionPolicy;
  }

  @Override
  public InfluxDB setLogLevel(LogLevel logLevel) {
    return connection.setLogLevel(logLevel);
  }

  @Override
  public InfluxDB enableGzip() {
    return connection.enableGzip();
  }

  @Override
  public InfluxDB disableGzip() {
    return connection.disableGzip();
  }

  @Override
  public boolean isGzipEnabled() {
    return connection.isGzipEnabled();
  }

  @Override
  public InfluxDB enableBatch() {
    return connection.enableBatch();
  }

  @Override
  public InfluxDB enableBatch(BatchOptions batchOptions) {
    return connection.enableBatch(batchOptions);
  }

  @Override
  public InfluxDB enableBatch(int actions, int flushDuration, TimeUnit flushDurationTimeUnit) {
    return connection.enableBatch(actions,flushDuration,flushDurationTimeUnit);
  }

  @Override
  public InfluxDB enableBatch(int actions, int flushDuration, TimeUnit flushDurationTimeUnit, ThreadFactory threadFactory) {
    return connection.enableBatch(actions,flushDuration,flushDurationTimeUnit,threadFactory);
  }

  @Override
  public InfluxDB enableBatch(int actions, int flushDuration, TimeUnit flushDurationTimeUnit, ThreadFactory threadFactory, BiConsumer<Iterable<Point>, Throwable> exceptionHandler,
      ConsistencyLevel consistency) {
    return connection.enableBatch(actions,flushDuration,flushDurationTimeUnit,threadFactory,exceptionHandler,consistency);
  }

  @Override
  public InfluxDB enableBatch(int actions, int flushDuration, TimeUnit flushDurationTimeUnit, ThreadFactory threadFactory, BiConsumer<Iterable<Point>, Throwable> exceptionHandler) {
    return connection.enableBatch(actions,flushDuration,flushDurationTimeUnit,threadFactory,exceptionHandler);
  }

  @Override
  public void disableBatch() {
      connection.disableBatch();
  }

  @Override
  public boolean isBatchEnabled() {
    return connection.isBatchEnabled();
  }

  @Override
  public Pong ping() {
    return connection.ping();
  }

  @Override
  public String version() {
    return connection.version();
  }

  @Override
  public void write(Point point) {
    connection.write(point);
  }

  @Override
  public void write(String records) {
    connection.write(records);
  }

  @Override
  public void write(List<String> records) {
    connection.write(records);
  }

  @Override
  public void write(String database, String retentionPolicy, Point point) {
    connection.write(database,retentionPolicy,point);
  }

  @Override
  public void write(int udpPort, Point point) {
    connection.write(udpPort,point);

  }

  @Override
  public void write(BatchPoints batchPoints) {
    connection.write(batchPoints);
  }

  @Override
  public void write(String database, String retentionPolicy, ConsistencyLevel consistency, String records) {
    connection.write(database,retentionPolicy,consistency,records);
  }

  @Override
  public void write(String database, String retentionPolicy, ConsistencyLevel consistency, List<String> records) {
    connection.write(database,retentionPolicy,consistency,records);
  }

  @Override
  public void write(int udpPort, String records) {
    connection.write(udpPort,records);
  }

  @Override
  public void write(int udpPort, List<String> records) {
    connection.write(udpPort,records);
  }

  @Override
  public QueryResult query(Query query) {
    return connection.query(query);
  }

  @Override
  public void query(Query query, Consumer<QueryResult> onSuccess, Consumer<Throwable> onFailure) {
    connection.query(query, onSuccess, onFailure);
  }

  @Override
  public void query(Query query, int chunkSize, Consumer<QueryResult> consumer) {
    connection.query(query, chunkSize, consumer);
  }

  @Override
  public QueryResult query(Query query, TimeUnit timeUnit) {
    return connection.query(query, timeUnit);
  }

  @Override
  public void flush() {
    connection.flush();
  }

  @Override
  public void close() {
    connection.close();
  }

  @Override
  public InfluxDB setConsistency(ConsistencyLevel consistency) {
    return connection.setConsistency(consistency);
  }

  @Override
  public InfluxDB setDatabase(String database) {
    this.database = database;
    return connection.setDatabase(database);
  }

  @Override
  public InfluxDB setRetentionPolicy(String retentionPolicy) {
    this.retentionPolicy = retentionPolicy;
    return connection.setRetentionPolicy(retentionPolicy);
  }

  @Deprecated
  @Override
  public void createDatabase(String name) {

  }

  @Deprecated
  @Override
  public void deleteDatabase(String name) {

  }

  @Deprecated
  @Override
  public List<String> describeDatabases() {
    return null;
  }

  @Deprecated
  @Override
  public boolean databaseExists(String name) {
    return false;
  }

  @Deprecated
  @Override
  public void createRetentionPolicy(String rpName, String database, String duration, String shardDuration, int replicationFactor, boolean isDefault) {

  }

  @Deprecated
  @Override
  public void createRetentionPolicy(String rpName, String database, String duration, int replicationFactor, boolean isDefault) {

  }

  @Deprecated
  @Override
  public void createRetentionPolicy(String rpName, String database, String duration, String shardDuration, int replicationFactor) {

  }

  @Deprecated
  @Override
  public void dropRetentionPolicy(String rpName, String database) {

  }
}
