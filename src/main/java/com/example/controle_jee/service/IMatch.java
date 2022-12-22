package com.example.controle_jee.service;

import com.example.controle_jee.entities.Match;

public interface IMatch {
    public String addmatch(Match match);

    public Match getmatch(Long id);
}
