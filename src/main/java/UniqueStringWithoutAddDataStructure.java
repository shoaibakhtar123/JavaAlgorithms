public class UniqueStringWithoutAddDataStructure {

    public static void main(String[] args) {
        String s = "helo wrd";

//        char c ="%20";

//        s.replace('', '');

        boolean unique = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    unique = false;
                }
            }
        }
        System.out.println(unique);
    }

}
