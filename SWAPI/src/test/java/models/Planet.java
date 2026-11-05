package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Planet {

    private String name;
    private String diameter;
    private String climate;
    private String gravity;
    private String population;
    private String terrain;
    private String url;

    @JsonProperty("rotation_period")
    private String rotationPeriod;

    @JsonProperty("orbital_period")
    private String orbitalPeriod;

    @JsonProperty("surface_water")
    private String surfaceWater;

    private List<String> residents;
    private List<String> films;
    private String created;
    private String edited;


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDiameter() { return diameter; }
    public void setDiameter(String diameter) { this.diameter = diameter; }
    public String getClimate() { return climate; }
    public void setClimate(String climate) { this.climate = climate; }
    public String getGravity() { return gravity; }
    public void setGravity(String gravity) { this.gravity = gravity; }
    public String getPopulation() { return population; }
    public void setPopulation(String population) { this.population = population; }
    public String getTerrain() { return terrain; }
    public void setTerrain(String terrain) { this.terrain = terrain; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getRotationPeriod() { return rotationPeriod; }
    public String getOrbitalPeriod() { return orbitalPeriod; }
    public String getSurfaceWater() { return surfaceWater; }
    public List<String> getResidents() { return residents; }
    public List<String> getFilms() { return films; }
    public String getCreated() { return created; }
    public String getEdited() { return edited; }
}