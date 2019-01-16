package com.stats.dao.impl;

import com.stats.dao.TeamDao;
import com.stats.model.Teams;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TeamDaoImpl implements TeamDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(Teams team) {
        entityManager.unwrap(Session.class).save(team);
    }

    @Override
    public List<Teams> list() {
        return (List<Teams>) entityManager.unwrap(Session.class).createQuery("From Teams").list();
    }

    @Override
    public Teams getTeamByDotaId(int dotaId) {
        return (Teams) entityManager.unwrap(Session.class).createQuery("From Teams where dotaId="+dotaId).uniqueResult();
    }
}
