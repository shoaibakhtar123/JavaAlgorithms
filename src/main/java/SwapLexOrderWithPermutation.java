import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SwapLexOrderWithPermutation {
    public static void main(String[] args) {
        SwapLexOrder swapLexOrder = new SwapLexOrder();
        String str = "acxrabdz";
        int[][] pairs = {{1,3}, {6,8}, {3,8}, {2,7}};
//        System.out.println(swapLexOrder.swapLexOrder(str, pairs));

        int[] array = {1,2,3};
        SwapLexOrderWithPermutation swapLexOrderWithPermutation = new SwapLexOrderWithPermutation();


        System.out.println(swapLexOrderWithPermutation.swapLexOrder(str, pairs));

    }

    String swapLexOrder(String str, int[][] pairs) {
        int n = pairs.length;
        if(n == 0){
            return str;
        }

        String result = str;

        List<List<Integer>> permutations = permutate(n);

        for(int k = 0; k < permutations.size(); ++k) {
            char[] a = str.toCharArray();
            Map<String, Set<Integer>> found = new HashMap<String, Set<Integer>>();
            String candidate = str;
            int j = 0;
            List<Integer> pk = permutations.get(k);
            while(true) {

                int pj = pk.get(j);
                exchange(a, pairs[pj][0]-1, pairs[pj][1]-1);
                candidate = new String(a);
                if(candidate.compareTo(result) > 0) {
                    result = candidate;
                }

                if(found.containsKey(candidate) && found.get(candidate).contains(j)) {
                    break;
                }

                if(found.containsKey(candidate)){
                    found.get(candidate).add(j);
                } else {
                    Set<Integer> s = new HashSet<Integer>();
                    s.add(j);
                    found.put(candidate, s);
                }

                j++;
                if(j >= n) j = 0;
            }
        }

        return result;
    }
    void exchange(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    List<List<Integer>> permutate(int n) {
        List<List<Integer>> set = new ArrayList<List<Integer>>();
        set.add(new ArrayList<Integer>());
        return permutate2(set, 0, n);
    }

    List<List<Integer>> permutate2(List<List<Integer>> set, int d, int n) {
        if(d == n){
            return set;
        }
        List<List<Integer>> newSet = new ArrayList<List<Integer>>();
        for(int i=0; i < set.size(); ++i) {
            List<List<Integer>> newSubSets = generate(set.get(i), d);
            newSet.addAll(newSubSets);
        }
        return permutate2(newSet, d+1, n);
    }

    List<List<Integer>> generate(List<Integer> list, int d) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0; i < list.size(); ++i) {
            List<Integer> newList = insert(list, i, d);
            result.add(newList);
        }
        result.add(insert(list, list.size(), d));

        return result;
    }

    List<Integer> insert(List<Integer> list, int index, int d){
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i < list.size(); ++i) {
            if(i == index) {
                result.add(d);
            }
            result.add(list.get(i));
        }
        if(index == list.size()) {
            result.add(d);
        }
        return result;
    }

//    String swapLexOrder(String str, int[][] pairs) {
//
//        if (pairs.length == 0){
//            return str;
//        }
//
//        int[] intArray = new int[pairs.length];
//        for (int i = 0; i < pairs.length; i++) {
//            intArray[i] = i;
//        }
//
//        ArrayList<ArrayList<Integer>> permute = permute(intArray);
//
//        Set<String> setData = new TreeSet<String>();
//
//        setData.add(str);
//
//        for(ArrayList<Integer> permuteList : permute){
//            String modifiedStr = getModifiedString(permuteList, str, pairs);
//            System.out.println(modifiedStr);
//            setData.add(modifiedStr);
////            boolean add = false;
////            for(String tempStr : setData){
//                setData.add(modifiedStr);
////                if (tempStr.compareTo(modifiedStr) < 1){
////                    add = true;
////                }
//            }
////            if (add){
//////                setData = new TreeSet<String>();
////                setData.add(modifiedStr);
////            }
////        }
//
//        System.out.println(setData);
//        return "";
//    }

    private String getModifiedString(ArrayList<Integer> permuteList, String str, int[][] pairs) {
//        System.out.println("str=" + str);
        char[] chars = str.toCharArray();

        int firstIndex = 0;
        int secondIndex = 0;
        char tempChar;

        for(int position : permuteList){
            firstIndex = pairs[position][0];
            secondIndex = pairs[position][1];
            tempChar = chars[firstIndex-1];
            chars[firstIndex-1] = chars[secondIndex-1];
            chars[secondIndex-1] = tempChar;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(chars[i]);
        }

        return stringBuilder.toString();
    }

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        permute(num, 0, result);
        return result;
    }

    void permute(int[] num, int start, ArrayList<ArrayList<Integer>> result) {

        if (start >= num.length) {
            ArrayList<Integer> item = convertArrayToList(num);
            result.add(item);
        }

        for (int j = start; j <= num.length - 1; j++) {
            swap(num, start, j);
            permute(num, start + 1, result);
            swap(num, start, j);
        }
    }

    private ArrayList<Integer> convertArrayToList(int[] num) {
        ArrayList<Integer> item = new ArrayList<Integer>();
        for (int h = 0; h < num.length; h++) {
            item.add(num[h]);
        }
        return item;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
