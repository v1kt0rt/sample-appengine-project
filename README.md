To quickstart a java project for Google appengine.

* Create a new project at https://console.cloud.google.com/
* It's also possible to set up Project ID, otherwise Google will give a random-ish ID.
* Go to 'App Engine' section in the top-left menu, click 'Create Application'.
* Choose a suitable region.
* Setting up a Java application can be skipped.


To deploy:


mvn -f java-backend clean install com.google.cloud.tools:appengine-maven-plugin:deploy -DskipTests=true -Dappid=<project_id>

Where <project_id> can be copied from the admin page of the project from console.cloud.google.com.

It can be accessed on:
https://<project_id>.appspot.com/api