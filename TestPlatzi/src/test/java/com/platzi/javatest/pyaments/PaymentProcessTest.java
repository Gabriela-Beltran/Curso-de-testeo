package com.platzi.javatest.pyaments;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
public class PaymentProcessTest {
    private  PaymentGetaway paymentGetaway;
    private PaymentProcess paymentProcess;
    @Before
    public void setup(){
         paymentGetaway = Mockito.mock(PaymentGetaway.class);
         paymentProcess = new PaymentProcess(paymentGetaway);
    }


    @Test
    public void payment_correct() {
       Mockito.when(paymentGetaway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
        assertTrue(paymentProcess.makePayment(1000));
    }


    @Test
    public void payment_incorrect() {
        Mockito.when(paymentGetaway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));
        assertFalse(paymentProcess.makePayment(1000));
    }
}