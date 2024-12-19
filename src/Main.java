
/*
3. Find the sum of the digits in the number 100! (i.e. 100 factorial)
{Correct answer: 648}

 */


import controller.StartProjectImpl;
import controller.interfeces.StartProject;

public class Main {

    public static void main(String[] args) {

        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");
        Vertex H = new Vertex("H");

        A.addNeighbour(new Edge(5, A, B));
        A.addNeighbour(new Edge(8, A, H));
        A.addNeighbour(new Edge(9, A, E));
        B.addNeighbour(new Edge(4, B, H));
        B.addNeighbour(new Edge(12, B, C));
        B.addNeighbour(new Edge(15, B, D));
        C.addNeighbour(new Edge(3, C, D));
        C.addNeighbour(new Edge(11, C, G));
        D.addNeighbour(new Edge(9, D, G));
        E.addNeighbour(new Edge(5, E, H));
        E.addNeighbour(new Edge(4, E, F));
        E.addNeighbour(new Edge(20, E, G));
        F.addNeighbour(new Edge(1, F, C));
        F.addNeighbour(new Edge(13, F, G));
        H.addNeighbour(new Edge(7, H, C));
        H.addNeighbour(new Edge(6, H, F));

        Dijksrea dijksrea = new Dijksrea();
        // запускаем програму и указываем что вершину с которой начитаем расчет
        // в данном случае вершина "А"
        dijksrea.compute(A);
        // указываем вершину "G" до каторой надо расчитать кратчайший путь
        System.out.println(G.getDistance());

        // запускаем метод который выводит на экран все вершины через которые проходит наш путь
        dijksrea.showPath(G);




//        // Declaring the startProject object
//        StartProject startProject = new StartProjectImpl();
//        // Calling the start() method in the StartProject class
//        startProject.start();

    }


}