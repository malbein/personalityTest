# Personality Test - Backend

This is the API for the personality test, it works alone as an API or can help as the backend of the frontend project.

In this case we use Java with SprintBoot, H2 DB, and liquibase to simplify the instalation of it, and have the hability 
to migrate to another DB without to much effort.

You will should go to 

**_cd backend_**

You will need to have maven install to package the app. If not you can learn how to do it 
https://maven.apache.org/download.cgi#Installation

then run 

**_mvn package_**

once is package continue

**_cd target_**

and there execute

**_java -jar PersonalityTestAPI.jar_**

All API specification is on Swagger you can access it accessing

**_http://localhost:8080/swagger-ui.html_**

**Note:**
I feel more comfortable on Backend.
Also I was planning to do a Groovy/Grails solution with MongoDB to minimize my model complexity and use mongodb ability 
to query on a JSON but will be more complex to deploy since installing MongoDB, so I decide this approach.
