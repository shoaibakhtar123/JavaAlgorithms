/*
Consider a special family of Engineers and Doctors. This family has the following rules:

Everybody has two children.
The first child of an Engineer is an Engineer and the second child is a Doctor.
The first child of a Doctor is a Doctor and the second child is an Engineer.
All generations of Doctors and Engineers start with an Engineer.
We can represent the situation using this diagram:

                E
           /         \
          E           D
        /   \        /  \
       E     D      D    E
      / \   / \    / \   / \
     E   D D   E  D   E E   D
Given the level and position of a person in the ancestor tree above, find the profession of the person.
Note: in this tree first child is considered as left child, second - as right.

Example

For level = 3 and pos = 3, the output should be
findProfession(level, pos) = "Doctor".

Input/Output

[time limit] 3000ms (java)
[input] integer level

The level of a person in the ancestor tree, 1-based.

Guaranteed constraints:
1 ≤ level ≤ 30.

[input] integer pos

The position of a person in the given level of ancestor tree, 1-based, counting from left to right.

Guaranteed constraints:
1 ≤ pos ≤ 2(level - 1).

[output] string

Return Engineer or Doctor.
 */
import java.util.Set;

public class TreeFindProfessionModified {
    class Tree<T>{
        T value;
        Tree<T> left;
        Tree<T> right;

        public Tree(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TreeFindProfessionModified treeFindProfessionModified = new TreeFindProfessionModified();
//        System.out.println(treeFindProfessionModified.findProfession(25, 16777216));
        System.out.println(treeFindProfessionModified.findProfession(3, 1));
        System.out.println(treeFindProfessionModified.findProfession(2, 1));
        System.out.println(treeFindProfessionModified.findProfession(2, 2));
        System.out.println(treeFindProfessionModified.findProfession(3, 1));
        System.out.println(treeFindProfessionModified.findProfession(3, 2));
        System.out.println(treeFindProfessionModified.findProfession(3, 3));
        System.out.println(treeFindProfessionModified.findProfession(3, 4));
        System.out.println(treeFindProfessionModified.findProfession(4, 1));
        System.out.println(treeFindProfessionModified.findProfession(4, 2));
        System.out.println(treeFindProfessionModified.findProfession(4, 3));
        System.out.println(treeFindProfessionModified.findProfession(4, 4));
        System.out.println(treeFindProfessionModified.findProfession(4, 5));
        System.out.println(treeFindProfessionModified.findProfession(4, 6));
        System.out.println(treeFindProfessionModified.findProfession(4, 7));
        System.out.println(treeFindProfessionModified.findProfession(4, 8));

    }

    String findProfession(int level, int pos) {

        String e = "Engineer";
        String d = "Doctor";
        String parent= "E";

        if (level == 1){
            return e;
        }

        int midPos;

        while (level > 2){

            int totalChild = (int)Math.pow(2, (level-1));
            level--;
            midPos = totalChild/2;
            if (midPos < pos){
                pos = (pos-midPos);
                if (parent == "E"){
                    parent = "D";
                }else{
                    parent = "E";
                }
            }
        }

        if (parent == "E"){
            if (pos == 1){
                return e;
            } else {
                return d;
            }
        } else {
            if (pos == 1){
                return d;
            } else {
                return e;
            }

        }
    }

    String findProfession2(int level, int pos) {
        int currentLevel = 1;
        int currentPosition = 1;
        String[] p = new String[1];
        Tree<String> professionTree = new Tree<>("E");
        createProfession(professionTree, currentLevel, level, currentPosition, pos, p);

        return p[0];

    }

    private int createProfession(Tree<String> rootProfession, int currentLevel, int level,
                                 int currentPos, int pos, String[] p) {

        if (currentPos > pos){
            return currentPos;
        }

        if (currentLevel > level){
            return currentPos;
        }

        //Engineer
        if (rootProfession.value.compareTo("E") == 0){
            rootProfession.left = new Tree<>("E");
            if (currentLevel == level){
                if (currentPos == pos){
                    p[0] = "Engineer";
                }
                currentPos++;
            }
            rootProfession.right = new Tree<>("D");

            if (currentLevel == level){
                if (currentPos == pos){
                    p[0] = "Doctor";
                }
                currentPos++;
            }

        } else { // Doctor
            rootProfession.left = new Tree<>("D");
            if (currentLevel == level){
                if (currentPos == pos){
                    p[0] = "Doctor";
                }
                currentPos++;
            }
            rootProfession.right = new Tree<>("E");
            if (currentLevel == level){
                if (currentPos == pos){
                    p[0] = "Engineer";
                }
                currentPos++;
            }
        }

        currentLevel++;
        if (currentPos <= pos){
            currentPos = createProfession(rootProfession.left, currentLevel, level, currentPos, pos, p);
        }

        if (currentPos <= pos){
            currentPos = createProfession(rootProfession.right, currentLevel, level, currentPos, pos, p);
        }

        return currentPos;
    }

    private int getProfession(Tree<String> rootProfession, int currentLevel, int level,
                              int currentPosition, int pos, Set<String> professionSet) {

        if (rootProfession == null){
            return currentPosition;
        }

        if (currentPosition > pos){
            return currentPosition;
        }

        if (currentLevel == level){

            if (currentPosition == pos){
                professionSet.add(rootProfession.value);
            }
            return currentPosition+1;
        }

        currentPosition = getProfession(rootProfession.left, currentLevel+1, level, currentPosition, pos, professionSet);
        if (currentPosition <= pos){
            currentPosition = getProfession(rootProfession.right, currentLevel+1, level, currentPosition, pos, professionSet);
        }
        return currentPosition;

    }

}
