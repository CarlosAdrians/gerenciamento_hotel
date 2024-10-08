import java.util.ArrayList;
import java.util.Date;

public class Hospede extends Pessoa {
    private Date dataNascimento;
    private String endereco;
    private int numeroContato;
    private ArrayList<String> estadias = new ArrayList<String>();
    
    public Hospede(String nome, int cpf, Date dataNascimento, String endereco, int numeroContato) {
        super(nome, cpf);
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.numeroContato = numeroContato;
        this.estadias = new ArrayList<>();
    }

    
    public void RegistarEstadia(String estadia){
        estadias.add(estadia);
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
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

    public ArrayList<String> getEstadias() {
        return estadias;
    }

    public void setEstadias(ArrayList<String> estadias) {
        this.estadias = estadias;
    }


    public void registrarEstadia(int quartoHotel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registrarEstadia'");
    }

    
    
}
