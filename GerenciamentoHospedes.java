import java.util.ArrayList;
import javax.swing.JOptionPane;

class GerenciamentoHospedes extends Pessoa{
   
    private String dataNascimento;
    private String endereco;
    private int numeroContato;
    ArrayList<GerenciamentoHospedes> hospedes = new ArrayList<GerenciamentoHospedes>();
    ArrayList<Integer> estadias = new ArrayList<Integer>();

public GerenciamentoHospedes(String nome, int cpf, String dataNascimento, String endereco, int numeroContato) {
        super(nome, cpf);

        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.numeroContato = numeroContato;
        this.estadias = new ArrayList<>();
}
    
public void adicionarHospede(GerenciamentoHospedes hospede){
        hospedes.add(hospede);
}

public void adicionarEstadia(int estadia){
        estadias.add(estadia);
}
public void vizualizarHistoricoEstadia(int cpf){
    for(GerenciamentoHospedes hospede: hospedes){
        if(cpf == hospede.getCpf()){
            for(int estadia : estadias){
                JOptionPane.showMessageDialog(null,"Tempo de estadia de " + nome + ": " + getEstadias() + " dias");
            }
        }

        else{
            JOptionPane.showMessageDialog(null,"hospede nao encontrado, por tanto nao existe um historico de estadia ");
        }
    }
}
public void editarInformacoes(int cpf, String nomeNovo, String enderecoNovo, int contatoNovo){
    for (GerenciamentoHospedes hospede : hospedes) {
        if (hospede.getCpf() == cpf) {
        setNome(nomeNovo);
        setEndereco(enderecoNovo);
        setNumeroContato(contatoNovo);
        JOptionPane.showMessageDialog(null, "informacoes atualizadas com sucesso");
        return;
        }
    else{
        JOptionPane.showMessageDialog(null,"nao existe cadastro para editar informacoes desse hospede");
    }
}
}

public void exibirinfoHospedes(){
        JOptionPane.showMessageDialog(null,"Nome: " + nome);
            JOptionPane.showMessageDialog(null,"Cpf: " + cpf);
            JOptionPane.showMessageDialog(null,"Data de nascimento: " + dataNascimento);
            JOptionPane.showMessageDialog(null,"Endereco: " + endereco);
            JOptionPane.showMessageDialog(null,"Contato: " + numeroContato);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public int getNumeroContato() {
        return numeroContato;
    }
    public void setNumeroContato(int numeroContato) {
        this.numeroContato = numeroContato;
    }
    public ArrayList<Integer> getEstadias() {
        return estadias;
    }
    public void setEstadias(ArrayList<Integer> estadias) {
        this.estadias = estadias;
    }
    

}
