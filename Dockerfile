FROM openjdk
EXPOSE 8080
ADD ./eight.jar /eight.jar
CMD java -jar /eight.jar
