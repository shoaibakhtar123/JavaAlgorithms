/*
Note: Your solution should have O(inorder.length) time complexity, since this is what
you will be asked to accomplish in an interview.

Let's define inorder and preorder traversals of a binary tree as follows:

Inorder traversal first visits the left subtree, then the root, then its right subtree;
Preorder traversal first visits the root, then its left subtree, then its right subtree.
For example, if tree looks like this:

    1
   / \
  2   3
 /   / \
4   5   6
then the traversals will be as follows:

Inorder traversal: [4, 2, 1, 5, 3, 6]
Preorder traversal: [1, 2, 4, 3, 5, 6]
Given the inorder and preorder traversals of a binary tree t, but not t itself,
restore t and return it.

Example

For inorder = [4, 2, 1, 5, 3, 6] and preorder = [1, 2, 4, 3, 5, 6], the output should be
restoreBinaryTree(inorder, preorder) = {
    "value": 1,
    "left": {
        "value": 2,
        "left": {
            "value": 4,
            "left": null,
            "right": null
        },
        "right": null
    },
    "right": {
        "value": 3,
        "left": {
            "value": 5,
            "left": null,
            "right": null
        },
        "right": {
            "value": 6,
            "left": null,
            "right": null
        }
    }
}
For inorder = [2, 5] and preorder = [5, 2], the output should be
restoreBinaryTree(inorder, preorder) = {
    "value": 5,
    "left": {
        "value": 2,
        "left": null,
        "right": null
    },
    "right": null
}
Input/Output

[time limit] 3000ms (java)
[input] array.integer inorder

An inorder traversal of the tree. It is guaranteed that all numbers in the tree
are pairwise distinct.

Guaranteed constraints:
1 ≤ inorder.length ≤ 2 · 103,
-105 ≤ inorder[i] ≤ 105.

[input] array.integer preorder

A preorder traversal of the tree.

Guaranteed constraints:
preorder.length = inorder.length,
-105 ≤ preorder[i] ≤ 105.

[output] tree.integer

The restored binary tree.
 */
public class TreeRestoreBinaryTree {
    public static void main(String[] args) {
        TreeRestoreBinaryTree  treeRestoreBinaryTree = new TreeRestoreBinaryTree();

//        int[] inorder = {-1, 1, 2, 3, 4, 5, 6};
//        int[] preorder = {3, 1, -1, 2, 5, 4, 6};

//        int[] inorder = {2,5};
//        int[] preorder = {5,2};

        int[] inorder = {1, 2, 3, 4, 5};
        int[] preorder = {1, 2, 3, 4, 5};
//        int[] preorder = {5, 4, 3, 2, 1};

        treeRestoreBinaryTree.restoreBinaryTree(inorder, preorder);

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

    Tree<Integer> restoreBinaryTree(int[] inorder, int[] preorder) {

        if (inorder == null){
            return null;
        }

        if (preorder == null){
            return null;
        }

        Tree<Integer> rootNode = new Tree<>(preorder[0]);

        int leftIndexForLeftTree = 0;

        int indexInInorder = getIndexInInOrder(preorder[0], inorder);
//        System.out.println("indexInInorder = " + indexInInorder);
        int rightIndexForLeftTree = getIndexInInOrder(preorder[0], inorder)-1;

        int totalLength = indexInInorder - leftIndexForLeftTree;

//        System.out.println("Total length = " + totalLength);

        int leftIndexForRightTree = indexInInorder + 1;
        int rightIndexForRightTree = preorder.length -1;

        int indexInPreOrderForLeft = 1;
        int indexInPreOrderForRight = indexInPreOrderForLeft + totalLength;

//        System.out.println("Calling for left RootNode value=" + rootNode.value
//                + " leftIndexForLeftTree = " + leftIndexForLeftTree
//                + " rightIndexForLeftTree = " + rightIndexForLeftTree
//                + " indexInPreOrderForLeft = " + indexInPreOrderForLeft);

//        System.out.println("Calling for right RootNode value=" + rootNode.value
//                + " leftIndexForRightTree = " + leftIndexForRightTree
//                + " rightIndexForRightTree = " + rightIndexForRightTree
//                + " indexInPreOrderForRight = " + indexInPreOrderForRight);

        //Create Left Tree
        if ((rightIndexForLeftTree - leftIndexForLeftTree) >=0){
            createLeftTree(rootNode, inorder, preorder, leftIndexForLeftTree,
                    rightIndexForLeftTree, indexInPreOrderForLeft);

        }

        //Create Right Tree
        if ((rightIndexForRightTree - leftIndexForRightTree) >=0){
            createRightTree(rootNode, inorder, preorder, leftIndexForRightTree,
                    rightIndexForRightTree, indexInPreOrderForRight);
        }

        inOrderTraversal(rootNode);
        System.out.println();
        preOrderTraversal(rootNode);

        return rootNode;
    }

    private void createLeftTree(Tree<Integer> rootNode, int[] inorder,
                                int[] preorder, int leftIndexForLeftTree,
                                int rightIndexForLeftTree, int indexInPreOrderForLeft) {

        System.out.println("createLeftTree RootNode value=" + rootNode.value
                + " leftIndexForLeftTree = " + leftIndexForLeftTree
                + " rightIndexForLeftTree = " + rightIndexForLeftTree
                + " indexInPreOrderForLeft = " + indexInPreOrderForLeft);

        rootNode.left = new Tree<>(preorder[indexInPreOrderForLeft]);

        if ((rightIndexForLeftTree - leftIndexForLeftTree) > 0) {
            System.out.println("Right or Left Exist in createLeftTree");
            //Right or Left or both exist
            int indexInInorder = getIndexInInOrder(preorder[indexInPreOrderForLeft], inorder);
            System.out.println("indexInInorder = " + indexInInorder);
            int leftIndexInPreOrder = indexInPreOrderForLeft+1;
            if ((indexInInorder - leftIndexForLeftTree) != 0){
                System.out.println("Left Tree Exist in Left");
                //Left Node exist
                createLeftTree(rootNode.left, inorder, preorder, leftIndexForLeftTree,
                        indexInInorder-1, leftIndexInPreOrder);
            }

            int rightIndexInPreOrder = leftIndexInPreOrder + (indexInInorder-leftIndexForLeftTree);
            if ((rightIndexForLeftTree - indexInInorder) !=0){
                System.out.println("Right Tree Exist In Left");
                //Right Node exist
                createRightTree(rootNode.left, inorder, preorder, indexInInorder+1,
                        rightIndexForLeftTree, rightIndexInPreOrder);

            }

        }

    }

    private void createRightTree(Tree<Integer> rootNode, int[] inorder,
                                 int[] preorder, int leftIndexForRightTree,
                                 int rightIndexForRightTree, int indexInPreOrderForRight) {

        System.out.println("createRightTree RootNode value=" + rootNode.value
                + " leftIndexForRightTree = " + leftIndexForRightTree
                + " rightIndexForRightTree = " + rightIndexForRightTree
                + " indexInPreOrderForRight = " + indexInPreOrderForRight);

        rootNode.right = new Tree<>(preorder[indexInPreOrderForRight]);

        if ((rightIndexForRightTree - leftIndexForRightTree) > 0) {
            //Right or Left or both exist
            int indexInInorder = getIndexInInOrder(preorder[indexInPreOrderForRight], inorder);

            int leftIndexInPreOrder = indexInPreOrderForRight+1;
            if ((leftIndexForRightTree - indexInInorder) != 0){
                System.out.println("Left Tree Exist in Right");

                //Left Node exist
                createLeftTree(rootNode.right, inorder, preorder, leftIndexForRightTree,
                        indexInInorder-1, leftIndexInPreOrder);

            }


            int rightIndexInPreOrder = leftIndexInPreOrder + (indexInInorder-leftIndexForRightTree);

            if ((rightIndexForRightTree - indexInInorder) >= 0){
                System.out.println("Right Tree Exist in Right");
                //Right Node exist
                createRightTree(rootNode.right, inorder, preorder, indexInInorder+1,
                        rightIndexForRightTree, rightIndexInPreOrder);
            }


        }
    }


    private int getIndexInInOrder(int i, int[] inorder) {
        for (int j = 0; j < inorder.length; j++) {
            if (inorder[j] == i){
                return j;
            }
        }
        return 0;
    }

    private void inOrderTraversal(Tree<Integer> node){

        if (node == null){
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.value + " ");
        inOrderTraversal(node.right);

    }

    private void preOrderTraversal(Tree<Integer> node){

        if (node == null){
            return;
        }

        System.out.print(node.value + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }


    //
// Definition for binary tree:

    Tree<Integer> restoreBinaryTree2(int[] inorder, int[] preorder) {
        return makeBTree(inorder, preorder, 0, inorder.length-1);
    }

    int pIndex=0;

    public Tree<Integer> makeBTree(int [] inOrder, int [] preOrder, int iStart, int iEnd ){
        if(iStart>iEnd){
            return null;
        }
        Tree<Integer> root = new Tree<Integer>(preOrder[pIndex]);
        pIndex++;

        if(iStart==iEnd){
            return root;
        }
        int index = getInorderIndex(inOrder, iStart, iEnd, root.value);
        root.left = makeBTree(inOrder,preOrder,iStart, index-1);
        root.right = makeBTree(inOrder,preOrder,index+1, iEnd);

        return root;
    }
    public int getInorderIndex(int [] inOrder, int start, int end, int data){
        for(int i=start;i<=end;i++){
            if(inOrder[i]==data){
                return i;
            }
        }
        return -1;
    }



}
