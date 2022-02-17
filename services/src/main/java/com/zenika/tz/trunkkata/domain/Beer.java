package com.zenika.tz.trunkkata.domain;

import com.zenika.tz.trunkkata.spi.IBeerRepository;

import java.util.Objects;

public final class Beer {
    private Long id;
    private String name;
    private String brewery;
    private String type;

    public Beer(Long id, String name, String brewery, String type) {
        this.id = id;
        this.name = name;
        this.brewery = brewery;
        this.type = type;
    }

    public Beer create(IBeerRepository repository) {
        return repository.save(this);
    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String brewery() {
        return brewery;
    }

    public String type() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Beer) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.brewery, that.brewery) &&
                Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, brewery, type);
    }

    @Override
    public String toString() {
        return "Beer[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "brewery=" + brewery + ", " +
                "type=" + type + ']';
    }

}
