/*
Note: Try to solve this task in O(n2) time, where n is a number of vertices, since this
is what you'll be asked to do during an interview.

Sue is a network administrator who consults for companies that have massive Local Area
Networks (LANs). The computers are connected together with network cables, and Sue has
been bought in to evaluate the company’s network. The networks are huge, and she wants
to ensure that no single network cable failure can disconnect the network. Any cable that
fails that leaves the network in two or more disconnected pieces is called a single point
of failure.

She labels the different network devices from 0 to n - 1. She keeps an n × n matrix
connections, where connections[i][j] = 1 if there is a network cable directly connecting
devices i and j, and 0 otherwise. Write a function that takes the matrix of connections,
and returns the number of cables that are a single point of failure.

Example

For connections = [[0, 1], [1, 0]], the output should be
singlePointOfFailure(connections) = 1.
A failure of the cable that connects devices 0 and 1 would leave the network disconnected.



For connections = [[0, 1, 1], [1, 0, 1], [1, 1, 0]], the output should be
singlePointOfFailure(connections) = 0.
No failure of a single network cable would result in the network being disconnected.



For connections = [[0, 1, 1, 1, 0, 0], [1, 0, 1, 0, 0, 0], [1, 1, 0, 0, 0, 0],
[1, 0, 0, 0, 1, 1], [0, 0, 0, 1, 0, 0], [0, 0, 0, 1, 0, 0]], the output should be
singlePointOfFailure(connections) = 3.
The three cables that are single points of failure are connected with device 3:



For connections = [[0, 1, 1, 1, 1], [1, 0, 0, 0, 0], [1, 0, 0, 0, 0], [1, 0, 0, 0, 0],
[1, 0, 0, 0, 0]], the output should be
singlePointOfFailure(connections) = 4.
In this topology, every cable is a single point of failure:



Input/Output

[execution time limit] 3 seconds (java)

[input] array.array.integer connections

Representations of connections between computers. connections[i][j] = 1 if there is a
network cable directly connecting devices i and j, and 0 otherwise. It is guaranteed
that the original network is connected.

Guaranteed constraints:
1 ≤ connections.length ≤ 300,
connections[i].length = connections.length,
connections[i][i] = 0,
 0 ≤ connections[i][j] ≤ 1,
connections[i][j] = connections[j][i].

[output] integer

The number of cables in the network that are a single point of failure.
 */
package newprogram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SinglePointOfFailure {
    public static void main(String[] args) {

        SinglePointOfFailure singlePointOfFailure = new SinglePointOfFailure();

//        int[][] connections = {{0, 1}, {1, 0}};
//        int[][] connections = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}};
//        int[][] connections = {{0, 1, 1, 1, 0, 0}, {1, 0, 1, 0, 0, 0}, {1, 1, 0, 0, 0, 0}, {1, 0, 0, 0, 1, 1}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 1, 0, 0}};
        int[][] connections = {{0, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}};
//        int[][] connections = {{0,1,1,0,0,0,0},
//            {1,0,1,0,0,0,0},
//            {1,1,0,0,0,0,1},
//            {0,0,0,0,1,1,1},
//            {0,0,0,1,0,1,0},
//            {0,0,0,1,1,0,0},
//            {0,0,1,1,0,0,0}};

        System.out.println(singlePointOfFailure.singlePointOfFailure(connections));
    }

    int singlePointOfFailure(int[][] connections) {
        int failures = 0;

        Map<Integer, ArrayList<Integer>> dataMap = new HashMap<>();

        for (int i = 0; i < connections.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < connections[0].length; j++) {
                if (i == j){
                    continue;
                }

                if (connections[i][j] == 1){
                    list.add(j);
                }
            }

            dataMap.put(i, list);
        }

        List<String> verifiedList = new ArrayList<>();

        for(Map.Entry<Integer, ArrayList<Integer>> entry : dataMap.entrySet()){
            Integer key = entry.getKey();
            ArrayList<Integer> childList = entry.getValue();

            for (Integer child : childList){
//                System.out.println("key:" + key + " Child = " + child + " failures = " + failures);


                String v1 = child + "" + key;
                String v2 = key + "" + child;
                if (verifiedList.contains(v1) || verifiedList.contains(v2)){
//                    System.out.println("Continuing key:" + key + " Child = " + child);
                    continue;
                }

//                System.out.println("putting child=" + child + " value=" + key );
//                System.out.println("putting v1=" + v1 + " v2=" + v2);

                verifiedList.add(v1);
                verifiedList.add(v2);

                ArrayList<Integer> reducedChildList = getReducedChildList(childList, child);
//                System.out.println(reducedChildList.size() + " =" + failures);

                ArrayList<Integer> traversedChildList = new ArrayList<>();
                traversedChildList.add(key);

                if (reducedChildList.size() == 0){
                    failures++;
                    continue;
                }

                if(!checkIfCanBeReached(key, child, reducedChildList, dataMap, traversedChildList)){
                    failures++;
                }
            }

        }

        return failures;
    }

    private ArrayList<Integer> getReducedChildList(ArrayList<Integer> childList, Integer child) {
        ArrayList<Integer> reducedChildList = new ArrayList<>();
        for(Integer tempChild : childList){
            if (tempChild.compareTo(child) == 0){
                continue;
            }
            reducedChildList.add(tempChild);
        }
        return reducedChildList;
    }

    private boolean checkIfCanBeReached(Integer source, Integer disconnectedChild, ArrayList<Integer> reducedChildList,
                                        Map<Integer, ArrayList<Integer>> dataMap, ArrayList<Integer> traversedChildList) {
        boolean canBeReached = false;

//        reducedChildList.remove(source);

        if(reducedChildList.contains(disconnectedChild)){
            canBeReached = true;
        }

        if (!canBeReached){
            for(Integer tempChild : reducedChildList){
                if (traversedChildList.contains(tempChild)){
                    continue;
                }
                traversedChildList.add(tempChild);
                ArrayList<Integer> subChildList = dataMap.get(tempChild);
                if (subChildList != null && subChildList.size()>0){
                    canBeReached = checkIfCanBeReached(source, disconnectedChild, subChildList, dataMap, traversedChildList);
                    if (canBeReached){
                        break;
                    }
                }
            }

        }

        return canBeReached;
    }


}
