package pages;

public class CountriesClass {
    private String country;
    private long population;
    private long area;

    public CountriesClass(String country, long population, long area) {
        this.country = country;
        this.population = population;
        this.area = area;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }


}