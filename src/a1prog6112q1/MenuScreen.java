/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a1prog6112q1;

import java.util.Scanner;

/**
 *
 * @author Keaton
 */
public class MenuScreen extends Student {

    public void welcomeScreen() {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("STUDENT MANAGMENT APPLICATION"
                + "\n**************************************"
                + "\nEnter (1) to launch menu or any other key to exit");
        choice = Integer.parseInt(sc.next());
        if (choice == 1) {
            menu();
        } else {
            System.exit(0);
        }
    }

    public void launchScreen() {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Enter (1) to launch menu or any other key to exit");
        choice = Integer.parseInt(sc.next());
        if (choice == 1) {
            menu();
        } else {
            System.exit(0);
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice, studFound;
        System.out.println("Please enter in one of the following menu items:"
                + "\n(1) Capture a new student."
                + "\n(2) Search for a student."
                + "\n(3) Delete a student."
                + "\n(4) Print student report."
                + "\n(5) Exit Application.");

        choice = sc.nextInt();
        switch (choice) {
            case 1:
                GetStudentValues();
                launchScreen();
                break;
            case 2:
                int tempID;
                System.out.print("Enter the student id to search: ");
                tempID = sc.nextInt();
                studFound = SearchStudent(tempID);
                if (studFound != -1) {
                    System.out.println("-----------------------------------------"
                            + "\nSTUDENT ID: " + idArr.get(studFound)
                            + "\nSTUDENT NAME: " + nameArr.get(studFound)
                            + "\nSTUDENT AGE: " + ageArr.get(studFound)
                            + "\nSTUDENT EMAIL: " + emailArr.get(studFound)
                            + "\nSTUDENT COURSE: " + courseArr.get(studFound));
                }
                launchScreen();
                break;
            case 3:
                int tempDeleteID;
                String choiceDelete;
                boolean check;
                System.out.print("Enter the student id to delete: ");
                tempDeleteID = sc.nextInt();
                System.out.println("Are you sure you want to student " + tempDeleteID + " from the system? Yes (y) to delete.");
                 choiceDelete= sc.next();
                check = DeleteStudent(tempDeleteID, choiceDelete);
                if(check){
                    System.out.println("-----------------------------------------");
                    System.out.println("Student with Student Id: " + tempDeleteID + " WAS deleted!");
                    System.out.println("-----------------------------------------");
                }else{
                    System.out.println("Student with Student Id: " + tempDeleteID + "dose not exist.");
                }
                launchScreen();
                break;
            case 4:
                StudentReport();
                launchScreen();
                break;
            case 5:
                ExitStudentApplication();
                break;
            default:
                System.out.println("Invalid choice");
                menu();
        }

    }

}
