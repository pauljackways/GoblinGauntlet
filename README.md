SENG201 Project - Team131

Authors
Paul Jackways
Benjamin Skinner



Importing Project (Using IntelliJ)
IntelliJ has built-in support for Gradle. To import your project:

Launch IntelliJ and choose Open from the start-up window.
Select the project and click open
At this point in the bottom right notifications you may be prompted to 'load gradle scripts', If so, click load
Note: If you run into dependency issues when running the app or the Gradle pop up doesn't appear then open the Gradle sidebar and click the Refresh icon.

Run Project
Open a command line interface inside the project directory and run ./gradlew run to run the app.
The app should then open a new window, this may not be displayed over IntelliJ but can be easily selected from the taskbar
Build and Run Jar


Open a command line interface inside the project directory and run ./gradlew jar to create a packaged Jar. The Jar file is located at build/libs/seng201_team131-Final.jar
Navigate to the build/libs/ directory (you can do this with cd build/libs)
Run the command java -jar seng201_team0-1.0-SNAPSHOT.jar to open the application.
