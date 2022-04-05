import java.io.File;
import java.io.*;
import java.util.*;

public class Dictionary {
    private ArrayList<String> words ;
    int shortest;
    int longest;

    public Dictionary(String filepath, int shortest, int longest)  {

        words = new ArrayList<>();
        this.shortest = shortest;
        this.longest = longest;
        //try catch block
        try {
            File newFile = new File(filepath);
            Scanner fileScan = new Scanner(newFile);

            //checks if document has a next line, then splits the CSV file into a string array of the words in that line
            while (fileScan.hasNextLine()) {
                String[] wordArray = (fileScan.nextLine()).split(",");
                //enhanced for loop trims each word in the wordArray, puts it into uppercase
                for (String s : wordArray) {
                    String word = (s.trim()).toUpperCase();
                    //checks if the word is a duplicate, and if it is within the specified length values. If it is, add it to the words arraylist
                    if (!words.contains(word) && word.length() >= shortest && word.length() <= longest) {
                        words.add(word);
                        Collections.sort(words);
                    }
                }
            }

        } catch (IOException e) {
            System.out.print("Whoops");

        }


    }

    public ArrayList getArrayList(){
        return words;
    }

    public boolean add(String word) {
        //trims and uppercases word
        String modifiedWord = (word.trim()).toUpperCase();
        //checks if word is in words, if its within the range specified, and adds
        if (!words.contains(modifiedWord) && modifiedWord.length() >= shortest && word.length() <= longest) {
            words.add(modifiedWord);
            Collections.sort(words);

            return true;
        }else{
            return false;
        }

    }

    public String nextWord(){
        if(words.isEmpty()){
            return "";

        }else{
            int random = (int)(Math.random() * words.size());
            return words.get(random);
        }
    }

    public boolean inDictionary(String word){
        String s = word.toUpperCase();
        return words.contains(s);
    }

}