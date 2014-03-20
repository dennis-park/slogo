Changes to the Frontend-Backend API
===

1) Rather than passing turtles between front and backend, we elected to have a 
Controller class that the backend could access to call commands on turtles based on
the turtles' ID numbers. An instance of the Controller class holds methods that take
in an ID number and appropriate parameters for a specific command, and calls a mirror
command in the Canvas class, where the command is actually carried out.