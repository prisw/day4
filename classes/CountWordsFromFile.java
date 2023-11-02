package day4.classes;

import java.io.BufferedReader;
import java.io.FileReader;  //top two codes use to buffer improve reading performance
                            //and filereader to read character data from txt.file
import java.io.IOException; //excemption class to handle input or output related error.

public class CountWordsFromFile {
    public static void main (String[] args) {
        try{
            FileReader fr = new FileReader("C:\\Users\\PRISCILLIA WINONA\\Documents\\sdf\\day4\\road_not_taken.txt");
            //FileReader to open the file for reading
            
            BufferedReader br = new BufferedReader(fr);
            //Filereader wrap in BufferedReader for efficient reading

            int wordCount = 0;

            String line;
            //read and print lines from file

            while ((line=br.readLine()) !=null) {

                line = line.trim().replaceAll("[^\\sa-zA-Z0-9]", "");
                //this function to clean the line and check if the line is empty

                if(line.length() <= 0) {
                    continue;
                }

                String[] words = line.split("\\s+");
                //split line into words delimited by single space

                wordCount += words.length;
                //count the number of words and add to total

                //System.out.printf("> line: %s\n", line); 
                //professor's code for printing the line
                //System.out.println(line); 
                //chatgpt code for printing line

            } 
            System.out.println("Word count: " + wordCount);

            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
