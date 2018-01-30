package newprogram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FeedingTime {
    public static void main(String[] args) {
//        String[][] classes = {{"Tiger", "Lima", "Frog"}, {"Tiger", "Zebra","Lion"}, {"Tiger", "Rabbit"}, {"Emu", "Zebra", "Rabbit"}};
//        String[][] classes = {{"Tiger", "Lima", "Frog"}, {"Tiger", "Zebra", "Lion"}, {"Tiger", "Rabbit"}, {"Lima", "Zebra", "Rabbit"}};
//        String[][] classes = {{"Lion", "Emu"}, {"Giraffe", "Peacock"}, {"Lima"}, {"Tiger", "Cheetah", "Slugs"}, {"Snakes", "Sealion"}};
//        String[][] classes = {{"Seal","Muskrat","Badger"},
//            {"Ocelot","Badger","Baboon"},
//            {"Mink","Opossum","Capybara"},
//            {"Camel","Muskrat","Opossum"},
//            {"Moose","Baboon","Camel"},
//            {"Lizard","Capybara","Beaver"}};

//        String[][] classes = {{"Ewe","Chipmunk","Chimpanzee"},
//                {"Ewe","Chimpanzee"},
//                {"Chimpanzee","Chipmunk"},
//                {"Chimpanzee","Shrew","Puma"},
//                {"Bat","Woodchuck","Chimpanzee"},
//                {"Chimpanzee","Turtle"}};

        String[][] classes = {{"aa","ab","ac","ad","ae","af","ag","ah"},
                {"aa","ai","aj","ba","bb","bc","bd","be"},
                {"bf","bg","bh","bi","bj","ca","cb","cc"},
                {"ab","bf","cd","ce","cf","cg","ch","ci","cj"},
                {"ac","ai","bg","da","db","dc","dd","de","df","dg"},
                {"aj","cd","da","dh","di","dj","ea","eb","ec","ed"},
                {"ad","bh","ee","ef","eg","eh","ei","ej","fa"},
                {"ba","bi","ce","db","dh","ee","fb","fc","fd"},
                {"ae","bj","cf","ef","fb","fe","ff","fg","fh","fi"},
                {"bb","ca","cg","dc","di","fe","fj","ga","gb"},
                {"af","dd","dj","eg","fc","ff","gc","gd","ge"},
                {"bc","cb","ch","de","ea","eh","fd","fg"},
                {"bd","cc","ci","eb","ei","fh","fj","gc"},
                {"ag","be","cj","df","ec","ej","fi","ga","gd"},
                {"ah","dg","ed","fa","gb","ge"}};

        FeedingTime feedingTime = new FeedingTime();
        System.out.println(feedingTime.feedingTime(classes));
    }

    int feedingTime(String[][] classes) {

        Map<Integer, ArrayList<String>> classList = new HashMap<>();

        for (int i = 0; i < classes.length; i++) {
            ArrayList<String> animalList = new ArrayList<>();
            for (int j = 0; j < classes[i].length; j++) {
                animalList.add(classes[i][j]);
            }
            classList.put(i, animalList);
        }

        int totalClasses = classList.size();

        int minDays = totalClasses;

        ArrayList<ArrayList<Integer>> listOfList = new ArrayList<>();

        for(Map.Entry<Integer, ArrayList<String>> entry : classList.entrySet()){
            Integer key = entry.getKey();
            ArrayList<String> animalList = entry.getValue();

            if (!existInListOfList(key, listOfList)){
                ArrayList<Integer> combinedKeys = new ArrayList<>();
                combinedKeys.add(key);
                listOfList.add(combinedKeys);
                getJoinedClasses(animalList, classList, combinedKeys, listOfList);
            }
        }

        if (listOfList.size() > 5){
            return -1;
        }
        return listOfList.size();
    }

    private void getJoinedClasses(ArrayList<String> animalList, Map<Integer,
            ArrayList<String>> classList, ArrayList<Integer> combinedKeys, ArrayList<ArrayList<Integer>> listOfList) {

        for (Map.Entry<Integer, ArrayList<String>> entry : classList.entrySet()) {
            Integer newKey = entry.getKey();
            ArrayList<String> newAnimalList = entry.getValue();

            if(!existInListOfList(newKey, listOfList)){
                boolean canCombine = canbeCombined(newAnimalList, animalList);
                if (canCombine){
                    combinedKeys.add(newKey);
                    animalList.addAll(newAnimalList);
                }
            }
        }
    }


    private boolean existInListOfList(Integer key, ArrayList<ArrayList<Integer>> listOfList) {
        for (ArrayList<Integer> list : listOfList){
            if (list.contains(key)){
                return true;
            }
        }
        return false;
    }

    private boolean canbeCombined(ArrayList<String> newAnimalList, ArrayList<String> animalList) {
        for (String animal : newAnimalList){
            boolean exist = ifExist(animal, animalList);
            if (exist){
                return false;
            }
        }
        return true;
    }

    private boolean ifExist(String animal, ArrayList<String> animalList) {
        for(String oldAnimal : animalList){
            if (oldAnimal.equalsIgnoreCase(animal)){
                return true;
            }
        }
        return false;
    }
}
