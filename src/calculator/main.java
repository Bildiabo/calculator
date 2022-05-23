package calculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        int principal;
        float monthlyInterest;
        int numberOfPayments;
        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1_000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1k to 1m $");
        }
        while (true) {
            System.out.print("Annual Interest Rate:");
            float annualInterest = scanner.nextFloat();
            monthlyInterest = (annualInterest / PERCENT) / MONTHS_IN_YEAR;
            if (annualInterest > 0 && annualInterest <= 30)
                break;
            System.out.println("enter a valid number bitch bigger than 0 to 30");
        }
        while (true) {
            System.out.print("period (Years): ");
            byte years = scanner.nextByte();
            numberOfPayments = years * MONTHS_IN_YEAR;
            if (years >=1 && years<=30)
                break;
            System.out.println("enter a valid number between 1 to 30");
        }
        double mortagage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) /
                (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        String mortageFormatted = NumberFormat.getCurrencyInstance().format(mortagage);
        System.out.println("Mortagage:" + mortageFormatted);
    }


}