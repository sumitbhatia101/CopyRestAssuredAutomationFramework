FROM maven:3.8.1-jdk-11
COPY src home/copyrestassuredautomationframework/src
COPY output home/copyrestassuredautomationframework/output
COPY index.html home/copyrestassuredautomationframework/index.html
COPY pom.xml home/copyrestassuredautomationframework/pom.xml
COPY testng.xml home/copyrestassuredautomationframework/testng.xml
WORKDIR home/copyrestassuredautomationframework
ENTRYPOINT mvn clean test
