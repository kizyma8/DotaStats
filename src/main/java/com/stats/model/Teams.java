package com.stats.model;

import javax.persistence.*;

@Entity
public class Teams {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = false)
    private int dotaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDotaId() {
        return dotaId;
    }

    public void setDotaId(int dotaId) {
        this.dotaId = dotaId;
    }
}
