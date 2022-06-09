package br.com.martins.jean.api.communication.enumerators;

public enum MessageErrorEnum {

    COMMUNICATION_NOT_FOUND("404.001", "Communication not found.");


    private final String code;
    private final String description;

    private MessageErrorEnum(String code, String description) {
        this.code= code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
