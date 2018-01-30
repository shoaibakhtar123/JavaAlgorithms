/*
Given a binary tree t, determine whether it is symmetric around its center, i.e.
each side mirrors the other.

Example

For

t = {
    "value": 1,
    "left": {
        "value": 2,
        "left": {
            "value": 3,
            "left": null,
            "right": null
        },
        "right": {
            "value": 4,
            "left": null,
            "right": null
        }
    },
    "right": {
        "value": 2,
        "left": {
            "value": 4,
            "left": null,
            "right": null
        },
        "right": {
            "value": 3,
            "left": null,
            "right": null
        }
    }
}
the output should be isTreeSymmetric(t) = true.

Here's what the tree in this example looks like:

    1
   / \
  2   2
 / \ / \
3  4 4  3
As you can see, it is symmetric.

For

t = {
    "value": 1,
    "left": {
        "value": 2,
        "left": null,
        "right": {
            "value": 3,
            "left": null,
            "right": null
        }
    },
    "right": {
        "value": 2,
        "left": null,
        "right": {
            "value": 3,
            "left": null,
            "right": null
        }
    }
}
the output should be isTreeSymmetric(t) = false.

Here's what the tree in this example looks like:

    1
   / \
  2   2
   \   \
   3    3
As you can see, it is not symmetric.

Input/Output

[time limit] 3000ms (java)
[input] tree.integer t

A binary tree of integers.

Guaranteed constraints:
0 ≤ tree size < 5 · 104,
-1000 ≤ node value ≤ 1000.

[output] boolean

Return true if t is symmetric and false otherwise.

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
 */

public class TreeIsTreeSymmetric {
    public static void main(String[] args) {

    }

    boolean isTreeSymmetric(Tree<Integer> t) {

        if (t==null){
            return true;
        }
        Tree<Integer> leftPointer = t.left;
        Tree<Integer> rightPointer = t.right;

        return checkIfChildIsSame(leftPointer, rightPointer);

    }

    private boolean checkIfChildIsSame(Tree<Integer> left, Tree<Integer> right) {
        if (left == null && right == null){
            return true;
        }

        if (left == null && right != null){
            return false;
        }
        if (left != null && right == null){
            return false;
        }

        if (left.value.intValue() != right.value.intValue()){
            return false;

        }

        if (!checkIfChildIsSame(left.left, right.right)){
            return false;
        }

        if (!checkIfChildIsSame(left.right, right.left)){
            return false;
        }

        return true;
    }

    private void postOrderTraversal(Tree<Integer> node, StringBuilder rightData, String r) {
        if (node == null){
            return;
        }
        rightData.append(r + node.value);
        postOrderTraversal(node.left, rightData, "L");
        postOrderTraversal(node.right, rightData, "R");
    }

    private void preOrderTraversal(Tree<Integer> node, StringBuilder leftData, String l) {
        if (node == null){
            return;
        }
        leftData.append(l + node.value);
        preOrderTraversal(node.left, leftData, "L");
        preOrderTraversal(node.right, leftData, "R");
    }


    //
// Definition for binary tree:
 class Tree<T> {
   Tree(T x) {
     value = x;
   }
   T value;
   Tree<T> left;
   Tree<T> right;
 }


}
