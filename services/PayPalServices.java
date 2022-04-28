package services;

public class PayPalServices implements OnlinePaymentService{

    private static final double PAYMENT_FEE = 0.02;      // Taxa de juros de 2%
    private static final double MONTHLY_INTEREST = 0.01; // Taxa de juro do payPal 1%

    @Override
    public double paymentFee(double amount) {
        return amount * PAYMENT_FEE;
    }

    @Override
    public double interest(double amount, int months) {
        return amount * months * MONTHLY_INTEREST; // Valor da parcela X qnt de meses X juros do paypal
    }
}
