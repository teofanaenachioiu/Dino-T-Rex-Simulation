### Instalation

- Download the JADE files from https://jade.tilab.com/. You can download the archive called *jadeAll* or only *jadeBin*. From all the files you will use only those from the *Bin* directory, because there are the jars files that are actually used. 
- Unzip the archive in a easy to find location.


### IntelliJ IDEA Configuration

- Open a new Java project in IntellJ IDEA;
- Add the JADE jars in the project. From the top menu of IntelliJ IDEA, click on the following items: *File >> Project Structure ... >> Project Settings >> Libraries*. By clicking on the plus symbol a new file explorer window will be opened and now, go to de directory where you unziped the JADE archive and select the jade.jar file. Click on *OK* button on the project settings window to apply the new changes and to close the window;
- Run the project using JADE by editing the project running configuration. From the top menu, click on *Run >> Edit configurations... >> "+" >> Application*. Choose a suggestive name for the new running configuration and type *jade.Boot* in the *Main Class* field.
