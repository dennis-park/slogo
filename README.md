SLogo README file
=====

Front End: Dennis Park, Ashley Qian

Back End: Grace Chen, Willy Chen


Date Started: Thurs 2/20/14

Date Finished: 

Approx. Hours Spent:


Division of Workload:
===

Sources Consulted:
===

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

Known Bugs:
===
As of 2/28/14: (Backend) when ParserTest is run using symbols as commands instead of 
proper string names (i.e. using "+" instead of "SUM"), the test enters some sort of
infinite loop. Looking into it.

Extra Features:
===
