package pl.sidor.exception;

import lombok.Getter;

@Getter
public enum MessageException {

    INCORRECT_LOGIN_DATA("1", "Nieprawidłowy email lub hasło!"),
    REQUIRED_LOGIN_DATA("2", "Wymagany email i hasło!");

    private final String code;
    private final String message;

    MessageException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
