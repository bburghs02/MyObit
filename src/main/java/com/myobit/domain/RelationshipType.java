package com.myobit.domain;

/**
 * Created by Phillip on 7/3/2016.
 */
public enum RelationshipType {

    MOTHER("Mother"),
    FATHER("Father"),
    BROTHER("Brother"),
    SISTER("Sister"),
    GRANDMOTHER("Grand Mother"),
    GRANDFATHER("Grand Father"),
    GRANDSON("Grand Son"),
    GRANDDAUGHTER("Grand Daughter"),
    GRANDPARENT("Grand Parent"),
    GRANDCHILD("Grand Child"),
    PARENT("Parent"),
    CHILD("Child"),
    AUNT("Aunt"),
    UNCLE("Uncle"),
    COUSIN("Cousin"),
    NIECE("Niece"),
    NEPHEW("Nephew"),
    FRIEND("Friend");

    private String type;

    RelationshipType(String relationshipType) {
        this.type = relationshipType;
    }

    public String getType() {
        return type;
    }
}
