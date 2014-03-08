SLogo README file
=====

Front End: Dennis Park, Ashley Qian

Back End: Grace Chen, Willy Chen


Date Started: Thurs 2/20/14

Date Finished: Sat 3/8/14

Approx. Hours Spent: oh my goodness


Division of Workload:
===

BACKEND:

Grace: the bulk of Part 2 commands, languages (formatting/parsing properties files), 
enabling commanding multiple turtles

Sources Consulted:
===
Google Translate (for the unfinished languages, as well as fixing existing 
translations)

Important Files:
===
"Main" class, which displays the GUI, is in the slogo package in the src folder.

Backend tests can be found in the test package of the backend package. ParserTest
tests the functionality of commands/operations, and TokenizerTest tests the 
functionality of the Tokenizer class, which breaks up a string of inputs into a string
array of user-entered commands, parameters, etc.

Required Data/Resource Files:
===
In Backend, the CommandFactory class is where the HashMap of strings to strings, where
the keys are valid commands (such as EQUAL? or EQUALP), and the values are the 
directory locations of the classes that contain the definitions of these commands. 
(CommandFactory isn't exactly a data or resource file, but sort of functions like 
one?)

Misc. Information About Using the Program:
===
The Controller class, also in the slogo package of the src folder, is the point of 
contact between the Frontend and Backend.

Known Bugs:
===
As of 3/8/14: The ability to recognize comments is not yet implemented; multiple 
turtle commands are not yet implemented (the commands just execute on all existing
turtles, rather than on user-selected turtles only).

Extra Features:
===
