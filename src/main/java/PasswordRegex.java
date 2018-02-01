import java.util.Arrays;
import java.util.List;

public class PasswordRegex {
    public static void main(String[] args) {

        /**
         * ^               # start-of-regex
         (?=.*[0-9])       # a digit must occur at least once
         (?=.*[a-z])       # a lower case letter must occur at least once
         (?=.*[A-Z])       # an upper case letter must occur at least once
         (?=.*[@#$%^&+=]*) # a special character possible, not mandatory
         (?=\S+$)          # no whitespace allowed in the entire string
         .{8,}             # anything, at least eight places though
         $                 # end-of-regex
         */
        final String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]*)(?=\\S+$).{8,}$";

        final String password = "Qq7777777";

        System.out.println(password.matches(passwordRegex));


        /**
         * ^               # start-of-regex
         (?=.*[0-9])       # a digit must occur at least once
         (?=.*[a-z])       # a lower case letter must occur at least once
         (?=.*[A-Z])       # an upper case letter must occur at least once
         (?=.*[@#$%^&+=])  # a special character must occur at least once
         (?=\S+$)          # no whitespace allowed in the entire string
         .{8,}             # anything, at least eight places though
         $                 # end-of-regex
         */
        final String passwordRegex2 = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        System.out.println(password.matches(passwordRegex2));

        /**
         * Bank requirements
         * ^               # start-of-REGEX
         (?=.*[0-9])       # a digit must occur at least once
         (?=.*[a-z])       # a lower case letter must occur at least once
         (?=.*[A-Z])       # an upper case letter must occur at least once
         (?=.*[@#$%^&+=])  # a special character must occur at least once
         (?=\S+$)          # no whitespace allowed in the entire string
         .{8,}             # anything, at least eight places though
         $                 # end-of-REGEX
         */
        final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\\\!\"#$%&\'()*+,-./:;<=>?@\\[\\]|^_`{}~])(?=\\S+$).{8,}$";

        final List<String> correctPasswords = Arrays.asList("", "       ", "4444", "77777777", "qqqqqqqq", "QQQQQQQQ", "Qw777777",
                "_-++++++++", "!qqqqqqq", "!QQQQQQQ", "Qw_ 77777");

        correctPasswords.stream()
                .forEach(correctPassword -> {
                            System.out.println(correctPassword + ": " + !correctPassword.matches(PASSWORD_REGEX));
//                            Assert.assertEquals(true, !correctPassword.matches(PASSWORD_REGEX));
                        }
                );
    }
}
