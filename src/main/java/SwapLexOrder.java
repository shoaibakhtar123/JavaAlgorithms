import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class SwapLexOrder {
    public static void main(String[] args) {
        SwapLexOrder swapLexOrder = new SwapLexOrder();
        String str = "acxrabdz";
        int[][] pairs = {{1,3}, {6,8}, {3,8}, {2,7}};
        System.out.println(swapLexOrder.swapLexOrder(str, pairs));
    }

    String swapLexOrder(String str, int[][] pairs) {

        if (pairs.length == 0){
            return str;
        }

        List<TreeSet<Integer>> listOfSetOfIntegers = getConnectedPairs(pairs);

        char[] charArray = str.toCharArray();
        System.out.println(charArray);
        System.out.println(pairs);


        for (TreeSet<Integer> tempSet : listOfSetOfIntegers) {
            char[] tempArray = getMaxArray(tempSet, charArray);

            int i =0;
            for (int index:tempSet) {
                charArray[index-1] = tempArray[i++];
            }
        }

        StringBuffer finalBuffer = new StringBuffer(charArray.length);
        for(char c : charArray){
            finalBuffer.append(c);
        }

        return finalBuffer.toString();
    }

    private char[] getMaxArray(TreeSet<Integer> setData, char[] charArray) {

        Character[] tempCharArray = new Character[setData.size()];

        int i = 0;
        for (int index : setData) {
            tempCharArray[i++] = charArray[index-1];
        }

        Arrays.sort(tempCharArray, Collections.reverseOrder());

        char[] sortedCharArray = new char[setData.size()];

        i = 0;
        for (char c : tempCharArray){
            sortedCharArray[i++] = c;
        }

        return sortedCharArray;
    }

    private List<TreeSet<Integer>> getConnectedPairs(int[][] pairs) {
        List<TreeSet<Integer>> listOfSetOfIntegers = new ArrayList<TreeSet<Integer>>();
        boolean found = false;

        TreeSet<Integer> dataSet = null;

        for (int i = 0; i < pairs.length; i++) {

            int firstIndex = pairs[i][0];
            int secondIndex = pairs[i][1];
            found = false;

            for (TreeSet<Integer> tempSet : listOfSetOfIntegers) {
                if (tempSet.contains(firstIndex) || tempSet.contains(secondIndex)) {
                    tempSet.add(firstIndex);
                    tempSet.add(secondIndex);
                    addAllRelatedIndexes(firstIndex, secondIndex, pairs, tempSet);
                    found = true;
                }
            }

            if (!found) {
                dataSet = new TreeSet<Integer>();
                dataSet.add(firstIndex);
                dataSet.add(secondIndex);
                addAllRelatedIndexes(firstIndex, secondIndex, pairs, dataSet);

                listOfSetOfIntegers.add(dataSet);
            }

        }

        return listOfSetOfIntegers;
    }

    private void addAllRelatedIndexes(int firstIndex, int secondIndex, int[][] pairs, TreeSet<Integer> tempSet) {

        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][0] == firstIndex || pairs[i][1] == firstIndex){
                tempSet.add(pairs[i][0]);
                tempSet.add(pairs[i][1]);
            }
            if (pairs[i][0] == secondIndex || pairs[i][1] == secondIndex){
                tempSet.add(pairs[i][0]);
                tempSet.add(pairs[i][1]);
            }
        }
    }
}
