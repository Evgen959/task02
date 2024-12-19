package model;

public class City {

    private int idCity;
    private String nameCity;

    public City(int idCity, String nameCity) {
        this.idCity = idCity;
        this.nameCity = nameCity;
    }

    @Override
    public String toString() {
        return String.format("nameCity - %s", nameCity);
    }

    public int getIdCity() {
        return idCity;
    }

    public Vertex getNameCity() {
        return nameCity;
    }
}
