package com.example.controle_jee.web;

import com.example.controle_jee.entities.Match;
import com.example.controle_jee.entities.Ticket;
import com.example.controle_jee.service.IMatch;
import com.example.controle_jee.service.ITicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MatchController {

    @Autowired
    IMatch iMatch;
    @Autowired
    ITicket iTicket;

    @MutationMapping
    String addmatch(@Argument Match m){
    return iMatch.addmatch(m);
    }
    @QueryMapping
    Match getmatch(@Argument Long id){
        return iMatch.getmatch(id);
    }


    @MutationMapping
    String buytickets(@Argument Long id){
        return iTicket.buyTicket(id);
    }
    @MutationMapping
    String updatetickets(@Argument Long id, @Argument Ticket t){
    return iTicket.updateTicket(id,t);
    }
    @MutationMapping
    String testupdatetickets(@Argument Long id,@Argument int i){
        return iTicket.testbuyTicket(id,i);
    }
}
