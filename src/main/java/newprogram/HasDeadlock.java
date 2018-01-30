/*
Note: Try to solve this task in O(m + n) or O(n) time, where n is a number of vertices
and m is a number of edges, since this is what you'll be asked to do during an interview.

In a multithreaded environment, it's possible that different processes will need to
use the same resource. A wait-for graph represents the different processes as nodes
in a directed graph, where an edge from node i to node j means that the node j is
using a resource that node i needs to use (and cannot use until node j releases it).

We are interested in whether or not this digraph has any cycles in it. If it does, it
is possible for the system to get into a state where no process can complete.

We will represent the processes by integers 0, ...., n - 1. We represent the edges using
a two-dimensional list connections. If j is in the list connections[i], then there is a
directed edge from process i to process j.

Write a function that returns True if connections describes a graph with a directed
cycle, or False otherwise.

Example

For connections = [[1], [2], [3, 4], [4], [0]], the output should be
hasDeadlock(connections) = true.


This graph contains a cycle.

For connections = [[1, 2, 3], [2, 3], [3], []], the output should be
hasDeadlock(connections) = false.


This graph doesn't contain a directed cycle (there are two paths from 0 to 3, but no
paths from 3 back to 0).

Input/Output

[execution time limit] 3 seconds (java)

[input] array.array.integer connections

A representation of the graphs edges. connection.length is the number of vertices. If j
is in the list connections[i], then there is a directed edge from process i to process j.

Guaranteed constraints:
1 ≤ connections.length ≤ 500,
0 ≤ connections[i][j] < connections.length,
connections[i][j] ≠ connections[i][k] for j ≠ k,
i not in connections[i].

[output] boolean

Return True if connections describes a graph with a directed cycle, or False otherwise.
 */

package newprogram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HasDeadlock {
    public static void main(String[] args) {

//        int[][] connections = {{1}, {2}, {3, 4}, {4}, {0}};
        int[][] connections = {{1, 2, 3}, {2, 3}, {3}, {}};
//        int[][] connections = {{1,6}, {2}, {3}, {4}, {5}, {6}, {3}};
        HasDeadlock hasDeadlock = new HasDeadlock();
        System.out.println(hasDeadlock.hasDeadlock(connections));

    }

    boolean hasDeadlock(int[][] connections) {

        Map<Integer, ArrayList<Integer>> dataMap = new HashMap<>();

        for (int i = 0; i < connections.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < connections[i].length; j++) {
                list.add(connections[i][j]);
            }
            dataMap.put(i, list);
        }

        boolean exist = false;
        for(Map.Entry<Integer, ArrayList<Integer>> entry : dataMap.entrySet()){
            Integer key = entry.getKey();
//            System.out.println("Key = " + key);
            ArrayList<Integer> childList = entry.getValue();

            ArrayList<Integer> exclusionList = new ArrayList<>();
            exclusionList.add(key);
            exist = isDeadLockExist(exclusionList, dataMap, childList);

            if (exist){
                break;
            }

        }

        return exist;
    }

    private boolean isDeadLockExist(ArrayList<Integer> exclusionList, Map<Integer,
            ArrayList<Integer>> dataMap, ArrayList<Integer> childList) {
        boolean exist = false;

        for(Integer exInt : exclusionList){
            if (childList.contains(exInt)){
                exist = true;
            }
        }

        if (!exist){
            for(Integer child : childList){
//                System.out.println("child = " + child);
                exclusionList.add(child);
                ArrayList<Integer> arrayList = dataMap.get(child);
                if (arrayList != null && arrayList.size() > 0){
                    exist = isDeadLockExist(exclusionList, dataMap, arrayList);
                    if (exist){
                        break;
                    }
                }
                exclusionList.remove(child);
            }
        }
        return exist;
    }

    private boolean checkIfExist(Map<Integer, ArrayList<Integer>> dataMap,
                                 Integer key, ArrayList<Integer> exclusionList) {

        ArrayList<Integer> arrayList = dataMap.get(key);

        for (Integer child : arrayList){
            if (exclusionList.contains(child)){
                return true;
            }
            if (dataMap.get(child).size() > 0){
                exclusionList.add(child);
                boolean exist = checkIfExist(dataMap, child, exclusionList);
            }
        }


        return false;
    }


}
