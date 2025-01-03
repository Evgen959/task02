
// Класс Edge описывает ребро.

public class Edge {

    private Vertex start; // вершина начала ребра
    private Vertex end; // вершина конца ребра
    private double weight; // вес ребра

    public Edge(double weight, Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public Vertex getStart() {
        return start;
    }

    public void setStart(Vertex start) {
        this.start = start;
    }

    public Vertex getEnd() {
        return end;
    }

    public void setEnd(Vertex end) {
        this.end = end;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
