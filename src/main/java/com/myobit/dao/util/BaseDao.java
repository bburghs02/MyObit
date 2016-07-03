package com.myobit.dao.util;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by Phillip on 5/28/2016.
 */
public interface BaseDao<T> {

    T getbyId(Integer id);

    ArrayList<T> getAll();

    void addNew(T t);

    void delete(T t);

    void update(T t);

    void refresh(T t);
}
