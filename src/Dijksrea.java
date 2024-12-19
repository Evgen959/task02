import java.util.*;

// Класс Dijksrea описывает логику алгоритма Дейкстры.

public class Dijksrea {

    // создаем приоритетную очередь
    private final PriorityQueue<Vertex> queue = new PriorityQueue<>();

    // метод реализующий логику алгоритма Дейкстры
    public void compute(Vertex source){

        source.setDistance(0);// присваиваем первой вершине растояние "0"
        queue.add(source); // добавляем первую вершину в очередь

        // проходим по очереди пока в ней что-то есть
        while (!queue.isEmpty()){
            // извлекаем из очереди вершину
            Vertex curr = queue.poll();

            // проходим по всем соседям, а узнаем соседей четез ребра
            for (Edge e : curr.getNeighbors()){
                // инициализируем вершину в конце ребра
                Vertex end = e.getEnd();
                // на ходим вес ребра
                double w = e.getWeight();

                // если еще небыл в вершине в конце ребра
                if (!end.isVisited()){
                    // если сумма нынишней вершины и вес ребра меньше чем значение вершины в конце ребра
                    if (curr.getDistance() + w < end.getDistance()){
                        // меняем значение вершины в конце ребра на растояние покороче
                        end.setDistance(curr.getDistance() + w);
                        // если в очереди лежит сосед
                        if (queue.contains(end))
                            // удаляем соседа из очереди
                            queue.remove(end);
                        // добавляем соседа с новым значением
                        queue.add(end);
                        // добавляем вершину откуда приходим
                        end.setPredecessor(curr);
                    }
                }
            }
            // если мы посетили всех соседей то выходим из цикла
            curr.setVisited(true);
        }
    }

    // метод который выводит на экран все вершины через которые проходит наш путь
    public void showPath(Vertex end){
        // Создаем коллекцию из вершин нашего пути с конца в начало
        List<Vertex> path = new ArrayList<>();

        // цик для прохождения по всему пути с конца в начало
        while (end != null){
            path.add(end);
            end = end.getPredecessor();
        }
        // реверс нашей коллекции для отображения пути с начала до конца
        Collections.reverse(path);
        for (Vertex v : path)
            System.out.print(v.getName()  + " ");
    }
}
