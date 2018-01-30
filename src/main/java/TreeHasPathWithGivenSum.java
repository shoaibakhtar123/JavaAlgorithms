public class TreeHasPathWithGivenSum {

    private Tree<Integer> treeTop;

    public static void main(String[] args) {
        TreeHasPathWithGivenSum treeHasPathWithGivenSum = new TreeHasPathWithGivenSum();
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

    boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
        return false;
    }

    //PreOrder, PostOrder and InOrder Traversal

    int inOrderTraversal_1(Tree<Integer> t, int totalSum, int requiredSum){

        if (t == null){
            return 0;
        }

        if (t.left == null && t.right == null){
            if ((totalSum + t.value) == requiredSum){
                System.out.println("Possible");
            }
            return totalSum + t.value;
        }

        if (t.left != null){
            //Traverse left
            totalSum += t.value;
        } else if (t.right != null){
            //Traverse right
        }


        return 0;


    }

    void preOrderTraversal(Tree<Integer> t){

        if (t == null){
            return;
        }

        System.out.println(t.value);

        if (t.left != null){
            preOrderTraversal(t.left);
        }else if (t.right != null){
            preOrderTraversal(t.right);
        }
    }

    void inOrderTraversal(Tree<Integer> t){

        if (t == null){
            return;
        }

        if (t.left == null){
            System.out.println(t.value);
        }

        if (t.left != null){
            preOrderTraversal(t.left);
        }else if (t.right != null){
            preOrderTraversal(t.right);
        }
    }

}
