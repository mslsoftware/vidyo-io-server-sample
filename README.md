# Vidyo IO token server sample for Google Cloud Platform

## Requirements
* [Apache Maven](http://maven.apache.org) 3.3.9 or greater
* [Google Cloud SDK](https://cloud.google.com/sdk/)
* `gcloud components install app-engine-java`
* `gcloud components update`
* [Vidyo IO account](https://developer.vidyo.io/login-widget?url=my-account) to get Application ID and Developer Key
* [An appengine project](https://console.cloud.google.com/projectselector/appengine/create) 

## Installation
* Clone or download and unzip the project files into a local directory
* In src/main/webapp/WEB-INF/web.xml replace `YOUR VIDYO IO appID` with Vidyo Application ID and `YOUR VIDYO IO KEY` with you Vidyo Developer Key
* run `gcloud init` to connect with your appengine project
  
### Running locally

    $ mvn jetty:run-exploded

	The server can be accessed using:
    http://localhost:8080/getToken?user_id=[some_user_id]
  
### Deploying

    $ mvn appengine:deploy

	The server can be accessed using:
    https://[YOUR_PROJECT_ID].appspot.com/getToken?user_id=[some_user_id]

## Server response

   {token : [generated token]}         

