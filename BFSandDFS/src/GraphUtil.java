import java.util.*;

public class GraphUtil {

    List<Vertex> BFSAlgorithm(Graph graph, Vertex start, Vertex end){

        Queue<Vertex> q = new LinkedList<>();

        Set<Vertex> visited = new HashSet<>();

        Map<Vertex, Vertex> parentMapping = new HashMap<>();

        q.add(start);

        visited.add(start);

        while(!q.isEmpty()){

            Vertex qPeek = q.poll();

            for(Vertex neighbor : graph.getAdjVertices(qPeek)){

                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    parentMapping.put(neighbor, qPeek);
                    q.add(neighbor);
                }
            }
        }

        List<Vertex> path = new ArrayList<>();

        path.add(end);

        while(true){
            end = parentMapping.get(end);
            path.add(end);

            if(end == start) return path;
        }

    }

    List<Vertex> DFSAlgorithm(Graph graph, Vertex start, Vertex end){

        Map<Vertex, Vertex> parentMapping = new HashMap<>();
        Set<Vertex> visited = new HashSet<>();

        DFSRecursion(graph, start, visited, parentMapping);

        List<Vertex> path = new ArrayList<>();

        path.add(end);

        while(true){
            end = parentMapping.get(end);
            path.add(end);

            if(end == start) return path;
        }

    }

    void DFSRecursion(Graph graph, Vertex currentVertex, Set<Vertex> visited, Map<Vertex, Vertex> parentMapping){

        if(visited.contains(currentVertex)) return;
        visited.add(currentVertex);

        for(Vertex neighbor: graph.getAdjVertices(currentVertex)){
            if(!parentMapping.containsKey(neighbor)) parentMapping.put(neighbor, currentVertex);
            DFSRecursion(graph, neighbor, visited, parentMapping);
        }

    }

}
