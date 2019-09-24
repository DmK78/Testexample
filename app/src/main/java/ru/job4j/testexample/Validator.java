package ru.job4j.testexample;

public interface Validator<T> {
    boolean validate (T value);
}
