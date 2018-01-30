public class ParentheisIndex {
    public static void main(String[] args) {

        String s = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
        System.out.println(indexOfClosingParenthesis(s, 10));

    }

    public static int indexOfClosingParenthesis(String inputString, int index){
        int count = 0;
        char[] chars = inputString.toCharArray();

        for (int i = index+1; i < chars.length; i ++){
            if (chars[i] == ')'){
                if (count==0) {
                    return i;
                }  else {
                    count--;
                }
            }

            if (chars[i] == '('){
                count++;
            }
        }

        return -1;
    }

}
