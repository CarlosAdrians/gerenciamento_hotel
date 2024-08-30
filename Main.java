import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;



public class Main {
    private static ArrayList<Quarto> quartos = new ArrayList<>();
    public static void main(String[] args) throws ParseException {
        GerenciamentoQuartos hotelQuartos = new GerenciamentoQuartos();
        GerenciamentoHospedes hotelHospedes = new GerenciamentoHospedes();
        GerenciamentoReservas hotelReservas = new GerenciamentoReservas();
        GerenciamentoFuncionarios hotelFuncionarios = new GerenciamentoFuncionarios();
        Check check_in_out = new Check(hotelQuartos, hotelHospedes, hotelReservas);

        
        int opcao = 0;
        String opcaoStr;

        while (opcao != 7){
            
            opcaoStr = JOptionPane.showInputDialog("Menu \n" +
            "1. Area de quartos \n" +
            "2. Area de hospedes \n" +
            "3. Area de reserva \n" +
            "4. Area de funcionarios \n" +
            "5. Check-in \n" +
            "6. Check-out \n" +
            "7. Sair \n" +
            "Escolha uma opção: ");
            opcao = Integer.parseInt(opcaoStr);


            if (opcao == 1){
                while (opcao != 4){
                    opcaoStr = JOptionPane.showInputDialog( "Area de quartos \n" +
                    "1. Cadastrar quarto \n" +
                    "2. Atualizar status do quarto \n" +
                    "3. Vizualizar lista de quartos \n" +
                    "4. Voltar para o menu principal\n" +
                    "Escolha uma opção: ");
                    opcao = Integer.parseInt(opcaoStr);

                    if (opcao == 1){

                        String numQuartoStr = JOptionPane.showInputDialog("Digite o numero do quarto: ");
                        int numQuarto = Integer.parseInt(numQuartoStr);
                        
                        String tipoStr = JOptionPane.showInputDialog("Escolha o tipo de quarto (SOLTEIRO, CASAL, SUITE): ");
                        Tipo tipo = Tipo.valueOf(tipoStr.toUpperCase());
                       
                        String capacidadeStr = JOptionPane.showInputDialog("Digite a capacidade do quarto: ");
                        int capacidade = Integer.parseInt(capacidadeStr);
                        
                        String precoStr = JOptionPane.showInputDialog("Digite o preço do quarto: ");
                        double preco = Double.parseDouble(precoStr);

                        Quarto quarto = new Quarto(numQuarto, tipo, capacidade, preco);

                        hotelQuartos.adicionarQuarto(quarto);

                    }
                    else if (opcao == 2){
                        
                        String numQuartoStr = JOptionPane.showInputDialog("Digite o numero do quarto a ser atualizado: ");
                        int numQuarto = Integer.parseInt(numQuartoStr);

                        hotelQuartos.AtualizarstatusQuarto(numQuarto);
                    }     

                    else if (opcao == 3){

                        hotelQuartos.vizualizarLista();
                    }
                    
                    else if(opcao == 4){
                        JOptionPane.showMessageDialog(null, "Aperte OK para confirmar");
                    }

                    else {
                        JOptionPane.showMessageDialog(null, "Opçao inválida!");
                    }
                }
            }
            
            else if (opcao == 2){
                while (opcao != 4){

                    opcaoStr = JOptionPane.showInputDialog( "Area de hospedes \n" +
                    "1. Cadastrar hospede \n" +
                    "2. Vizualizar historico de estadia de um hospede \n" +
                    "3. Editar informações de um hospede \n" +
                    "4. Voltar para o menu principal\n" +
                    "Escolha uma opção: ");
                    opcao = Integer.parseInt(opcaoStr);

                    if (opcao == 1){
                        
                        String nome = JOptionPane.showInputDialog("Digite seu nome completo: ");

                        String cpfStr = JOptionPane.showInputDialog("Digite seu cpf: ");
                        int cpf = Integer.parseInt(cpfStr);

                        String dataStr = JOptionPane.showInputDialog("Digite a sua data de nascimento: " + "(dd/MM/yyyy)");
                        Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataStr);

                        String endereco = JOptionPane.showInputDialog("Digite seu endereço (RUA PADRAO, 0231: )");

                        String numeroContatoString = JOptionPane.showInputDialog("Digite o seu número de contato (83986693221): ");
                        int numeroContato = Integer.parseInt(numeroContatoString);

                        Hospede hospede = new Hospede(nome, cpf, data, endereco, numeroContato);
                        hotelHospedes.adicionarHospede(hospede);

                    }

                    else if (opcao == 2){
                        
                        String cpfStr = JOptionPane.showInputDialog("Digite seu cpf: ");
                        int cpf = Integer.parseInt(cpfStr);

                        hotelHospedes.vizualizarHistoricoEstadia(cpf);

                    }

                    else if (opcao == 3){

                        String cpfStr = JOptionPane.showInputDialog("Digite seu cpf: ");
                        int cpf = Integer.parseInt(cpfStr);

                        Hospede hospede = hotelHospedes.buscarCpfCadastrado(cpf);

                        if (hospede == null){
                            break;
                        }
                        else{ 

                            String nomeNovo = JOptionPane.showInputDialog("Digite seu novo nome: ");
                            String enderecoNovo = JOptionPane.showInputDialog("Digite o seu novo endereço (RUA PADRAO, 0231 ): ");
                            String numeroContatoNovoString = JOptionPane.showInputDialog("Digite seu novo número de contato (83986693221): ");
                            int numeroContatoNovo = Integer.parseInt(numeroContatoNovoString);
                            hotelHospedes.editarInformacoes(cpf, nomeNovo, enderecoNovo, numeroContatoNovo);
                        }
                    }
                }     
            }
            
            else if (opcao == 3){
                while (opcao != 4){
                    try {
                        opcaoStr = JOptionPane.showInputDialog( "Area de reservas \n" +
                        "1. Cadastrar reserva \n" +
                        "2. Cancelar reserva \n" +
                        "3. Verificar disponibilidade de quarto \n" +
                        "4. Voltar para o menu principal\n" +
                        "Escolha uma opção: ");
                        opcao = Integer.parseInt(opcaoStr);

                        if ( opcao == 1 ){
                        
                            String cpfStr = JOptionPane.showInputDialog("Digite o cpf do hospede cadastrado para fazer a reserva: ");
                            int cpf = Integer.parseInt(cpfStr);

                            Hospede hospede = hotelHospedes.buscarCpfCadastrado(cpf);

                            if (hospede == null){
                                break;
                            }    
                        
                        else{
                            String dataEntradaStr = JOptionPane.showInputDialog("Digite a sua data de entrada: ");
                            Date dataEntrada = new SimpleDateFormat("dd/MM/yyyy").parse(dataEntradaStr);
                            
                            String dataSairStr = JOptionPane.showInputDialog("Digite a sua data de saida: ");
                            Date dataSair = new SimpleDateFormat("dd/MM/yyyy").parse(dataSairStr);
                            
                            String tipoStr = JOptionPane.showInputDialog("Escolha o tipo de quarto (SOLTEIRO, CASAL, SUITE): ");
                            Tipo tipo = Tipo.valueOf(tipoStr.toUpperCase());
                
                            String quantidadeStr = JOptionPane.showInputDialog("Digite a quantidade de hospedes: ");
                            int quantidade = Integer.parseInt(quantidadeStr);
                            for (Quarto q : quartos) {
                                if (q.getTipo().name().equalsIgnoreCase(tipo.name()) && q.getCapacidade() >= quantidade && q.getDisponivel().equalsIgnoreCase("disponível")) {
                                    Reserva reserva = new Reserva(hospede, q, dataEntrada, dataSair, tipo, quantidade);
                                    hotelReservas.CadastrarReserva(reserva);
                                    break;
                                }
                            }
                        }
                    }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Erro ao cadastrar reserva: " + e.getMessage());
                        }
                    
                        if (opcao == 2){

                       String cpfStr = JOptionPane.showInputDialog("Digite o seu cpf: ");
                       int cpf = Integer.parseInt(cpfStr);
                       
                       String numQuartoStr = JOptionPane.showInputDialog("Digite o numero do quarto a ser cancelado: ");
                       int numQuarto = Integer.parseInt(numQuartoStr);
                       
                       Reserva reserva = hotelReservas.buscarReservaPorHospedeEQuarto(cpf, numQuarto);

                       if (reserva == null){
                           break;
                       }
                       
                       else{
                           hotelReservas.CancelarReserva(cpf, numQuarto);
                       }
                    }   
                }
            }
                    


                else if (opcao == 4){
                        
                    while (opcao != 4){
                        opcaoStr = JOptionPane.showInputDialog( "Area de funcionarios\n" +
                        "1. Cadastrar informações de funcionario \n" +
                        "2. Editar informações de funcionario \n" +
                        "3. Calcular salário \n" +
                        "4. Voltar para o menu principal \n" + 
                        "Escolha uma opção: ");
                        opcao = Integer.parseInt(opcaoStr);
                        
                        if (opcao == 1){
                            
                            String nome = JOptionPane.showInputDialog("Digite seu nome completo: ");

                            String cpfStr = JOptionPane.showInputDialog("Digite seu cpf: ");
                            int cpf = Integer.parseInt(cpfStr);

                            String cargo = JOptionPane.showInputDialog("Digite o seu cargo: ");

                            String salarioStr = JOptionPane.showInputDialog("Digite o seu salário: ");
                            double salario = Double.parseDouble(salarioStr);

                            String turno = JOptionPane.showInputDialog("Digite o turno do seu trabalho: ");

                            hotelFuncionarios.cadastrarFuncionario(nome, cpf, cargo, salario, turno);

                        }
                        else if (opcao == 2){
                           
                            String cpfStr = JOptionPane.showInputDialog("Digite o seu cpf: ");
                            int cpf = Integer.parseInt(cpfStr);

                            Funcionario funcionario = hotelFuncionarios.buscarCpfCadastrado(cpf);
                            
                            if(funcionario == null){
                                break;
                            }
                            else{

                                String nomeNovo = JOptionPane.showInputDialog("Digite o seu novo nome : ");
                                
                                String cargoNovo = JOptionPane.showInputDialog("Digite o seu novo cargo: ");
    
                                String salarioNovoStr = JOptionPane.showInputDialog("Digite o seu novo salario: ");
                                double salarioNovo = Double.parseDouble(salarioNovoStr);
    
                                String turnoNovo = JOptionPane.showInputDialog("Digite o seu novo turno de trabalho: ");
    
                                hotelFuncionarios.editarFuncionario(cpf, nomeNovo, cargoNovo, turnoNovo, salarioNovo);

                            }
                        }
                        else if (opcao == 3){

                            String cpfStr = JOptionPane.showInputDialog("Digite o seu cpf: ");
                            int cpf = Integer.parseInt(cpfStr);

                            String horasStr = JOptionPane.showInputDialog("Digite suas horas extras trabalhadas no mês: ");
                            int horas = Integer.parseInt(horasStr);

                            hotelFuncionarios.CalcularSalario(cpf, horas);

                        }
                }
            }
            else if (opcao == 5){

                while(opcao != 2){
                    opcaoStr = JOptionPane.showInputDialog( "Area de check-in \n" +
                        "1. Realizar check-in \n" +
                        "2. Voltar para o menu principal \n" + 
                        "Escolha uma opção: ");
                        opcao = Integer.parseInt(opcaoStr);

                        if (opcao == 1){
                            
                            String cpfStr = JOptionPane.showInputDialog("Digite o cpf do hospede cadastrado para fazer o check-in: ");
                            int cpf = Integer.parseInt(cpfStr);

                            Hospede hospede = hotelHospedes.buscarCpfCadastrado(cpf);

                            if (hospede == null){
                                break;
                            }    
                        
                        else{
                            String dataEntradaStr = JOptionPane.showInputDialog("Digite a sua data entrada: ");
                            Date dataEntrada = new SimpleDateFormat("dd/MM/yyyy").parse(dataEntradaStr);
                            
                            String dataSairStr = JOptionPane.showInputDialog("Digite a sua data de saida: ");
                            Date dataSair = new SimpleDateFormat("dd/MM/yyyy").parse(dataSairStr);
                            
                            for (Quarto q : quartos) {
                                if (q.getDisponivel().equalsIgnoreCase("Disponível")) {
                                    
                                    check_in_out.realizarCheckIn(hospede, q, dataEntrada, dataSair);
                                    JOptionPane.showMessageDialog(null, "Check-in realizado com sucesso!");
                                    break;
                                }
                            }

                        }

                }
            }  
        }
        else if (opcao == 6){
            while(opcao != 2){
                
                opcaoStr = JOptionPane.showInputDialog( "Area de check-out \n" +
                "1. Realizar check-out \n" +
                "2. Voltar para o menu principal \n" + 
                "Escolha uma opção: ");
                opcao = Integer.parseInt(opcaoStr);
                
                if (opcao == 1){
                            
                    String cpfStr = JOptionPane.showInputDialog("Digite o cpf do hospede cadastrado para realizar o check-out: ");
                    int cpf = Integer.parseInt(cpfStr);

                    Hospede hospede = hotelHospedes.buscarCpfCadastrado(cpf);

                    if (hospede == null){
                        break;
                    }    
                
                else{   
                    for (Quarto q : quartos) {
                        if (q.getDisponivel().equalsIgnoreCase("Disponível")) {
                            
                            check_in_out.realizarCheckOut(hospede, q);
                            JOptionPane.showMessageDialog(null, "Check-out realizado com sucesso!");
                            break;
                        }
                    }

                }

        }


                }

            }
     }
    }
}
