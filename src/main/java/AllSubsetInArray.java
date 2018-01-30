public class AllSubsetInArray {

    public static void main(String[] args) {

        int[] intArr = {1,2,3,4,5,6,7,8,9,10, 11, 12};

        printAllSubset(intArr);

    }

    private static void printAllSubset(int[] intArr) {

        System.out.println("{}");

        int subsetOf = 1;

        while (subsetOf<= intArr.length){
            for (int i = 0; i < intArr.length; i++){
                printAllSubset(intArr, i, subsetOf);
            }
            subsetOf++;
        }
    }

    private static void printAllSubset(int[] intArr, int i, int subsetOf) {

        //Just print the value of the subset of 1 is required
        if (subsetOf == 1){
            System.out.println("{" + intArr[i] + "}");
            return;
        }

        String firstData = "", completeData = "";

        int pos = i+1;
        int count = subsetOf-1;

        firstData = "{" + intArr[i] +",";

        while ((pos + count) <= intArr.length){
            int j = 0;

            String subsetData = "";
            while (j<count){
                subsetData = subsetData + intArr[pos+j] + ",";
                j++;
            }
            completeData = firstData + subsetData;
            completeData = completeData.substring(0,completeData.length()-1) + "}";

            System.out.println(completeData);
            pos++;
        }
    }

}
