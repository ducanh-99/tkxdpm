package test.paymentTest;

import org.junit.Test;
import returnbike.payment.CheckAccountParams;

import static org.junit.Assert.*;

public class PaymentWhiteBoxTest {
    CheckAccountParams checkAccount = new CheckAccountParams();

    @Test
    public void checkAccountBank() {
        assertTrue("Fail testcase 1", checkAccount.checkPaymentParams("Nam Pham", "02342374"));
        assertFalse("Fail testcase 2", checkAccount.checkPaymentParams("Nam @", "02342374"));
    }
}
