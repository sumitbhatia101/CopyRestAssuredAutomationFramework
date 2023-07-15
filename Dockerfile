FROM sumitbhatia101/apicopy:2
COPY src home/copyrestassuredautomationframework/src
COPY output home/copyrestassuredautomationframework/output
COPY index.html home/copyrestassuredautomationframework/index.html
COPY pom.xml home/copyrestassuredautomationframework/pom.xml
COPY testng.xml home/copyrestassuredautomationframework/testng.xml
WORKDIR home/copyrestassuredautomationframework
ENTRYPOINT mvn clean test
