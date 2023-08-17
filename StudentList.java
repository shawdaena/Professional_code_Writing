import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static String Line = " ";

    // Read operation
    public static void Reader() {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(Constants.FILE_NAME)));
            Line = bufferedReader.readLine();
        } catch (Exception e) {
        }
    }

    // Write operation
    public static void Write(String substring, String Date) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(Constants.FILE_NAME, true));
            bufferedWriter.write(Constants.SPLIT + substring + Constants.LAST_UPDATE + Date);
            bufferedWriter.close();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {

     //Check arguments of the elements
        if (args[0].equals(Constants.SHOW_NAMES)) {
            System.out.println(Constants.LOADING_DATA);
            Reader();
            String students[] = Line.split(Constants.SPLIT);

            for (String student : students) {
                System.out.println(student);
            }
            System.out.println(Constants.LOADED_DATA);
        }

        // print random student name
        else if (args[0].equals(Constants.RANDOM_NAME)) {
            System.out.println(Constants.LOADING_DATA);
            Reader();
            //System.out.println(r);
            String students[] = Line.split(Constants.SPLIT);
            Random random = new Random();
            int number = random.nextInt(4);
            System.out.println(students[number]);
            System.out.println(Constants.LOADED_DATA);
        }

        // Add another student name
        else if (args[0].contains(Constants.ADD_NAME)) {
            System.out.println(Constants.LOADING_DATA);
            String students[] = Line.split(Constants.SPLIT);
            String substring = args[0].substring(1);
            Date Line = new Date();
            String df = Constants.DATE_FORMAT;
            DateFormat dateFormat = new SimpleDateFormat(df);
            String Date = dateFormat.format(Line);
            Write(substring, Date);
            System.out.println(Constants.LOADED_DATA);

        }

        // check a student name in the file
        else if (args[0].contains(Constants.QUERY)) {
            System.out.println(Constants.LOADING_DATA);
            Reader();
            String students[] = Line.split(Constants.SPLIT);
            //boolean done = false;
            String substring = args[0].substring(1);
            for (int idx = 0; idx < students.length; idx++) {
                if (students[idx].equals(substring)) {
                    System.out.println(Constants.FOUND);
                    break;
                    //done = true;
                }
            }
            System.out.println(Constants.LOADED_DATA);
        }

        //the logic behind the count operation
        else if (args[0].contains(Constants.COUNT_WORDS)) {
            System.out.println(Constants.LOADING_DATA);
            Reader();
            char students[] = Line.toCharArray();
            // boolean in_word = false;
            int count = 0;
            for (char ch : students) {
                if (ch == ' ') {
                    count++;
                }
            }
            System.out.println(count / 2 + Constants.WORDS_FOUND + students.length);
            System.out.println(Constants.LOADED_DATA);
        }

        //STEP Adds handling for case when user enters invalid argumentsSTEP
        else {
            System.out.println(Constants.INVALID);
        }

    }
}