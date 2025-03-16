import ch.qos.logback.core.encoder.JsonEscapeUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;


class WordNotFoundException extends RuntimeException{
    public WordNotFoundException(String message){
        super(message);
    }
}

public class FrequencyWords {
    private static String myText;
    private static String[] myArray;

    public static void main(String[] args) {
        Properties p = new Properties();
        try {
            FileInputStream file = new FileInputStream("OR.properties");
            p.load(file);
            file.close();
            myText = p.getProperty("text");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(myText);
        myArray = myText.split(" ");
        System.out.println(myArray[1]);
        Map<String, Integer> myMap = new HashMap<>();
        for (String str : myArray) {
            int count = 0;
            String word = str.toLowerCase();
            if (myMap.get(String.valueOf(word)) == null) {
                myMap.put(word, ++count);
            } else {
                count = myMap.get(String.valueOf(word));
                myMap.put(word, ++count);
            }
        }
        System.out.println(myMap);
           /* Scanner scanner = new Scanner(System.in);
            System.out.print("Which word do you want to search in the paragraph?   : ");
            String choice = (scanner.nextLine());
                for(String s: myArray){
                    String word = s.toLowerCase();
                    if (choice.equals(word)) {
                        System.out.println(choice+ " word is present in the paragraph");
                    } else {
                        throw new WordNotFoundException(choice+" word is not present");
                    }
                }*/
                Scanner scanner = new Scanner(System.in);
                System.out.print("Which word do you want to search in the paragraph? : ");
                String choice = scanner.nextLine().toLowerCase(); // Convert input to lowercase

                boolean found = false; // Flag to track word existence

                for (String s : myArray) {
                    if (s.equalsIgnoreCase(choice)) { // Case-insensitive check
                        found = true;
                        break; // Stop searching once found
                    }
                }
                if (found) {
                    System.out.println(choice + " word is present in the paragraph");
                } else {
                    throw new WordNotFoundException(choice + " word is not present");
                }
            }

            }





