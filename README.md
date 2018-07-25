# PDF report generation 
## for School Management System


There are two files.


**1. main.java
2. StudentReport.java**

The StudentReport.java file is the class that you will be using in your code. The main.java file shows how to use it.
You basically need to initialize a StudentReport object with the necessary informations. Then calling the generateReport() method will generate the pdf.
The pdf generation is done using iText library. So you need to add the **itextpdf-5.1.0.jar** file as a library like the sqlite.jar file.

##What are the members of the class StudentReport?

1. String FILE : the path to the directory where the reports will be saved.
2. String roll : student's roll number.
3. String term : the term examination of whose report is to be generated.
4. String name : name of the student.
5. int Class : class of the student.
6. int merit : merit position of the student in the class.
7. int students : number of total students in that class.
8. String subjects[] : array of the subjects of the student.
9. int full_marks [] : array containing the full marks of the subjects. The full marks of a subject is in the same index of this array as the subject is in the *subjects* array. 
10. double ct1_marks[] : ct1 mark for the subjects. Index of a subject in the *subjects* array is  the  index for its corresponding mark in this array.
11. double ct2_marks[] : likewise.
12. double ct3_marks[] : likewise.
13. double final_marks[] : likewise.
14. double lab_marks[] : likewise.
15. double total_marks[]: likewise.
16. double highest_marks[] : likewise.
17. double gpas[] : likewise. GPA for the specific subject.
18. double total : total marks of the student.
19. double gpa : total GPA of the student.
20. String letter_grade : letter grade for the GPA, i.e. A+,A, ect.

***
###The logo.jpg file needs to be in there for the pdf to be generated.
Set the path fo the logo in the StudentReport.java file to your convenience. It is set in the *addTitlePage()* method.


