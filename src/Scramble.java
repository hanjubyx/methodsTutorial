import java.util.ArrayList;
import java.util.List;

public class Scramble {

    public static String scrambleWord(String word) {
        char[] letters = word.toCharArray();

        for (int i = 0; i < letters.length - 1; i++) {
            if (letters[i] == 'A' && letters[i + 1] != 'A') {
                char temp = letters[i];
                letters[i] = letters[i + 1];
                letters[i + 1] = temp;
                i++;
            }
        }

        return new String(letters);
    }

    public static void scrambleOrRemove(List<String> wordList) {
        List<String> modifiedList = new ArrayList<>();

        for (String word : wordList) {
            String scrambledWord = scrambleWord(word);
            if (!scrambledWord.equals(word)) {
                modifiedList.add(scrambledWord);
            }
        }

        wordList.clear();
        wordList.addAll(modifiedList);
    }

    public static void main(String[] args) {
        System.out.println(scrambleWord("TAN"));
        System.out.println(scrambleWord("ABRACADABRA"));
        System.out.println(scrambleWord("WHOA"));

        List<String> wordList = new ArrayList<>();
        wordList.add("TAN");
        wordList.add("ABRACADABRA");
        wordList.add("WHOA");
        wordList.add("APPLE");
        wordList.add("EGGS");

        scrambleOrRemove(wordList);
        System.out.println(wordList);
    }
}