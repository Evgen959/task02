package service;

import model.Edge;
import model.Vertex;

import java.util.*;

// The Dijkstra class describes the logic of Dijkstra algorithm.

public class Dijkstra {

    // create a priority queue
    private final PriorityQueue<Vertex> queue = new PriorityQueue<>();

    //method implementing the logic of Dijkstra algorithm
    public void compute(Vertex source){

        source.setDistance(0);// assign distance "0" to the first vertex
        queue.add(source); // add the first vertex to the queue

        // we go through the line until there is something in it
        while (!queue.isEmpty()){
            // remove a vertex from the queue
            Vertex curr = queue.poll();

            // we go through all the neighbors, and recognize the neighbors through the edge
            for (Edge e : curr.getNeighbors()){
                // initialize the vertex at the end of the edge
                Vertex end = e.getEnd();
                // find the weight of the edge
                double w = e.getWeight();

                // if you haven't already been to the vertex at the end of the edge
                if (!end.isVisited()){
                    // if the sum of the current vertex plus the weight of the edge is less than the value of the vertex at the end of the edge
                    if (curr.getDistance() + w < end.getDistance()){
                        // change the value of the vertex at the end of the edge to a shorter distance
                        end.setDistance(curr.getDistance() + w);
                        // if a neighbor is in line
                        if (queue.contains(end))
                            // remove a neighbor from the queue
                            queue.remove(end);
                        // add a neighbor with a new value
                        queue.add(end);
                        // add the vertex from where we come
                        end.setPredecessor(curr);
                    }
                }
            }
            // if we have visited all neighbors, then we exit the loop
            curr.setVisited(true);
        }
    }

    // a method that displays all the vertices through which our path passes
    public void showPath(Vertex end){
        // We create a collection of vertices of our path from end to beginning
        List<Vertex> path = new ArrayList<>();

        // loop to go all the way from end to beginning
        while (end != null){
            path.add(end);
            end = end.getPredecessor();
        }
        // reverse of our collection to show the path from start to finish
        Collections.reverse(path);
        for (Vertex v : path)
            System.out.print(v.getName()  + " ");
    }
}
