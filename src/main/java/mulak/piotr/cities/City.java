package mulak.piotr.cities;

public class City {

    private long id;
    private String name;
    private String country;
    private int population;
    private int area;



    public City(long id, String name, String country, int population, int area) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.population = population;
        this.area = area;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", population=" + population +
                ", area=" + area +
                '}';
    }
}
