/*
You have a list of dishes. Each dish is associated with a list of ingredients used
to prepare it. You want to group the dishes by ingredients, so that for each ingredient
you'll be able to find all the dishes that contain it (if there are at least 2 such dishes).

Return an array where each element is a list with the first element equal to the name of
the ingredient and all of the other elements equal to the names of dishes that contain
this ingredient. The dishes inside each list should be sorted lexicographically. The
result array should be sorted lexicographically by the names of the ingredients
in its elements.

Example

For
  dishes = [["Salad", "Tomato", "Cucumber", "Salad", "Sauce"],
            ["Pizza", "Tomato", "Sausage", "Sauce", "Dough"],
            ["Quesadilla", "Chicken", "Cheese", "Sauce"],
            ["Sandwich", "Salad", "Bread", "Tomato", "Cheese"]]
the output should be
  groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
                            ["Salad", "Salad", "Sandwich"],
                            ["Sauce", "Pizza", "Quesadilla", "Salad"],
                            ["Tomato", "Pizza", "Salad", "Sandwich"]]
For
  dishes = [["Pasta", "Tomato Sauce", "Onions", "Garlic"],
            ["Chicken Curry", "Chicken", "Curry Sauce"],
            ["Fried Rice", "Rice", "Onions", "Nuts"],
            ["Salad", "Spinach", "Nuts"],
            ["Sandwich", "Cheese", "Bread"],
            ["Quesadilla", "Chicken", "Cheese"]]
the output should be
  groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
                            ["Chicken", "Chicken Curry", "Quesadilla"],
                            ["Nuts", "Fried Rice", "Salad"],
                            ["Onions", "Fried Rice", "Pasta"]]
Input/Output

[time limit] 3000ms (java)
[input] array.array.string dishes

An array of dishes. dishes[i] for each valid i contains information about the ith dish:
the first element of dishes[i] is the name of the dish and the following elements are
the ingredients of that dish. Both the dish name and the ingredient names consist of
English letters and spaces. It is guaranteed that all dish names are different. It is
also guaranteed that ingredient names for one dish are also pairwise different.

Guaranteed constraints:
1 ≤ dishes.length ≤ 500,
2 ≤ dishes[i].length ≤ 10,
1 ≤ dishes[i][j].length ≤ 50.

[output] array.array.string

The array containing the grouped dishes.

[Java] Syntax Tips

// Prints help message to the console
// Returns a string
//
// Globals declared here will cause a compilation error,
// declare variables inside the function instead!
String helloWorld(String name) {
    System.out.println("This prints to the console when you Run Tests");
    return "Hello, " + name;
}

String[][] groupingDishes(String[][] dishes) {

}
 */

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class GroupingDishes {
    public static void main(String[] args) {
        String[][] dishes = {{"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
                            {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
                            {"Quesadilla", "Chicken", "Cheese", "Sauce"},
                            {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}};
        groupingDishes(dishes);
    }

    static String[][] groupingDishes(String[][] dishes) {

        Map<String, TreeSet<String>> map = new TreeMap<String, TreeSet<String>>();

        TreeSet<String> tempList = null;
        int numberOfRows = 0;

        for (int i = 0; i < dishes.length; i++) {
            String value = dishes[i][0];
            for (int j = 1; j < dishes[i].length; j++) {
                if (map.containsKey(dishes[i][j])){
                    tempList = map.get(dishes[i][j]);
                    tempList.add(value);
                } else {
                    tempList = new TreeSet<String>();
                    tempList.add(value);
                    map.put(dishes[i][j], tempList);
                }
            }
        }


        System.out.println("numberOfRows" + numberOfRows);
        Set<Map.Entry<String, TreeSet<String>>> entries = map.entrySet();

        for(Map.Entry<String, TreeSet<String>> entry : entries) {
            if(entry.getValue().size() > 1){
                numberOfRows++;
            }
        }
        String[][] newArray = new String[numberOfRows][];
        int count=0;
        for(Map.Entry<String, TreeSet<String>> entry : entries){
            String key = entry.getKey();
            TreeSet<String> value = entry.getValue();
            if (value.size() > 1){
                newArray[count] = new String[value.size()+1];
                newArray[count][0] = key;
                Iterator<String> iterator = value.iterator();

                int dishCount = 1;
                while(iterator.hasNext()){
                    newArray[count][dishCount] = iterator.next();
                    dishCount++;
                }
                count++;
            }
        }

//        for (int i = 0; i <newArray.length; i++) {
//            for (int j = 0; j < newArray[i].length; j++) {
//                System.out.print(newArray[i][j] + ", ");
//            }
//            System.out.println();
//        }

        return newArray;

    }


}
