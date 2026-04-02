package com.wellsfargo.counselor.entity;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities;

    protected Portfolio() {}

    public Portfolio(Client client, List<Security> securities) {
        this.client = client;
        this.securities = securities;
    }

    public Long getId() { return id; }
    public Client getClient() { return client; }
    public List<Security> getSecurities() { return securities; }

    public void setClient(Client client) { this.client = client; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }
}