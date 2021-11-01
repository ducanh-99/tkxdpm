package returnbike.payment;

public class CheckAccountParams {

    public CheckAccountParams() {
    }

    public boolean checkPaymentParams(String ownerName, String accountNumber) {
        boolean flag = false;
        if (ownerName.matches("^[a-zA-z ]*$") && accountNumber.matches("\\d+")) flag = true;
        return flag;
    }
}
