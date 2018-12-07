Todo List

1. Support multi language 
     - data
     - Exception
     
2. Support TCC(Try-Confirm/Cancel)  - Two-Phase commit protocol algorithm


Important note about version
PlantUML should be working with any version of Graphviz, starting with 2.26.3

The following versions have been tested, and are known to work:

However, it is possible that some cases with some versions have issues.

If you compile Graphviz by yourself, you have to build it with libexpat in order to work with PlantUML.

If you find something wrong, thanks for sending us a note or posting a message on the forum.

Default

 
By default, the dot executable should be:

Windows :
* Firstly in: ''c:\Program Files\Graphviz*\bin\dot.exe''
* Then in: ''c:\Program Files (x86)\Graphviz*\bin\dot.exe''
On Linux/Mac OS-X :
* Firstly in: ''/usr/local/bin/dot''
* Then in: ''/usr/bin/dot''
Note for Mac users
You can easily install GraphViz by installing brew on your Mac machine. This could fix issues if you have installed GraphViz as .dmg package.


brew install libtool
brew link libtool
brew install graphviz
brew link --overwrite graphviz
Testing
To have information about where PlantUML expects to find dot, you can use the command line:

java -jar plantuml.jar -testdot
You can also use this special diagram description:

@startuml
testdot
@enduml
