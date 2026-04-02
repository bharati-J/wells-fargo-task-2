package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "advisor_id", nullable = false)
    private FinancialAdvisor advisor;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Portfolio> portfolios;

    protected Client() {}

    public Client(String name, FinancialAdvisor advisor, List<Portfolio> portfolios) {
        this.name = name;
        this.advisor = advisor;
        this.portfolios = portfolios;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public FinancialAdvisor getAdvisor() { return advisor; }
    public List<Portfolio> getPortfolios() { return portfolios; }

    public void setName(String name) { this.name = name; }
    public void setAdvisor(FinancialAdvisor advisor) { this.advisor = advisor; }
    public void setPortfolios(List<Portfolio> portfolios) { this.portfolios = portfolios; }
}