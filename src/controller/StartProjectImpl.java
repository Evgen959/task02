package controller;

import controller.interfeces.StartProject;
import model.City;
import model.Edge;
import model.Vertex;
import service.Dijkstra;

import java.util.List;
import java.util.Scanner;

// This class is designed to interact with the user and store initial data.
// Этот класс предназначен для взаимодействия с пользователем и хранения исходных данных.

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

        // запускаем программу и указываем город с которого начитаем расчет
        // город находим по индексу из списка используя метод cityNameByIdCity
        dijkstra.compute(cityNameByIdCity(a));

        // указываем город с помощью метода cityNameByIdCity, до которого надо рассчитать кратчайший путь
        System.out.println(cityNameByIdCity(b).getDistance());

        // запускаем метод который выводит на экран все города через которые проходит наш путь
        dijkstra.showPath(cityNameByIdCity(b));
    }

    // метод для указания города
    private Vertex cityNameByIdCity (int idcity){

        // создаем не изменяемый List<City>
        List<City> cityList = List.of(
                new City(1, gdansk),
                new City(2, bydgoszcz),
                new City(3, torun),
                new City(4, warszawa)
        );

        // возвращаем объект Vertex, в stream() фильтруем по номеру города
        return cityList.stream()
                .filter(s -> s.getIdCity() == idcity)
                .findFirst()
                .map(c -> c.getNameCity())
                .orElse(null);
    }
}
