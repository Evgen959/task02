package controller;

import controller.interfeces.StartProject;
import model.City;
import model.Edge;
import model.Vertex;
import service.Dijkstra;

import java.util.List;
import java.util.Scanner;

// This class is designed to interact with the user and store initial data.

public class StartProjectImpl implements StartProject {

    private Dijkstra dijkstra = new Dijkstra();

    private Vertex gdansk = new Vertex("gdansk");
    private Vertex bydgoszcz = new Vertex("bydgoszcz");
    private Vertex torun = new Vertex("torun");
    private Vertex warszawa = new Vertex("warszawa");

    @Override
    public void start() {

        gdansk.addNeighbour(new Edge(1, gdansk, bydgoszcz));
        gdansk.addNeighbour(new Edge(3, gdansk, torun));
        bydgoszcz.addNeighbour(new Edge(1, bydgoszcz, gdansk));
        bydgoszcz.addNeighbour(new Edge(1, bydgoszcz, torun));
        bydgoszcz.addNeighbour(new Edge(4, bydgoszcz, warszawa));
        torun.addNeighbour(new Edge(3, torun, gdansk));
        torun.addNeighbour(new Edge(1, torun, bydgoszcz));
        torun.addNeighbour(new Edge(1, torun, warszawa));
        warszawa.addNeighbour(new Edge(4, warszawa, bydgoszcz));
        warszawa.addNeighbour(new Edge(1, warszawa, torun));

        Scanner scanner = new Scanner(System.in);

        System.out.println("1: gdansk");
        System.out.println("2: bydgoszcz");
        System.out.println("3: torun");
        System.out.println("4: warszawa");
        System.out.print("Выбери номер города из списка с которого надо начинать расчет: ");
        int a = scanner.nextInt();

        System.out.println("1: gdansk");
        System.out.println("2: bydgoszcz");
        System.out.println("3: torun");
        System.out.println("4: warszawa");
        System.out.print("Выбери номер города из списка до которой надо рассчитать кратчайший путь: ");
        int b = scanner.nextInt();

        // launch the program and indicate the city from which we will start the calculation
        // We find the city by index from the list using the cityNameByIdCity method
        dijkstra.compute(cityNameByIdCity(a));

        // We indicate the city using the cityNameByIdCity method, to which we need to calculate the shortest path
        System.out.println(cityNameByIdCity(b).getDistance());

        // we run a method that displays all the cities through which our path passes
        dijkstra.showPath(cityNameByIdCity(b));
    }

    // method for specifying a city
    private Vertex cityNameByIdCity (int idcity){

        // create an immutable List<City>
        List<City> cityList = List.of(
                new City(1, gdansk),
                new City(2, bydgoszcz),
                new City(3, torun),
                new City(4, warszawa)
        );

        // return a Vertex object, filter by city number in stream()
        return cityList.stream()
                .filter(s -> s.getIdCity() == idcity)
                .findFirst()
                .map(c -> c.getNameCity())
                .orElse(null);
    }
}
