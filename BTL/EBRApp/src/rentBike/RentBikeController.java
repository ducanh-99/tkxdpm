package rentBike;

import api.EBRApi;
import returnbike.payment.IPaymentController;
import returnbike.payment.PaymentDialog;


public class RentBikeController implements IPaymentController {

    private QRCodeDialog dialog;
    private RentBikeDialog rentBikeDialog;
    private PaymentDialog bankDialog;
    private NoticeDialog noticeDialog;
    private RentBikeEntity rentBikeEntity;

    public RentBikeController() {
        dialog = new QRCodeDialog(this);
        rentBikeDialog = new RentBikeDialog(this);
        noticeDialog = new NoticeDialog();
        rentBikeEntity = new RentBikeEntity();
    }

    public void showBarcodeDialog() {
        dialog.setVisible(true);
    }

    public void shutDownQRCodePane(QRCodeDialog pane) {
        pane.setVisible(false);
    }

    public void showRentBikePane(RentBikeEntity rentBikeEntity) {
        if (rentBikeEntity.getId()!=null && rentBikeEntity.getId().length()!=0) {
            rentBikeDialog.getIdBikeField().setText(rentBikeEntity.getId() + "");
            rentBikeDialog.getTypeBikeField().setText(rentBikeEntity.getType());
            rentBikeDialog.getDepositBikeField().setText(rentBikeEntity.getDeposit()+"");
            rentBikeDialog.getRentBikeParkID().setText(rentBikeEntity.getIdStation() + "");

            rentBikeDialog.setVisible(true);
        } else {
            noticeDialog.setVisible(true);
        }
    }

    public void showBankDialog() {
        bankDialog = new PaymentDialog(this);
    }

    public RentBikeEntity getRentBikeEntity(String idBike) {
        RentBikeEntity rentBikeEntity = new EBRApi().getRentBike(idBike);
        return rentBikeEntity;
    }

    //Làm tiếp ở đây


    public RentBikeEntity getRentBikeEntity() {
        return rentBikeEntity;
    }

    public void setRentBikeEntity(RentBikeEntity rentBikeEntity) {
        this.rentBikeEntity = rentBikeEntity;
    }

    @Override
    public boolean pay(String accountNumber) {
        Boolean flag = new EBRApi().payRentBike(rentBikeEntity, accountNumber);
        System.out.println("thanh toán thuê xe là : " +flag);
        System.out.println(rentBikeEntity.toString()+"-"+accountNumber);
        if (flag == false){
            noticeDialog.setVisible(true);
        }
        return flag;

    }
}
