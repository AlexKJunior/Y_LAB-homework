package HW3.PasswordValidator;

public class PasswordValidator {
    public static boolean validate(String login, String password, String confirmPassword) throws WrongLoginException,
            WrongPasswordException {

        try {
            if (!login.matches("^[a-zA-Z0-9_]+$")) {
                throw new WrongLoginException("Логин содержит недопустимые символы");
            }
            if (login.length() > 20) {
                throw new WrongLoginException("Логин слишком длинный");
            }
            if (!password.matches("^[a-zA-Z0-9_]+$")) {
                throw new WrongPasswordException("Пароль содержит недопустимые символы");
            }
            if (password.length() > 20) {
                throw new WrongPasswordException("Пароль слишком длинный");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}