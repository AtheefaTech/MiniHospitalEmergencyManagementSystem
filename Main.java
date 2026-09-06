import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PatientBST patientBST = new PatientBST();
        EmergencyQueue emergencyQueue = new EmergencyQueue();
        TreatmentStack treatmentStack = new TreatmentStack();

        // Sample patients for testing
        Patient p1 = new Patient(
            100,
            "Amal Perera",
            35,
            "0771234567",
            "Fever"
        );

        Patient p2 = new Patient(
            50,
            "Nimal Silva",
            52,
            "0719876543",
            "Chest Pain"
        );

        Patient p3 = new Patient(
            150,
            "Kamal Fernando",
            28,
            "0754567890",
            "Fracture"
        );

        patientBST.insert(p1);
        patientBST.insert(p2);
        patientBST.insert(p3);

        int choice;

        do {

            System.out.println();
            System.out.println("==============================================");
            System.out.println("   MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM");
            System.out.println("==============================================");
            System.out.println("1. Add Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Display All Patients");
            System.out.println("4. Delete Patient");
            System.out.println("5. Add Patient to Emergency Queue");
            System.out.println("6. Process Emergency Patient");
            System.out.println("7. Display Emergency Queue");
            System.out.println("8. Add Treatment Record");
            System.out.println("9. Remove Latest Treatment");
            System.out.println("10. Display Treatment History");
            System.out.println("11. Add Patient Visit");
            System.out.println("12. Search Patient Visit");
            System.out.println("13. Remove Patient Visit");
            System.out.println("14. Display Patient Visit History");
            System.out.println("0. Exit");
            System.out.println("==============================================");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.println();
                    System.out.println("----- ADD PATIENT -----");

                    System.out.print("Enter Patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String contact = scanner.nextLine();

                    System.out.print("Enter Medical Condition: ");
                    String condition = scanner.nextLine();

                    Patient newPatient = new Patient(
                        id,
                        name,
                        age,
                        contact,
                        condition
                    );

                    patientBST.insert(newPatient);

                    break;

                case 2:

                    System.out.println();
                    System.out.println("----- SEARCH PATIENT -----");

                    System.out.print("Enter Patient ID: ");
                    int searchId = scanner.nextInt();

                    Patient foundPatient = patientBST.search(searchId);

                    if (foundPatient != null) {
                        System.out.println("Patient found:");
                        foundPatient.displayPatient();
                    }
                    else {
                        System.out.println("Patient not found.");
                    }

                    break;

                case 3:

                    System.out.println();
                    System.out.println("----- ALL PATIENTS -----");

                    patientBST.displayInOrder();

                    break;

                case 4:

                    System.out.println();
                    System.out.println("----- DELETE PATIENT -----");

                    System.out.print("Enter Patient ID: ");
                    int deleteId = scanner.nextInt();

                    patientBST.delete(deleteId);

                    break;

                case 5:

                    System.out.println();
                    System.out.println("----- ADD TO EMERGENCY QUEUE -----");

                    System.out.print("Enter Patient ID: ");
                    int queueId = scanner.nextInt();

                    Patient queuePatient = patientBST.search(queueId);

                    if (queuePatient != null) {
                        emergencyQueue.enqueue(queuePatient);
                    }
                    else {
                        System.out.println("Patient not found.");
                    }

                    break;

                case 6:

                    System.out.println();
                    System.out.println("----- PROCESS EMERGENCY PATIENT -----");

                    Patient treatmentPatient = emergencyQueue.dequeue();

                    if (treatmentPatient != null) {
                        System.out.println("Patient selected for treatment:");
                        treatmentPatient.displayPatient();
                    }

                    break;

                case 7:

                    System.out.println();
                    System.out.println("----- EMERGENCY QUEUE -----");

                    emergencyQueue.displayQueue();

                    break;

                case 8:

                    System.out.println();
                    System.out.println("----- ADD TREATMENT RECORD -----");

                    System.out.print("Enter Patient ID: ");
                    int treatmentPatientId = scanner.nextInt();
                    scanner.nextLine();

                    Patient treatmentRecordPatient =
                        patientBST.search(treatmentPatientId);

                    if (treatmentRecordPatient != null) {

                        System.out.print("Enter Doctor Name: ");
                        String doctorName = scanner.nextLine();

                        System.out.print("Enter Treatment: ");
                        String treatment = scanner.nextLine();

                        System.out.print("Enter Treatment Date: ");
                        String treatmentDate = scanner.nextLine();

                        TreatmentRecord record = new TreatmentRecord(
                            treatmentRecordPatient.getPatientId(),
                            treatmentRecordPatient.getPatientName(),
                            doctorName,
                            treatment,
                            treatmentDate
                        );

                        treatmentStack.push(record);

                    }
                    else {
                        System.out.println("Patient not found.");
                    }

                    break;

                case 9:

                    System.out.println();
                    System.out.println("----- REMOVE LATEST TREATMENT -----");

                    TreatmentRecord removedRecord =
                        treatmentStack.pop();

                    if (removedRecord != null) {
                        System.out.println("Removed treatment record:");
                        removedRecord.displayTreatment();
                    }

                    break;

                case 10:

                    System.out.println();
                    System.out.println("----- TREATMENT HISTORY -----");

                    treatmentStack.displayStack();

                    break;

                case 11:

                    System.out.println();
                    System.out.println("----- ADD PATIENT VISIT -----");

                    System.out.print("Enter Patient ID: ");
                    int visitPatientId = scanner.nextInt();
                    scanner.nextLine();

                    Patient visitPatient =
                        patientBST.search(visitPatientId);

                    if (visitPatient != null) {

                        System.out.print("Enter Visit ID: ");
                        int visitId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter Visit Date: ");
                        String visitDate = scanner.nextLine();

                        System.out.print("Enter Doctor Name: ");
                        String visitDoctor = scanner.nextLine();

                        System.out.print("Enter Diagnosis: ");
                        String diagnosis = scanner.nextLine();

                        System.out.print("Enter Treatment: ");
                        String visitTreatment = scanner.nextLine();

                        Visit visit = new Visit(
                            visitId,
                            visitDate,
                            visitDoctor,
                            diagnosis,
                            visitTreatment
                        );

                        visitPatient.getVisitHistory().addVisit(visit);

                    }
                    else {
                        System.out.println("Patient not found.");
                    }

                    break;

                case 12:

                    System.out.println();
                    System.out.println("----- SEARCH PATIENT VISIT -----");

                    System.out.print("Enter Patient ID: ");
                    int searchVisitPatientId = scanner.nextInt();

                    Patient searchVisitPatient =
                        patientBST.search(searchVisitPatientId);

                    if (searchVisitPatient != null) {

                        System.out.print("Enter Visit ID: ");
                        int searchVisitId = scanner.nextInt();

                        Visit foundVisit =
                            searchVisitPatient
                                .getVisitHistory()
                                .searchVisit(searchVisitId);

                        if (foundVisit != null) {
                            System.out.println("Visit found:");
                            foundVisit.displayVisit();
                        }
                        else {
                            System.out.println("Visit not found.");
                        }

                    }
                    else {
                        System.out.println("Patient not found.");
                    }

                    break;

                case 13:

                    System.out.println();
                    System.out.println("----- REMOVE PATIENT VISIT -----");

                    System.out.print("Enter Patient ID: ");
                    int removeVisitPatientId = scanner.nextInt();

                    Patient removeVisitPatient =
                        patientBST.search(removeVisitPatientId);

                    if (removeVisitPatient != null) {

                        System.out.print("Enter Visit ID: ");
                        int removeVisitId = scanner.nextInt();

                        removeVisitPatient
                            .getVisitHistory()
                            .removeVisit(removeVisitId);

                    }
                    else {
                        System.out.println("Patient not found.");
                    }

                    break;

                case 14:

                    System.out.println();
                    System.out.println("----- PATIENT VISIT HISTORY -----");

                    System.out.print("Enter Patient ID: ");
                    int historyPatientId = scanner.nextInt();

                    Patient historyPatient =
                        patientBST.search(historyPatientId);

                    if (historyPatient != null) {

                        System.out.println(
                            "Visit history for "
                            + historyPatient.getPatientName()
                        );

                        historyPatient
                            .getVisitHistory()
                            .displayVisits();

                    }
                    else {
                        System.out.println("Patient not found.");
                    }

                    break;

                case 0:

                    System.out.println();
                    System.out.println(
                        "Thank you for using the Mini Hospital Emergency Management System."
                    );

                    break;

                default:

                    System.out.println(
                        "Invalid choice. Please try again."
                    );
            }

        } while (choice != 0);

        scanner.close();
    }
}