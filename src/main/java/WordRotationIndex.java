public class WordRotationIndex {

    private String[] words = new String[]{
            "ptolemaic",
            "retrograde",
            "supplant",
            "undulate",
            "xenoepist",
            "zz",
            "zzzzzz",
            "aaaaa",
            "asymptote",  // <-- rotates here!
            "babka",
            "banoffee",
            "engender",
            "karpatka",
            "othellolagkage",
    };

    public static void main(String[] args) {

        WordRotationIndex wordRotationIndex = new WordRotationIndex();

        System.out.println(wordRotationIndex.findRotationPoint());

    }

    private int findRotationPoint() {

        int startPoint = 0;
        int endPoint = words.length-1;
        int midPoint = endPoint/2;

        while (true){
            if ((endPoint - startPoint) <= 1){
                if (words[startPoint].compareTo(words[endPoint])>0)
                    return endPoint;
                else
                    return 0;
            }

            if (words[startPoint].compareTo(words[midPoint]) > 0){
                endPoint = midPoint;
                midPoint = midPoint - (endPoint - startPoint)/2;
            } else {
                startPoint = midPoint;
                midPoint = midPoint + (endPoint-startPoint)/2;
            }

        }
    }
}
