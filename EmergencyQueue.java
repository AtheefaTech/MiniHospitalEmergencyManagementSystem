public class EmergencyQueue {

// Node represents one patient in the queue
private class Node {

    Patient patient;
    Node next;

    Node(Patient patient) {
        this.patient = patient;
        this.next = null;
    }
}

// Front and rear of the queue
private Node front;
private Node rear;

// Constructor
public EmergencyQueue() {
    front = null;
    rear = null;
}

// Add a patient to the rear of the queue
public void enqueue(Patient patient) {

    Node newNode = new Node(patient);

    // If queue is empty
    if (rear == null) {
        front = newNode;
        rear = newNode;
    }

    // If queue already has patients
    else {
        rear.next = newNode;
        rear = newNode;
    }

    System.out.println(
        "Patient " + patient.getPatientName() +
        " added to emergency queue."
    );
}

// Remove the patient from the front of the queue
public Patient dequeue() {

    // Check if queue is empty
    if (front == null) {

        System.out.println("Emergency queue is empty.");
        return null;
    }

    // Store the patient being removed
    Patient patient = front.patient;

    // Move front to the next patient
    front = front.next;

    // If queue becomes empty, reset rear
    if (front == null) {
        rear = null;
    }

    System.out.println(
        "Patient " + patient.getPatientName() +
        " removed from emergency queue for treatment."
    );

    return patient;
}

// Display all patients currently waiting
public void displayQueue() {

    // Check if queue is empty
    if (front == null) {

        System.out.println("No patients are currently waiting.");
        return;
    }

    Node current = front;

    System.out.println("Patients currently waiting:");

    while (current != null) {

        current.patient.displayPatient();

        current = current.next;
    }
}

// Check whether the queue is empty
public boolean isEmpty() {

    return front == null;
}


}
