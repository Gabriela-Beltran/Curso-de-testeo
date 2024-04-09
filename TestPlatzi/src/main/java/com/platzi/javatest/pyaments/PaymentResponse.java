package com.platzi.javatest.pyaments;

public class PaymentResponse {
    public PaymentResponse(PaymentStatus status) {
        this.status = status;
    }

    enum PaymentStatus{
        OK, ERROR
    }

    public PaymentStatus getStatus() {
        return status;
    }

    private PaymentStatus status;


}
