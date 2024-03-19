package nguyen_dinh_hieu.ex_customlistview;

public class Country {
    private String coutryName;
    private String flagName;
    private int population;

    public Country(String coutryName, String flagName, int population) {
        this.coutryName = coutryName;
        this.flagName = flagName;
        this.population = population;
    }

    public String getCoutryName() {
        return coutryName;
    }

    public String getFlagName() {
        return flagName;
    }

    public int getPopulation() {
        return population;
    }
}
