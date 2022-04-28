package application;

import entities.Contract;
import entities.Installments;
import services.ContractService;
import services.OnlinePaymentService;
import services.PayPalServices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {
        //OnlinePaymentService ops = new PayPalServices();
        // passando como argumento deste objeto o objeto que acabou de ser instanciado(injecao de dependecia)
        // Entao neste momento o PROGRAM main esta sendo responsavel por instanciar e nao a classe ContratService
        // O controle foi invertido
        //ContractService cs = new ContractService(ops);

        SimpleDateFormat simpledf = new SimpleDateFormat("dd/MM/yyyy");

        // Ler ponto ao inves da virgula, sempre antes do scanner
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter contract data");
        System.out.print("Number: ");
        Integer number = scanner.nextInt() ;
        System.out.println("Date (dd/MM/yyyy)");
        Date date = simpledf.parse(scanner.next());
        System.out.print("Contract Value: ");
        double amount = scanner.nextDouble();

        // Instanciando Contract passando como argumentos, numero, data e valor do emprestimo
        Contract contract = new Contract(number, date, amount);

        System.out.print("Enter Number of Installments: ");
        int qntParcelas = scanner.nextInt();

        // Instaciando o ContractService que realizara o calculo e passando como argumento
        // Um objeto do tipo ContractService instanciando o objeto PayPalServices.
        ContractService novoContrato = new ContractService(new PayPalServices());
        novoContrato.processContract(contract, qntParcelas);

        System.out.println("Installments: ");
        for(Installments parcelas : contract.getInstallments()){
            System.out.println(parcelas);
        }

        scanner.close();

    }

}
