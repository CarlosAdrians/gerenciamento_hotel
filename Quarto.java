

public class Quarto {
    private int numQuarto;
    private Tipo tipo;
    private int capacidade;
    private double preco;
    private String disponivel;

    
    public Quarto(int numQuarto, Tipo tipo, int capacidade, double preco) {
        this.numQuarto = numQuarto;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.preco = preco;
        this.disponivel = "disponivel";
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
