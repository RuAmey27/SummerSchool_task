import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * cgpa_calculator
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class cgpa_calculator {
    // Static HashMap for grade points
    static HashMap<String, Integer> gradePoints = new HashMap<>();
    static {
        gradePoints.put("A+", 10);
        gradePoints.put("A", 9);
        gradePoints.put("B+", 8);
        gradePoints.put("B", 7);
        gradePoints.put("C+", 6);
        gradePoints.put("C", 5);
        gradePoints.put("D", 4);
        gradePoints.put("F", 0);
    }

    // Method to calculate CGPA based on grades
    public static double calculateCGPA(Map<String, Integer> subjectsCredits, Map<String, String> grades) {
        double totalCredits = 0.0;
        double totalGradePoints = 0.0;

        // Iterate through subjects and their credits
        for (Map.Entry<String, Integer> entry : subjectsCredits.entrySet()) {
            String subject = entry.getKey();
            int credits = entry.getValue();

            // Retrieve grade for the subject
            String grade = grades.get(subject);

            // Calculate grade points and add to total
            if (grade != null && gradePoints.containsKey(grade)) {
                int gradePoint = gradePoints.get(grade);
                totalGradePoints += gradePoint * credits;
                totalCredits += credits;
            }
        }

        // Calculate CGPA
        if (totalCredits > 0) {
            return totalGradePoints / totalCredits;
        } else {
            return 0.0; // Handle division by zero gracefully
        }
    }

    public static void main(String[] args) {
        // Example usage
        Department computerScienceDept = new Department();

        // Define subjects and credits for semester 1
        Map<String, Integer> semester1Subjects = new HashMap<>();
        semester1Subjects.put("Mathematics", 2);
        semester1Subjects.put("Programming", 2);

        // Add semester 1 to Computer Science department
        computerScienceDept.addSemester("semester1", semester1Subjects);

        // Define subjects and credits for semester 2
        Map<String, Integer> semester2Subjects = new HashMap<>();
        semester2Subjects.put("Data Structures", 2);
        semester2Subjects.put("Algorithms", 2);
        semester2Subjects.put("Database Systems", 3);

        // Add semester 2 to Computer Science department
        computerScienceDept.addSemester("semester2", semester2Subjects);

        // Simulate input of grades
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter department name (e.g., Computer Science): ");
        String deptName = scanner.nextLine();

        System.out.print("Enter semester name (e.g., semester1): ");
        String semesterName = scanner.nextLine();

        // Get subjects and credits for the specified semester
        Map<String, Integer> subjectsCredits = computerScienceDept.getSubjectsAndCredits(semesterName);

        // Prompt user for grades for each subject
        Map<String, String> grades = new HashMap<>();
        for (String subject : subjectsCredits.keySet()) {
            System.out.print("Enter grade for " + subject + ": ");
            String grade = scanner.nextLine().toUpperCase(); // Convert to uppercase for consistency
            grades.put(subject, grade);
        }

        // Calculate CGPA based on entered grades
        double cgpa = calculateCGPA(subjectsCredits, grades);
        System.out.println("CGPA for " + deptName + " in " + semesterName + " is: " + cgpa);

        scanner.close();
    }
}

/**
 * Department
 */
class Department {
    private Map<String, Map<String, Integer>> semesters;

    public Department() {
        // Initialize the semesters map
        semesters = new HashMap<>();
    }

    // Method to add a semester with subjects and credits
    public void addSemester(String semesterName, Map<String, Integer> subjectsCredits) {
        semesters.put(semesterName, subjectsCredits);
    }

    // Method to get subjects and their credits for a specific semester
    public Map<String, Integer> getSubjectsAndCredits(String semesterName) {
        return semesters.get(semesterName);
    }
}