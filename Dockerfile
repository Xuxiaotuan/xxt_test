FROM java:8
MAINTAINER xujiawei jia_yangchen@163.com
ADD xxt_test-0.0.1-SNAPSHOT.jar test.jar

EXPOSE 9002

ENTRYPOINT ["java","-jar","test.jar"]

