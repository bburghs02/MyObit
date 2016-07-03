package com.myobit.dao;

import com.myobit.dao.util.BaseDao;
import com.myobit.domain.Person;

/**
 * Created by Phillip on 5/21/2016.
 */
public interface PersonDao extends BaseDao<Person> {

    Person getByFirstNameLastName(String firstName, String lastName);

    void deleteByFirstNameLastName(String firstName, String lastName);

    void deleteAllAddresses(Person person);
}
