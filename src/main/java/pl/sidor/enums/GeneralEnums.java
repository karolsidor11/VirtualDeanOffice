package pl.sidor.enums;

import lombok.Getter;

@Getter
public enum GeneralEnums {

    EMPTY_STRING(" "),
    NOMEN_NESCIO("NOMEN  NESCIO");

    private final String value;

    GeneralEnums(String value) {
        this.value = value;
    }
}
