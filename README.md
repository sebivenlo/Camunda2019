# Fontysvenlo-Camunda2019

## Prerequisites

Camunda Modeler installed:

    https://camunda.com/download/modeler/

Postman installed for REST-API calls:

    https://www.getpostman.com/apps

Docker installed and running:

    https://www.docker.com/get-started

Eclipse IDE for Java
	
	https://www.eclipse.org/downloads/packages/release/indigo/sr2/eclipse-ide-java-ee-developers

Pg Admin

	https://www.pgadmin.org/download/

## Setup Project
	1. Create Database in Pgadmin name it camundadb.
	2. In srs/main/resources Adjust your application.yaml file with your db credentials like this.
![alt text](https://i.ibb.co/kGJXyj4/yaml.png)

	3. Download our Project and Unzip it.
	4. Open it with Eclipse
	5. We are using Java 11. If you get an Java compling error at beginning go to 
		3.a Project > Properties > Java Build Path > Add your library.
		3.b Adjust Pom.xml in Java version properties.
	6. Right click on Pom.xml > Run as > Maven install
	7. To run the Project Right click on Application.java > Run as > Java application
	8. On localhost:8080 you should see the Camunda Login page > Login as demo:demo 

## Use REST to get information and post diagram or start diagram using Postman.
[Camunda Rest Docs for further development or questions](https://docs.camunda.org/manual/7.10/reference/rest/)
### Post a diagram into Camunda

	1. Post localhost:8080/rest/deployment/create.
	2. Headers > Key = Content-Type , Value = multipart/form-data.
	3. Body > Key = upload of type file, Value = choose file to upload.
	4. Check in Cockpit/Processes if succesfull

### start a process

	1. Post localhost:8080/rest/process-definition/key/yourProcessIDinModeller/start
	2. Headers > Key = Content-Type , Value = application/json.
	3. Body > Checkmark raw > empty json {}
	4. Check in Cockpit/Processes/yourProcess if started

### start a process with variable

	1. Get localhost:8080/rest/task?processDefinitionKey=yourProcessIDinModeller (get the id in JSON repsonse)
	2. Post localhost:8080/rest/task/efcd51c6-15d1-11ea-8eb9-704d7b67f494/complete
	3. Headers > Key = Content-Type, Value = application/json
	4. Body > Checkmark raw, add following

	{"variables":
 	   {"teamName": {"value": "koln"}
  	  }
	}

	5. Check in Cockpit/Processes/yourProcess if started with variable
	
### send message to diagram
	1. Post localhost:8080/rest/message
	2. Headers > Key = Content-Type, Value = application/json
	3. Body > Checkmark raw, add following
	
 	{
    	"messageName" : "FreeBeerArrived",
    	"businessKey" :"50"
   	}

## Trouble shooting
	Port 8080 already in use error:
	For Linux: netstat -lnp | grep 8080 (which instance listenning to 8080) >  kill -9 process_id
	For Windows: netstat -ano | findstr 8080 (which instance listenning to 8080) > taskkill /F /pid process_id
	
	
	
## Sources Used
[Youtube Channel of Camunda](https://www.youtube.com/channel/UCTYG6fjGgHg5p47PqsiaI2w)
Tutorials by: Niall Deehan & [Bernd Ruecker](https://github.com/berndruecker)

[Camunda Docs](https://docs.camunda.org/manual/7.12/)

[Big Business Process Diagram](https://theartfulmodellerdotcom.files.wordpress.com/2015/11/big-process-model.png?w=751&h=391)


