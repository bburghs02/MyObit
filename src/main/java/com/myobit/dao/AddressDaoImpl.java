package com.myobit.dao;

import com.myobit.dao.util.AbstractBaseDao;
import com.myobit.domain.Address;
import org.springframework.stereotype.Repository;

/**
 * Created by Phillip on 6/19/2016.
 */
@Repository("AddressDao")
public class AddressDaoImpl extends AbstractBaseDao<Address> implements AddressDao {

}
