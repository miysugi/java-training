package com.samuraism.training.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class FizzBuzzController {
    @PersistenceContext
    EntityManager manager;

    @Transactional
    public List<Fizz> persistFizzBuzz(int max){
        manager.createNativeQuery("DELETE from FIZZ").executeUpdate();
        for (int i = 0; i < max; i++) {
            final Fizz newRecord = new Fizz();
            newRecord.setNumber(i);
            newRecord.setFizzBuzz(new FizzBuzz().fizzBuzz(i));
            manager.persist(newRecord);
        }
        return manager.createNamedQuery("FizzBuzz.findAll", Fizz.class).getResultList();

    }
}
