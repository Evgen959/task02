package model;

public class City {

    private int idCity;
    private Vertex nameCity;

    public City(int idCity, Vertex nameCity) {
        this.idCity = idCity;
        this.nameCity = nameCity;
    }

    public int getIdCity() {
        return idCity;
    }

    public Vertex getNameCity() {
        return nameCity;
    }
}
