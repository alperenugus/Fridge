import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    Map<Vertex, List<Vertex>> adjVertices;
    int nodeCount;

    Graph(){
        adjVertices = new HashMap<>();
        nodeCount = 0;
    }

    void addVertex(Vertex vertex){
        adjVertices.put(vertex, new ArrayList<>());
        nodeCount++;
    }

    void removeVertex(Vertex vertex){
        adjVertices.values().stream().forEach(value -> value.remove(vertex));
        adjVertices.remove(vertex);
        nodeCount--;
    }

    void addEdge(Vertex vertex1, Vertex vertex2){
        adjVertices.get(vertex1).add(vertex2);
        adjVertices.get(vertex2).add(vertex1);
    }

    void removeEdge(Vertex vertex1, Vertex vertex2){
        List<Vertex> edgeList1 = adjVertices.get(vertex1);
        List<Vertex> edgeList2 = adjVertices.get(vertex2);
        if(edgeList1 != null) edgeList1.remove(vertex2);
        if(edgeList2 != null) edgeList2.remove(vertex1);
    }

    List<Vertex> getAdjVertices(Vertex vertex){
        return adjVertices.get(vertex);
    }

    void printGraph(){
        for(Map.Entry<Vertex, List<Vertex>> entry : this.adjVertices.entrySet()){

            System.out.println(entry.getKey().label + ":");

            entry.getValue().forEach(neighbor -> System.out.print(neighbor.label + ' '));
            System.out.println('\n');
        }
        for(int i = 0; i < 100; i++) System.out.print('=');
        System.out.println('\n');
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        Vertex bob = new Vertex("Bob");
        Vertex alice = new Vertex("Alice");
        Vertex mark= new Vertex("Mark");
        Vertex rob = new Vertex("Rob");
        Vertex maria = new Vertex("Maria");

        graph.addVertex(bob);
        graph.addVertex(alice);
        graph.addVertex(mark);
        graph.addVertex(rob);
        graph.addVertex(maria);

        graph.addEdge(bob, alice);
        graph.addEdge(bob, rob);
        graph.addEdge(alice, mark);
        graph.addEdge(rob, maria);
        graph.addEdge(alice, maria);

        GraphUtil graphUtil = new GraphUtil();

        List<Vertex> pathFromMariaToBob = graphUtil.BFSAlgorithm(graph, bob, maria);

        pathFromMariaToBob.forEach(vertex -> System.out.println(vertex.label));

        for(int i = 0; i < 50; i++) System.out.print('=');
        System.out.println('\n');

        List<Vertex> pathFromMarkToRob = graphUtil.DFSAlgorithm(graph, bob, maria);

        pathFromMarkToRob.forEach(vertex -> System.out.println(vertex.label));

    }
}
