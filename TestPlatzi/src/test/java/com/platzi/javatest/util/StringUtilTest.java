package com.platzi.javatest.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {
    @Test
   public void Repetir_una_vez() {
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3) );
    }

    @Test
    public void Repetir_varias_veces() {
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1) );
    }


    @Test
    public void Repetir_cero_veces() {
        Assert.assertEquals("", StringUtil.repeat("hola", 0) );
    }

}