import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FirstGraphTest {
    Map<String, String[]> network;
    public static void main(String[] args) {
        FirstGraphTest firstGraphTest = new FirstGraphTest();
        firstGraphTest.initializeMap();
    }

    private void initializeMap() {
        network = new HashMap<>();
        network.put("Min",     new String[] { "William", "Jayden", "Omar" });
        network.put("William", new String[] { "Min", "Noam" });
        network.put("Jayden",  new String[] { "Min", "Amelia", "Ren", "Noam" });
        network.put("Ren",     new String[] { "Jayden", "Omar" });
        network.put("Amelia",  new String[] { "Jayden", "Adam", "Miguel" });
        network.put("Adam",    new String[] { "Amelia", "Miguel", "Sofia", "Lucas" });
        network.put("Miguel",  new String[] { "Amelia", "Adam", "Liam", "Nathan" });
    }

    void findShortestRoute(String startNode, String endNode){
        Queue<String> nodesToVisit = new ArrayDeque<>();
        nodesToVisit.add(startNode);

        Set<String> visitedNode = new HashSet<>();
        visitedNode.add(startNode);

        Map<String, String> shortestRoute = new HashMap<>();
        shortestRoute.put(startNode, null);

        while (!nodesToVisit.isEmpty()){
            String currentNode = nodesToVisit.remove();

            if (currentNode.equals(endNode)){
//                shortestRoute.put(currentNode, endNode);
                //TODO right the method to return the shortest route.
                getTheShortestRoute(shortestRoute, startNode, endNode);
                break;
            }


            for (String neighbour : network.get(currentNode)){

                if (!visitedNode.contains(neighbour)){
                    nodesToVisit.add(neighbour);
                    visitedNode.add(neighbour);
                    shortestRoute.put(currentNode, neighbour);
                }

            }

        }

        //If it comes here no route is possible.

        return;


    }

    private void getTheShortestRoute(Map<String, String> shortestRoute, String startNode, String endNode) {

    }
}
