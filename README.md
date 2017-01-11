# restJerseyExamples

3 apis available:

Convert Celsius to Fahrenheit returning XML, the last number is the Celsius value
http://localhost:8080/RESTJerseyExample/jmw/celsius/20

Convert Fahrenheit to Celsius returning a JSON object, the last number is the Fahrenheit value
http://localhost:8080/RESTJerseyExample/jmw/fahrenheit/68

Returns a JSON object by using the us zipcode provided and using api.openweathermap.org
http://localhost:8080/RESTJerseyExample/jmw/weather/94158



Setup from eclipse:

1) New Dynamic Web Project

2) Check that web.xml was created, if not Right Click/ Java EE Tools /Generate Deployment Descriptor Stub

3) Convert to Maven project to add the dependencies Right click on project -> Configure -> Convert to Maven Project

4) add dependendies: asm asm 3.3.1, com.sun.jersey (jersey-bundle, jersey-core, jersey-server) 1.19, org.json json 20140107

5) edit web.xml

6) Maven Build, clean install, add server 


Based on http://crunchify.com/how-to-build-restful-service-with-java-using-jax-rs-and-jersey/
