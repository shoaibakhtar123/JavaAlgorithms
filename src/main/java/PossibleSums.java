import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
You have a collection of coins, and you know the values of the coins and the quantity
of each type of coin in it. You want to know how many distinct sums you can make
from non-empty groupings of these coins.

Example

For coins = [10, 50, 100] and quantity = [1, 2, 1], the output should be
possibleSums(coins, quantity) = 9.

Here are all the possible sums:

50 = 50;
10 + 50 = 60;
50 + 100 = 150;
10 + 50 + 100 = 160;
50 + 50 = 100;
10 + 50 + 50 = 110;
50 + 50 + 100 = 200;
10 + 50 + 50 + 100 = 210;
10 = 10;
100 = 100;
10 + 100 = 110.
As you can see, there are 9 distinct sums that can be created from
non-empty groupings of your coins.

Input/Output

[time limit] 3000ms (java)
[input] array.integer coins

An array containing the values of the coins in your collection.

Guaranteed constraints:
1 ≤ coins.length ≤ 20,
1 ≤ coins[i] ≤ 104.

[input] array.integer quantity

An array containing the quantity of each type of coin in your collection. quantity[i]
indicates the number of coins that have a value of coins[i].

Guaranteed constraints:
quantity.length = coins.length,
1 ≤ quantity[i] ≤ 105.

It is guaranteed that (quantity[0] + 1) * (quantity[1] + 1) * ... *
(quantity[quantity.length - 1] + 1) <= 106.

[output] integer

The number of different possible sums that can be created from non-empty
groupings of your coins.
 */
public class PossibleSums {

    public static void main(String[] args) {

        PossibleSums possibleSums = new PossibleSums();

        int[] coins = {10, 50,100};
        int[] quantity = {1, 2,1};
        possibleSums.possibleSums3(coins, quantity);

    }


    int possibleSums3(int[] coins, int[] quantity) {

        Set<Integer> sumSet = new HashSet<Integer>();
        sumSet.add(0);
        int value=0;
        for (int i = 0; i < coins.length; i++) {
//            System.out.println("Adding:" + coins[i]);
            Set<Integer> tempSet = new HashSet<Integer>();
            for (int data : sumSet) {
//                System.out.println("data:" + data);
                for (int j = 0; j < quantity[i]; j++) {
                    value = data + (j+1)*coins[i];
//                    System.out.println("Data:" + data + " value=" + value);
                    tempSet.add(value);
                }

            }
                sumSet.addAll(tempSet);
        }

//        System.out.println(sumSet);
        return sumSet.size()-1;
    }


    int possibleSums(int[] coins, int[] quantity) {

        int[] totalCoins = new int[getIntArrayLength(quantity)];
        int index = 0;
        for (int i = 0; i < coins.length; i++) {
            int count = quantity[i];
            for (int j = 0; j < count; j++) {
                totalCoins[index] = coins[i];
                index++;
            }
        }

//        System.out.println(totalCoins.length);
//        return 0;
        HashSet<Integer> possibleSums = createPossibleSums(totalCoins, 0, totalCoins.length - 1);

        System.out.println("total possible"+possibleSums.size());

        return possibleSums.size();
    }

    int possibleSums2(int[] coins, int[] quantity) {
        Set<Integer> sums = new HashSet<Integer>();
        sums.add(0);
        for (int i = 0; i < quantity.length; ++i) {
            List<Integer> sumsNow = new ArrayList<Integer>(sums);
            for (Integer sum : sumsNow) {
                for (int j = 1; j <= quantity[i]; ++j) {
                    sums.add(sum + j * coins[i]);
                }
            }
        }
        return sums.size() - 1;
    }

    private HashSet<Integer> createPossibleSums(int[] totalCoins, int leftStart, int rightEnd) {

        if (leftStart >= rightEnd){

            HashSet<Integer> list = new HashSet<Integer>();
            list.add(totalCoins[leftStart]);
            return list;
        }

        int midPoint = (leftStart + rightEnd)/2;

        HashSet<Integer> possibleSums1 = createPossibleSums(totalCoins, leftStart, midPoint);

        HashSet<Integer> possibleSums2 = createPossibleSums(totalCoins, midPoint + 1, rightEnd);

        return createSums(possibleSums1, possibleSums2);

    }

    private HashSet<Integer> createSums(HashSet<Integer> possibleSums1, HashSet<Integer> possibleSums2) {

//        System.out.println("Print first array");
//        for (int firstInt : possibleSums1){
//            System.out.print(firstInt);
//            System.out.print(",");
//        }
//        System.out.println();
//
//        System.out.println("Print second array");
//        for (int secondInt : possibleSums2){
//            System.out.print(secondInt);
//            System.out.print(",");
//        }

        HashSet<Integer> tempList = new HashSet<Integer>();
        for (int firstInt : possibleSums1){
            tempList.add(firstInt);
            for (int secondInt : possibleSums2){
                tempList.add(secondInt);
                int sum = firstInt + secondInt;
                tempList.add(sum);
            }
        }

//        System.out.println();
//        System.out.println("Print final array");
//        for (int finalInt : tempList){
//            System.out.print(finalInt);
//            System.out.print(",");
//        }

        return tempList;
    }

    private int getIntArrayLength(int[] quantity) {
        int size = 0;
        for (int i = 0; i < quantity.length; i++) {
            size = size + quantity[i];
        }
        System.out.println("size=" + size);
        return size;
    }
}
