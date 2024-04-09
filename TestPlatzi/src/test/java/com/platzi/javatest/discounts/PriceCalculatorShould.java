package com.platzi.javatest.discounts;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriceCalculatorShould {


    @Test
    public void total_zero_cuando_no_hay_precios() {
        PriceCalculator calculator = new PriceCalculator();

        assertThat(calculator.getTotal(), CoreMatchers.is(0.0));
    }

    @Test
    public void total_suma_de_precios() {
        PriceCalculator calculator = new PriceCalculator();
        calculator.addPrice(10.2);
        calculator.addPrice(15.5);

        assertThat(calculator.getTotal(), CoreMatchers.is(25.7));
    }

    @Test
    public void aplicar_descuento() {
        PriceCalculator calculator = new PriceCalculator();
        calculator.addPrice(100.0);
        calculator.addPrice(50.0);
        calculator.addPrice(50.0);
        calculator.setDescuento(25);
        assertThat(calculator.getTotal(), CoreMatchers.is( 150.0));
    }
}