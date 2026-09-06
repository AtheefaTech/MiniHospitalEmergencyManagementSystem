public class PatientBST {
// Node represents one patient in the BST
private class Node {

    Patient patient;
    Node left;
    Node right;

    Node(Patient patient) {
        this.patient = patient;
        this.left = null;
        this.right = null;
    }
}

// Root node of the BST
private Node root;

// Constructor
public PatientBST() {
    root = null;
}

// Insert a new patient
public void insert(Patient patient) {
    root = insertRecursive(root, patient);
}

// Recursive insertion
private Node insertRecursive(Node current, Patient patient) {

    // Empty position found
    if (current == null) {
        return new Node(patient);
    }

    // Smaller ID goes to the left
    if (patient.getPatientId() < current.patient.getPatientId()) {

        current.left = insertRecursive(current.left, patient);

    }
    // Larger ID goes to the right
    else if (patient.getPatientId() > current.patient.getPatientId()) {

        current.right = insertRecursive(current.right, patient);

    }
    // Duplicate ID
    else {

        System.out.println("Patient ID already exists.");
    }

    return current;
}

// Search for a patient using Patient ID
public Patient search(int patientId) {

    Node current = root;

    while (current != null) {

        // Patient found
        if (patientId == current.patient.getPatientId()) {
            return current.patient;
        }

        // Search left side
        if (patientId < current.patient.getPatientId()) {
            current = current.left;
        }

        // Search right side
        else {
            current = current.right;
        }
    }

    // Patient not found
    return null;
}

// Display patients in ascending order
public void displayInOrder() {

    if (root == null) {
        System.out.println("No patients found.");
        return;
    }

    inOrderRecursive(root);
}

// Recursive in-order traversal
private void inOrderRecursive(Node current) {

    if (current != null) {

        // Visit left subtree
        inOrderRecursive(current.left);

        // Visit current patient
        current.patient.displayPatient();

        // Visit right subtree
        inOrderRecursive(current.right);
    }
}

// Delete a patient using Patient ID
public void delete(int patientId) {

    if (search(patientId) == null) {
        System.out.println("Patient not found. Cannot delete.");
        return;
    }

    root = deleteRecursive(root, patientId);

    System.out.println("Patient with ID " + patientId + " deleted successfully.");
}

// Recursive deletion
private Node deleteRecursive(Node current, int patientId) {

    // Patient not found
    if (current == null) {
        return null;
    }

    // Search left subtree
    if (patientId < current.patient.getPatientId()) {

        current.left = deleteRecursive(current.left, patientId);
    }

    // Search right subtree
    else if (patientId > current.patient.getPatientId()) {

        current.right = deleteRecursive(current.right, patientId);
    }

    // Patient found
    else {

        // Case 1: No children
        if (current.left == null && current.right == null) {

            return null;
        }

        // Case 2: Only right child
        if (current.left == null) {

            return current.right;
        }

        // Case 3: Only left child
        if (current.right == null) {

            return current.left;
        }

        // Case 4: Two children
        // Find the smallest node in the right subtree
        Node successor = findMinimum(current.right);

        // Replace current patient with successor
        current.patient = successor.patient;

        // Delete successor
        current.right = deleteRecursive(
            current.right,
            successor.patient.getPatientId()
        );
    }

    return current;
}

// Find the smallest node in a subtree
private Node findMinimum(Node current) {

    while (current.left != null) {
        current = current.left;
    }

    return current;
}

}
