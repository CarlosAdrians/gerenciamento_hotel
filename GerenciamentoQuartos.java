import java.util.ArrayList;
import javax.swing.JOptionPane;

class  GerenciamentoQuartos{

    public int numQuarto;
    public Tipo tipo;
    public int capacidade;
    public double preco;
    public String disponivel;
    public ArrayList<GerenciamentoQuartos> quartos = new ArrayList<GerenciamentoQuartos>();

    public GerenciamentoQuartos(int numQuarto, Tipo tipo, int capacidade, double preco ) {
        this.numQuarto = numQuarto;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.preco = preco;
        this.disponivel = "disponivel";
    }
     
    public void adicionarQuarto(GerenciamentoQuartos quarto){
        quartos.add(quarto);
    }

    public void vizualizarLista(){
        for(GerenciamentoQuartos i: quartos){

        if (i.getDisponivel().equals(disponivel) ){
            JOptionPane.showMessageDialog(null, "Numero do quarto: " + i.getNumQuarto());
            JOptionPane.showMessageDialog(null, "Tipo do quarto: " + i.getTipo());
            JOptionPane.showMessageDialog(null, "Capacidade do quarto: " + i.getCapacidade());
            JOptionPane.showMessageDialog(null, "Preco do quarto: " + i.getPreco());
            JOptionPane.showMessageDialog(null, "Disponiblidade do quarto: " + i.getDisponivel());
        }
        }
   
    }

    public void statusQuarto(int numeroQuarto){
        for(GerenciamentoQuartos quarto: quartos){
            if(numeroQuarto == quarto.getNumQuarto()){

                if(quarto.getDisponivel().equals(disponivel)){
                    JOptionPane.showMessageDialog(null,"Status do quarto " + numeroQuarto + ": " + "quarto disponivel!");
                // quarto.setDisponivel("ocupado");
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
    

    public int getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }

    
}