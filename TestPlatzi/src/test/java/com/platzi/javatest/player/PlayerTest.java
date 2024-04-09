package com.platzi.javatest.player;
import org.mockito.Mockito;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void pierde_cuando_dadochico() {
        Dice dice= Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(2);
        Player player= new Player(dice, 3);
        assertFalse(player.play());
    }


    @Test
    public void gana_cuando_esgrande() {
        Dice dice= Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(4);
        Player player= new Player(dice, 3);
        assertTrue(player.play());
    }
}