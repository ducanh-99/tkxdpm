package test.paymentTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ PaymentBlackBoxTest.class, PaymentWhiteBoxTest.class })
public class PaymentSuiteTest {
}
