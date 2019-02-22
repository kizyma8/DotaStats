package com.stats.dao.impl;

import com.stats.dao.LeagueDao;
import com.stats.model.Leagues;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class LeagueDaoImpl implements LeagueDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Leagues league) {
        entityManager.unwrap(Session.class).save(league);
    }

    @Override
    public List<Leagues> list() {
        return (List<Leagues>) entityManager.unwrap(Session.class).createQuery("From Leagues").list();
    }
}
