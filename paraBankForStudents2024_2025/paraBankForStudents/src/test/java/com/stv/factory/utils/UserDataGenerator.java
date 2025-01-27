package com.stv.factory.utils;

import java.util.Random;

public class UserDataGenerator {

    private static final Random random = new Random();
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String generateUsername(int length) {
        StringBuilder username = new StringBuilder();
        for (int i = 0; i < length; i++) {
            username.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return username.toString();
    }
    public static String generateUserPassword() {
        StringBuilder userPassword = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            userPassword.append(random.nextInt(10));
        }
        return userPassword.toString();
    }

    public static String generatePhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }

    public static String generateName(int length) {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < length; i++) {
            name.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return name.toString();
    }

    public static String generateSurname(int length) {
        return generateName(length);
    }

    public static String generateZipCode() {
        StringBuilder zipCode = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            zipCode.append(random.nextInt(10));
        }
        return zipCode.toString();
    }

    public static String generateSSN() {
        return String.format("%03d-%02d-%04d",
                random.nextInt(1000),
                random.nextInt(100),
                random.nextInt(10000));
    }

    public static String generateState() {
        return "" + ALPHABET.charAt(random.nextInt(ALPHABET.length())) +
                ALPHABET.charAt(random.nextInt(ALPHABET.length()));
    }

    public static String generateAddress() {
        StringBuilder streetName = new StringBuilder();
        int streetLength = random.nextInt(5) + 5;
        for (int i = 0; i < streetLength; i++) {
            streetName.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        int number1 = random.nextInt(90) + 10;
        int number2 = random.nextInt(90) + 10;
        return String.format("%s %d, %d", streetName, number1, number2);
    }

    public static void main(String[] args) {
        System.out.println("Username: " + generateUsername(12));
        System.out.println("Password: " + generateUserPassword());
        System.out.println("Phone Number: " + generatePhoneNumber());
        System.out.println("Name: " + generateName(8));
        System.out.println("Surname: " + generateSurname(10));
        System.out.println("ZIP Code: " + generateZipCode());
        System.out.println("SSN: " + generateSSN());
        System.out.println("State: " + generateState());
        System.out.println("Address: " + generateAddress());
    }
}
