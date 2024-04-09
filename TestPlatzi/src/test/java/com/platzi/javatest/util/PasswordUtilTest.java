package com.platzi.javatest.util;

import org.junit.Test;

import static com.platzi.javatest.util.PasswordUtil.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void weak_menos_de_8_letras() {
        assertEquals(SecurityLevel.WEAK, assessPassword("1234567"));
    }

    @Test
    public void weak_solo_letras() {
        assertEquals(SecurityLevel.WEAK, assessPassword("abcdfgh"));
    }

    @Test
    public void medio_con_letrasynum() {
        assertEquals(SecurityLevel.MEDIUM, assessPassword("abcd1234"));
    }

    @Test
    public void fuerte_letras_num_simbol() {
        assertEquals(SecurityLevel.STRONG, assessPassword("abcd1234!"));
    }
}