FROM eclipse-temurin:11
ADD target/*.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8090
ENTRYPOINT ["sh", "-c" , "java -jar /app.jar"]

