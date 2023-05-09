package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class DataHelper {
    static final Faker faker = new Faker();
    private static final String CARD_NUMBER = "4444 4444 4444 4441";
    private static final String ZERO_CARD_NUMBER = "0000 0000 0000 0000";
    private static final String ERROR_CARD_NUMBER = "4444 4444 4444 4442";
    private static final String EMPTY_CARD_NUMBER = "";
    private static final String WRONG_DIGITS_COUNT_CARD_NUMBER = "4444 4444 4444 444";

    private static final String CVC_NUMBER = Integer.toString(faker.number().numberBetween(100, 999));
    private static final String EMPTY_CVC_NUMBER = "";
    private static final String ZERO_CVC_NUMBER = "000";
    private static final String ONE_DIGIT_CVC_NUMBER = Integer.toString(faker.number().numberBetween(0, 9));
    private static final String TWO_DIGIT_CVC_NUMBER = Integer.toString(faker.number().numberBetween(10, 99));

    private static final String OWNER = "IVAN PETROV";
    private static final String WITH_MINUS_OWNER = "IVAN PETROV-VODKIN";
    private static final String WITH_APOSTROPHE_OWNER = "IVAN D’ARTANIYAN";
    private static final String EMPTY_OWNER = "";
    private static final String CYRILLIC_OWNER = "ИВАН ПЕТРОВ";
    private static final String ONLY_DIGIT_OWNER = "932497 2343534";
    private static final String EIGHTY_CHARACTERS_OWNER = "FDGRGFBGFTHRTRHRHGYDSARTYFVGARFGTHYUIJKO FDGRGFBGFTHRTRHRHGYDSARTYFVGARFGTHYUIJK";
    private static final String ONE_CHARACTER_OWNER = "I";
    private static final String TWO_CHARACTERS_OWNER = "IV";
    private static final String MINUS_CHARACTER_OWNER = "-";

    private static final String CARD_YEAR = Integer.toString(Year.now().getValue() + 1).substring(2,4);
    private static final String EMPTY_CARD_YEAR = "";
    private static final String ZERO_CARD_YEAR = "00";
    private static final String CURRENT_CARD_YEAR = Integer.toString(Year.now().getValue()).substring(2,4);
    private static final String PREVIOUS_CARD_YEAR = Integer.toString(Year.now().getValue() - 1).substring(2,4);
    private static final String OVER_VALIDATION_CARD_YEAR = Integer.toString(Year.now().getValue() + 6).substring(2,4);


    private static final String CARD_MONTH = "09";
    private static final String EMPTY_CARD_MONTH = "";
    private static final String ZERO_CARD_MONTH = "00";
    private static final String OVER_CARD_MONTH = Integer.toString(faker.number().numberBetween(13, 99));
    private static final String CURRENT_CARD_MONTH = Integer.toString(LocalDate.now().getMonth().getValue());


    public DataHelper() {
    }


    public static CardInfo successPaymentWithApprovedCard() {
        return new CardInfo(CARD_NUMBER, CARD_MONTH, CARD_YEAR, OWNER, CVC_NUMBER);
    }

    public static CardInfo errorNotificationWhilePayingWithDeclinedCard() {
        return new CardInfo(ERROR_CARD_NUMBER, CARD_MONTH, CARD_YEAR, OWNER, CVC_NUMBER);
    }

    public static CardInfo successPaymentDoubleSurname() {
        return new CardInfo(CARD_NUMBER, CARD_MONTH, CARD_YEAR, WITH_MINUS_OWNER, CVC_NUMBER);
    }

    public static CardInfo successPaymentApostropheSurname() {
        return new CardInfo(CARD_NUMBER, CARD_MONTH, CARD_YEAR, WITH_APOSTROPHE_OWNER, CVC_NUMBER);
    }

    public static CardInfo ErrorAllFormFieldsEmpty() {
        return new CardInfo(EMPTY_CARD_NUMBER, EMPTY_CARD_MONTH, EMPTY_CARD_YEAR, EMPTY_OWNER, EMPTY_CVC_NUMBER);
    }

    public static CardInfo errorNotificationFifteenSymbolsInCardNumberField() {
        return new CardInfo(WRONG_DIGITS_COUNT_CARD_NUMBER, CARD_MONTH, CARD_YEAR, OWNER, CVC_NUMBER);
    }

    public static CardInfo errorNotificationSixteenZerosInCardNumberField() {
        return new CardInfo(ZERO_CARD_NUMBER, CARD_MONTH, CARD_YEAR, OWNER, CVC_NUMBER);
    }

    public static CardInfo errorNotificationCardNumberFieldEmpty() {
        return new CardInfo(EMPTY_CARD_NUMBER, CARD_MONTH, CARD_YEAR, OWNER, CVC_NUMBER);
    }

    public static CardInfo errorNotificationTwoZerosInMonthField() {
        return new CardInfo(CARD_NUMBER, ZERO_CARD_MONTH, CARD_YEAR, OWNER, CVC_NUMBER);
    }

    public static CardInfo errorNotificationNumberThirteenInMonthField() {
        return new CardInfo(CARD_NUMBER, OVER_CARD_MONTH, CARD_YEAR, OWNER, CVC_NUMBER);
    }

    public static CardInfo errorNotificationMonthFieldEmpty() {
        return new CardInfo(CARD_NUMBER, EMPTY_CARD_MONTH, CARD_YEAR, OWNER, CVC_NUMBER);
    }

    public static CardInfo errorNotificationTwoZerosInYearField() {
        return new CardInfo(CARD_NUMBER, CARD_MONTH, ZERO_CARD_YEAR, OWNER, CVC_NUMBER);
    }

    public static CardInfo errorNotificationNumberTwentyNineInYearField() {
        return new CardInfo(CARD_NUMBER, CARD_MONTH, OVER_VALIDATION_CARD_YEAR, OWNER, CVC_NUMBER);
    }

    public static CardInfo errorNotificationNumberTwentyTwoInYearField() {
        return new CardInfo(CARD_NUMBER, CARD_MONTH, PREVIOUS_CARD_YEAR, OWNER, CVC_NUMBER);
    }

    public static CardInfo errorNotificationIfEnterCurrentMonthAndCurrentYear() {
        return new CardInfo(CARD_NUMBER, CURRENT_CARD_MONTH, CURRENT_CARD_YEAR, OWNER, CVC_NUMBER);
    }

    public static CardInfo errorNotificationYearFieldEmpty() {
        return new CardInfo(CARD_NUMBER, CARD_MONTH, EMPTY_CARD_YEAR, OWNER, CVC_NUMBER);
    }

    public static CardInfo errorNotificationOwnerFieldEmpty() {
        return new CardInfo(CARD_NUMBER, CARD_MONTH, CARD_YEAR, EMPTY_OWNER, CVC_NUMBER);
    }

    public static CardInfo errorNotificationOneSymbolInOwnerField() {
        return new CardInfo(CARD_NUMBER, CARD_MONTH, CARD_YEAR, ONE_CHARACTER_OWNER, CVC_NUMBER);
    }

    public static CardInfo errorNotificationTwoSymbolsInOwnerField() {
        return new CardInfo(CARD_NUMBER, CARD_MONTH, CARD_YEAR, TWO_CHARACTERS_OWNER, CVC_NUMBER);
    }

    public static CardInfo errorNotificationDashSymbolInOwnerField() {
        return new CardInfo(CARD_NUMBER, CARD_MONTH, CARD_YEAR, MINUS_CHARACTER_OWNER, CVC_NUMBER);
    }

    public static CardInfo errorNotificationEightySymbolsInOwnerField() {
        return new CardInfo(CARD_NUMBER, CARD_MONTH, CARD_YEAR, EIGHTY_CHARACTERS_OWNER, CVC_NUMBER);
    }

    public static CardInfo errorNotificationNumbersInOwnerField() {
        return new CardInfo(CARD_NUMBER, CARD_MONTH, CARD_YEAR, ONLY_DIGIT_OWNER, CVC_NUMBER);
    }

    public static CardInfo errorNotificationOneSymbolInCVCField() {
        return new CardInfo(CARD_NUMBER, CARD_MONTH, CARD_YEAR, OWNER, ONE_DIGIT_CVC_NUMBER);
    }

    public static CardInfo errorNotificationTwoSymbolsInCVCField() {
        return new CardInfo(CARD_NUMBER, CARD_MONTH, CARD_YEAR, OWNER, TWO_DIGIT_CVC_NUMBER);
    }

    public static CardInfo errorNotificationThreeZerosInCVCField() {
        return new CardInfo(CARD_NUMBER, CARD_MONTH, CARD_YEAR, OWNER, ZERO_CVC_NUMBER);
    }

    public static CardInfo errorNotificationCVCFieldEmpty() {
        return new CardInfo(CARD_NUMBER, CARD_MONTH, CARD_YEAR, OWNER, EMPTY_CVC_NUMBER);
    }

    public static CardInfo errorNotificationCyrillicNameAndSurname() {
        return new CardInfo(CARD_NUMBER, CARD_MONTH, CARD_YEAR, CYRILLIC_OWNER, CVC_NUMBER);
    }
}

