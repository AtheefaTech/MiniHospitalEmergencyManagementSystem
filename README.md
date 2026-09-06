 Mini Hospital Emergency Management System

 CIT300 – Data Structures and Algorithms

Project Description

The Mini Hospital Emergency Management System is a Java-based console application developed for the CIT300 Data Structures and Algorithms individual assignment.

The system demonstrates how different data structures can be used to manage hospital patient information, emergency patients, treatment records, and patient visit histories.

Objectives

The main objectives of this project are:

* To manage patient records efficiently using a Binary Search Tree.
* To manage emergency patients using a Queue following FIFO order.
* To maintain treatment history using a Stack following LIFO order.
* To maintain individual patient visit histories using a Singly Linked List.
* To demonstrate the practical application of data structures in a hospital management scenario.

 Data Structures Used

1. Binary Search Tree (BST)

The Binary Search Tree is used to store and manage patient records.

Each patient contains:

* Patient ID
* Patient Name
* Age
* Contact Number
* Medical Condition

Operations implemented:

* Insert patient
* Search patient by Patient ID
* Delete patient
* Display all patients using in-order traversal

The in-order traversal displays patients in ascending order of Patient ID.

2. Queue

A Queue is used to manage patients waiting for emergency treatment.

The queue follows the FIFO (First In, First Out) principle.

Operations implemented:

* Enqueue a patient
* Dequeue the next patient
* Display waiting patients
* Check whether the queue is empty

3. Stack

A Stack is used to maintain completed treatment records.

The stack follows the LIFO (Last In, First Out) principle.

Operations implemented:

* Push a treatment record
* Pop the most recent treatment record
* Display treatment history
* Check whether the stack is empty

4. Singly Linked List

A Singly Linked List is used to maintain the visit history of each patient.

Each visit contains:

* Visit ID
* Visit Date
* Doctor Name
* Diagnosis
* Treatment

Operations implemented:

* Add a visit
* Search for a visit
* Remove a visit
* Display patient visit history

Main Features

The system provides a menu-driven console interface with the following functions:

1. Add Patient
2. Search Patient
3. Display All Patients
4. Delete Patient
5. Add Patient to Emergency Queue
6. Process Emergency Patient
7. Display Emergency Queue
8. Add Treatment Record
9. Remove Latest Treatment
10. Display Treatment History
11. Add Patient Visit
12. Search Patient Visit
13. Remove Patient Visit
14. Display Patient Visit History
15. Exit

Project Structure

MiniHospitalEmergencyManagementSystem/
│
├── Main.java
├── Patient.java
├── PatientBST.java
├── EmergencyQueue.java
├── TreatmentRecord.java
├── TreatmentStack.java
├── Visit.java
├── VisitHistory.java
├── .gitignore
└── README.md

How to Run

Requirements

* Java Development Kit (JDK)
* Git (optional for running locally)

Compilation

Open a terminal in the project directory and run:

javac *.java


Execution

Run the main program using:

java Main


The system will display the main menu and allow the user to perform different hospital management operations.

Example Data

The system includes sample patients for demonstration:

| Patient ID | Name           | Age | Medical Condition |
| ---------: | -------------- | --: | ----------------- |
|         50 | Nimal Silva    |  52 | Chest Pain        |
|        100 | Amal Perera    |  35 | Fever             |
|        150 | Kamal Fernando |  28 | Fracture          |


The BST in-order traversal displays these patients in ascending Patient ID order.

Data Structure Design

The system uses separate classes for each major data structure:

* `PatientBST` manages patient records using a Binary Search Tree.
* `EmergencyQueue` manages emergency patients using a Queue.
* `TreatmentStack` manages completed treatments using a Stack.
* `VisitHistory` manages each patient's visits using a Singly Linked List.

The `Patient` class contains a `VisitHistory` object so that each patient can maintain their own visit records.

Testing

The system was tested using the following operations:

* Adding and searching patients
* Displaying patients in ascending Patient ID order
* Deleting patients
* Adding and processing emergency patients
* Verifying FIFO queue behaviour
* Adding and removing treatment records
* Verifying LIFO stack behaviour
* Adding patient visits
* Searching and removing visits
* Displaying patient visit history
* Testing empty queue and stack conditions

Learning Outcomes

Through this project, practical knowledge was gained in:

* Binary Search Tree implementation
* Queue implementation
* Stack implementation
* Singly Linked List implementation
* Object-oriented programming in Java
* Searching, insertion, deletion and traversal operations
* Git and GitHub version control
* Applying data structures to a real-world problem

Author

Atheefa

CIT300 – Data Structures and Algorithms
