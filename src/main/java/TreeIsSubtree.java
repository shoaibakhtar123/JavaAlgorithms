/*
Given two binary trees t1 and t2, determine whether the second tree is a subtree
of the first tree. A subtree for vertex v in a binary tree t is a tree consisting of
v and all its descendants in t. Determine whether or not there is a
vertex v (possibly none) in tree t1 such that a subtree for
vertex v (possibly empty) in t1 equals t2.

Example

For

t1 = {
    "value": 5,
    "left": {
        "value": 10,
        "left": {
            "value": 4,
            "left": {
                "value": 1,
                "left": null,
                "right": null
            },
            "right": {
                "value": 2,
                "left": null,
                "right": null
            }
        },
        "right": {
            "value": 6,
            "left": null,
            "right": {
                "value": -1,
                "left": null,
                "right": null
            }
        }
    },
    "right": {
        "value": 7,
        "left": null,
        "right": null
    }
}
and

t2 = {
    "value": 10,
    "left": {
        "value": 4,
        "left": {
            "value": 1,
            "left": null,
            "right": null
        },
        "right": {
            "value": 2,
            "left": null,
            "right": null
        }
    },
    "right": {
        "value": 6,
        "left": null,
        "right": {
            "value": -1,
            "left": null,
            "right": null
        }
    }
}
the output should be isSubtree(t1, t2) = true.

This is what these trees look like:

      t1:             t2:
       5              10
      / \            /  \
    10   7          4    6
   /  \            / \    \
  4    6          1   2   -1
 / \    \
1   2   -1
As you can see, t2 is a subtree of t1 (the vertex in t1 with value 10).

For

t1 = {
    "value": 5,
    "left": {
        "value": 10,
        "left": {
            "value": 4,
            "left": {
                "value": 1,
                "left": null,
                "right": null
            },
            "right": {
                "value": 2,
                "left": null,
                "right": null
            }
        },
        "right": {
            "value": 6,
            "left": {
                "value": -1,
                "left": null,
                "right": null
            },
            "right": null
        }
    },
    "right": {
        "value": 7,
        "left": null,
        "right": null
    }
}
and

t2 = {
    "value": 10,
    "left": {
        "value": 4,
        "left": {
            "value": 1,
            "left": null,
            "right": null
        },
        "right": {
            "value": 2,
            "left": null,
            "right": null
        }
    },
    "right": {
        "value": 6,
        "left": null,
        "right": {
            "value": -1,
            "left": null,
            "right": null
        }
    }
}
the output should be isSubtree(t1, t2) = false.

This is what these trees look like:

        t1:            t2:
         5             10
       /   \          /  \
     10     7        4    6
   /    \           / \    \
  4     6          1   2   -1
 / \   /
1   2 -1
As you can see, there is no vertex v such that the subtree of t1 for vertex v equals t2.

For

t1 = {
    "value": 1,
    "left": {
        "value": 2,
        "left": null,
        "right": null
    },
    "right": {
        "value": 2,
        "left": null,
        "right": null
    }
}
and

t2 = {
    "value": 2,
    "left": {
        "value": 1,
        "left": null,
        "right": null
    },
    "right": null
}
the output should be isSubtree(t1, t2) = false.

Input/Output

[time limit] 3000ms (java)
[input] tree.integer t1

A binary tree of integers.

Guaranteed constraints:
0 ≤ tree size ≤ 6 · 104,
-1000 ≤ node value ≤ 1000.

[input] tree.integer t2

Another binary tree of integers.

Guaranteed constraints:
0 ≤ tree size ≤ 6 · 104,
-1000 ≤ node value ≤ 1000.

[output] boolean

Return true if t2 is a subtree of t1, otherwise return false.
 */
import java.util.ArrayList;
import java.util.List;

public class TreeIsSubtree {
    public static void main(String[] args) {

    }

    // Definition for binary tree:
 class Tree<T> {
   Tree(T x) {
     value = x;
   }
   T value;
   Tree<T> left;
   Tree<T> right;
 }
    boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {

        if (t1 == null || t2 == null){
            return false;
        }

        List<Tree<Integer>> vertexNodes = new ArrayList<>();

        populateAllVertexNodes(t1, t2.value, vertexNodes);

        boolean isSubtree = false;
        for (Tree<Integer> nodes:vertexNodes) {
            isSubtree = checkIfSubTree(nodes, t2);
            if(isSubtree)
                break;
        }

        return isSubtree;

    }

    private boolean checkIfSubTree(Tree<Integer> nodes, Tree<Integer> t2) {

        boolean isSubTree = false;
        if (nodes == null && t2 == null){
            return true;
        }

        if (nodes == null && t2 != null){
            return false;
        }

        if (nodes != null && t2 == null){
            return false;
        }

        if (nodes.value.compareTo(t2.value) == 0){
            isSubTree = true;
        }

        if (isSubTree){
            isSubTree = checkIfSubTree(nodes.left, t2.left);
        }

        if (isSubTree){
            isSubTree = checkIfSubTree(nodes.right, t2.right);
        }
        return isSubTree;
    }

    private void populateAllVertexNodes(Tree<Integer> t, Integer value, List<Tree<Integer>> vertexNodes) {

        if (t == null){
            return;
        }

        if (t.value.compareTo(value) == 0){
            vertexNodes.add(t);
        }

        populateAllVertexNodes(t.left, value, vertexNodes);
        populateAllVertexNodes(t.right, value, vertexNodes);

    }


}
