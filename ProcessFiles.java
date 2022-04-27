import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
class Point{
    double x;
    double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public boolean equals(Point other){
        return this.x == other.x && this.y == other.y;
    }
}


public class ProcessFiles {
    public static void CopyWithLineNumbers(String inFileName, String outFileName){
        try {
            File input = new File(inFileName);
            File output = new File(outFileName);

            Scanner sc = new Scanner(input);
            PrintWriter printer = new PrintWriter(output);

            int lineNumber =0;
            while(sc.hasNextLine()) {
                lineNumber += 1;
                String s = sc.nextLine();
                printer.write(lineNumber + ": ");
                printer.write(s + "\n");
            }
            printer.close();
        }
        catch(FileNotFoundException e) {
            System.err.println("File not found.");
            System.err.println(e);
        }
    }

    public static void Split(String inFileName, String outWordsFileName, String outNumbersFileName){
        try {
            File input = new File(inFileName);
            File outputWords = new File(outWordsFileName);
            File outputNumbers = new File(outNumbersFileName);

            Scanner sc = new Scanner(input);
            PrintWriter wordPrinter = new PrintWriter(outputWords);
            PrintWriter numberPrinter = new PrintWriter(outputNumbers);

            while(sc.hasNext()) {
                if (sc.hasNextDouble()){
                    double d = sc.nextDouble();
                    numberPrinter.write(" " +  d);
                }
                else{
                    String s = sc.next();
                    wordPrinter.write(" " + s);
                }

            }
            wordPrinter.write("\n");
            numberPrinter.write("\n");
            wordPrinter.close();
            numberPrinter.close();
        }
        catch(FileNotFoundException e) {
            System.err.println("File not found.");
            System.err.println(e);
        }


    }

    public static Point loadPointFromFile(String fileName){
        //Your code here

        try {
            File input = new File(fileName);
            Scanner sc = new Scanner(input);
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            return new Point(a, b);
        }
        catch (FileNotFoundException e) {
            System.err.println("File not found.");
            System.err.println(e);
        }
        return null;
    }
    public static void savePointToFile(Point p, String fileName){
        //Your code here
        try {
            PrintWriter printer = new PrintWriter(fileName);
            printer.write(p.x + "\n" + p.y);
            printer.close();
        }
        catch(FileNotFoundException e) {
            System.err.println("File not found.");
            System.err.println(e);
        }

    }

    public static void main(String args[]) {
        Split("sample.txt", "words.txt", "numbers.txt");
        CopyWithLineNumbers("sample.txt", "output.txt");

        Point p1 = new Point(3.0, 5.0);
        savePointToFile(p1, "point.txt");
        Point p2 = loadPointFromFile("point.txt");
        System.out.println("The points are equal? " + p1.equals(p2));
    }
}