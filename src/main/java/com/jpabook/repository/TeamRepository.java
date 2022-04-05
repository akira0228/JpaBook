package com.jpabook.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class TeamRepository {
    @PersistenceContext
    private EntityManager em;

    public Team save(Team team){
        em.persist(team);
        return team;

    }

    public void delete(Team team){
        em.remove(team);


    }
}
