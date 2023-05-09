package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.DBHelper;
import ru.netology.data.DataHelper;
import ru.netology.util.CommonConsts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataHelper.errorNotificationWhilePayingWithDeclinedCard;
import static ru.netology.data.RestHelper.postRequest;
import static ru.netology.util.CommonConsts.APPROVED;
import static ru.netology.util.CommonConsts.DECLINED;


public class RestAPITest {
    private static final String PAY_PATH = "/pay";
    private static final String CREDIT_PATH = "/credit";

    @Test
    public void getSuccessResponseIfPayWithApprovedStatusCard() {
        postRequest(DataHelper.successPaymentWithApprovedCard(), PAY_PATH).statusCode(200);
        assertEquals(APPROVED, DBHelper.getCreditPaymentStatus());
    }

    @Test
    public void getErrorResponseIfPayWithDeclinedStatusCard() {
        postRequest(errorNotificationWhilePayingWithDeclinedCard(), PAY_PATH).statusCode(400);
        assertEquals(DECLINED, DBHelper.getCreditPaymentStatus());
    }

    @Test
    public void getSuccessResponseIfPayWithApprovedStatusCreditCard() {
        postRequest(DataHelper.successPaymentWithApprovedCard(), CREDIT_PATH).statusCode(200);
        assertEquals(APPROVED, DBHelper.getCreditPaymentStatus());

    }

    @Test

    public void getErrorResponseIfPayWithDeclinedStatusCreditCard() {
        postRequest(errorNotificationWhilePayingWithDeclinedCard(), CREDIT_PATH).statusCode(400);
        assertEquals(DECLINED, DBHelper.getCreditPaymentStatus());
    }

}

