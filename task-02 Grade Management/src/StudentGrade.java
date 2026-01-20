import java.util.Scanner;

class Student {
    String name;
    int[] marks;
    double average;
    char grade;

    public Student(String name, int numberOfSubjects) {
        this.name = name;
        this.marks = new int[numberOfSubjects];
    }

    public void inputMarks(Scanner sc) {
        for (int i=0;i< marks.length;i++) {
            while (true) {
                System.out.print("Enter mark of subject " + (i + 1) + " : ");
                int mark = sc.nextInt();
                if (mark >= 0 && mark <= 100) {
                    marks[i] = mark;
                    break;
                }
                else System.out.println("Enter valid mark");
            }
        }
    }

    public void getAverage() {
        int totalMark = 0;
        for(int i : marks) totalMark+=i;
        average = (double) totalMark/marks.length;
    }

    public void getGrade() {
        if (average >80) grade = 'A';
        else if (average >60) grade = 'B';
        else if (average >40) grade = 'C';
        else grade = 'F';
    }

    public void getReport() {
        System.out.println("\n------------Report-------------");
        System.out.println("Name : "+name);
        for (int i=0;i< marks.length;i++) System.out.println("Marks in subject "+(i+1) +" : "+marks[i]);
        System.out.printf("Average Marks: %.2f%n", average);
        System.out.println("Grade achieved : "+(grade=='F'? "Fail":grade));
    }
}

public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student name : ");
        String name = sc.nextLine();
        Student student = new Student(name,3);
        try {
            student.inputMarks(sc);
            student.getAverage();
            student.getGrade();
            student.getReport();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
