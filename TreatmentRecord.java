public class TreatmentRecord {
private int patientId;
private String patientName;
private String doctorName;
private String treatment;
private String treatmentDate;

public TreatmentRecord(
    int patientId,
    String patientName,
    String doctorName,
    String treatment,
    String treatmentDate
) {

    this.patientId = patientId;
    this.patientName = patientName;
    this.doctorName = doctorName;
    this.treatment = treatment;
    this.treatmentDate = treatmentDate;
}

public int getPatientId() {
    return patientId;
}

public String getPatientName() {
    return patientName;
}

public String getDoctorName() {
    return doctorName;
}

public String getTreatment() {
    return treatment;
}

public String getTreatmentDate() {
    return treatmentDate;
}

public void displayTreatment() {

    System.out.println(
        "Patient ID: " + patientId
        + " | Patient: " + patientName
        + " | Doctor: " + doctorName
        + " | Treatment: " + treatment
        + " | Date: " + treatmentDate
    );
}

}
