# Project Observer
In this project you will find principles of the design pattern of **Observer**, And how we chose to perform it.

### OOP
OOP stands for Object-Oriented Programming.  
Procedural programming is about writing procedures or methods that perform operations on the data,   
while object-oriented programming is about creating objects that contain both data and methods.  

Object-oriented programming has several advantages over procedural programming:

  - OOP is faster and easier to execute.
  - OOP provides a clear structure for the programs.
  - OOP helps to keep the Java code DRY "Don't Repeat Yourself", and makes the code easier to maintain, modify and debug.
  - OOP makes it possible to create full reusable applications with less code and shorter development time.

### Design pattern
A design pattern is a general repeatable solution to a commonly occurring problem in software design.   

A design pattern isn't a finished design that can be transformed directly into code.  
It is a description or template for how to solve a problem that can be used in many different situations.   
Design patterns can speed up the development process by providing tested, proven development paradigms.  
Effective software design requires considering issues that may not become visible until later in the implementation.  
Reusing design patterns helps to prevent subtle issues that can cause major problems and improves code readability for coders and architects who are familiar with the patterns.   

There are several types of design patterns, including creational, structural, and behavioral patterns.  
Creational patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation.  
Structural patterns deal with object composition, creating relationships between objects to form larger structures.  
Behavioral patterns focus on communication between objects, what goes on between objects and how they operate together.    

Some common design patterns include the Singleton pattern, the Factory pattern, and the **Observer pattern**.    
 
### Observer pattern
The Observer pattern is a behavioral design pattern that defines a one-to-many dependency between objects, such that when one object (the subject) changes state, all of its dependents (the observers) are notified and updated automatically.  
It's a way of establishing a communication channel between objects so that when one object changes state, all of its dependents are notified and updated automatically.  
Especially, the Observer pattern is a useful way to establish a communication channel between objects and to allow objects to be notified of changes in the state of other objects.  
It helps to decouple the objects and make them more flexible and reusable.   

The Observer pattern is a specific type of design pattern.  
A design pattern is a general repeatable solution to a commonly occurring problem in software design.  
The Observer pattern is a specific type of design pattern that describes how to establish a communication channel between objects, such that when one object (the subject) changes state, all of its dependents (the observers) are notified and updated automatically.

# System
The purpose of the project is to add functionality to UndoableStringBuilder.  
UndoableStringBuilder is a class which is based on StringBuilder with support for the: 

`public void undo()`

This function keep a list of all operations set to an object, and return the last value that enter to the list.  
This project add an option to organize a group of members of updates on the status of  
**UndoableStringBuilder** and send all updates to it in real time.

In order for our run times to be efficient we used _HashSet_. _HashSet_ is a collection that stores a set of elements. It is implemented using a hash table, which
allows for fast insertion, deletion, and lookup of elements.
_HashSet_ does not allow duplicate elements, and it does not maintain the insertion order of the elements. This means that the order in which elements are added 
to a _HashSet_ is not preserved, and trying to add a duplicate element to the set will have no effect. It is an efficient data structure for storing and 
manipulating a set of elements in Java.  
We chose time efficiency over memory efficiency.

## Interface

### Member <kbd> -> </kbd> Observer
> This interface have only one method, _update(UndoableStringBuilder usb)_ that does not have any implementation details. Instead, it serves as a blueprint for
> other classes to implement. 

### Sender <kbd> -> </kbd> Observerable
> This interface have method that similar to UndoableStringBuilder, this methods does not have any implementation details. Instead, it
> serves as a blueprint for other classes to implement.

## Class

### UndoableStringBuilder
> This is our StringBuilder class with support for the undo operation. To do this,
> we delegate all methods to the standard StringBuilder, and keep a list of all operations
> to perform undo() in our class . An undo() method be written for `insert()` , `delete()` , `append()` .

### ConcreteMember
> This class implements the class of Member, take the _update_ function and executes it.
> Each member that entered to the list, get a _Data_ to point on our UndoableStringBuilder.
> Member can return a _Data_ with the `getData` function that return string.  

### GroupAdmin
> This class implements the class of Member, overriding the functions and executes them.
> In order to executes all the functions we made a shallow copy to UndoableStringBuilder, and use his ability in the functions.
> `notifyAll` - This function updates all members on the changes that have been made on UndoableStringBuilder. 


# How to run the project
In order to run this project follow this steps:
  - Push on `code` and download the zip.
  - Extract the zip file.
  - Open a new java project.
  - Write the file path.
  - Press on __pom.xml__ press ok.
  - Open as project.
Now you can run the file successfully.

  
