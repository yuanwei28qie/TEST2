FROM daocloud.io/java:8
VOLUME /tmp
ADD FinanceService-1.0.0.jar FinanceService.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/FinanceService.jar"]