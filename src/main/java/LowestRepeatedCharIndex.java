import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LowestRepeatedCharIndex {
    public static void main(String[] args) {
        int[] arr = {2, 4, 2, 3, 5, 1};
//        Arrays.

//        String str = Arrays.toString(arr);
//        str = str.replaceAll(", ", "");
//        str = str.substring(1, str.length()-1);
//
//        System.out.println(s);
//        s = s.replaceAll("\[", "");
//        s =
//        System.out.println(firstDuplicateDiff3(arr));

        System.out.println(firstNotRepeatingCharacter2("abacabad"));
    }

    static int firstDuplicate(int[] a) {

        int lowestIndex = -1;

        int fromLength = 0;
        String str = "";

        for (int i = 0; i < a.length; i++){
            str = str + String.valueOf(a[i]);
        }

        for (int i = 0; i < a.length; i++){

            fromLength = fromLength + String.valueOf(a[i]).length();

            int index = str.indexOf(String.valueOf(a[i]),fromLength);

            System.out.println("index=" + index + " str = " + str +
                    " lowestIndex = " + lowestIndex + "String.valueOf(a[i]) = " + String.valueOf(a[i]));

            if (lowestIndex == -1 && index != -1){
                lowestIndex = index;
            }
            if (index != -1 && lowestIndex > index){
                lowestIndex = index;
            }
        }

        if (lowestIndex == -1)
            return -1;

        return a[lowestIndex];

    }

    static int firstDuplicateDiff(int[] a) {

        ArrayList<Integer> tempArrList = new ArrayList<Integer>(a.length);
        int lowestIndex = -1;

        for (int arrData : a){
            if (tempArrList.contains(arrData)){
                lowestIndex = arrData;
                break;
            } else {
                tempArrList.add(arrData);
            }
        }
        return lowestIndex;
    }

    static int firstDuplicateDiff3(int[] a) {
        int[] b = new int[a.length];
        int lowestIndex = -1;

        for (int i = 0; i < a.length; i++) {
            if (b[a[i]-1] == 1){
                lowestIndex = a[i];
                break;
            } else {
                b[a[i]-1] = 1;
            }
        }
        return lowestIndex;
    }

    static char firstNotRepeatingCharacter(String s) {

        char c  = '_';
        int strSize = s.length();
        Map<Integer, Integer> characterIntegerHashMap = new LinkedHashMap<Integer, Integer>(strSize);

        char[] chars = s.toCharArray();
        int count = 0;

        for (char cElement : chars){
            int i = cElement;
            if (characterIntegerHashMap.get(i) != null){
                count = characterIntegerHashMap.get(i) + 1;
                System.out.println("incrementing=" + cElement + " i=" + i + " count=" + count);
                characterIntegerHashMap.put(i, count);
            } else {
                System.out.println("putting=" + cElement + " i=" + i);
                characterIntegerHashMap.put(i, 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = characterIntegerHashMap.entrySet();

        for (Map.Entry<Integer, Integer> entry : entries){
            System.out.println("Key = " + entry.getKey() + " value=" + entry.getValue());
        }

        for (int i = 0; i < strSize; i++) {
            Integer integer = characterIntegerHashMap.get(Integer.valueOf(i));

            System.out.println(integer);

            if (integer != null){
                System.out.println(integer + " char = " + (char)integer.intValue());
            }

            if (integer != null && integer.equals(1)){
                return (char)integer.intValue();
            }

        }

        return c;

    }

    static char firstNotRepeatingCharacter2(String s) {

        char c  = '_';

        char[] charArr = new char[s.length()];
        int[] intArr = new int[s.length()];

        char[] chars = s.toCharArray();

        int index = 0;
        for (char cElement : chars) {

            int indexIfPresent = getIndexIfPresent(cElement, charArr);
            if (indexIfPresent != -1) {
                int count = intArr[indexIfPresent];
                intArr[indexIfPresent] = count+1;

            } else {
                charArr[index] = cElement;
                intArr[index] = 1;

            }
            index++;
        }

        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] == 1){
                c = charArr[i];
                break;
            }
        }

        return c;

    }

    private static int getIndexIfPresent(char cElement, char[] charArr) {
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == cElement){
                return i;
            }
        }
        return -1;
    }

}
