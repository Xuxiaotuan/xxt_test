# 第一阶段：编译 Java 代码
FROM adoptopenjdk/maven-openjdk8 AS build
WORKDIR /app
COPY . .
RUN mvn clean install

# 第二阶段：打包 JAR 文件
FROM openjdk:8-jre-alpine
WORKDIR /app
MAINTAINER xujiawei jia_yangchen@163.com
COPY --from=build /app/target/*.jar app.jar
EXPOSE 9002

ENTRYPOINT ["java","-jar","/app/app.jar"]