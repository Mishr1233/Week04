package org.example.regex.validate_creditcard;
import java.util.regex.*;

public class validateCreditCardNumber{
    public static void main(String[] args) {
        String[] cardNumbers = {
                "4111111111111111",
                "5111111111111111",
                "411111111111111",
                "51111111111111111"
        };

        //Regex pattern for Visa or MasterCard
        String regex = "^4\\d{15}$|^5\\d{15}$";

        //Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        //Check each card number
        for (String card : cardNumbers) {
            Matcher matcher = pattern.matcher(card);
            if (matcher.matches()) {
                System.out.println(card + " is a valid credit card number.");
            } else {
                System.out.println(card + " is not a valid credit card number.");
            }
        }
    }
}
