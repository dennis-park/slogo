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

View.java
===

The view consists of the canvas, turtle, textarea for commands and all the buttons that the user can use to quickly test out the fucntionality of Slogo. The View can hold multiple TabPane.java classes, and each of those modules load the entire user interface. The user interface contains one Canvas.java class that can hold as many Turtle.java classes as the user wants and instantiates all the fucntional buttons as well as the textarea and the panel containing information about the turtle. When the user enters text in the textarea and presses the run button, the information from the textarea gets passed into the Controller.java class.

Controller.java
===
The controller handles the communication between the view and the backend. There is a method that passes the string to the backend and mutiple methods that pass backend commands to the current canvas and the current activated turtle. The view takes the command from there are executes them.

Backend.java
===

User Interface Design
==

Design Details
==

View.java
===

Controller.java
===

Front End (Ashley & Dennis)
===
Our GUI will utilize Swing components. Packages are listed below:

-Send to backend information from the �console� (Possibly in a giant string). 
We need to figure out how to represent line breaks?
Should we preprocess the comments for the backend?

-Get turtle movements from backend

-Controller: 
This class will read the input string from the TextView and pass it to the appropriate parsers for processing; stores button state and its mapped keyboard mnemonic, enable flag when pressed, etc.
listeners. 
Objects derived from ActionListener and EventListener subclasses will be instantiated when end-user interacts with IDE and always running for keystroke inputs and looking to see if they match mapped bindings.  They will then pass handle to the controller.
model.

-Turtle:
Turtle object to be instantiated in the beginning; has the following traits
movements:

	forward, back
	take in values
	rotation/orientation
	left, right
	take in values

The turtle has a set movement method

Turtle keeps track of it�s own coordinates

There are methods that act on the turtle

The turtle has a set attribute method (for color maybe?)


-Model:
Instantiates and manipulates a Controller object, deals with parsers

-View:
GUI will designate a components for text manipulation.

-SLogoButton:
super class: JButton

-TextView:
super class: JFrame/JTextComponent
Creates, displays, and updates a text field JComponent

-Canvas:
super class: JPanel
This content pane is implemented within a frame with super class JFrame.  The canvas object displays and updates the turtle object(s) stored in an ArrayList (to allow multiple turtle objects) and paints/re-paints on the Canvas grid by pen.
Push/pop methods in a queue for the commands sent from the backend
Can have multiple turtle objects on it?
Edge detection/no edges
A separate queue class for turtle commands?
History?



BackEnd (Willy & Grace)
===
Four main components:

--Tokenizer (class): splits strings from inputs into �tokens� of individual words/numbers/etc., split by white spaces

--Parser (class): uses tokens to build commands, checks to see if each string is a start to a new command, a number, etc. and instantiate each command as appropriate, and create a list of commands (which will be passed into the Executor class)

--Command (package of classes, each command represented by a class): defines each individual command (some may be recursively implemented, some commands call other commands, etc.); holds 

--Executor (class): actually executing the commands in proper order as dictated by the user; will call commands in command package sequentially


To Add a New Command:
===

1) In the command package of the Backend package, create a class for the command in the appropriate sub-package, and make sure it extends Command.

2) Be sure to implement the method execute() in your new command class, which should return a double value as appropriate.

3) Add the command string(s) and the class path to the language properties files

