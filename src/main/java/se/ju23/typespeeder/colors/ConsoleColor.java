package se.ju23.typespeeder.colors;

public enum ConsoleColor {
    // Textfärger
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    BLUE("\u001B[34m"),
    MAGENTA("\u001B[35m"),
    CYAN("\u001B[36m"),
    BRIGHT_YELLOW("\u001B[93m"),
    BRIGHT_MAGENTA("\u001B[95m"),

    // Bakgrundsfärger

    BG_BRIGHT_CYAN("\u001B[106m"),

    // Textstilar
    BOLD("\u001B[1m");

    private final String code;

    ConsoleColor(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
    }
