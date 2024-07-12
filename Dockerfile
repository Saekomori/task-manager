FROM openjdk:21 AS dependencies
WORKDIR /tm_diplom
COPY . .
RUN ./mvnw clean package -DskipTests -U

FROM openjdk:21 as builder
WORKDIR /tm_diplom
COPY . .
COPY --from=dependencies /root/.m2 /root/.m2
RUN ./mvnw clean package -DskipTests

FROM openjdk:21
COPY --from=builder /tm_diplom/target/*.jar /tm_diplom/task_tm.jar
ENTRYPOINT ["java", "-jar", "/tm_diplom/task_tm.jar"]
EXPOSE 8989

