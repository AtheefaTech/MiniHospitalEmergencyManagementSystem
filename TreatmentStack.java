public class TreatmentStack {
// Node represents one treatment record
private class Node {

    TreatmentRecord treatmentRecord;
    Node next;

    Node(TreatmentRecord treatmentRecord) {
        this.treatmentRecord = treatmentRecord;
        this.next = null;
    }
}

// Top of the stack
private Node top;

// Constructor
public TreatmentStack() {
    top = null;
}

// Push a completed treatment onto the stack
public void push(TreatmentRecord treatmentRecord) {

    Node newNode = new Node(treatmentRecord);

    // New record becomes the top
    newNode.next = top;
    top = newNode;

    System.out.println(
        "Treatment record added for "
        + treatmentRecord.getPatientName()
    );
}

// Pop the most recently completed treatment
public TreatmentRecord pop() {

    // Check if stack is empty
    if (top == null) {

        System.out.println("Treatment history stack is empty.");
        return null;
    }

    // Store the top record
    TreatmentRecord record = top.treatmentRecord;

    // Move top to the next record
    top = top.next;

    System.out.println(
        "Most recent treatment record removed."
    );

    return record;
}

// Display all treatment records
public void displayStack() {

    // Check if stack is empty
    if (top == null) {

        System.out.println("No treatment records found.");
        return;
    }

    Node current = top;

    System.out.println("Treatment History:");

    while (current != null) {

        current.treatmentRecord.displayTreatment();

        current = current.next;
    }
}

// Check whether the stack is empty
public boolean isEmpty() {

    return top == null;
}

}
