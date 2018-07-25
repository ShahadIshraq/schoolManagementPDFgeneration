import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



public class StudentReport {
    private String FILE ;
    private String roll;
    private String term;
    private String name  ;
    private int Class ;
    private int merit ;
    private int students ;
    private String subjects[] ;
    private int full_marks [] ;
    private double ct1_marks[];
    private double ct2_marks[];
    private double ct3_marks[];
    private double final_marks[];
    private double lab_marks[];
    private double total_marks[];
    private double highest_marks[];
    private double gpas[];
    private double total;
    private double gpa;
    private String letter_grade;


    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 20,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    private static final Font subUnderlinedBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,    Font.BOLD|Font.UNDERLINE);

    public StudentReport(String FILE, String roll, String term, String name, int aClass, int merit, int students, String[] subjects, int[] full_marks, double[] ct1_marks, double[] ct2_marks, double[] ct3_marks, double[] final_marks, double[] lab_marks, double[] total_marks, double[] highest_marks, double[] gpas, double total, double gpa, String letter_grade) {
        this.FILE = FILE+roll+"_"+term+"_report.pdf";
        this.roll = roll;
        this.term = term;
        this.name = name;
        Class = aClass;
        this.merit = merit;
        this.students = students;
        this.subjects = subjects;
        this.full_marks = full_marks;
        this.ct1_marks = ct1_marks;
        this.ct2_marks = ct2_marks;
        this.ct3_marks = ct3_marks;
        this.final_marks = final_marks;
        this.lab_marks = lab_marks;
        this.total_marks = total_marks;
        this.highest_marks = highest_marks;
        this.gpas = gpas;
        this.total = total;
        this.gpa = gpa;
        this.letter_grade = letter_grade;
    }


    public boolean generatePDF() {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            addTitlePage(document);
            //addContent(document);
            document.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    private  void addMetaData(Document document) {
        document.addTitle(roll);
        document.addSubject(term+" report");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Shahad Ishraq");
        document.addCreator("Mamun Rahman");
    }

    private  void addTitlePage(Document document)
            throws DocumentException {

        String year = Integer.toString(LocalDate.now().getYear());
        String exam = term+", "+year;
        Image img = null;
        try {
            img = Image.getInstance("resources/logo.jpg");
        } catch (IOException e) {
            System.out.println("Image not found.");
        }
        img.scaleToFit(100f, 100f);
        img.setAbsolutePosition(30f, 700f);
        document.add(img);

        Paragraph preface = new Paragraph();
        preface.setAlignment(Element.ALIGN_CENTER);
        addEmptyLine(preface, 2);

        preface.add(new Paragraph("Snanghata High School", catFont));

        preface.add(new Paragraph("Kalkini, Madaripur", smallBold));
        preface.add(new Paragraph("Academic Transcript ", smallBold));
        preface.add(new Paragraph(exam, subUnderlinedBold));
        addEmptyLine(preface, 3);

        document.add(preface);

        //Student Details
        PdfPTable table = new PdfPTable(2);
        table.setTotalWidth(new float[]{ 60, 280 });
        table.setLockedWidth(true);
        // first row
        PdfPCell cell = new PdfPCell(new Phrase("Name :"));
        cell.setFixedHeight(25);
        cell.setBorder(Rectangle.BOX);
        cell.setColspan(1);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(name));
        cell.setFixedHeight(25);
        cell.setVerticalAlignment(PdfPCell.LEFT);
        cell.setBorder(Rectangle.BOX);
        cell.setColspan(1);
        table.addCell(cell);

        //second row
        cell = new PdfPCell(new Phrase("Class :"));
        cell.setFixedHeight(25);
        cell.setBorder(Rectangle.BOX);
        cell.setColspan(1);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(Integer.toString(Class)));
        cell.setFixedHeight(25);
        cell.setBorder(Rectangle.BOX);
        cell.setColspan(1);
        table.addCell(cell);

        // third row
        cell = new PdfPCell(new Phrase("Roll :"));
        cell.setFixedHeight(25);
        cell.setBorder(Rectangle.BOX);
        cell.setColspan(1);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(roll));
        cell.setFixedHeight(25);
        cell.setBorder(Rectangle.BOX);
        cell.setColspan(1);
        table.addCell(cell);

        document.add(table);

        preface = new Paragraph();
        preface.setAlignment(Element.ALIGN_CENTER);
        // We add one empty line
        addEmptyLine(preface, 2);
        // Lets write a big header

        document.add(preface);

        // Main Table

        table = new PdfPTable(11);
        table.setWidthPercentage(100);
        table.setWidths(new float[] { 1, 5, 3, 2, 2, 2, 2, 2, 3, 3,2 });
        // first row
        String labels [] = {"SL", "Subject", "Full Marks", "CT 1", "CT 2", "CT 3", "Final", "Lab", "Total", "Highest" , "GPA"};
        for (int i = 0 ; i < labels.length ; i++) {
            cell = new PdfPCell(new Phrase(labels[i]));
            cell.setBorder(Rectangle.BOX);
            cell.setColspan(1);
            table.addCell(cell);
        }

        // next rows
        for (int i = 0 ; i < subjects.length ; i++) {
            //SL
            cell = new PdfPCell(new Phrase(Integer.toString(i+1)));
            cell.setBorder(Rectangle.BOX);
            cell.setColspan(1);
            table.addCell(cell);

            //subject
            cell = new PdfPCell(new Phrase(subjects[i]));
            cell.setBorder(Rectangle.BOX);
            cell.setColspan(1);
            table.addCell(cell);

            //full marks
            cell = new PdfPCell(new Phrase(Double.toString(full_marks[i])));
            cell.setBorder(Rectangle.BOX);
            cell.setColspan(1);
            table.addCell(cell);

            //CT1 marks
            cell = new PdfPCell(new Phrase(ct1_marks[i]==-1?"":Double.toString(ct1_marks[i])));
            cell.setBorder(Rectangle.BOX);
            cell.setColspan(1);
            table.addCell(cell);

            //CT2 marks
            cell = new PdfPCell(new Phrase(ct2_marks[i]==-1?"":Double.toString(ct2_marks[i])));
            cell.setBorder(Rectangle.BOX);
            cell.setColspan(1);
            table.addCell(cell);

            //CT3 marks
            cell = new PdfPCell(new Phrase(ct3_marks[i]==-1?"":Double.toString(ct3_marks[i])));
            cell.setBorder(Rectangle.BOX);
            cell.setColspan(1);
            table.addCell(cell);

            //final marks
            cell = new PdfPCell(new Phrase(final_marks[i]==-1?"":Double.toString(final_marks[i])));
            cell.setBorder(Rectangle.BOX);
            cell.setColspan(1);
            table.addCell(cell);

            //lab marks
            cell = new PdfPCell(new Phrase(lab_marks[i]==-1?"":Double.toString(lab_marks[i])));
            cell.setBorder(Rectangle.BOX);
            cell.setColspan(1);
            table.addCell(cell);

            //total marks
            cell = new PdfPCell(new Phrase(total_marks[i]==-1?"":Double.toString(total_marks[i])));
            cell.setBorder(Rectangle.BOX);
            cell.setColspan(1);
            table.addCell(cell);

            //highest marks
            cell = new PdfPCell(new Phrase(highest_marks[i]==-1?"":Double.toString(highest_marks[i])));
            cell.setBorder(Rectangle.BOX);
            cell.setColspan(1);
            table.addCell(cell);

            //gpas
            cell = new PdfPCell(new Phrase(gpas[i]==-1?"":Double.toString(gpas[i])));
            cell.setBorder(Rectangle.BOX);
            cell.setColspan(1);
            table.addCell(cell);
        }

        //Row with Total
        //"Total"
        cell = new PdfPCell(new Phrase("Total"));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setBorder(Rectangle.BOX);
        cell.setColspan(8);
        table.addCell(cell);

        //Total Marks
        cell = new PdfPCell(new Phrase(Double.toString(total)));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setBorder(Rectangle.BOX);
        cell.setColspan(1);
        table.addCell(cell);

        //blank
        cell = new PdfPCell(new Phrase(""));
        cell.setBorder(Rectangle.BOX);
        cell.setColspan(1);
        table.addCell(cell);

        //Total GPA
        cell = new PdfPCell(new Phrase(Double.toString(gpa)));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setBorder(Rectangle.BOX);
        cell.setColspan(1);
        table.addCell(cell);

        document.add(table);

        preface = new Paragraph();
        // We add empty lines
        addEmptyLine(preface, 3);
        document.add(preface);

        // Summary Table
        table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setWidths(new float[] { 1, 1, 1, 1 });

        //"GPA"
        cell = new PdfPCell(new Phrase("Grade Point : "+Double.toString(gpa)));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setBorder(Rectangle.BOX);
        cell.setColspan(2);
        table.addCell(cell);

        //"GPA"
        cell = new PdfPCell(new Phrase("Merit Position : "+Integer.toString(merit)));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setBorder(Rectangle.BOX);
        cell.setColspan(2);
        table.addCell(cell);

        // Letter Grade
        cell = new PdfPCell(new Phrase("Letter Grade : "+ letter_grade));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setBorder(Rectangle.BOX);
        cell.setColspan(2);
        table.addCell(cell);

        // Total Students
        cell = new PdfPCell(new Phrase("Total Students : "+ Integer.toString(students)));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setBorder(Rectangle.BOX);
        cell.setColspan(2);
        table.addCell(cell);


        cell = new PdfPCell(new Phrase("Total Classes "));
        cell.setBorder(Rectangle.BOX);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setColspan(1);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(""));
        cell.setBorder(Rectangle.BOX);
        cell.setColspan(1);
        table.addCell(cell);


        cell = new PdfPCell(new Phrase("Present "));
        cell.setBorder(Rectangle.BOX);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setColspan(1);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(""));
        cell.setBorder(Rectangle.BOX);
        cell.setColspan(1);
        table.addCell(cell);

        document.add(table);


        preface = new Paragraph();
        // We add empty lines
        addEmptyLine(preface, 5);
        document.add(preface);


        // Summary Table
        table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setWidths(new float[] { 4, 1, 4, 1, 4 });

        cell = new PdfPCell(new Phrase("Class Teacher"));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setBorder(Rectangle.TOP);
        cell.setColspan(1);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(""));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setColspan(1);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Parent / Guardian"));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setBorder(Rectangle.TOP);
        cell.setColspan(1);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(""));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setColspan(1);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Head Master"));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setBorder(Rectangle.TOP);
        cell.setColspan(1);
        table.addCell(cell);

        document.add(table);

    }




    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}