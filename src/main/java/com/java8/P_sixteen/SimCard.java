package com.java8.P_sixteen;

import java.util.Objects;

public class SimCard {

    int customerId;
    String simStartDate;
    String simEndDate;
    String operator;
    String company;
    String plan;
    String mobileNumber; // 10-digit mobile number
    int price; // Price in INR

    public SimCard(int customerId, String simStartDate, String simEndDate, String operator, String company, String plan, String mobileNumber, int price) {
        this.customerId = customerId;
        this.simStartDate = simStartDate;
        this.simEndDate = simEndDate;
        this.operator = operator;
        this.company = company;
        this.plan = plan;
        this.mobileNumber = mobileNumber;
        this.price = this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimCard)) return false;
        SimCard simCard = (SimCard) o;
        return Objects.equals(mobileNumber, simCard.mobileNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobileNumber);
    }

    @Override
    public String toString() {
        return "SimCard{" +
                "customerId=" + customerId +
                ", simStartDate='" + simStartDate + '\'' +
                ", simEndDate='" + simEndDate + '\'' +
                ", operator='" + operator + '\'' +
                ", company='" + company + '\'' +
                ", plan='" + plan + '\'' +
                ", price=₹" + price +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
