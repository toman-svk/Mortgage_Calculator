import java.text.NumberFormat;
import java.util.Currency;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        Scanner scanner = new Scanner(System.in);
        Currency usd = Currency.getInstance("USD");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        currencyFormat.setCurrency(usd);

        System.out.print("Principal ($): ");
        float principal = scanner.nextFloat();

        System.out.print("Annual Interest Rate (%): ");
        float annualInterestRate = scanner.nextFloat();

        System.out.print("Period (Years): ");
        byte period = scanner.nextByte();

        float r = annualInterestRate / PERCENT;
        float mocnitel = (float) Math.pow(1+r,period);
        float mortgage = principal * (r * mocnitel) / (mocnitel - 1);

        String mortgageFormatted = currencyFormat.format(mortgage);
        String monthlyMortgageFormatted = currencyFormat.format(mortgage/MONTHS_IN_YEAR);
        String totalAmountPaidFormatted = currencyFormat.format(mortgage*period);

        System.out.println(" ");
        System.out.println("Annual mortgage payments will be " + mortgageFormatted + ".");
        System.out.println("Monthly mortgage payments will be " + monthlyMortgageFormatted + ".");
        System.out.println("Total paid amount will be " + totalAmountPaidFormatted + ".");

    }
}