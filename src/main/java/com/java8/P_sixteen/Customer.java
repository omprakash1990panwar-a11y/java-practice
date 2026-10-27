package com.java8.P_sixteen;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {

    int id;
    String name;
    String aadharCardNo; // Aadhaar in format XXXX-XXXX-XXXX
    String address;
    List<SimCard> simCards;

    public Customer(int id, String name, String aadharCardNo, String address) {
        this.id = id;
        this.name = name;
        this.aadharCardNo = aadharCardNo;
        this.address = address;
        this.simCards = new ArrayList<>();
    }

    public void addSimCard(SimCard simCard) {
        this.simCards.add(simCard);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(aadharCardNo, customer.aadharCardNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aadharCardNo);
    }

    @Override
    public String toString() {
        return "\nCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", aadharCardNo='" + aadharCardNo + '\'' +
                ", address='" + address + '\'' +
                ", simCards=" + simCards +
                '}';
    }
}
