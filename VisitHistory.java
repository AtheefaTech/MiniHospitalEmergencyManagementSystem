public class VisitHistory {

    private class Node {

        Visit visit;
        Node next;

        Node(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public VisitHistory() {
        head = null;
        tail = null;
    }

    public void addVisit(Visit visit) {

        Node newNode = new Node(visit);

        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }

        System.out.println(
            "Visit " + visit.getVisitId()
            + " added to patient visit history."
        );
    }

    public Visit searchVisit(int visitId) {

        Node current = head;

        while (current != null) {

            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }

            current = current.next;
        }

        return null;
    }

    public void removeVisit(int visitId) {

        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        if (head.visit.getVisitId() == visitId) {

            head = head.next;

            if (head == null) {
                tail = null;
            }

            System.out.println(
                "Visit " + visitId
                + " removed from visit history."
            );

            return;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.visit.getVisitId() == visitId) {

                current.next = current.next.next;

                if (current.next == null) {
                    tail = current;
                }

                System.out.println(
                    "Visit " + visitId
                    + " removed from visit history."
                );

                return;
            }

            current = current.next;
        }

        System.out.println(
            "Visit " + visitId
            + " not found."
        );
    }

    public void displayVisits() {

        if (head == null) {
            System.out.println("No previous visits found.");
            return;
        }

        Node current = head;

        System.out.println("Patient Visit History:");

        while (current != null) {

            current.visit.displayVisit();

            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}