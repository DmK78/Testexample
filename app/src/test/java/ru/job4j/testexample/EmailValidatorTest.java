package ru.job4j.testexample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailValidatorTest {
    private Validator<String> validator;

    @Before
    public void bebore(){
        validator=new EmailValidator();
    }

    @Test
    public void whenEmailNotValid() {
        String email = "";
        assertEquals(validator.validate(email),false);
    }

    @Test
    public void whenEmailIsValid() {
        String email = "dmk78@inbox.ru";
        assertEquals(validator.validate(email),true);
    }
}