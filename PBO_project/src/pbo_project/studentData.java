/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo_project;

import java.sql.Date;

/**
 *
 * @author boytr
 */
public class studentData {
       private Integer studentNum;
       private String year;
       private String course;
       private String firstName;
       private String lastName;
       private String gender;
       private Date birth;
       private String status;
       private String image;
       private Double firstSem;
       private Double secondSem;
       private Double finals;
       
       public studentData(Integer studentNum,String year,String course,String firstName,String lastName,String gender,Date birth,String status,String image){
           this.studentNum = studentNum;
           this.year = year;
           this.course = course;
           this.firstName = firstName;
           this.lastName = lastName;
           this.gender = gender;
           this.birth = birth;
           this.status = status;
           this.image = image;
       }
       
       public studentData(Integer studentNum,String year,String course,Double firstSem,Double secondSem,Double finals){
           this.studentNum = studentNum;
           this.year = year;
           this.course = course;
           this.firstSem = firstSem;
           this.secondSem = secondSem;
           this.finals = finals;
       }
       public Integer getStudentNum(){
           return studentNum;
       }
       public String getYear(){
           return year;
       }
       public String getCourse(){
           return course;
       }
       public String getFirstName(){
           return firstName;
       }
       public String getLastName(){
           return lastName;
       }
       public String getGender(){
           return gender;
       }
       public Date getBirth(){
           return birth;
       }
       public String getStatus(){
           return status;
       }
       public String getImage(){
           return image;
       }
       public Double getFristSem(){
           return firstSem;
       }
       public Double getSecondSem(){
           return secondSem;
       }
       public Double getFinals(){
           return finals;
       }
       
}
