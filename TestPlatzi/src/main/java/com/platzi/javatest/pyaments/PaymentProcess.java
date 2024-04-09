package com.platzi.javatest.pyaments;

public class PaymentProcess {
    private PaymentGetaway paymentGetaway;

    public PaymentProcess(PaymentGetaway paymentGetaway) {
        this.paymentGetaway = paymentGetaway;
    }

    public boolean makePayment(double mount){
        PaymentResponse response= paymentGetaway.requestPayment(new PaymentRequest(mount));
        if(response.getStatus() == PaymentResponse.PaymentStatus.OK){
            return true;
        }else {
            return false;
        }

    }
}
