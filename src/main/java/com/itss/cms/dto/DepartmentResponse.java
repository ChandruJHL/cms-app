package com.itss.cms.dto;

import java.util.List;

public class DepartmentResponse {

   private String departmentId ;
   private String departmentName;
   private String hodName;
   private int totalStudent;
   private int totalStaff;

   List<StudentResponse> students;

   public List<StudentResponse> getStudents() {
      return students;
   }

   public void setStudents(List<StudentResponse> students) {
      this.students = students;
   }

   public String getDepartmentId() {
      return departmentId;
   }

   public void setDepartmentId(String departmentId) {
      this.departmentId = departmentId;
   }

   public String getDepartmentName() {
      return departmentName;
   }

   public void setDepartmentName(String departmentName) {
      this.departmentName = departmentName;
   }

   public String getHodName() {
      return hodName;
   }

   public void setHodName(String hodName) {
      this.hodName = hodName;
   }

   public int getTotalStudent() {
      return totalStudent;
   }

   public void setTotalStudent(int totalStudent) {
      this.totalStudent = totalStudent;
   }

   public int getTotalStaff() {
      return totalStaff;
   }

   public void setTotalStaff(int totalStaff) {
      this.totalStaff = totalStaff;
   }
}
