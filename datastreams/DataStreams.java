package org.example.datastreams;

import java.io.*;

class Student {
    int rollNumber;
    String name;
    double gpa;

    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }
}

public class DataStreams {

    public static void main(String[] args) {
        String filePath = "students.dat";

        //Store student details
        Student student1 = new Student(101, "Alice", 3.85);
        Student student2 = new Student(102, "Bob", 3.90);

        //writing student data to binary file using DataOutputStream
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {

            writeStudentData(dos, student1);
            writeStudentData(dos, student2);

            System.out.println("Student details have been written to the file.");
        } catch (IOException e) {
            System.out.println("Error while writing student data: " + e.getMessage());
        }

        //Reading student details from the binary file using DataInputStream
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            //Read and display student details
            System.out.println("\nReading student details from the file:");
            while (dis.available() > 0) {
                Student student = readStudentData(dis);
                System.out.println("Roll Number: " + student.rollNumber + ", Name: " + student.name + ", GPA: " + student.gpa);
            }
        } catch (IOException e) {
            System.out.println("Error while reading student data: " + e.getMessage());
        }
    }


    private static void writeStudentData(DataOutputStream dos, Student student) throws IOException {
        dos.writeInt(student.rollNumber);
        dos.writeUTF(student.name);
        dos.writeDouble(student.gpa);
    }

    //Method to read student data using DataInputStream
    private static Student readStudentData(DataInputStream dis) throws IOException {
        int rollNumber = dis.readInt();
        String name = dis.readUTF();
        double gpa = dis.readDouble();

        return new Student(rollNumber, name, gpa);
    }
}
