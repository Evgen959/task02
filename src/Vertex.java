import java.util.ArrayList;
import java.util.List;

// Класс Vertex описывает вершину

public class Vertex implements Comparable<Vertex>{

    private final String name; // Имя вершины
    private boolean visited; // были мы в этой вершине или нет
    private List<Edge> neighbors = new ArrayList<>(); // массив для хронения соседей
    private double distance = Double.MAX_VALUE; // растояние до вершин инициализируем растояние как бесконечность
    private Vertex predecessor = null; // предыдущая вершина из которой пришел

    public Vertex(String name) {
        this.name = name;
    }

    // Метод для добавления соседей принимая соседий как ребра
    public void addNeighbour (Edge e){
        neighbors.add(e);
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Edge> getNeighbors() {
        return neighbors;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    // Метод для сортировки вершин
    @Override
    public int compareTo(Vertex o) {
        // Сравнение двух вершин в порядке возростания
        return Double.compare(this.getDistance(), o.getDistance());
    }
}
