package com.myobit.dao;

import com.myobit.dao.util.AbstractBaseDao;
import com.myobit.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Phillip on 6/26/2016.
 */
@Repository("UserDao")
public class UserDaoImpl extends AbstractBaseDao<User> implements UserDao {

}
