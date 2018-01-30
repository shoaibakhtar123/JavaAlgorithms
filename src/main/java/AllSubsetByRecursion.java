import java.util.ArrayList;

public class AllSubsetByRecursion {
    public static void main(String[] args) {
        int[] intArr = {1,2,3,4,5};

        String[] subset = getSubset(intArr, 0, intArr.length - 1);
        printStringArray(subset);
        System.out.println(subset.length);

    }

    private static String[] getSubset(int[] intArr, int leftStart, int rightEnd) {

        if (leftStart >= rightEnd){
            return new String[]{getStringValue(intArr[leftStart])};
        }

        int midPoint = (leftStart + rightEnd)/2;

        String[] leftStringArr = getSubset(intArr, leftStart, midPoint);
//        System.out.println("leftStringArr = ");
//        printStringArray(leftStringArr);
        String[] rightStringArr = getSubset(intArr, midPoint+1, rightEnd);
//        System.out.println("rightStringArr = ");
//        printStringArray(rightStringArr);

        return createSubsetFromTwoHalves(leftStringArr, rightStringArr);
    }

    private static void printStringArray(String[] leftStringArr) {

        for (String s:leftStringArr){
            System.out.println(s);
        }
    }

    private static String[] createSubsetFromTwoHalves(String[] leftStringArr, String[] rightStringArr) {

        ArrayList<String> subsetList = new ArrayList<String>();
        for (String s : leftStringArr){
            subsetList.add(s);
        }

        for (String s : rightStringArr){
            subsetList.add(s);
        }

        for (int i = 0; i < leftStringArr.length; i++){
            for (int j = 0; j < rightStringArr.length; j++){
                if (leftStringArr[i].contains("{"))
                    leftStringArr[i] = leftStringArr[i].substring(1, leftStringArr[i].length()-1);
                if (rightStringArr[j].contains("{"))
                    rightStringArr[j] = rightStringArr[j].substring(1, rightStringArr[j].length()-1);

                subsetList.add("{" + leftStringArr[i] + "," + rightStringArr[j] + "}");
            }
        }

        String[] finalSubset = new String[subsetList.size()];
        int count = 0;
        for(String s : subsetList){

            if (!s.contains("{"))
                finalSubset[count] = "{" + s + "}";
            else
                finalSubset[count] = s;
            count++;
        }
//        System.out.println("(String[])subsetList.toArray() = ");
//        printStringArray(finalSubset);

        return finalSubset;
    }


    private static String getStringValue(int i) {
        return String.valueOf(i);
//        return "{" + String.valueOf(i) + "}";
    }
}
