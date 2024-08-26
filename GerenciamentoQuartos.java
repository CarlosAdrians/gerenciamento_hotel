import java.util.ArrayList;
import javax.swing.JOptionPane;

class  GerenciamentoQuartos{
    private ArrayList<Quarto> quartos = new ArrayList<Quarto>();
     
    public void adicionarQuarto(Quarto quarto){
        quartos.add(quarto);
        JOptionPane.showMessageDialog(null,"Quarto cadastrado com sucesso: " + quarto);
    }

    public void vizualizarLista(){
        for(Quarto i: quartos){

        if (i.getDisponivel().equals("disponivel") ){
            JOptionPane.showMessageDialog(null, "Numero do quarto: " + i.getNumQuarto());
            JOptionPane.showMessageDialog(null, "Tipo do quarto: " + i.getTipo());
            JOptionPane.showMessageDialog(null, "Capacidade do quarto: " + i.getCapacidade());
            JOptionPane.showMessageDialog(null, "Preco do quarto: " + i.getPreco());
            JOptionPane.showMessageDialog(null, "Disponiblidade do quarto: " + i.getDisponivel());
        }
        }
   
    }

    public void statusQuarto(int numeroQuarto){
        for(Quarto quarto: quartos){
            if(numeroQuarto == quarto.getNumQuarto()){

                if(quarto.getDisponivel().equals("disponivel")){
                    JOptionPane.showMessageDialog(null,"Status do quarto " + numeroQuarto + ": " + "quarto disponivel!");
    
                    return;
                }
    
                else if(quarto.getDisponivel().equalsIgnoreCase("ocupado")){
                    JOptionPane.showMessageDialog(null, "Esta ocupado!");
                    return;
                }
                else if(quarto.getDisponivel().equalsIgnoreCase("manutencao")){
                    JOptionPane.showMessageDialog(null, "Quarto em manutencao!");
                    return;
            } 
            else{
                JOptionPane.showMessageDialog(null,"quarto nao encontardo");
                return;
            }
            }
        }
    }


    
}