/*
Given an encoded string, return its corresponding decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square
brackets is repeated exactly k times. Note: k is guaranteed to be a positive integer.

Note that your solution should have linear complexity because this is what you
will be asked during an interview.

Example

For s = "4[ab]", the output should be

decodeString(s) = "abababab";

For s = "2[b3[a]]", the output should be

decodeString(s) = "baaabaaa";

For s = "z1[y]zzz2[abc]", the output should be

decodeString(s) = "zyzzzabcabc".

Input/Output

[time limit] 3000ms (java)

[input] string s

A string encoded as described above. It is guaranteed that:

the string consists only of digits, square brackets and lowercase English letters;
the square brackets form a regular bracket sequence;
all digits that appear in the string represent the number of times the content in the
 brackets that follow them repeats, i.e. k in the description above;
there are at most 20 pairs of square brackets in the given string.
Guaranteed constraints:

0 ≤ s.length ≤ 80.
 */
package newprogram;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
//        String str = "4[ab]";
//        String str = "2[b3[a]]";
        String str = "z1[y]zzz2[abc]";
        System.out.println(decodeString.decodeString(str));
    }

    String decodeString(String s) {

        if (s == null || s.length() <= 0) {
            return s;
        }

        if (s.indexOf("[") == -1) {
            return s;
        }

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']'){

                String tempString = "";
                char c2 = stk.pop();
                while(c2 != '['){
                    tempString = c2 + tempString;
                    c2 = stk.pop();
                }

                //need to get the count
                c2 = stk.pop();
                int count = 0;
                int base = 1;
                boolean stackEmpty = false;
                do {
                    int value = Character.getNumericValue(c2);
                    count = count + base*value;
                    base = base*10;
                    if(!stk.isEmpty()){
                        c2 = stk.pop();
                    }else{
                        stackEmpty = true;
                        break;
                    }
                } while(c2 > 47 && c2 < 58);

                if (!stackEmpty){
                    stk.push(c2);
                }
                String t = getModifiedString(tempString, count);
                for (int j = 0; j < t.length(); j++) {
                    stk.push(t.charAt(j));
                }
            }else{
                stk.push(c);
            }
        }


        String finalString = "";
        while(!stk.isEmpty()){
            finalString =  stk.pop()+ finalString;
        }

        return finalString;
    }

    private String getModifiedString(String str, int count) {
        if (count == 0) {
            return str;
        }
        String tempString = "";
        while (count > 0) {
            tempString = tempString + str;
            count--;
        }
        return tempString;
    }


//    private String getDecodedString(String str, int count) {
//        if (str.indexOf("[") == -1) {
//            return getModifiedString(str, count);
//        }
//
//        int index = str.indexOf("[");
//        String tempString = str.substring(0, index);
//        int numericValue = getNumericValue(tempString);
//        int lengthOfCount = String.valueOf(numericValue).length();
//        tempString = tempString.substring(0, tempString.length() - lengthOfCount);
//
//        tempString = tempString + getDecodedString(str.substring(index+1, str.length()-1), numericValue);
//
//        return getModifiedString(tempString, count);
//    }


//    private int getNumericValue(String finalString) {
//        int l = finalString.length();
//
//        int count=0;
//        int base = 1;
//
//        for (int i=l-1; i>=0; i--) {
//            char c = finalString.charAt(i);
//            if (c < 48 || c > 57) {
//                break;
//            }
//            int value = Character.getNumericValue(c);
//            //it is number
//            count = count + base*value;
//            base = base*10;
//        }
//
//        return count;
//    }

//    String decodeString2(String s) {
//
//        if (s == null || s.length() <= 0) {
//            return s;
//        }
//
//        if (s.indexOf("[") == -1) {
//            return s;
//        }
//
//        int index = s.indexOf("[");
//        String finalString = s.substring(0, index);
//
//        int count = getNumericValue(finalString);
//        int lengthOfCount = String.valueOf(count).length();
//        finalString = finalString.substring(0, finalString.length() - lengthOfCount);
//
//        finalString = finalString + getDecodedString(s.substring(index+1, s.length()-1), count);
//
//        return finalString;
//
//    }


}
