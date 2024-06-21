package hu.dss.util;

import java.util.Arrays;

public enum Separator {
    PIPE("p", "|", "\\|"),
    SEMICOLON("s", ";", "\\;");

    private final String separatorCode;
    private final String separatorString;
    private final String separatorRegex;

    Separator(String separatorCode, String separatorString, String separatorRegex) {
        this.separatorCode = separatorCode;
        this.separatorString = separatorString;
        this.separatorRegex = separatorRegex;
    }

    public static Separator getSeparatorByCode(String separatorCode) {
        return Arrays.stream(values())
                .filter(separator -> separator.separatorCode.equals(separatorCode.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    public String getSeparatorString() {
        return separatorString;
    }

    public String getSeparatorRegex() {
        return separatorRegex;
    }

}
