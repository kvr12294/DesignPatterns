CS542 Design Patterns
Spring 2016
ASSIGNMENT <ASSIGNMENT 2> README FILE

Due Date: <ASSIGNMENT DUE DATE,  Monday, February 29, 2016>
Submission Date: <DATE SUBMITED, Monday, February 29, 2016>
Author(s): <VARUN KULKARNI> 
e-mail(s): <vkulkar2@binghamton.edu> 

FILES:-
Driver.java
Results.java
StdoutDisplayInterface.java
CreateWorkers.java
WorkerThread.java
FileProcessor.java
IsPrime.java
Logger.java

SAMPLE OUTPUT:-
(Debug value = 0)
The sum of all the prime numbers is: 193 

(Debug value = 1)
The sum of all the prime numbers is: 193	
[9, 11, 45, 35, 23, 67, 3]

(Debug value = 2)
Entry Added
Entry Added
Entry Added
Entry Added
Entry Added
Entry Added
Entry Added
The sum of all the prime numbers is: 193

(Debug value = 3)
Run Method
Run Method
Run Method
The sum of all the prime numbers is: 193

(Debug value = 4)
In FileProcessor Constructor
In CreateWorkers Constructor
In CreateWorkers Constructor
In WorkerThread Constructor
In WorkerThread Constructor
In WorkerThread Constructor
The sum of all the prime numbers is: 193

TO CLEAN :-
ant -buildfile src/build.xml clean

TO COMPILE :- 
ant -buildfile src/build.xml all

TO RUN :- 
ant -buildfile src/build.xml run -Darg0=bstInput.txt -Darg1=5
DATA STRUCTURE USED:-
To store the sum of all prime numbers I have Used Arraylist, because we need dynamic storage.
Arraylist grows by 50% in space but time required to access is not on the higher side. 