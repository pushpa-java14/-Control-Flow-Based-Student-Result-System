import java.util.Scanner;
public class StudentResultProcessing {

    // Method to validate marks
    public static boolean validateMarks(int marks) {
        if (marks < 0 || marks > 100) {
            return false;
        }
        return true;
    }

    // Method to calculate grade using switch
    public static char calculateGrade(int percentage) {
        switch (percentage / 10) {
            case 10:
            case 9:
                return 'A';
            case 8:
                return 'B';
            case 7:
                return 'C';
            case 6:
                return 'D';
            case 5:
                return 'E';
            default:
                return 'F';
        }
    }

    // Method to display final result
    public static void displayResult(String name, int total, int percentage, char grade) {
        System.out.println("\n----- RESULT SUMMARY -----");
        System.out.println("Student Name : " + name);
        System.out.println("Total Marks  : " + total + " / 300");
        System.out.println("Percentage   : " + percentage + "%");
        System.out.println("Grade        : " + grade);
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter Student Name (or EXIT to stop): ");
            String name = sc.next();

            if (name.equalsIgnoreCase("EXIT")) {
                break; // break loop
            }

            int total = 0;

            for (int i = 1; i <= 3; i++) {
                System.out.print("Enter marks for Subject " + i + ": ");
                int marks = sc.nextInt();

                if (!validateMarks(marks)) {
                    System.out.println("Invalid marks! Please enter 0 to 100.");
                    i--;           // repeat same subject
                    continue;      // skip remaining code
                }

                total += marks;
            }

            int percentage = total / 3;
            char grade = calculateGrade(percentage);

            displayResult(name, total, percentage, grade);
        }

        sc.close();
        System.out.println("\nProgram Terminated.");
    }
}
