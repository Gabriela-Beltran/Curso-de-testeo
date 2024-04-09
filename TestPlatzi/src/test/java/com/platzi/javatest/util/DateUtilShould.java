package com.platzi.javatest.util;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateUtilShould {
    @Test
    public void verdaero_cuando_divisible_por400() {

        assertThat(DateUtil.SiesBiesiento(1600), CoreMatchers.is(true));
        assertThat(DateUtil.SiesBiesiento(2000), CoreMatchers.is(true));
        assertThat(DateUtil.SiesBiesiento(2400), CoreMatchers.is(true));
    }

    @Test
    public void falso_cuando_divisible_por100_no_por400() {
        assertThat(DateUtil.SiesBiesiento(1700), CoreMatchers.is(false));
        assertThat(DateUtil.SiesBiesiento(1800), CoreMatchers.is(false));
        assertThat(DateUtil.SiesBiesiento(1900), CoreMatchers.is(false));
    }


    @Test
    public void verdadero_cuando_divisible_por4_perono_por100() {
        assertThat(DateUtil.SiesBiesiento(1996), CoreMatchers.is(true));
        assertThat(DateUtil.SiesBiesiento(2004), CoreMatchers.is(true));
        assertThat(DateUtil.SiesBiesiento(2008), CoreMatchers.is(true));
    }

    @Test
    public void falso_cuano_no_es_divisible_por4() {
        assertThat(DateUtil.SiesBiesiento(2017), CoreMatchers.is(false));
        assertThat(DateUtil.SiesBiesiento(2019), CoreMatchers.is(false));
        assertThat(DateUtil.SiesBiesiento(2018), CoreMatchers.is(false));
    }
}