# 使用官方轻量级 JRE 17 镜像
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
LABEL maintainer="xujiawei jia_yangchen@163.com"

# 复制本地编译好的 JAR 文件（确保路径正确）
COPY target/*.jar app.jar

# 暴露端口与启动命令
EXPOSE 9002
ENTRYPOINT ["java", "-jar", "app.jar"]