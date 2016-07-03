package com.myobit.dao.util;

import com.myobit.dao.util.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by Phillip on 5/28/2016.
 */
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class AbstractBaseDao<T> implements BaseDao<T> {

    protected T t;

    @Autowired
    protected SessionFactory sessionFactory;

    public T getbyId(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String query = String.format("from %s where Id = %d",this.getClass().getSimpleName().replace("DaoImpl",""),id);
        this.t = (T)session.createQuery(query).uniqueResult();
        session.getTransaction().commit();
        session.close();
        return t;
    }

    @SuppressWarnings(value = "METHOD")
    public ArrayList<T> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String query = String.format("from %s",this.getClass().getSimpleName().replace("DaoImpl",""));
        ArrayList<T> list = (ArrayList)session.createQuery(query).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public void addNew(T t) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(T t) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
        session.close();
    }

    public void update(T t) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        session.close();
    }

    public void refresh(T t) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.refresh(t);
        session.getTransaction().commit();
        session.close();
    }
}
