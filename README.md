# 1. Description

The project includes simple backend logic for writing a JSON file to the database from an external API.

# 2.StartUP

The project can be started locally by executing the ReceivingWebserviceApplication class that starts Spring ApplicationContext. During this time, you can access via the local address on port 8080. The project downloads the JSON file from the local address on port 8181

# 3. Endpoints description

7 endpoints have been created

@GetMapping("/allDatabase") - display the entire database

@GetMapping("/saveInformation") - writing JSON external API to the database

@GetMapping("/receivedInformation") - displaying the JSON content of an external API

@GetMapping("/{id}") - searching for data in the database by id

@PostMapping("/createInformation") - creating and saving own information into the database

@DeleteMapping("/{id}") - deletion of information from the database by id

@DeleteMapping("/clearingTheDatabase") - clearing the database

# 4. Application

At this point, the application can only download JSON objects. 
The application is prepared to enter an address, token and external API key.

