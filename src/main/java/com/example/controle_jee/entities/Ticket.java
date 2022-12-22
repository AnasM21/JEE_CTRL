package com.example.controle_jee.entities;

import com.example.controle_jee.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 16,nullable = false,unique = true)
    private String RefTicket;

    private float Price;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Match match;


    public Ticket(long id, String refTicket, float price, Status status) {
        this.id = id;
        RefTicket = refTicket;
        Price = price;
        this.status = status;
    }
}
