package com.zenika.tz.trunkkata.entity;

public class BeerEntity {

    private Long id;

    private String name;

    private String brewery;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(final String brewery) {
        this.brewery = brewery;
    }

}
