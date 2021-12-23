package com.arboleda.arboledarecharge.model;

import javax.persistence.*;

@Entity
@Table(name = "COMPANY")
public class TelecomProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    public TelecomProvider(Long id, String acceptedCurrency, String name) {
        this.id = id;
        this.acceptedCurrency = acceptedCurrency;
        this.name = name;
    }

    public TelecomProvider() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    private String acceptedCurrency;

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcceptedCurrency() {
        return acceptedCurrency;
    }

    public void setAcceptedCurrency(String acceptedCurrency) {
        this.acceptedCurrency = acceptedCurrency;
    }
}
