import java.util.ArrayList;

public class Vertex {
    public String name;
    public ArrayList<Edge> adjlist;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean visited;

    public Vertex(String _name) {
        this.name = _name;
        this.adjlist = new ArrayList<>();
    }

}

