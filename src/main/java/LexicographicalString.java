import java.util.ArrayList;
import java.util.HashSet;

    public class LexicographicalString {

        public static void main(String[] args) {

            String str = "acxrabdz";
            int[][] pairs = {{1,3}, {6,8}, {3,8}, {2,7}};
            LexicographicalString lexicographicalString = new LexicographicalString();
            System.out.println(lexicographicalString.swapLexOrder(str, pairs));


//
//
//            Scanner sc = new Scanner(System.in);
//            System.out.println("Enter a String :- ");
//            String word = sc.nextLine();
//            char[] ch= word.toCharArray();
//            System.out.println("Enter how many indexes you want to create :- ");
//            int[] indexes;
//            List<int[]> list = new ArrayList<int[]>();
//            int length =sc.nextInt();
//            for(int k=0 ; k<length;){
//                indexes=new int[2];
//                System.out.println("Enter"+ k +" value of i :- ");
//                Integer i=sc.nextInt();
//                System.out.println("Enter"+ k +" value of j :- ");
//                Integer j=sc.nextInt();
//                if(i!=j && 1<j){
//                    indexes[0]=i;
//                    indexes[1]=j;
//                    list.add(indexes);
//                    k++;
//                }else{
//                    System.out.println("The value of i and j could not be same and i could not be greater than j, Please enter different values.");
//                }
//            }
//
//            Set<String> result = new TreeSet<String>();
//            int previousUsedIndex = -1;
//            int currentUsedIndex=-1;
//            for (int i = 0; (i < factorial(word.length()) || i<length); i++) {
//                Random r = new Random();
//                currentUsedIndex=	r.nextInt(((list.size()-1) -0) + 1) + 0;
//                if((previousUsedIndex != currentUsedIndex) && (currentUsedIndex>=0 || currentUsedIndex<2)){
//                    System.out.println("currentindex:- "+currentUsedIndex +" , previousIndex :-" +previousUsedIndex);
//                    int firstIndex =list.get(currentUsedIndex)[0];
//                    int SecondIndex =list.get(currentUsedIndex)[1];
//                    result.add(swap(firstIndex,SecondIndex, ch));
//                    previousUsedIndex = currentUsedIndex;
//                    currentUsedIndex=-1;
//                }
//
//            }
//
//            List<String> resultedList = new ArrayList<String>(result);
//
//            System.out.println("Greatest String :- "+resultedList.get(resultedList.size()-1));

        }

        public static String swap(int i,int j, char[] ch){
            char temp = ch[i-1];
            ch[i-1]=ch[j-1];
            ch[j-1]=temp;
            return String.valueOf(ch);
        }

        public static int factorial(int n){
            if(n<=0)
                return 1;
            else
                return n*factorial(n-1);
        }

        String swapLexOrder(String str, int[][] pairs) {

            if (pairs.length == 0){
                return str;
            }

            ArrayList<Pair> pairsList = new ArrayList<Pair>();
            for (int i = 0; i < pairs.length; i++) {

                Pair p = new Pair(pairs[i][0]-1, pairs[i][1]-1);
                pairsList.add(p);

            }

            System.out.println(getLargestLexicographicalString(str, pairsList));
            return "";
//            return finalBuffer.toString();
        }

        String getLargestLexicographicalString(String str, ArrayList<Pair> pairs) {
            return getLargestLexicographicalString(str, pairs, 0, new HashSet<String>());
        }

        String getLargestLexicographicalString(String str, ArrayList<Pair> pairs,
                                                              int index, HashSet<String> cache) {

            // reset if index reaches pairs list size as we will
            // keep trying until we get the highest lexicographical
            // possible string (pair swapping can be reused).
            if (index == pairs.size())
                index = 0;

            Pair pair = pairs.get(index);

            // return if (string + pair) has been processed before
            if (cache.contains(str + pair.toString()))
                return str;

            String swappedString = swap(str, pair);

            // mark (string + pair) as visited
            cache.add(str + pair.toString());

            String withSwap = getLargestLexicographicalString(swappedString, pairs, index + 1, cache);

            String withOutSwap = getLargestLexicographicalString(str, pairs, index + 1, cache);

            return withSwap.compareTo(withOutSwap) > 0 ? withSwap : withOutSwap;
        }

        String swap(String s, Pair pair) {
            char[] str = s.toCharArray();
            char temp = str[pair.x];
            str[pair.x] = str[pair.y];
            str[pair.y] = temp;
            return new String(str);
        }

        static class Pair {
            int x, y;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public String toString() {
                return "x=" + x + ", y=" + y;
            }
        }
    }
