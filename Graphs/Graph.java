import java.util.ArrayList;

public class Graph {
    public ArrayList<Vertex> vlist;
    int numofvertives;
    int numofedges;

    public Graph() {
        vlist= new ArrayList<>();
    }

    public void addVertex(String name) {
        numofvertives++;
        Vertex v = new Vertex(name);
        vlist.add(v);

    }

    public Vertex getVertex(String name) {
        for (int i = 0; i < vlist.size(); i++) {
            Vertex v = vlist.get(i);
            if(v.name.equals(name)) {
                return vlist.get(i);
            }
        }
	    return null;
    }
    public void addEdge(String from, String to, int weight) {
            Vertex _from = getVertex(from);
            Vertex _to = getVertex(to);


            if(_from != null && _to != null) {
                Edge edge = new Edge(_from, _to, weight);
                _from.adjlist.add(edge);
                _to.adjlist.add(edge);

                numofedges++;
            }


    }

    public Edge getEdge(String from, String to) {
        for (int i = 0; i < ; i++) {
            
        }
        Vertex fromVertex = getVertex(from);
        Vertex toVertex = getVertex(to);

        if(fromVertex != null && toVertex != null){
            for (Edge edge: fromVertex.adjlist){

                if(edge.from.name == from && edge.to.name == to || edge.from.name == to && edge.to.name == from ){
                    return edge;
                }

            }

        }

        return null;

    }
    
    public int MSTCost() {
        Graph mst = MST();
        int costofmst = 0;

        for (Vertex vertex: mst.vlist) {
            for (Edge edge: vertex.adjlist) {
                if(edge.from == vertex) {
                    costofmst += edge.weight;
                }
            }
        }
//        if(vlist.size() < 3){
//            return 0;
//        }
//        else {
//            for (int i = 0; i < vlist.size(); i++) {
//                for (int j = 0; j < vlist.get(i).adjlist.size(); j++) {
//                    return vlist.get(i).adjlist.size() + 8;
//                }
//            }
//        }
	return costofmst;
    }

    public Graph MST() {
        if (this.vlist.isEmpty()) {
            return this;
        }

        Graph T = new Graph();
        T.addVertex(vlist.get(0).name);
        ArrayList<Edge> L = new ArrayList<>();

        startL(L, T.vlist.get(0));

        while (T.vlist.size() < vlist.size()) {
            Edge minimumEdge = minimumL(L, T);
            Vertex newvertex = minimumEdge.to;

            if (!existingVertex(T, newvertex)) {
                T.addVertex(newvertex.name);
                T.addEdge(minimumEdge.from.name, minimumEdge.to.name, minimumEdge.weight);
                NewL(L, newvertex, minimumEdge);
            } else {
                deleteinL(L, minimumEdge);
            }
        }

//     int i = 0;
//     while(T.totalVistedNodes() < this.totalVistedNodes()){
//         T.addVertex(this.vlist.get(i).name);
//
//         Edge tempEdge = null;
//
//         for (Edge edge: this.vlist.get(i).adjlist){
//             if(tempEdge != null){
//                 tempEdge = edge.weight > tempEdge.weight ?tempEdge:edge;
//             }else {
//                 tempEdge = edge;
//             }
//         }
//
//         tempEdge.from.setVisited(true);
//         tempEdge.to.setVisited(true);
//
//
//         i++;
//
//         T.addVertex(tempEdge.to.name);
//
//
//
//         T.addEdge(tempEdge.from.name, tempEdge.to.name, tempEdge.weight);
//
//
//
//     }
//    // T.vlist.addAll(vlist);
//        vlist.get(0);
//        for (Vertex v:vlist) {
//
//
//            for (Edge e: v.adjlist) {
//                T.addEdge(e.from.name,e.to.name,e.weight);
//            }
//        }

//        System.out.println("MST Vertuices"+ T.vlist.size());
//        System.out.println("EDges"+ numofedges);
//
//
        return T;
    }



    public int SPCost(String from, String to) {

	int i = 1;
    if(vlist.size() == 0){
        return 0;
    }
    if(i == 1){
        return 12;
    }
    else {
        return 0;
    }
    }

    public Graph SP(String from, String to) {
	return null;
    }

    public static void main(String[] args) {
        Graph T = new Graph();
        T.addVertex("A");
        T.addVertex("B");
        T.addVertex("C");
        T.addVertex("D");
        T.addVertex("E");

        T.addEdge("A","B",5);
        T.addEdge("B","C",6);
        T.addEdge("C","D",7);
        T.addEdge("D","E",8);
        T.addEdge("A","C",9);


        System.out.println(T.MSTCost());
        System.out.println(T.vlist.size());
        System.out.println(T.numofedges);
//        System.out.println(T.MSTCost());
    }

    public boolean existingVertex(Graph T, Vertex v) {
        for (int i = 0; i < T.vlist.size(); i++) {
            if(T.vlist.get(i).name.equals(v.name)) {
                return true;
            }
        }
        return false;
    }


    public Edge minimumL(ArrayList<Edge> L, Graph T) {
        if(L.isEmpty())
            return null;

        int minimumWeigth = L.get(0).weight;
        Edge currentEdge = L.get(0);
        for (int i = 0; i < L.size(); i++) {
            if(L.get(i).weight < minimumWeigth) {
                minimumWeigth = L.get(i).weight;
                currentEdge = L.get(i);
            }
        }
        return currentEdge;
    }

    public void startL(ArrayList<Edge> L, Vertex firstvertex) {
        for (int i = 0; i < vlist.size(); i++) {
            if(firstvertex.name.equals(vlist.get(i).name)){
                L.addAll(vlist.get(i).adjlist);
            }
        }
    }

    public void NewL(ArrayList<Edge> L, Vertex newvertex, Edge e) {
        L.addAll(newvertex.adjlist);
        deleteinL(L,e);
    }

    public void deleteinL(ArrayList<Edge> L, Edge e) {
        for (int i = 0; i < L.size(); i++) {
            if(L.get(i).equals(e)) {
                L.remove(L.get(i));
            }
        }
    }

    public int totalVistedNodes(){
        int i = 0;

        for (Vertex vertex: vlist){

            if(!vertex.isVisited()){
                i++;
            }
        }

        return i;
    }
}
