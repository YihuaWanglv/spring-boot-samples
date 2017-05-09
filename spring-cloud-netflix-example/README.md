# spring-cloud-netflix-example
spring-cloud-netflix-example is a example for microservices system.

It contain 
**configuration management, service discovery, circuit breakers, intelligent routing, distributed tracing, application monitor**.

## Getting Started
```shell
./gradle clean build -x test
./buildDockerImage.sh
docker-compose up -d
```
if you want to start more serve, you should use 
```shell
docker-compose scale service-a=2 service-b=3  
```

## Technology List
* Spring Cloud Netflix
* Spring Cloud Sleuth
* Spring Cloud Config
* Spring Boot Admin
* Spring Boot
* ZipKin
* RabbitMQ
* Docker

## Architecture Overview
[](url "title")
<img src="https://raw.githubusercontent.com/yidongnan/spring-cloud-netflix-example/master/screenshots/Architecture.png">

## Screenshots
### Api Route(Zuul)
[](url "title")
<img src="https://raw.githubusercontent.com/yidongnan/spring-cloud-netflix-example/master/screenshots/Selection_001.png">

### Eureka DashBoard
[](url "title")
<img src="https://raw.githubusercontent.com/yidongnan/spring-cloud-netflix-example/master/screenshots/Selection_002.png">

### ZipKin DashBoard
[](url "title")
<img src="https://raw.githubusercontent.com/yidongnan/spring-cloud-netflix-example/master/screenshots/Selection_003.png">

### ZipKin Trace Detail
[](url "title")
<img src="https://raw.githubusercontent.com/yidongnan/spring-cloud-netflix-example/master/screenshots/Selection_004.png">

### ZipKin Dependencies Overview
[](url "title")
<img src="https://raw.githubusercontent.com/yidongnan/spring-cloud-netflix-example/master/screenshots/Selection_005.png">

### Spring Boot Admin DashBoard
[](url "title")
<img src="https://raw.githubusercontent.com/yidongnan/spring-cloud-netflix-example/master/screenshots/Selection_006.png">

### Spring Boot Admin Detail
[](url "title")
<img src="https://raw.githubusercontent.com/yidongnan/spring-cloud-netflix-example/master/screenshots/Selection_007.png">

### Spring Boot Admin Environment
[](url "title")
<img src="https://raw.githubusercontent.com/yidongnan/spring-cloud-netflix-example/master/screenshots/Selection_008.png">

### Spring Boot Admin Thread Dump
[](url "title")
<img src="https://raw.githubusercontent.com/yidongnan/spring-cloud-netflix-example/master/screenshots/Selection_009.png">

### Spring Boot Admin Trace
[](url "title")
<img src="https://raw.githubusercontent.com/yidongnan/spring-cloud-netflix-example/master/screenshots/Selection_010.png">

### Hystrix Dashboard
[](url "title")
<img src="https://raw.githubusercontent.com/yidongnan/spring-cloud-netflix-example/master/screenshots/Selection_011.png">

### Hystrix Dashboard Detail
[](url "title")
<img src="https://raw.githubusercontent.com/yidongnan/spring-cloud-netflix-example/master/screenshots/Selection_012.png">


## update
my debug and update for this repository

### how to run rabbitmq and zipkin as service

#### rabbitmq Installing on Windows (manual)

down and install erl:
http://erlang.org/download/otp_win64_19.3.exe

Set ERLANG_HOME to where you actually put your Erlang installation, e.g.  C:\Program Files\erlx.x.x (full path). 

Download rabbitmq-server-windows-3.6.9.zip
https://www.rabbitmq.com/releases/rabbitmq-server/v3.6.9/rabbitmq-server-windows-3.6.9.zip

unzip rabbitmq-server-windows-3.6.9.zip

rabbitmq-server.bat starts the broker as an application.
or rabbitmq-server start

#### zipkin Quick-start

Zipkin server requires minimum JRE 8.
```
wget -O zipkin.jar 'https://search.maven.org/remote_content?g=io.zipkin.java&a=zipkin-server&v=LATEST&c=exec'
java -jar zipkin.jar
```

You can also start Zipkin via Docker.
```
docker run -d -p 9411:9411 openzipkin/zipkin
```

Once you've started, browse to http://your_host:9411 to find traces!








