import java.util.ArrayList;
import javax.swing.JOptionPane;

class GerenciamentoHospedes {
    private ArrayList<Hospede> hospedes = new ArrayList<Hospede>();
   

    
    public void adicionarHospede(Hospede hospede){
        hospedes.add(hospede);
        JOptionPane.showMessageDialog(null, "Hóspede cadastrado com sucesso: " + hospede);
    }


    public void vizualizarHistoricoEstadia(int cpf){
        for(Hospede hospede: hospedes){
            if(cpf == hospede.getCpf()){
                    JOptionPane.showMessageDialog(null,"Tempo de estadia: " + hospede.getEstadias() + " do hospede " + hospede.getNome() + ": " + hospede.getEstadias() + " dias");
                    return;
                
            }

            else{
                JOptionPane.showMessageDialog(null,"hospede nao encontrado, por tanto nao existe um historico de estadia ");
            }
        }
    }
    public void editarInformacoes(int cpf, String nomeNovo, String enderecoNovo, int contatoNovo){
        for (Hospede hospede : hospedes) {
            if (hospede.getCpf() == cpf) {
                hospede.setNome(nomeNovo);
                hospede.setEndereco(enderecoNovo);
                hospede.setNumeroContato(contatoNovo);
                JOptionPane.showMessageDialog(null, "informacoes atualizadas com sucesso");
                exibirinfoHospedes();
                return;
        }
            else{
            JOptionPane.showMessageDialog(null,"nao existe cadastro para editar informacoes desse hospede");
        }
    }
    }

    public void exibirinfoHospedes(){
        for(Hospede h: hospedes){
            JOptionPane.showMessageDialog(null,"Nome: " + h.getNome());
            JOptionPane.showMessageDialog(null,"Cpf: " + h.getCpf());
            JOptionPane.showMessageDialog(null,"Data de nascimento: " + h.getDataNascimento());
            JOptionPane.showMessageDialog(null,"Endereco: " + h.getEndereco());
            JOptionPane.showMessageDialog(null,"Contato: " + h.getNumeroContato());
        }
    }
    

    

}
