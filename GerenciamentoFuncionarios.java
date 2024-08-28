import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GerenciamentoFuncionarios {
    private ArrayList<Funcionario> funcionarios;

    public GerenciamentoFuncionarios() {
        this.funcionarios = new ArrayList<>();
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void cadastrarFuncionario(String nome, int cpf, String cargo, double salario, String turno){
        Funcionario funcionario = new Funcionario(nome, cpf, cargo, salario, turno);
        funcionarios.add(funcionario);
    }

    public void editarFuncionario(int cpf, String nome, String cargo, String turno, double salario){
        for(Funcionario f: funcionarios){
            if(cpf == f.getCpf()){
                f.setNome(nome);
                f.setCargo(cargo);
                f.setTurno(turno);
                f.setSalario(salario);
                JOptionPane.showMessageDialog(null, "alterações realizadas com sucesso");
                f.exibirDetalhes();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "funcionario n cadastrado");
    }
    public void RegistrarHoraTrabalho(int cpf, int horasTrabalhadas){
        for(Funcionario f: funcionarios){
            if(cpf == f.getCpf()){
                f.setHoras(horasTrabalhadas);
                JOptionPane.showMessageDialog(null, " registrado as horas de trabalho! ");
                return;
    }
        JOptionPane.showMessageDialog(null, "funcionario nao encontrado");
}
    
    }
    public Funcionario buscarCpfCadastrado(int cpf){
        for(Funcionario funcionario: funcionarios){
            if(cpf == funcionario.getCpf()){
                continue;
            }
        }
        JOptionPane.showMessageDialog(null,"Funcionario nao encontrado ");
        return null;
    }
}