package com.example.controle_jee.service;

import com.example.controle_jee.entities.Ticket;

public interface ITicket {
    public String buyTicket(Long i);
    public String testbuyTicket(Long id,int i);

    public String updateTicket(Long id, Ticket ticket);


}
