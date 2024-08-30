import java.util.ArrayList;
import javax.swing.JOptionPane;

class  GerenciamentoQuartos{
    private ArrayList<Quarto> quartos = new ArrayList<Quarto>();
     
    public void adicionarQuarto(Quarto quarto){
        quartos.add(quarto);
        JOptionPane.showMessageDialog(null,"Quarto cadastrado com sucesso: " + quarto.getNumQuarto());
    }

    public void vizualizarLista(){
        for(Quarto i: quartos){

            if (i.getDisponivel().equals("Disponivel") ){
                JOptionPane.showMessageDialog(null, "Numero do quarto: " + i.getNumQuarto());
                JOptionPane.showMessageDialog(null, "Tipo do quarto: " + i.getTipo());
                JOptionPane.showMessageDialog(null, "Capacidade do quarto: " + i.getCapacidade());
                JOptionPane.showMessageDialog(null, "Preco do quarto: " + i.getPreco());
                JOptionPane.showMessageDialog(null, "Disponiblidade do quarto: " + i.getDisponivel());
            }   
        }
    }

    public void AtualizarstatusQuarto(int numeroQuarto){
        for(Quarto quarto: quartos){
            if(numeroQuarto == quarto.getNumQuarto()){

                if(quarto.getDisponivel().equals("Disponivel")){
                    quarto.setDisponivel("Ocupado");
                    JOptionPane.showMessageDialog(null,"Status do quarto: " + numeroQuarto + " atualizado com sucesso para " + "quarto ocupado!");
                    return;
                }
    
                else if(quarto.getDisponivel().equalsIgnoreCase("Ocupado")){
                    quarto.setDisponivel("Disponivel");
                    JOptionPane.showMessageDialog(null, "Status do quarto: " + numeroQuarto + " atualizado com sucesso para " + "quarto disponivel!");
                    return;
                }
                else if(quarto.getDisponivel().equalsIgnoreCase("manutencao")){
                    quarto.setDisponivel("Disponivel");
                    JOptionPane.showMessageDialog(null, "Status do quarto: " + numeroQuarto + " atualizado com sucesso para " + "quarto manutencao !");
                    return;
            } 
                else{
                    JOptionPane.showMessageDialog(null,"Quarto nao encontardo");
                    return;
            }
            }
        }
    }



    
}