package model;

import java.util.List;

public class City {

    // private long idCity;

    private final String nameCity;

    private long namberOfNeighbors;

    private List<Neighbars> neighbars;

    public City(String nameCity) {
        this.nameCity = nameCity;
    }
}
