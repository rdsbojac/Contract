package services;

public interface OnlinePaymentService {

    double paymentFee(double amount); // Assinatura do metodo que a classe que a implementar obrigatoriamente tem que ter
                                      // Recebe quantidade de parcelas

    double interest(double amount, int months); // Recebe quantidade de parcelas e quantidade de meses
}
