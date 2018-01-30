import java.util.HashMap;
import java.util.Map;

public class TriesWordSubstringNewApproach {
    public static void main(String[] args) {

        TriesWordSubstringNewApproach triesWordSubstringNewApproach = new TriesWordSubstringNewApproach();
        String[] words = {"Apple", "Melon", "Orange", "Watermelon"};
//        String words[] = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaab", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
//                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaac"};

        String[] parts = {"a", "mel", "lon", "el", "An"};

        triesWordSubstringNewApproach.findSubstrings(words, parts);

        for(String word : words){
            System.out.println(word);
        }


    }

    String[] findSubstrings(String[] words, String[] parts) {

        NewTrie trie = new NewTrie();
        Map<String, String> wordVsWord = new HashMap<>();
        for (String word : words){
            trie.addWord(word);
            wordVsWord.put(word, word);
        }

        for (String part : parts) {
            findStringsInTrie(part, trie, wordVsWord);
        }

        for (int i = 0; i < words.length; i++) {
            if (wordVsWord.get(words[i]) != null) {
                words[i] = wordVsWord.get(words[i]);
            }
        }

        return words;
    }

    private void findStringsInTrie(String part, NewTrie rootNode, Map<String, String> wordVsWord) {

        Map<String, String> wordVsFormattedWord = new HashMap<>();

        rootNode.collectAllModifiedWords(rootNode.getRootNode(), part, 0,
                wordVsFormattedWord, "", "");

        for (Map.Entry<String, String> entry : wordVsFormattedWord.entrySet()){
            String formattedValue = entry.getValue();
            String actualValue = wordVsWord.get(entry.getKey());
            String greaterValue = getGreaterValue(actualValue, formattedValue);
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

class NewTrie{

    public void collectAllModifiedWords(TrieNode node, String part, int partIndex,
                                        Map<String, String> wordVsFormattedWord, String modWord, String actualWord) {

        if(node.isCompleteWord){
            if (modWord.indexOf("[") != -1 && modWord.indexOf("]") != -1){
                wordVsFormattedWord.put(actualWord, modWord);
            }else{
                wordVsFormattedWord.put(actualWord, actualWord);
            }

            wordVsFormattedWord.put(actualWord, modWord);
        }

        Map<Character, TrieNode> children = node.children;

        for (Map.Entry<Character, TrieNode> nodeEntry : children.entrySet()){
            String mWord = "";

            String aWord = actualWord + nodeEntry.getKey();

            if (partIndex < part.length()){
                char c = part.charAt(partIndex);

                if (c == nodeEntry.getKey()){
                    String prefix = "";
                    String postFix = "";
                    if (partIndex == 0){
                        prefix = "[";
                    }
                    if (partIndex == part.length()-1){
                        postFix = "]";
                    }
                    mWord = modWord  + prefix + nodeEntry.getKey() + postFix;
                } else {
                    mWord = aWord;
                    partIndex = -1;
                }

            } else {
                mWord = modWord + nodeEntry.getKey();
            }

            partIndex++;
            collectAllModifiedWords(nodeEntry.getValue(), part, partIndex,
                    wordVsFormattedWord, mWord, aWord);
        }


    }

    private class TrieNode{
        private Map<Character, TrieNode> children;
        private boolean isCompleteWord;

        public TrieNode() {
            children = new HashMap<>();
            isCompleteWord = false;

        }
    }

    private TrieNode rootNode;

    public NewTrie() {
        rootNode = new TrieNode();
    }

    public void addWord(String word){
        addWordRecursive(word, 0, rootNode);
    }

    private void addWordRecursive(String word, int index, TrieNode currentTrieNode) {
        if (index == word.length()){
            currentTrieNode.isCompleteWord = true;
            return;
        }

        char c = word.charAt(index);

        TrieNode trieNode = currentTrieNode.children.get(c);
        if (trieNode == null){
            trieNode = new TrieNode();
            currentTrieNode.children.put(c, trieNode);
        }

        addWordRecursive(word, index+1, trieNode);
    }

    public TrieNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(TrieNode rootNode) {
        this.rootNode = rootNode;
    }
}
