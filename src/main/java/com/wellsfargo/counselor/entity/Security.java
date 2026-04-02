package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

@Entity
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double value;

    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    protected Security() {}

    public Security(String name, Double value, Portfolio portfolio) {
        this.name = name;
        this.value = value;
        this.portfolio = portfolio;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Double getValue() { return value; }
    public Portfolio getPortfolio() { return portfolio; }

    public void setName(String name) { this.name = name; }
    public void setValue(Double value) { this.value = value; }
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
}