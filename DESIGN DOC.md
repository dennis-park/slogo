SLogo Design Document
=====

Introduction
==
The SLogo program a replica of Logo, where a basic person can type in commands and move a turtle on the canvas. It is an easy interface for someone to learn the language as well as create models and interesting logic-based simulations.

The GUI provides an easy way to test out the different commands for the turtle: forwards, backwards, rotate left and right. There is a panel that keeps track of the position and and the heading of the turtle so that the user knows where the turtle is oriented.

The user can also execute his/her own commands in the textbox, and this is where the GUI has to interact with the backend in order to parse and have the turtle reflect those respective commands.

Overview
==
There are 3 primary modules in our SLogo projecta: Backend.java, View.java and the Controller.java.

### View.java

The view consists of the canvas, turtle, textarea for commands and all the buttons that the user can use to quickly test out the fucntionality of Slogo. The View can hold multiple TabPane.java classes, and each of those modules load the entire user interface. The user interface contains one Canvas.java class that can hold as many Turtle.java classes as the user wants and instantiates all the fucntional buttons as well as the textarea and the panel containing information about the turtle. When the user enters text in the textarea and presses the run button, the information from the textarea gets passed into the Controller.java class.

### Controller.java

The controller handles the communication between the view and the backend. There is a method that passes the string to the backend and mutiple methods that pass backend commands to the current canvas and the current activated turtle. The view takes the command from there are executes them.

### Backend.java


User Interface Design
==

Design Details
==

### View.java
The View.java is instantiated by the Main.java class. It is a JFrame that contains a JTabbedPane private variable called TABS. 

### TabPanel.java
The TabPanel.java class is a JPanel that holds the bulk of what the user sees. The user can add mutliple TabPanel.java classes to the TABS variable through the Add Tab button. The TabPanel.java instantiates everything that the user would see in a tab. This means the buttons for testing turtle movements are instantiated, the panel that reports the turtles position and heading as well as the canvas that acutally holds the turtle and the textarea for the user to type commands in. The TabPanel.java class also contains all the button listners and executes those commands respectively. There are methods to organize the different pieces of the GUI but these could be better placed in individual classes for further clarity.

### Canvas.java
The Canvas.java holds and keeps track of all the turtles that the user creates in a specific tab. 


### Controller.java
