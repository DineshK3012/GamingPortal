package GamingPortal;

//importing packages
import java.io.*;
import javax.swing.*;

/** A class for file handling and Exception handling used in the project */
public class input {
    static String name;
    static String score;
    static String names[];
    static int scores[];
    static int len1;
    static int len2;
    static int HighestScore = 0;

    // Method which takes the text from the Name TextField and write it into the
    // Names.text file
    public static void inputName(JTextField user) {
        // takes the text from the name TextField
        name = user.getText().toString();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Names.txt", true))) {
            bw.write(name); // writing the name into the file
            bw.newLine();
            bw.close();

        } catch (IOException e1) {
            System.out.println("ERROR CAUGHT: " + e1);
        }
    }

    // Method which takes the score from the snake game and write it into the
    // Scores.text file
    public static void inputScore(int sc) {
        score = Integer.toString(sc);

        try (BufferedWriter bw1 = new BufferedWriter(new FileWriter("Scores.txt", true))) {
            bw1.write(score); // writing the score into the file
            bw1.newLine();
            bw1.close();

        } catch (IOException e2) {
            System.out.println("ERROR CAUGHT: " + e2);
        }
    }

    // method to find number of names and number of scores
    public static void length() {
        len1 = 0; // variable to store the number of names
        len2 = 0; // variable to store the number of scores
        String str1;
        String str2;

        // taking input for names from the names file
        try {
            BufferedReader sizeName = new BufferedReader(new FileReader("Names.txt"));
            BufferedReader sizeScore = new BufferedReader(new FileReader("Scores.txt"));

            do {
                str1 = sizeName.readLine();
                if (str1 != null) {
                    len1++; // increment the variable value everytime it reads any name from the file
                }
            } while (str1 != null);

            do {
                str2 = sizeScore.readLine();
                if (str2 != null) {
                    len2++; // increment the variable value everytime it reads any name from the file
                }
            } while (str2 != null);

            sizeName.close();
            sizeScore.close();

        } catch (IOException e) {
            System.out.println("I/O Exception " + e);
        }
    }

    // method to take input for names and score from the files and store it into
    // their respective arrays
    public static void TakingInput() {
        String nm;
        String sc;
        int x = 0; // variable for storing index of the current name in the names array
        int y = 0; // variable for storing index of the current name in the scores array

        // taking input for names and for scores from the their respective files
        try {
            BufferedReader file1 = new BufferedReader(new FileReader("Names.txt"));
            BufferedReader file2 = new BufferedReader(new FileReader("Scores.txt"));

            do {
                // reading the name from the file one by one
                nm = file1.readLine();
                if (nm != null) {
                    names[x] = nm; // storing the into the names array at index x
                    x++; // incrementing the index after storing a name
                }
            } while (nm != null && x < len1);

            do {
                // reading the score from the file one by one
                sc = file2.readLine();
                if (sc != null) {
                    scores[y] = Integer.parseInt(sc); // storing the into the scores array at index y
                    y++; // incrementing the index after storing a score
                }
            } while (sc != null && y < len2);

            file1.close();
            file2.close();

        } catch (IOException e) {
            System.out.println("I/O Exception " + e);
        }
    }

    // method to sort the scores array and names array in the descending order
    public static void sort() {
        int temp = 0; // temporary integer variable to store score
        String str; // temporary string variable to store name

        // sort the score array in descending order also change the ordering of name
        // acc. to the scores of that person
        for (int i = 0; i < len2; i++) {
            for (int j = i + 1; j < len2; j++) {
                if (scores[i] < scores[j]) {
                    temp = scores[i];
                    scores[i] = scores[j];
                    scores[j] = temp;

                    str = names[i];
                    names[i] = names[j];
                    names[j] = str;
                }
            }
        }
        HighestScore = scores[0]; // stores the score at First index in the HightestScore integer variable

        // writing the highest score in the separate file
        try (BufferedWriter bw2 = new BufferedWriter(new FileWriter("Highscore.txt"))) {
            // writing the highest score into the file
            bw2.write(Integer.toString(HighestScore));
            bw2.close();

        } catch (IOException e2) {
            System.out.println("ERROR CAUGHT: " + e2);
        }
    }

    // method to read the highest score from the Highscore.txt file
    public static void highScore() {
        try (BufferedReader file3 = new BufferedReader(new FileReader("Highscore.txt"))) {
            HighestScore = Integer.parseInt(file3.readLine()); // reading the high score
            file3.close();
        } catch (

        IOException e3) {
            System.out.println("I/O Exception " + e3);
        }
    }
}
