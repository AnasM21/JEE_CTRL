package com.example.controle_jee.entities;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true,length = 16)
    private String ref;

    @Temporal(TemporalType.DATE)
    private Date date;


    private String Lieu;


    private String FirstTeam;


    private String SecondTeam;



    @OneToMany(mappedBy = "match",fetch = FetchType.LAZY)
    private Collection<Ticket> ticket;


}
