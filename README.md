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
