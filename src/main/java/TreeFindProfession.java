import java.util.HashSet;
import java.util.Set;

public class TreeFindProfession {
    public static void main(String[] args) {

        TreeFindProfession treeFindProfession = new TreeFindProfession();
        treeFindProfession.findProfession(4, 1);

    }

    String findProfession(int level, int pos) {
        int currentLevel = 1;
        int currentPosition = 1;
        Tree<String> professionTree = createProfessionTree(level, pos);
        Set<String> professionSet = new HashSet<>();
        getProfession(professionTree, currentLevel, level, currentPosition, pos, professionSet);

        String profession = "";
        System.out.println(professionSet);
        for(String c : professionSet){
            profession = c;
        }

        if (profession.equals("D")){
            return "Doctor";
        } else {
            return "Engineer";
        }

    }

    Tree<String> createProfessionTree(int level, int pos){

        Tree<String> rootProfession = new Tree<>("E");
        int currentLevel = 1;
        createProfession(rootProfession, currentLevel, level);
        return rootProfession;

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

    private void createProfession(Tree<String> rootProfession, int currentLevel, int level) {

        if (currentLevel >= level){
            return;
        }

        //Engineer
        if (rootProfession.value.compareTo("E") == 0){
            rootProfession.left = new Tree<>("E");
            rootProfession.right = new Tree<>("D");
        } else { // Doctor
            rootProfession.left = new Tree<>("D");
            rootProfession.right = new Tree<>("E");
        }

        createProfession(rootProfession.left, currentLevel+1, level);
        createProfession(rootProfession.right, currentLevel+1, level);
        return;
    }
    class Tree<T>{
        T value;
        Tree<T> left;
        Tree<T> right;

        public Tree(T value) {
            this.value = value;
        }
    }

//    private void postOrderTraversal(Tree<Character> rootProfession) {
//
//        if (rootProfession == null){
//            return;
//        }
//
//        postOrderTraversal(rootProfession.left);
//        postOrderTraversal(rootProfession.right);
//        System.out.print(rootProfession.value + " ");
//
//    }
//
//    private void inOrderTraversal(Tree<Character> rootProfession) {
//        if (rootProfession == null){
//            return;
//        }
//
//        inOrderTraversal(rootProfession.left);
//        System.out.print(rootProfession.value + " ");
//        inOrderTraversal(rootProfession.right);
//
//    }
//
//    private void preOrderTraversal(Tree<Character> rootProfession) {
//        if (rootProfession == null){
//            return;
//        }
//        System.out.print(rootProfession.value + " ");
//        preOrderTraversal(rootProfession.left);
//        preOrderTraversal(rootProfession.right);
//    }
//
//    private int createProfessionTreeLevels(Tree<Character> rootProfession, int currentLevel,
//                                            int level, int currentPos, int pos, Set<Character> profession) {
//
//        System.out.println("currentLevel = " + currentLevel);
//        System.out.println("currentPos = " + currentPos);
//        if (currentLevel >= level){
//            System.out.println("Returning");
//            return currentPos;
//        }
//
//        if ((currentPos+1) >= pos){
//            System.out.println("Returning pos");
//            return currentPos;
//        }
//
//        //Engineer
//        if (rootProfession.value.compareTo('E') == 0){
//            rootProfession.left = new Tree<>('E');
//            rootProfession.right = new Tree<>('D');
//
//            if (((currentLevel+1) == level)){
//                System.out.println("currentLevel reached = " + currentLevel);
//                if ((currentPos+1) == pos){
//                    System.out.println("Adding 1 E");
//                    profession.add('E');
//                }
//                currentPos++;
//                System.out.println("currentPos 1 = " + currentPos);
//
//                if ((currentPos+1) == pos){
//                    System.out.println("Adding 1 D");
//                    profession.add('D');
//                }
//                currentPos++;
//                System.out.println("currentPos 2 = " + currentPos);
//            }
//
//
//        } else { // Doctor
//            rootProfession.left = new Tree<>('D');
//            rootProfession.right = new Tree<>('E');
//            if (((currentLevel+1) == level)){
//                if ((currentPos+1) == pos){
//                    System.out.println("Adding 2 D");
//                    profession.add('D');
//                }
//                currentPos++;
//                System.out.println("currentPos 3 = " + currentPos);
//                if ((currentPos+1) == pos){
//                    profession.add('E');
//                    System.out.println("Adding 2 E");
//                }
//                currentPos++;
//                System.out.println("currentPos 4 = " + currentPos);
//            }
//        }
//
//        currentPos = createProfessionTreeLevels(rootProfession.left, currentLevel+1, level, currentPos, pos, profession);
//        currentPos = createProfessionTreeLevels(rootProfession.right, currentLevel+1, level, currentPos, pos, profession);
//        return currentPos;
//    }


}
