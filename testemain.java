import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;



public class testemain {
    public static void main(String[] args) throws ParseException {
        GerenciamentoQuartos hotelQuartos = new GerenciamentoQuartos();
        GerenciamentoHospedes hotelHospedes = new GerenciamentoHospedes();
        GerenciamentoReservas hotelReservas = new GerenciamentoReservas();
        GerenciamentoFuncionarios hotelFuncionarios = new GerenciamentoFuncionarios();

        int opcao = 0;
        String opcaoStr;
        
        String lineSep = System.lineSeparator();
        StringBuilder resultado = new StringBuilder();

        while (opcao != 7){
            
            opcaoStr = JOptionPane.showInputDialog("MENU \n" +
            "1. AREA DE QUARTOS \n" +
            "2. AREA DE HOSPEDES \n" +
            "3. AREA DE RESERVA \n" +
            "4. AREA DE FUNCIONARIOS \n" +
            "5. CHECK-IN \n" +
            "6. CHECK-OUT \n" +
            "7. SAIR \n" +
            "ESCOLHA UMA OPCAO: ");
            opcao = Integer.parseInt(opcaoStr);


            if (opcao == 1){
                while (opcao != 3){
                    opcaoStr = JOptionPane.showInputDialog( "AREA DE QUARTOS \n" +
                    "1. CADASTRAR QUARTO \n" +
                    "2. ATUALIZAR STATUS DO QUARTO \n" +
                    "3. VOLTAR PARA O MENU PRINCIPAL\n" +
                    "ESCOLHA UMA OPCAO: ");
                    opcao = Integer.parseInt(opcaoStr);

                    if (opcao == 1){

                        String numQuartoStr = JOptionPane.showInputDialog("DIGITE O NUMERO DO QUARTO: ");
                        int numQuarto = Integer.parseInt(numQuartoStr);
                        
                        String tipoStr = JOptionPane.showInputDialog("ESCOLHA O TIPO DE QUARTO (SOLTEIRO, CASAL, SUITE): ");
                        Tipo tipo = Tipo.valueOf(tipoStr);
                       
                        String capacidadeStr = JOptionPane.showInputDialog("DIGITE A CAPACIDADE DO QUARTO: ");
                        int capacidade = Integer.parseInt(capacidadeStr);
                        
                        String precoStr = JOptionPane.showInputDialog("DIGITE O PRECO DO QUARTO: ");
                        double preco = Double.parseDouble(precoStr);

                        Quarto quarto = new Quarto(numQuarto, tipo, capacidade, preco);

                        hotelQuartos.adicionarQuarto(quarto);

                    }
                    else if (opcao == 2){
                        
                        String numQuartoStr = JOptionPane.showInputDialog("DIGITE O NUMERO DO QUARTO A SER ATUALIZADO: ");
                        int numQuarto = Integer.parseInt(numQuartoStr);

                        hotelQuartos.statusQuarto(numQuarto);
                    }     
                    
                    else{
                        JOptionPane.showMessageDialog(null, "OPCAO INVALIDA! DIGITE UMA DAS OPCOES EXISTENTES");

                    }
                }
            }
            else if (opcao == 2){
                while (opcao != 4){

                    opcaoStr = JOptionPane.showInputDialog( "AREA DE HOSPEDES \n" +
                    "1. CADASTRAR HOSPEDE \n" +
                    "2. VIZUALIZAR HISTORICO DE ESTADIA DE UM HOSPEDE \n" +
                    "3. EDITAR INFORMAÇOES DE UM HOSPEDE \n" +
                    "4. VOLTAR PARA O MENU PRINCIPAL\n" +
                    "ESCOLHA UMA OPCAO: ");
                    opcao = Integer.parseInt(opcaoStr);

                    if (opcao == 1){
                        
                        String nome = JOptionPane.showInputDialog("DIGITE SEU NOME COMPLETO: ");

                        String cpfStr = JOptionPane.showInputDialog("DIGITE SEU CPF: ");
                        int cpf = Integer.parseInt(cpfStr);

                        String dataStr = JOptionPane.showInputDialog("DIGITE A SUA DATA DE NASCIMENTO: " + "(dd/MM/yyyy)");
                        Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataStr);

                        String endereco = JOptionPane.showInputDialog("DIGITE O SEU ENDERECO (RUA PADRAO, 0231: )");

                        String numeroContatoString = JOptionPane.showInputDialog("DIGITE SEU NUMERO PARA CONTATO (83986693221): ");
                        int numeroContato = Integer.parseInt(numeroContatoString);

                        Hospede hospede = new Hospede(nome, cpf, data, endereco, numeroContato);
                        hotelHospedes.adicionarHospede(hospede);

                    }

                    else if (opcao == 2){
                        
                        String cpfStr = JOptionPane.showInputDialog("DIGITE SEU CPF: ");
                        int cpf = Integer.parseInt(cpfStr);

                        hotelHospedes.vizualizarHistoricoEstadia(cpf);

                    }

                    else if (opcao == 3){

                        String cpfStr = JOptionPane.showInputDialog("DIGITE SEU CPF: ");
                        int cpf = Integer.parseInt(cpfStr);

                        String nomeNovo = JOptionPane.showInputDialog("DIGITE SEU NOVO NOME : ");

                        String enderecoNovo = JOptionPane.showInputDialog("DIGITE O SEU NOVO ENDERECO (RUA PADRAO, 0231: )");

                        String numeroContatoNovoString = JOptionPane.showInputDialog("DIGITE SEU NOVO NUMERO PARA CONTATO (83986693221): ");
                        int numeroContatoNovo = Integer.parseInt(numeroContatoNovoString);

                        hotelHospedes.editarInformacoes(cpf, nomeNovo, enderecoNovo, numeroContatoNovo);

                    }
                }     
            }
            else if (opcao == 3){
                while (opcao != 4){
                    
                    opcaoStr = JOptionPane.showInputDialog( "AREA DE RESERVAS \n" +
                    "1. CADASTRAR RESERVA \n" +
                    "2. CANCELAR RESERVA \n" +
                    "3. VERIFICAR DISPONIBILIDADE DE QUARTO \n" +
                    "4. VOLTAR PARA O MENU PRINCIPAL\n" +
                    "ESCOLHA UMA OPCAO: ");
                    opcao = Integer.parseInt(opcaoStr);

                    if ( opcao == 1 ){
                        
                        String cpfStr = JOptionPane.showInputDialog("DIGITE O CPF DO HOSPEDE CADASTRADO PARA FAZER A RESERVA: ");
                        int cpf = Integer.parseInt(cpfStr);
            
                        String dataEntradaStr = JOptionPane.showInputDialog("DIGITE A SUA DATA DE ENTRADA: ");
                        Date dataEntrada = new SimpleDateFormat("dd/MM/yyyy").parse(dataEntradaStr);
                
                        String dataSairStr = JOptionPane.showInputDialog("DIGITE A SUA DATA DE SAIDA: ");
                        Date dataSair = new SimpleDateFormat("dd/MM/yyyy").parse(dataSairStr);
                
                        String tipoStr = JOptionPane.showInputDialog("ESCOLHA O TIPO DE QUARTO (SOLTEIRO, CASAL, SUITE): ");
                        Tipo tipo = Tipo.valueOf(tipoStr);
    
                        String quantidadeStr = JOptionPane.showInputDialog("DIGITE A QUANTIDADE DE HOSPEDES: ");
                        int quantidade = Integer.parseInt(quantidadeStr);

                        Reserva reserva = new Reserva(null, null, dataEntrada, dataSair, tipo, quantidade);
                        hotelReservas.CadastrarReserva(reserva);

                        }
                    }

                    

                }

                else if (opcao == 4){
                        
                    while (opcao != 4){
                        opcaoStr = JOptionPane.showInputDialog( "AREA DE FUNCIONARIOS \n" +
                        "1. CADASTRAR INFORMACOES DE FUNCIONARIOS \n" +
                        "2. EDITAR INFORMACOES DE FUNCIONARIO \n" +
                        "3. CALCULAR SALARIO \n" +
                        "4. VOLTAR PARA O MENU PRINCIPAL \n" + 
                        "ESCOLHA UMA OPCAO: ");
                        opcao = Integer.parseInt(opcaoStr);
                        
                        if (opcao == 1){
                            
                            String nome = JOptionPane.showInputDialog("DIGITE SEU NOME COMPLETO: ");

                            String cpfStr = JOptionPane.showInputDialog("DIGITE SEU CPF: ");
                            int cpf = Integer.parseInt(cpfStr);

                            String cargo = JOptionPane.showInputDialog("DIGITE SEU CARGO: ");

                            String salarioStr = JOptionPane.showInputDialog("DIGITE SEU SALARIO: ");
                            double salario = Double.parseDouble(salarioStr);

                            String turno = JOptionPane.showInputDialog("DIGITE O TURNO DO SEU TRABALHO: ");

                            hotelFuncionarios.cadastrarFuncionario(nome, cpf, cargo, salario, turno);

                        }

                        else if (opcao == 2){
                           
                            String cpfStr = JOptionPane.showInputDialog("DIGITE SEU CPF: ");
                            int cpf = Integer.parseInt(cpfStr);

                            String nomeNovo = JOptionPane.showInputDialog("DIGITE SEU NOVO NOME : ");
                            
                            String cargoNovo = JOptionPane.showInputDialog("DIGITE SEU NOVO CARGO: ");

                            String salarioNovoStr = JOptionPane.showInputDialog("DIGITE SEU NOVO SALARIO: ");
                            double salarioNovo = Double.parseDouble(salarioNovoStr);

                            String turnoNovo = JOptionPane.showInputDialog("DIGITE O NOVO TURNO DO SEU TRABALHO: ");

                            hotelFuncionarios.editarFuncionario(cpf, cargoNovo, turnoNovo, salarioNovo);
                        }

                        else if (opcao == 3){

                            String horasStr = JOptionPane.showInputDialog("DIGITE SUAS HORAS TRABALHADAS NO MES: ");
                            int horas = Integer.parseInt(horasStr);

                        }

                }


            }  
          


            
            

        }
    }
}
