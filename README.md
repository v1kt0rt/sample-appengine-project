To quickstart a java project for Google appengine.

Create a new project at https://console.cloud.google.com/
Java project, choose a suitable region.

To deploy:


mvn -f java-backend clean install com.google.cloud.tools:appengine-maven-plugin:deploy -DskipTests=true -Dappid=ABCD

Where ABCD is the name of the project.