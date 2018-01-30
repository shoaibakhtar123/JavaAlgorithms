import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SwapLexOrderCopied {
    public static void main(String[] args) {
        String str = "acxrabdz";
        int[][] pairs = {{1,3}, {6,8}, {3,8}, {2,7}};
        SwapLexOrderCopied swapLexOrderCopied = new SwapLexOrderCopied();
        System.out.println(swapLexOrderCopied.swapLexOrder(str, pairs));
    }

    String swapLexOrder(String str, int[][] pairs) {
        char[] chars = str.toCharArray();
        List<Set<Integer>> pools = new ArrayList<>();
        for( int[] pair : pairs ){
            List<Set<Integer>> foundPools = new ArrayList<>();
            for( Set<Integer> pool : pools ){
                if(pool.contains(pair[0]) || pool.contains(pair[1])){
                    foundPools.add(pool);
                }
            }
            if(foundPools.size() == 0){
                Set<Integer> newPool = new TreeSet<>();
                newPool.add(pair[0]);
                newPool.add(pair[1]);
                pools.add(newPool);
            }else if(foundPools.size() == 1){
                int i = 0;
                Set<Integer> pool = foundPools.get(0);
                if(pool.contains(pair[i]) || pool.contains(pair[++i])){
                    pool.add(pair[1-i]);
                }
            }else if(foundPools.size() == 2){
                foundPools.get(0).addAll(foundPools.get(1));
                pools.remove(foundPools.get(1));
            }else throw new RuntimeException("Merge Error");
        }

        for( Set<Integer> pool : pools ){
            char[] possibles = new char[pool.size()];
            int i = 0;
            for( int pos : pool ){
                possibles[i++] = chars[pos-1];
            }
            Arrays.sort(possibles);
            for( int pos : pool ){
                chars[pos-1] = possibles[--i];
            }
        }

        return new String(chars);
    }


}
