import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class WPM {
    public static void main(String[] args) throws InterruptedException {
        int average = 0;
        String filePath = System.getProperty("user.dir");
        System.out.println(filePath);
        Dictionary words = new Dictionary(filePath + "\\src\\WordFileLarge.csv",1, 30);
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the amount of words you would like");
        int numOfWords = scan.nextInt();
        scan.nextLine();
        String[] wordsGiven = new String[numOfWords];
            System.out.println("3...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("2...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("1...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("GO!");

            int[] lengths = new int[numOfWords];
            for(int i = 0; i < numOfWords; i++) {
                String s = words.nextWord();
                System.out.print(s + " ");
                wordsGiven[i] = s;
                lengths[i] = s.length();
            }

            double startingTime = LocalTime.now().toNanoOfDay();
System.out.println();
            for(int i : lengths) {
                 average = average + i;
            }
            int averageWordLength = average / numOfWords;

            String typedWords = scan.nextLine().toUpperCase();
            String[] typedWordsArray = typedWords.split(" ");

            if(Arrays.equals(typedWordsArray, wordsGiven)) {
                double endingTime = LocalTime.now().toNanoOfDay();
                double elapsedTime = endingTime - startingTime;
                double seconds = elapsedTime / 1000000000.0;
                double WPM = ((typedWords.length() / 5) / seconds) * 60;
                System.out.println("WPM IS " + ((int)(WPM) + "!"));

            }else{
                System.out.println("Spelling is incorrect. Restart.");
            }
        }
}
