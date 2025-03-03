import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AnagramSolver {

    private AnagramSolver() {};

    /**
     * Input: name of text file (containing English words).
     * Output: a hashmap of lists of words that are anagrams.
     * @param filename
     * @return
     */
    public static HashMap<String, ArrayList<String>> anagrams(String filename) {
        HashMap<String, ArrayList<String>> result = new HashMap<>();
        File file = new File(filename);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String word = scanner.nextLine().toLowerCase();
                char[] chars = word.toCharArray();
                Arrays.sort(chars); // Sort the array
                String key = new String(chars);
                // Check if the key exists
                if (!result.containsKey(key)) {
                    result.put(key, new ArrayList<>());
                    result.get(key).add(word);
                }
                // Add the word to the list in the HashMap
                else{
                    result.get(key).add(word);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: largest list of words in hashmap that are anagrams.
     * @param anagrams
     * @return
     */
    public static ArrayList<String> mostFrequentAnagram(HashMap<String, ArrayList<String>> anagrams) {
        ArrayList<String> largestList = new ArrayList<>();
        for (ArrayList<String> list : anagrams.values()) {
            if (list.size() > largestList.size()) {
                largestList = list;
            }
        }
        return largestList;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: prints all key value pairs in the hashmap.
     * @param anagrams
     */
    public static void printKeyValuePairs(HashMap<String, ArrayList<String>> anagrams) {
        for(String i:anagrams.keySet()){
            ArrayList<String> a = anagrams.get(i);
            System.out.println(i + ": " +a);
        }
    }

}
