package com.java8.P_sixteen;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestSteamFilterAndMap {

    static String[] names = {
            "Rahul Sharma", "Priya Verma", "Amit Patel", "Sneha Singh", "Ravi Kumar",
            "Pooja Joshi", "Ankit Mehta", "Neha Reddy", "Karan Malhotra", "Divya Gupta"
    };

    static String[] addresses = {
            "123 MG Road, Mumbai", "45 Lajpat Nagar, Delhi", "678 Sector 21, Chandigarh",
            "Plot 34, Anna Nagar, Chennai", "12 Banjara Hills, Hyderabad",
            "56 Park Street, Kolkata", "7 HSR Layout, Bangalore", "88 Lalghati, Bhopal",
            "23 Civil Lines, Jaipur", "91 Ambawadi, Ahmedabad"
    };

    static String[] operators = {"Airtel", "Jio", "Vodafone", "BSNL"};
    static String[] plans = {"1 Month Plan", "3 Month Plan", "6 Month Plan", "1 Year Plan"};
    static int[] prices = {100, 199, 299, 499, 1200, 2000};

    static Random random = new Random();

    // Aadhaar Generator
    private static String generateAadharNumber(int seed) {
        String digits = String.format("%012d", 159800000000L + seed * 987);
        return digits.replaceAll("(\\d{4})(\\d{4})(\\d{4})", "$1-$2-$3");
    }

    // Mobile number generator
    private static String generateMobileNumber(int seed, int simIndex) {
        int prefix = 9 - (simIndex % 3); // 9, 8, 7
        return prefix + String.format("%09d", seed * 1000 + simIndex * 23);
    }

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            Customer customer = new Customer(i + 1,names[i],generateAadharNumber(i),addresses[i]);

            int simCount = random.nextInt(5) + 1; // 1 to 5 SIMs
            for (int j = 1; j <= simCount; j++) {
                String operator = operators[random.nextInt(operators.length)];
                String plan = plans[random.nextInt(plans.length)];
                int price = prices[random.nextInt(prices.length)];
                String startDate = "2023-01-" + String.format("%02d", j);
                String endDate = "2024-01-" + String.format("%02d", j);

                SimCard simCard = new SimCard(customer.id,startDate,endDate,operator,operator + " Pvt Ltd",plan,generateMobileNumber(i, j),price);
                customer.addSimCard(simCard);
            }

            customers.add(customer);
        }
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}

