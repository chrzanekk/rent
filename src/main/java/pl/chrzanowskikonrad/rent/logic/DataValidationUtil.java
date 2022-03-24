package pl.chrzanowskikonrad.rent.logic;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DataValidationUtil {

    public static void validateTextField(String textField, String fieldName) {
        if (textField == null || textField.equals("")) {
            throw new IllegalArgumentException(prepareMessageForEmpty(fieldName));
        }
    }

    public static void validateValue(Long value, String fieldName) {
        if (value == null) {
            throw new IllegalArgumentException(prepareMessageForEmpty(fieldName));
        }
        if (value < 0) {
            throw new IllegalArgumentException(prepareMessageForNegativeValue(fieldName));
        }
    }

    public static void validateValue(Float value, String fieldName) {
        if (value == null) {
            throw new IllegalArgumentException(prepareMessageForEmpty(fieldName));
        }
        if (value < 0) {
            throw new IllegalArgumentException(prepareMessageForNegativeValue(fieldName));
        }
    }
    public static void validateValue(BigDecimal value, String fieldName) {
        if (value == null) {
            throw new IllegalArgumentException(prepareMessageForEmpty(fieldName));
        }
        if (isUnitPricePositive(value)) {
            throw new IllegalArgumentException(prepareMessageForNegativeValue(fieldName));
        }
    }

    public static void validateDate(LocalDate dateTime, String fieldName){
        if (dateTime == null){
            throw new IllegalArgumentException(prepareMessageForEmpty(fieldName));
        }
        if(dateTime.isBefore(LocalDate.now())){
            throw new IllegalArgumentException(prepareMessageForDateBeforeActualDate(dateTime));
        }
    }

    public static boolean isUnitPricePositive(BigDecimal unitPrice) {
        return unitPrice.compareTo(BigDecimal.ZERO) < 0;
    }

    public static void validateDescription(String description, String fieldName) {
        if (description == null) {
            throw  new IllegalArgumentException(prepareMessageForEmpty(fieldName));
        }
        if (description.length() < 5){
            throw new IllegalArgumentException(prepareMessageForToShortDesctiption(fieldName));
        }
    }


    private static String prepareMessageForEmpty(String fieldName) {
        return "Pole \" " + fieldName + " \" nie może być puste.";
    }

    private static String prepareMessageForNegativeValue(String fieldName) {
        return "Pole \" " + fieldName + " \" nie może mieć wartości ujemnej.";
    }

    private static String prepareMessageForToShortDesctiption(String fieldName) {
        return "Pole \" " + fieldName + " \" musi mieć minimum 5 znaków.";
    }

    private static String prepareMessageForDateBeforeActualDate(LocalDate localDate) {
        return "Data " + localDate + " nie może być wcześniejsza niż " + LocalDate.now();
    }
}
