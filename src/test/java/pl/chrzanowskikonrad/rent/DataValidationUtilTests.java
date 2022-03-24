package pl.chrzanowskikonrad.rent;

import org.junit.Test;
import pl.chrzanowskikonrad.rent.logic.DataValidationUtil;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DataValidationUtilTests {

    @Test(expected = IllegalArgumentException.class)
    public void validateBigDecimalValue() {
        BigDecimal value = new BigDecimal("-500.00");

        DataValidationUtil.validateValue(value, "test field");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateBigDecimalValueWhenValueIsNull() {

        DataValidationUtil.validateValue((BigDecimal) null, "test field 2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateTextFieldAsEmptyString() {
        String value = "";

        DataValidationUtil.validateTextField(value, "test field");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateTextFieldAsNull() {

        DataValidationUtil.validateTextField(null, "test field");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateDescriptionAsStringShorterThanFive() {

        String description = "aaaa";

        DataValidationUtil.validateDescription(description, "test field");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateDescriptionAsEmptyString() {

        String description = "";

        DataValidationUtil.validateDescription(description, "test field");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateDescriptionWhenDescriptionIsNull() {

        DataValidationUtil.validateDescription(null, "test field");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateDateWhenDateIsBeforeToday() {

        LocalDate date = LocalDate.of(2022, 2, 28);

        DataValidationUtil.validateDate(date, "test field");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateDateWhenDateIsNull() {

        DataValidationUtil.validateDate(null, "test field");
    }


}
