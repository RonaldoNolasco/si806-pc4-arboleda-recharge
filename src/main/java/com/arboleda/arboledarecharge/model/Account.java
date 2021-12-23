package com.arboleda.arboledarecharge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Entity
@Table(name = "ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String currency;

    @ManyToOne
    public User user;

    @Column
    @NotNull
    @PositiveOrZero
    public Double balance;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    public List<Recharge> recharges;
}
