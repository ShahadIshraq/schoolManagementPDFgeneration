import java.time.LocalDate;

public class main {
    private static String FILE = "./FirstPdf.pdf";
    private static String year = Integer.toString(LocalDate.now().getYear());
    private static String exam = "First Term Examination"+", "+year;
    private static String term = "First Term Examination";
    private static String name = "Shahad Ishraq";
    private static String roll = "1305022";
    private static int Class = 10;
    private static int merit = 5;
    private static int students = 60;

    private static String subjects[] = {"Bangla","Englis", "Physics", "Chemistry", "Biology"};
    private static int full_marks [] = {100,100,100,75,100};
    private static double ct1_marks[] = {10,11,12,14,15};
    private static double ct2_marks[] = {0,1,21,3,5};
    private static double ct3_marks[] = {5,4,3,2,1};
    private static double final_marks[] = {100,99,98,97,96};
    private static double lab_marks[] = {-1,-1,10,15,21};
    private static double total_marks[] = {95,96,97,98,99};
    private static double highest_marks[] = {10,11,12,13,14};
    private static double gpas[] = {3.3,3.2,3.4,3.5,3.6};
    private static double total = 991;
    private static double gpa = 3.61;
    private static String letter_grade = "A";



    public static void main(String[] args) {
        StudentReport studentReport = new StudentReport(FILE,roll,term,name,Class,merit,students,subjects,full_marks,ct1_marks,ct2_marks,ct3_marks,final_marks,lab_marks,total_marks,highest_marks,gpas, total, gpa, letter_grade);
        studentReport.generatePDF();
    }


}