package com.myobit.dao;

import com.myobit.dao.util.BaseDao;
import com.myobit.domain.Person;
import com.myobit.domain.Relationship;
import com.myobit.domain.RelationshipType;

/**
 * Created by Phillip on 5/21/2016.
 */
public interface PersonDao extends BaseDao<Person> {

    Person getByFirstNameLastName(String firstName, String lastName);

    void deleteByFirstNameLastName(String firstName, String lastName);

    void deleteAllAddresses(Person person);

    void addRelationship(Person primary, Person secondary, RelationshipType relationshipType);

    void removeRelationship(Person person, Relationship toRemove);
}
