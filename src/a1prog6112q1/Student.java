/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a1prog6112q1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Keaton
 */
public class Student {

    //Scanner sc = new Scanner(System.in);
    private String name, email, course;
    private int id, age;

    ArrayList<String> nameArr = new ArrayList<>();
    ArrayList<String> emailArr = new ArrayList<>();
    ArrayList<String> courseArr = new ArrayList<>();
    ArrayList<Integer> idArr = new ArrayList<>();
    ArrayList<Integer> ageArr = new ArrayList<>();

    public Student() {

    }

    public Student(int id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    public void GetStudentValues() {
        Scanner sc = new Scanner (System.in);
        String tempAge, tempID;
        boolean ageChecker = false;
        System.out.println("CAPTURE A NEW STUDENT"
                + "\n*************************    ");
        System.out.print("Enter student id: ");
        tempID = sc.nextLine();
        id = Integer.parseInt(tempID);
        System.out.print("Enter the student name: ");
        name = sc.nextLine();
        while (ageChecker == false){
        System.out.print("Enter the student age: ");
        tempAge = sc.nextLine();
        ageChecker = checkAge(tempAge);
        age = Integer.parseInt(tempAge);
        }
        System.out.print("Enter the student email: ");
        email = sc.nextLine();
        System.out.print("Enter the student course: ");
        course = sc.nextLine();
        
        SaveStudent(id,name,age,email,course);
    }
    
    public void SaveStudent(int id, String name, int age, String email, String course){
        idArr.add(id);
        nameArr.add(name);
        ageArr.add(age);
        emailArr.add(email);
        courseArr.add(course);
        System.out.println("Student details successfully saved.");
    }

    public int SearchStudent(int tempID) {
        for (int i = 0; i < idArr.size(); i++) {
            if (idArr.get(i) == tempID) {
                return i;
            } else {
                System.out.println("Student with ID " + tempID + " was not found!");
                return -1;
            }
        }
        return 0;
    }

    public boolean DeleteStudent(int tempID, String choice) {
        
        
        
        for (int i = 0; i < idArr.size(); i++) {
            if (idArr.get(i) == tempID) {
                
                if (choice.equals("y")) {
                    idArr.remove(i);
                    nameArr.remove(i);
                    ageArr.remove(i);
                    emailArr.remove(i);
                    courseArr.remove(i);
                    
                    return true;
                }
            }
        }
        return false;
    }

    public void StudentReport() {
        for (int i = 0; i < idArr.size(); i++) {
            System.out.println("STUDENT " + (i + 1)
                    + "\n-------------------------------------------------------"
                    + "\nSTUDENT ID: " + idArr.get(i)
                    + "\nSTUDENT NAME: " + nameArr.get(i)
                    + "\nSTUDENT AGE: " + ageArr.get(i)
                    + "\nSTUDENT EMAIL: " + emailArr.get(i)
                    + "\nSTUDENT COURSE: " + courseArr.get(i)
            +"\n-------------------------------------------------------");
        }
    }

    public void ExitStudentApplication() {
        System.exit(0);
    }

    public boolean checkAge(String tempChar) {
        boolean check = false;
        int tempAge = 0;
        
        
        while (tempAge < 16) {
            
            if (Character.isDigit(tempChar.charAt(0)) && Integer.parseInt(tempChar) > 15) {
                tempAge = Integer.parseInt(tempChar);
                check = true;
            } else {
                System.out.println("You have entered a incorrect student age!!!");
                return false;
            }
        }
        return true;
    }

}
