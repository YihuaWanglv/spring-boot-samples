# spring-boot-cassandra
spring-boot-cassandra sample

## 1. install and run cassandra

### run cassandra
```
bin/cassandra -f
```

## 2. run cqlsh and init keyspace

### run cqlsh
```
bin/cqlsh
```

### and create a sample Cassandra keyspace:
```
CREATE KEYSPACE IF NOT EXISTS sample WITH replication = {'class':'SimpleStrategy', 'replication_factor':1};
```

## 3. add spring-boot-data-cassandra maven dependency like this sample

### add spring-boot-data-cassandra maven dependency
```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-cassandra</artifactId>
    </dependency>
```

## 4. add properties config "spring.data.cassandra.keyspace-name=sample"

```
spring.data.cassandra.keyspace-name=sample
```

## 5. run spring boot project or run TestCase SampleCassandraApplicationTest for test
