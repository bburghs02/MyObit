package com.myobit.test.util;

import com.myobit.util.DateUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Phillip on 5/21/2016.
 */
public class DateUtilsTest {

    @Test
    public void testDateUtilsShort() {
        assertEquals("Someone changed the short date format","yyyy-MM-dd", DateUtils.SHORT_DATE_FORMAT);
    }
}
