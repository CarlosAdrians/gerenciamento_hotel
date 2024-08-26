class GerenciamentoFuncionarios extends Pessoa{

    private String cargo;
    private double salario;
    private String turnoTrabalho;
    
    public GerenciamentoFuncionarios(String nome, int cpf, String cargo, double salario, String turnoTrabalho) {
        super(nome, cpf);
        this.cargo = cargo;
        this.salario = salario;
        this.turnoTrabalho = turnoTrabalho;
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
    public String getTurnoTrabalho() {
        return turnoTrabalho;
    }
    public void setTurnoTrabalho(String turnoTrabalho) {
        this.turnoTrabalho = turnoTrabalho;
    }

    
}