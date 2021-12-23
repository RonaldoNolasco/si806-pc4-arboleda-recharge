package com.arboleda.arboledarecharge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RECHARGE")
public class Recharge {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "accountId", nullable = false)
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String currency;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private TelecomProvider telecomProvider;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Phone phone;

    @Column
    private Date rechargeDate;

    @Column
    private Double amount;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getRechargeDate() {
        return rechargeDate;
    }

    public void setRechargeDate(Date paymentDate) {
        this.rechargeDate = paymentDate;
    }

    public TelecomProvider getCompany() {
        return telecomProvider;
    }

    public void setCompany(TelecomProvider telecomProvider) {
        this.telecomProvider = telecomProvider;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
