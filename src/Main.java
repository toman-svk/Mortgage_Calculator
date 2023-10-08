import java.text.NumberFormat;
import java.util.Currency;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Currency usd = Currency.getInstance("USD");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        currencyFormat.setCurrency(usd);

        int principal = (int) readNumber("Principal: ",1_000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual Interest Rate: ", 0, 1);
        byte years = (byte) readNumber("Number of years: ", 1, 30);

        double mortgage = calculateMortgage(principal, annualInterestRate, years);
        String mortgageFormatted = currencyFormat.format(mortgage);

        System.out.println(" ");
        System.out.println("Monthly mortgage payments will be " + mortgageFormatted + ".");

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


    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments)));

        return mortgage;

    }

}