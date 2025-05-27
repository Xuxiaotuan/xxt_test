# 第一阶段：使用 JDK 17 构建
FROM maven:3.8.7-jdk-17 AS build
WORKDIR /app
COPY pom.xml .
# 先下载依赖（利用 Docker 缓存层）
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# 第二阶段：使用轻量级 JRE 17 运行
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
LABEL maintainer="xujiawei jia_yangchen@163.com"
# 复制时指定精确文件名
COPY --from=build /app/target/*.jar app.jar
EXPOSE 9002

# 推荐添加 JVM 优化参数
ENTRYPOINT ["java", "-XX:+UseZGC", "-Xmx512m", "-jar", "/app/app.jar"]
