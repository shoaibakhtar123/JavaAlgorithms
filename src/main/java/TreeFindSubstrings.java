import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
public class TreeFindSubstrings {
    public static void main(String[] args) {

        TreeFindSubstrings treeFindSubstrings = new TreeFindSubstrings();
        String[] words = {"Apple", "Melon", "Orange", "Watermelon"};
//        String[] words = {"Orange"};
        String[] parts = {"a", "mel", "lon", "el", "An"};
//        String[] words = {"televise"};
//        String[] parts = {"el", "ise","i"};


        treeFindSubstrings.findSubstrings(words, parts);

        for (String word : words){
            System.out.println(word);
        }

    }

    String[] findSubstrings(String[] words, String[] parts) {

        if (parts.length == 0){
            return words;
        }

        if (words.length == 0){
            return words;
        }

        int maxLength = isMaxPartLengthAvailable(words);

        ArrayList<String>[] organizedParts = getOrganizedParts(parts, maxLength);
        for (int i = 0; i < words.length; i++) {
            String updateWord = getUpdatedStringModified(words[i], organizedParts);
            words[i] = updateWord;
        }
        return words;
    }

    private int isMaxPartLengthAvailable(String[] words) {

        int tempLength = 0;

        for (String word : words){

            int wordLength = word.length();
            if (wordLength > 5){
                return 5;
            }
            if (wordLength > tempLength){
                tempLength = wordLength;
            }


        }
        return tempLength;
    }

    private String getUpdatedStringModified(String word, ArrayList<String>[] organizedParts) {

        boolean found = false;

        int tempIndex = 31;
        String partFinal = "";

        for (int i = organizedParts.length-1; i >=0 ; i--) {
            for (String part : organizedParts[i]){
                if (part.length() > word.length()){
                    break;
                }
                if (word.indexOf(part) != -1){
                    found = true;
                    int index = word.indexOf(part);
                    if (index < tempIndex){
                        tempIndex = index;
                        partFinal = part;
                    }
                }
            }

            if (found){
                break;
            }

        }

        if (found){
            word = word.substring(0, tempIndex) + "[" + partFinal + "]" + word.substring(tempIndex+partFinal.length());
        }

        return word;
    }

    private ArrayList<String>[] getOrganizedParts(String[] parts, int maxLength) {

        ArrayList<String>[] partSizeArray = new ArrayList[maxLength];

        for (int i = 0; i < maxLength; i++) {
            partSizeArray[i] = new ArrayList<>();
        }

        for (int i = 0; i < parts.length; i++) {
            if (parts[i].length() > maxLength){
                continue;
            }
            partSizeArray[parts[i].length()-1].add(parts[i]);
        }

        return partSizeArray;
    }

    private String getModifiedString(String word, TreeMap<Integer, String> treeMap) {

        Set<Map.Entry<Integer, String>> entries = treeMap.entrySet();

        String maxPart = "";
        int lowestIndex = 0;

        int index;
        String part;
        for (Map.Entry<Integer, String> entry : entries){

            index = entry.getKey();
            part = entry.getValue();
            if (maxPart.length() < part.length()){
                maxPart = part;
                lowestIndex = index;
            } else if ((maxPart.length() == part.length()) && lowestIndex > index){
                maxPart = part;
                lowestIndex = index;
            }

        }

        word = word.substring(0, lowestIndex) + "[" + maxPart + "]" + word.substring(lowestIndex+maxPart.length());

        return word;
    }

//    private String getUpdatedString(String word, String[] parts) {
//
//        TreeMap<Integer, String> treeMap = new TreeMap<>();
//
//        int partSize = 5;
//
//        boolean found = false;
//
//        while (partSize > 0 && !found){
//
//            for (String part : parts){
//
//                if (part.length() == partSize){
//                    if (word.indexOf(part) != -1){
//                        found = true;
//                        int index = word.indexOf(part);
//
//                        if (treeMap.containsKey(index)){
//                            String tempPart = treeMap.get(index);
//                            if (tempPart.length() < part.length()){
//                                treeMap.put(index, part);
//                            }
//                        }else {
//                            treeMap.put(index, part);
//                        }
//
//                    }
//                }
//
//            }
//
//            if (!found){
//                partSize--;
//            }
//
//        }
//
//        if (treeMap.size() > 0){
//            word = getModifiedString(word, treeMap);
//
//        }
//
//        return word;
//    }

}
