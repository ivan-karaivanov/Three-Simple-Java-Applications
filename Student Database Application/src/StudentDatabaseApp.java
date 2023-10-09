import java.util.Scanner;

public class StudentDatabaseApp {
    public static void main(String[] args) {
        // An array is created to store student objects
        Student[] students;

        // Get the number of new students to add
        int numOfStudents = getNumberOfStudents();

        // Initialize the array here
        students = new Student[numOfStudents];

        // Populate the student array here
        for (int i = 0; i < numOfStudents; i++) {
            students[i] = createStudent(i + 1);
            students[i].enrollCourses();
            students[i].payTuition();
        }

        // Display the information for each student
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Helper method for the number of new students
    private static int getNumberOfStudents() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of new students to add: ");
        return scanner.nextInt();
    }

    // Helper method to create a new student
    private static Student createStudent(int studentNumber) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter information for Student #" + studentNumber + ":");
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student year (1-4): ");
        int year = scanner.nextInt();

        return new Student(name, year);
    }
}

class Student {
    private static int uniqueID = 1000;
    private String name;
    private int year;
    private String studentID;
    private String courses = "";
    private double balance = 0;
    private static final int courseCost = 600;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        this.studentID = year + "" + uniqueID;
        uniqueID++;
    }

    public void enrollCourses() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter course to enroll (Q to quit): ");
            String course = scanner.nextLine();
            if (course.equalsIgnoreCase("Q")) {
                break;
            }
            if (isValidCourse(course)) {
                courses += "\n  " + course;
                balance += courseCost;
            } else {
                System.out.println("Invalid course. Please enter a valid course.");
            }
        }
    }


    private boolean isValidCourse(String course) {
        return course.equals("History 101") ||
                course.equals("Mathematics 101") ||
                course.equals("English 101") ||
                course.equals("Chemistry 101") ||
                course.equals("Computer Science 101");
    }

    public void payTuition() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to pay: $");
        double payment = scanner.nextDouble();
        if (payment >= balance) {
            System.out.println("Thank you for your payment of $" + payment);
            balance -= payment;
        } else {
            System.out.println("Insufficient payment. Please pay the full tuition amount.");
        }
    }

    @Override
    public String toString() {
        return "Student Information:" +
                "\nName: " + name +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled:" + courses +
                "\nBalance: $" + balance + "\n";
    }
}
