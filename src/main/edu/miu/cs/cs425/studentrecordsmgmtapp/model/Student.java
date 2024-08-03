package edu.miu.cs.cs425.studentrecordsmgmtapp.model;

import java.time.LocalDate;

public class Student {
  private int studentId;
  private String name;
  private LocalDate dateOfAdmission;

  public Student() {

  }

  public Student(int studentId, String name) {
      this.studentId = studentId;
      this.name = name;
  }

  public Student(int studentId, String name, LocalDate dateOfAdmission) {
      this.studentId = studentId;
      this.name = name;
      this.dateOfAdmission = dateOfAdmission;
  }

    public LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(LocalDate dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", dateOfAdmission=" + dateOfAdmission +
                '}';
    }
}
