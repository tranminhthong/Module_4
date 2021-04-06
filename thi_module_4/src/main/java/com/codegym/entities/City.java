package com.codegym.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cities")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nameCity;
    @ManyToOne
    @JoinColumn(name = "country_id")
    @NotNull
    private Country country;

    @NotNull @Min(1)
    private Long area;
    @NotNull @Min(1)
    private Long population;
    @NotNull @Min(1)
    private Long GDP;
    private String introduction;

    public City() {
    }

    public City(Long id, @NotNull String nameCity, @NotNull Country country, @NotNull @Min(1) Long area, @NotNull @Min(1) Long population, @NotNull @Min(1) Long GDP, String introduction) {
        this.id = id;
        this.nameCity = nameCity;
        this.country = country;
        this.area = area;
        this.population = population;
        this.GDP = GDP;
        this.introduction = introduction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getGDP() {
        return GDP;
    }

    public void setGDP(Long GDP) {
        this.GDP = GDP;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
