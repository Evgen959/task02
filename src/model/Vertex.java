package model;

import java.util.ArrayList;
import java.util.List;

// The Vertex class describes a vertex

public class Vertex implements Comparable<Vertex>{

    private final String name; // Vertex name
    private boolean visited; // whether we were at this peak or not
    private List<Edge> neighbors = new ArrayList<>(); // array for storing neighbors
    private double distance = Double.MAX_VALUE; // distance to vertices initialize the distance as infinity
    private Vertex predecessor = null; // previous peak from which you came

    public Vertex(String name) {
        this.name = name;
    }

    // Method for adding neighbors taking neighbors as edges
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

    // Method for sorting vertices
    @Override
    public int compareTo(Vertex o) {
        // Comparing two vertices in ascending order
        return Double.compare(this.getDistance(), o.getDistance());
    }
}
