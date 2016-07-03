package com.myobit.dao;

import com.myobit.dao.util.AbstractBaseDao;
import com.myobit.domain.Person;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Phillip on 5/22/2016.
 */
@Repository("PersonDao")
public class PersonDaoImpl extends AbstractBaseDao<Person> implements PersonDao{

    @Autowired
    AddressDaoImpl addressDao;

    public Person getByFirstNameLastName(String firstName, String lastName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String query = String.format("from Person where FirstName = '%s' and LastName = '%s'",firstName,lastName);
        Person foundPerson = (Person)session.createQuery(query).uniqueResult();
        session.getTransaction().commit();
        session.close();
        return foundPerson;
    }

    public void deleteByFirstNameLastName(String firstName, String lastName) {
        delete(getByFirstNameLastName(firstName, lastName));
    }

    public void deleteAllAddresses(Person person) {
        for (int i = 0; i< person.getAddresses().size(); i++) {
            addressDao.delete(person.getAddresses().get(i));
        }
    }
}