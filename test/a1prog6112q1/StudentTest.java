/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package a1prog6112q1;

import java.util.Scanner;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author lab_services_student
 */
public class StudentTest {
    
    Student stud = new Student(10111 , "J.Bloggs" , 19 , "jbloggs@ymail.com" ,"disd");

    @Test
    public void testSaveStudent() {       
        int expectedID = 10111, expectedAge = 19;
        String expectedName = "J.Bloggs", expectedEmail = "jbloggs@ymail.com" , expectedCourse = "disd";
        
        stud.SaveStudent(10111,  "J.Bloggs" , 19 , "jbloggs@ymail.com" ,"disd");
        
        int actualID = stud.idArr.get(0);
        String actualName = stud.nameArr.get(0);
        int actualAge = stud.ageArr.get(0);
        String actualEmail = stud.emailArr.get(0);
        String actualCourse = stud.courseArr.get(0);
        
        assertEquals(expectedID,actualID );
        assertSame(expectedName,actualName);
        assertEquals(expectedAge,actualAge);
        assertSame(expectedEmail,actualEmail);
        assertSame(expectedCourse,actualCourse);
        
    }
    
    
    @Test
    public void testSearchStudent(){
      
        int expectedID = 0;
        stud.idArr.add(10111);
        stud.nameArr.add("J.Bloggs");
        stud.ageArr.add(19);
        stud.emailArr.add( "jbloggs@ymail.com");
        stud.courseArr.add("disd");
        int actualID = stud.SearchStudent(10111);
        
        assertEquals(expectedID,actualID);
        
    }
    
    @Test
    public void testSearchStudent_StudentNotFound(){
        int expectedID = -1;
        stud.idArr.add(10111);
        stud.nameArr.add("J.Bloggs");
        stud.ageArr.add(19);
        stud.emailArr.add( "jbloggs@ymail.com");
        stud.courseArr.add("disd");
        int actualID = stud.SearchStudent(6);
        
        assertEquals(expectedID,actualID);
    }
    
    @Test
    public void TestDeleteStudent(){
        stud.idArr.add(10111);
        stud.nameArr.add("J.Bloggs");
        stud.ageArr.add(19);
        stud.emailArr.add( "jbloggs@ymail.com");
        stud.courseArr.add("disd");
        boolean actual = stud.DeleteStudent(10111, "y");
        
        assertTrue(actual);
    }
    
    @Test
    public void TestDeleteStudent_StudentNotFound(){
        stud.idArr.add(10111);
        stud.nameArr.add("J.Bloggs");
        stud.ageArr.add(19);
        stud.emailArr.add( "jbloggs@ymail.com");
        stud.courseArr.add("disd");
        boolean actual = stud.DeleteStudent(6, "y");
        
        assertFalse(actual);
    }   
    
    
    @Test 
    public void TestStudentAge_StudentAgeValid(){
        
        boolean actual = stud.checkAge("19");
        
        assertTrue(actual);
    }
    
    @Test 
    public void TestStudentAge_StudentAgeInvalid(){
        
        
        boolean actual = stud.checkAge("11");
        
        assertFalse(actual);
    }
    
    @Test 
    public void TestStudentAge_StudentAgeInvalidCharacter(){
        
        boolean actual = stud.checkAge("*");
        
        assertFalse(actual);
    }
}
