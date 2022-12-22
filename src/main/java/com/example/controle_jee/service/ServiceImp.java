package com.example.controle_jee.service;

import com.example.controle_jee.entities.Match;
import com.example.controle_jee.entities.Ticket;
import com.example.controle_jee.enums.Status;
import com.example.controle_jee.repos.MatchRepo;
import com.example.controle_jee.repos.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service

public class ServiceImp implements ITicket,IMatch{
    @Autowired
    MatchRepo matchRepo;
    @Autowired
    TicketRepo ticketRepo;
    @Override
    public String addmatch(Match match) {
        matchRepo.save(match);
        return "match saved";
    }

    @Override
    public Match getmatch(Long id) {

        return matchRepo.findById(id).get();
    }


    @Override
    public String buyTicket(Long i) {
        Ticket e = ticketRepo.findById(i).orElse(null);
        Collection<Ticket> t = ticketRepo.findAll();
        System.out.println(t.size());
        if(e ==null){
            return "No tickets available";
        }else {
            e.setStatus(Status.ACTIVATED);
            ticketRepo.save(e);
            return "You have successfully purchased a ticket";
        }
    }

    @Override
    public String testbuyTicket(Long id, int i) {
        Match m = matchRepo.findById(id).orElse(null);
        Boolean check=true;
        if (m != null){

            List<Ticket> t = ticketRepo.findByMatch(m);
            List<Ticket> newone = new ArrayList<>();
            t.forEach(x->{
                if (x.getStatus().equals(Status.DEACTIVATED)) {
                    newone.add(x);
                }
            });
            if (newone.size() < 2022 && newone.size() !=0) {
                System.out.println(newone.size());
                for (Ticket s : newone) {

                    if (s.getId() == i) {
                        System.out.println(s.getId());
                        s.setStatus(Status.ACTIVATED);
                        ticketRepo.save(s);
                        check=false;
                        return "you just bought a ticket";

                    }
                }
                if (check){
                    return "ticket aleardy bought";
                }
            }else {
                return "not in stock";
            }
        }


        return "no match";
    }

    @Override
    public String updateTicket(Long id, Ticket ticket) {
        Ticket e = ticketRepo.findById(id).orElse(null);
        if (e == null ) {
            return "not found";

        }else {
            e.setRefTicket(ticket.getRefTicket());
            e.setStatus(ticket.getStatus());
            e.setPrice(ticket.getPrice());
            ticketRepo.save(e);
            return "saved";
        }
    }
}
