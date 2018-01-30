/*
You have two arrays of strings, words and parts. Return an array that contains the
strings from words, modified so that any occurrences of the substrings from parts are
surrounded by square brackets [], following these guidelines:

If several parts substrings occur in one string in words, choose the longest one. If
there is still more than one such part, then choose the one that appears first
in the string.

Example

For words = ["Apple", "Melon", "Orange", "Watermelon"] and
parts = ["a", "mel", "lon", "el", "An"], the output should be
findSubstrings(words, parts) = ["Apple", "Me[lon]", "Or[a]nge", "Water[mel]on"].

While "Watermelon" contains three substrings from the parts
array, "a", "mel", and "lon", "mel" is the longest substring that appears
first in the string.

Input/Output

[time limit] 3000ms (java)
[input] array.string words

An array of strings consisting only of uppercase and lowercase English letters.

Guaranteed constraints:
0 ≤ words.length ≤ 104,
1 ≤ words[i].length ≤ 30.

[input] array.string parts

An array of strings consisting only of uppercase and lower English letters. Each
string is no more than 5 characters in length.

Guaranteed constraints:
0 ≤ parts.length ≤ 105,
1 ≤ parts[i].length ≤ 5,
parts[i] ≠ parts[j].

[output] array.string
 */

import java.util.HashMap;
import java.util.Map;

public class TriesWordSubstring {

    Tries rootNode = new Tries();

    public static void main(String[] args) {

        TriesWordSubstring triesWordSubstring = new TriesWordSubstring();
        String[] words = {"Apple", "Melon", "Orange", "Watermelon"};
        String[] parts = {"a", "mel", "lon", "el", "An"};

        Map<String, String> wordVsWord = new HashMap<>();
        for (String word : words){
            triesWordSubstring.rootNode.addWord(word);
            wordVsWord.put(word, word);
        }

        for (String part : parts) {
            triesWordSubstring.findStringInWords(part, triesWordSubstring.rootNode, wordVsWord);
        }

        System.out.println(triesWordSubstring.rootNode);
    }

    private void findSubString2(String part, int partIndex, Tries node, Map<String, String> wordVsFormattedWord,
                                String actualWord, String formattedWord) {

        if (node.isCompleteWord()) {
//            System.out.println("Complete word = " + actualWord);
//            System.out.println("Complete formattedWord = " + formattedWord);
            if (formattedWord.indexOf("[") != -1 && formattedWord.indexOf("]") != -1){
                wordVsFormattedWord.put(actualWord, formattedWord);
            }
        }

        for (Map.Entry<Character, Tries> entry : node.getDataMap().entrySet()) {
            actualWord = actualWord + entry.getKey();

            if (partIndex < part.length()) {
                int c = part.charAt(partIndex);

                String prefix = "";
                String postfix = "";
                if (c == entry.getKey()) {
                    if (partIndex == 0) { // first character matched
                        prefix = "[";
                    }
                    if (partIndex == part.length() - 1) {
                        postfix = "]";
                    }
                    formattedWord = formattedWord + prefix + entry.getKey() + postfix;
                } else {
                    formattedWord = actualWord;
                    partIndex = -1;
                }

            } else {
                formattedWord = formattedWord + entry.getKey();
            }

            partIndex++;
            findSubString2(part, partIndex, entry.getValue(), wordVsFormattedWord, actualWord, formattedWord);

            actualWord = "";

        }

    }

    private void findStringInWords(String part, Tries rootNode, Map<String, String> wordVsWord) {

        Map<String, String> wordVsFormattedWord = new HashMap<>();

        findSubString2(part, 0, rootNode, wordVsFormattedWord, "", "");

        for (Map.Entry<String, String> entry : wordVsFormattedWord.entrySet()){
            String formattedValue = entry.getValue();
            String actualValue = wordVsWord.get(entry.getKey());

            String greaterValue = getGreaterValue(actualValue, formattedValue);

            System.out.println(actualValue + " : " + formattedValue + " : " + greaterValue);
            wordVsWord.put(entry.getKey(), greaterValue);
        }

        for (Map.Entry<String, String> entry : wordVsFormattedWord.entrySet()){
//            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    private String getGreaterValue(String actualValue, String formattedValue) {


        if (actualValue.indexOf("[") == -1){
            return formattedValue;
        }
        int startIndex = formattedValue.indexOf("[");
        int endIndex = formattedValue.indexOf("]");
        int actualStartIndex = actualValue.indexOf("[");
        int actualEndIndex = actualValue.indexOf("]");

        int actualLength = actualEndIndex-actualStartIndex;
        int formattedLength = endIndex-startIndex;

        if (formattedLength > actualLength){
            return formattedValue;
        }

        if (actualLength > formattedLength){
            return actualValue;
        }

        if (actualLength == formattedLength){
            if (startIndex < actualStartIndex){
                return formattedValue;
            } else {
                return actualValue;
            }
        }

        return null;
    }


}

class Tries {
    private HashMap<Character, Tries> dataMap = new HashMap<>();
    //    Tries[] triesData = new Tries[128];
    private boolean isCompleteWord;

    public HashMap<Character, Tries> getDataMap() {
        return dataMap;
    }

    public void setDataMap(HashMap<Character, Tries> dataMap) {
        this.dataMap = dataMap;
    }

    public boolean isCompleteWord() {
        return isCompleteWord;
    }

    public void setCompleteWord(boolean completeWord) {
        isCompleteWord = completeWord;
    }

    public void addWord(String s) {
        addWordRecursively(s, 0);
    }

//    public Tries[] getTriesData() {
//        return triesData;
//    }
//
//    public void setTriesData(Tries[] triesData) {
//        this.triesData = triesData;
//    }

    private void addWordRecursively(String s, int index) {
        if (index == s.length()) {
//            System.out.println("Setting complete word");
            this.setCompleteWord(true);
            return;
        }
        char c = s.charAt(index);
        Tries t = dataMap.get(c);
//        int pos = c-'a';
//        Tries t = triesData[c];

        if (t == null) {
            t = new Tries();
            dataMap.put(c, t);
//            triesData[c] = t;
        }
        index++;
        t.addWordRecursively(s, index);
    }
}
