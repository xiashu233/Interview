package com.facetest.demo.RabbitMq;

public enum BusinessMessageEnum {
    work("work"),
    topic("topic");

    private String ququer;

    public String getQuquer() {
        return ququer;
    }

    public void setQuquer(String ququer) {
        this.ququer = ququer;
    }

    BusinessMessageEnum(String ququer) {
        this.ququer = ququer;
    }
}
