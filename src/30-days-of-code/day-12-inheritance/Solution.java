import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Person {
    private String firstName;
    private String lastName;
    private int idNumber;

    Person(String firstName, String lastName, int identification) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = identification;
    }

    public void printPerson() {
        System.out.println(
                "Name: " + lastName + ", " + firstName
                        + "\nID: " + idNumber);
    }
}

class Student extends Person {
    private int[] testScores;

    Student(String firstName, String lastName, int identification, int[] scores) {
        super(firstName, lastName, identification);
        this.testScores = scores;
    }

    char calculate() {
        int sum = 0;
        for (int testScore : testScores) {
            sum += testScore;
        }
        int average = sum / testScores.length;

        if (average < 40) {
            return 'T';
        } else if (average < 55) {
            return 'D';
        } else if (average < 70) {
            return 'P';
        } else if (average < 80) {
            return 'A';
        } else if (average < 90) {
            return 'E';
        }

        return 'O';
    }
}

public class Solution {

    public static void main(String[] argh) {
        Scanner scan = new Scanner(System.in);

        String firstName = scan.next();
        String lastName = scan.next();
        int id = scan.nextInt();
        int numScores = scan.nextInt();

        int[] testScores = new int[numScores];
        for(int i = 0; i < numScores; i++){
            testScores[i] = scan.nextInt();
        }
        
        scan.close();
        
        Student s = new Student(firstName, lastName, id, testScores);
        s.printPerson();
        System.out.println("Grade: " + s.calculate());
    }
}
