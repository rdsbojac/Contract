package services;

import entities.Contract;
import entities.Installments;

import java.util.Calendar;
import java.util.Date;

// Neste programa sera usada e inversao de controle, ou seja, a classe ContractService não sera responsavel
// por qual instancia ela ira precisar executar.(A PROPRIA CLASSE NAO CONTROLA SUA PROPRIA DEPENDENCIA ESPECIFICA)
public class ContractService {

    // Instanciando variavel com o mesmo tipo da interface
    private OnlinePaymentService onlinepaymentService;

    // Construtor recebe o tipo OnlinePaymentService
    public ContractService(OnlinePaymentService onlinepaymentService){
        //this(esse atributo aqui se refere ao atributo privado da classe e recebe o objeto que foi passada no construtor)
        this.onlinepaymentService = onlinepaymentService;
    }

    // Este metodo instancia x classes Contract de acordo com o numero de months passados como argumento
    // Ex: Se contract.getTotalValues = 1000 e months = 10 o basicQuota sera 100 reais
    // que é a divisao do getTotalValues pela quantidade de meses
    // no primeiro laço o basicQuota = 100 + onlinepaymentSerive.interest(Juros)(100,1)
    // interest multiplica basicQuota * 1(1 mes) * 0.01 = 102
    public void processContract(Contract contract, int months){
        double basicQuota = contract.getTotalValues() / months;
        for(int i=0 ; i < months; i++){
            double updatedQuota = basicQuota + onlinepaymentService.interest(basicQuota, i);
            double totalQuota = updatedQuota + onlinepaymentService.paymentFee(updatedQuota);
            // a cada laço aponta para a nova data de vencimento
            Date dueDate = addMonths(contract.getDate(), i+1);
            // Adiciona na lista de contratos uma nova instancia do Objeto Intallments com a data da parcela e o valor
            contract.getInstallments().add(new Installments(dueDate, totalQuota));
        }
    }

    // Funcao auxiliar para setar a data
    private Date addMonths(Date date, int qntMonths){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, qntMonths);
        return calendar.getTime();

    }

}
