import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int principal = (int) readNumber("Principal (1,000 - 1,000,000): ",1_000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual Interest Rate (0 - 1): ", 0, 1);
        byte years = (byte) readNumber("Number of years (1 - 30): ", 1, 30);

        calculateMortgage(principal, annualInterestRate, years);

    }

    public static double readNumber(
            String prompt,
            double min,
            double max) {

        Scanner scanner = new Scanner(System.in);
        double scannedValue;

        while (true) {

            System.out.println(prompt);
            scannedValue = scanner.nextDouble();
            if (scannedValue >= min && scannedValue <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max + "!");
        }
        return scannedValue;
    }

    public static void calculateMortgage(
            int principal,
            float annualInterest,
            byte years) {

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        final byte MONTHS_IN_YEAR = 12;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest / MONTHS_IN_YEAR;

        System.out.println("Number of payments " + numberOfPayments);
        System.out.println("Monthly interest rate " + monthlyInterest);

        double mortgagePayment = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments)-1));

        String formattedMortgagePayment = decimalFormat.format(mortgagePayment);

        System.out.println(" ");
        System.out.println("Monthly mortgage payment will be " + formattedMortgagePayment + "$.");
        System.out.println("----------------------------------------");
        System.out.println("Payment calendar:");
        System.out.println("----------------------------------------");

        for (int i = 0; i <= numberOfPayments; i++) {

            double totalLoanAmount = mortgagePayment * (numberOfPayments - i);
            double totalAmountPaid = mortgagePayment * i;

            String formattedTotalLoanAmount = decimalFormat.format(totalLoanAmount);
            String formattedTotalAmountPaid = decimalFormat.format(totalAmountPaid);

            System.out.println(formattedTotalLoanAmount + " | " + formattedTotalAmountPaid);
        }
    }
}