import javax.swing.JOptionPane;

public class testemain {
    public static void main(String[] args) {
        GerenciamentoQuartos 
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
            "5. CHECK-IN E CHECK-OUT \n" +
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
                        Int numQuarto = Integer.parseInt(numQuartoStr);
                    }

                    
                    
                }
            }   
          


            
            

        }
    }
}
