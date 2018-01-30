import java.util.HashMap;
import java.util.Map;

public class TriesWordSubstringFixed {

    public static void main(String[] args) {
        TriesWordSubstringFixed triesWordSubstringFixed = new TriesWordSubstringFixed();
//        String[] words = {"neuroses", "myopic", "sufficient", "televise", "coccidiosis", "gules", "during", "construe", "establish", "ethyl"};
//        String[] parts = {"aaaaa", "Aaaa", "E", "z", "Zzzzz", "a", "mel", "lon", "el", "An", "ise", "d", "g", "wnoVV", "i", "IUMc", "P", "KQ", "QfRz", "Xyj", "yiHS"};

//        String words[] = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaab", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
//                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaac"};
//
//        String parts[] = {"aaaaa", "bbbbb", "a", "aa", "aaaa", "AAAAA", "aaa", "aba", "aaaab",
//                "c", "bbbb", "d", "g", "ccccc", "B", "C", "P", "D"};

//        String[] words = {"123", "123b", "123", "12", "1234c","abc12"};
//        String[] parts = {"1", "b", "4c", "12"};

        String[] words = {"Apple", "Melon", "Orange", "Watermelon"};
        String[] parts = {"a", "mel", "lon", "el", "An"};

        triesWordSubstringFixed.findSubstrings(words, parts);

        for(String word : words){
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

        Trie trie = new Trie();
        Map<String, String> wordVsWord = new HashMap<>();
        for (String word : words){
            trie.addWord(word);
            wordVsWord.put(word, word);
        }

        for (String part : parts) {
            findStringInWords(part, trie, wordVsWord);
        }

        for (int i = 0; i < words.length; i++) {
            if (wordVsWord.get(words[i]) != null) {
                words[i] = wordVsWord.get(words[i]);
            }

        }

        return words;
    }

    private void findSubString2(String part, int partIndex, Trie node, Map<String, String> wordVsFormattedWord,
                                String actualWord, String formattedWord) {

//        System.out.println("formattedWord = " + formattedWord + " actualWord = " + actualWord + " part = " + part);

        if (node.isCompleteWord()) {
//            System.out.println("formattedWord = " + formattedWord + " actualWord = " + actualWord + " part = " + part);
            if (formattedWord.indexOf("[") != -1 && formattedWord.indexOf("]") != -1){
                wordVsFormattedWord.put(actualWord, formattedWord);
            }

        }

        for (Map.Entry<Character, Trie> entry : node.getDataMap().entrySet()) {
//            System.out.println("formattedWord = " + formattedWord + " actualWord = " + actualWord + " part = " + part);
//            System.out.println(entry.getKey());
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

            if (actualWord != null){
                actualWord = actualWord.substring(0, actualWord.length()-1);
//                formattedWord = formattedWord.substring(0, formattedWord.length()-1);
            }
//            actualWord = "";
//            formattedWord = "";

        }

    }

    private void findStringInWords(String part, Trie rootNode, Map<String, String> wordVsWord) {

        Map<String, String> wordVsFormattedWord = new HashMap<>();

        findSubString2(part, 0, rootNode, wordVsFormattedWord, "", "");

        for (Map.Entry<String, String> entry : wordVsFormattedWord.entrySet()){
            String formattedValue = entry.getValue();
            String actualValue = wordVsWord.get(entry.getKey());

//            System.out.println("Key=" + entry.getKey() + " actualValue = " + actualValue + " formattedValue = " + formattedValue + "part = " + part);
            String greaterValue = getGreaterValue(actualValue, formattedValue);

//            System.out.println(actualValue + " : " + formattedValue + " : " + greaterValue);
            wordVsWord.put(entry.getKey(), greaterValue);
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

class Trie {
    private HashMap<Character, Trie> dataMap = new HashMap<>();
    //    Tries[] triesData = new Tries[128];
    private boolean isCompleteWord;

    public HashMap<Character, Trie> getDataMap() {
        return dataMap;
    }

    public void setDataMap(HashMap<Character, Trie> dataMap) {
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
//            System.out.println("Setting complete word " + s);
            this.setCompleteWord(true);
            return;
        }
        char c = s.charAt(index);
        Trie t = dataMap.get(c);
//        int pos = c-'a';
//        Tries t = triesData[c];

        if (t == null) {
            t = new Trie();
            dataMap.put(c, t);
//            triesData[c] = t;
        }
        index++;
        t.addWordRecursively(s, index);
    }
}
