package pl.sidor.exception;

import lombok.Getter;

@Getter
public enum MessageException {

    INCORRECT_LOGIN_DATA("1", "Podany login i/lub hasło są nieprawidłowe."),
    REQUIRED_LOGIN_DATA("2", "Wymagany email i hasło!"),
    PASSWORD_ENCRYPTION_ERROR("3", "Błąd przy szyfrowaniu hasła.");

    private final String code;
    private final String message;

    MessageException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
