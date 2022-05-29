package calculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int principal;
        float annualInterest;
        byte years;
        principal = (int) readNumber("principal; ",1_000,1_000_000);
        annualInterest=(float)readNumber("Annual Interest Rate: ",1,30);
        years=(byte)readNumber("period (Years): ",1,30);
        double mortgage = calculateMortgage(principal, annualInterest, years);
    }
    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
    while (true) {
        System.out.print(prompt);
        value = scanner.nextInt();
        if (value >= min && value <= max)
            break;
        System.out.println("Enter a value between" + min + " and " +max);
    }
    return value;
    }
    public static double calculateBalance (int principal,
                                           float annualInterest,
                                           byte years, short numberOfPaymentsMade){
        double monthlyInterest = (annualInterest / PERCENT) / MONTHS_IN_YEAR;
        short numberOfPayments =(short)( years * MONTHS_IN_YEAR);
        double balance = principal *( Math.pow(1+monthlyInterest, numberOfPayments)-Math.pow(1+monthlyInterest,numberOfPaymentsMade))
                /(Math.pow(1+monthlyInterest,numberOfPayments)-1);
        String balanceFormatted = NumberFormat.getCurrencyInstance().format(balance);
        System.out.print("Remaining Balance= "+balanceFormatted);
        return balance;

    }
    public static double calculateMortgage(int principal,
                                           float annualInterest,
                                           byte years){
        double monthlyInterest = (annualInterest / PERCENT) / MONTHS_IN_YEAR;
        short numberOfPayments =(short)( years * MONTHS_IN_YEAR);
        double mortagage = principal
            * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) /
            (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        String mortageFormatted = NumberFormat.getCurrencyInstance().format(mortagage);
        System.out.println("Mortagage:" + mortageFormatted);
        return mortagage;


    }


}