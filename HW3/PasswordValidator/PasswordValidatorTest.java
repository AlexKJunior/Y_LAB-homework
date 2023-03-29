package HW3.PasswordValidator;

public class PasswordValidatorTest {
    public static void main(String[] args) {
        try {
            System.out.println(PasswordValidator.validate("12345678912345678901234",
                    "1234567890123456789012355", "1234567890123456789012355"));
            System.out.println(PasswordValidator.validate("rtmrtm", "45vwerr", "mar6ghf"));
            System.out.println(PasswordValidator.validate("ratata", "12345ert", "12345ert"));
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
        }
    }
}
