package ru.job4j.testexample;

import java.util.regex.Pattern;

public class EmailValidator implements Validator {
    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );
    @Override
    public boolean validate(Object value) {
        return EMAIL_ADDRESS_PATTERN.matcher(value.toString()).matches();
    }
}
