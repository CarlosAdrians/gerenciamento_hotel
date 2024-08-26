
import javax.swing.JOptionPane;

public class Funcionario extends Pessoa{
    private String cargo;
    private double salario;
    private String turno;
    private int horas;

    public Funcionario(String nome, int cpf, String cargo, double salario, String turno) {
        super(nome, cpf);
        this.cargo = cargo;
        this.salario = salario;
        this.turno = turno;
        this.horas = 0; 
    }


    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public String getTurno() {
        return turno;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }

    
    public int getHoras() {
        return horas;
    }


    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void exibirDetalhes() {
        JOptionPane.showMessageDialog(null,"Nome: " + nome);
        JOptionPane.showMessageDialog(null,"CPF: " + cpf);
        JOptionPane.showMessageDialog(null,"Cargo: " + cargo);
        JOptionPane.showMessageDialog(null,"Salário: R$ " + salario);
        JOptionPane.showMessageDialog(null,"Turno: " + turno);
    }


}