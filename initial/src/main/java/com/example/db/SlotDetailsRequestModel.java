package com.example.db;


// var obj = new Object();
//         obj['name'] = fullName.value;
//         obj['age'] = age.value;
//         obj['bookingDate'] = bookingDate.value;
//         obj['noteToDoctor'] = noteToDoctor.value;
//         obj['selectedSlot'] = selectedSlot.value;
//         obj['selectedDoctorId'] = selectedDoctor.value;


public class SlotDetailsRequestModel {
    String name;
    int age;
    String bookingDate;
    String noteToDoctor;
    String selectedSlot;
    String selectedDoctorId;

    public SlotDetailsRequestModel(String name, int age, String bookingDate, String noteToDoctor, String selectedSlot, String selectedDoctorId) {
        this.name = name;
        this.age = age;
        this.bookingDate = bookingDate;
        this.noteToDoctor = noteToDoctor;
        this.selectedSlot = selectedSlot;
        this.selectedDoctorId = selectedDoctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getNoteToDoctor() {
        return noteToDoctor;
    }

    public void setNoteToDoctor(String noteToDoctor) {
        this.noteToDoctor = noteToDoctor;
    }

    public String getSelectedSlot() {
        return selectedSlot;
    }

    public void setSelectedSlot(String selectedSlot) {
        this.selectedSlot = selectedSlot;
    }

    public String getSelectedDoctorId() {
        return selectedDoctorId;
    }

    public void setSelectedDoctorId(String selectedDoctorId) {
        this.selectedDoctorId = selectedDoctorId;
    }
}
