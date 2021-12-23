package com.arboleda.arboledarecharge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "PHONE")
public class Phone {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    public Phone(String id, TelecomProvider telecomProvider) {
        this.id = id;
        this.telecomProvider = telecomProvider;
    }

    public Phone() {
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "companyId", referencedColumnName = "id")
    public TelecomProvider telecomProvider;
}
