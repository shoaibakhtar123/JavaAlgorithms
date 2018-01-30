package newprogram;

public class Power {
    public static void main(String[] args) {
        System.out.println(Power.getPowerNumber(100));
    }

    /*
     * Complete the function below.
     */
    static long getPowerNumber(long index) {
        if (index < 0){
            throw new IllegalArgumentException("Number should be positive");
        }

        if (index == 0){
            return 4;
        }

        //start the number from 5 and check if the number is can be represented by any power below that number
        long value = 4;

        for (int startIndex = 1; startIndex <= index;) {
            value++;
            for (long range = 2; range < value/2; range++){

//                if(checkIfRangeIsPowerOfPreviousNumber(range)){
//                    continue;
//                }


                boolean flag = checkIfCanBePowerOfAnyNumber(value, range);
                if (flag){
                    System.out.println("flag = " + flag + " value=" + value + " range=" + range + " startIndex=" + startIndex);
                    startIndex++;
                    break;
                }
            }
        }
        return value;
    }

    private static boolean checkIfRangeIsPowerOfPreviousNumber(long range) {
        for (long i = 2; i < range/2; i++){
            if(checkIfCanBePowerOfAnyNumber(range, i)){
                return true;
            }
        }

        return false;
    }

    static boolean checkIfCanBePowerOfAnyNumber(long value, long range) {
        while (value != 1)
        {
            if (value % range != 0)
                return false;
            value = value / range;
        }
        return true;
    }


}
