package PRACTICE_2024_12_08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SCHOOL_MANAGEMENT {

    // {"OGUZ" = {"MATH" = 40, "BIO" = 50}, "MERVE" = {"MATH" = 90, "BIO" = 80}}

    // MAP >> KEY : VALUE
    Map<String, List<Double>> studentGrades = new HashMap<>();

    public void addStudent(String studentName) {

        if (studentGrades.containsKey(studentName)) {
            System.out.println(studentName + " is already registered.");
        } else {
            studentGrades.put(studentName, new ArrayList<Double>());
            System.out.println(studentName + " is registered.");
        }
    }

    public void addGrade(String studentName, double grade) {
        List<Double> grades = studentGrades.get(studentName);

        if (grades == null) {
            System.out.println("Student " + studentName + " is not in school system.");
        } else {
            grades.add(grade);
        }
    }

    public double averageGrade(String studentName) {

        List<Double> grades = studentGrades.get(studentName);

//        if (grades != null && !grades.isEmpty())  {
//            double sum = 0;
//            for (Double grade : grades) {
//                sum += grade;
//
//            }
//            double average = sum / grades.size();
//            System.out.println("Student " + studentName + " is average grade: " + average);
//            return average;
//        }else {
//            System.out.println("Student " + studentName + " is not in school system or student grade list is empty.");
//            return 0;
//        }

        if (grades == null) {
            System.out.println("Student " + studentName + " is not in school system.");
            return 0;
        } else {
            if (grades.isEmpty()) {
                System.out.println("Student " + studentName + "'s grade list is empty.");
                return 0;
            } else {
                double sum = 0;
                for (Double each : grades) {
                    sum += each;
                }
                double average = sum / grades.size();
                System.out.println("Student " + studentName + " average grade is " + average);

                return average;
            }
        }
    }

    public static void main(String[] args) {

        SCHOOL_MANAGEMENT school = new SCHOOL_MANAGEMENT();

        school.addStudent("OGUZ");
        school.addGrade("OGUZ", 70);
        school.addGrade("OGUZ", 50);

        school.addStudent("MERVE");
        school.addGrade("MERVE", 100);
        school.addGrade("MERVE", 90);

        school.averageGrade("ADEM");
        school.averageGrade("OGUZ");
        school.averageGrade("MERVE");
        System.out.println(school.studentGrades);

    }
}