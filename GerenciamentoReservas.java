import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GerenciamentoReservas extends Pessoa{
    private String dataEntrada;
    private String dataSaida;
    private Tipo tipo;
    private int numeroHospedes;
    private String status;

    private ArrayList<GerenciamentoReservas> reservas = new ArrayList<GerenciamentoReservas>();

    public GerenciamentoReservas(String nome, int cpf, String dataEntrada, String dataSaida, Tipo tipo, int numeroHospedes){
        super(nome, cpf);
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.tipo = tipo;
        this.numeroHospedes = numeroHospedes;
        this.status="ativo";
    }
    public void CancelarReserva(int cpf){
        for(GerenciamentoReservas reserva: reservas ){
            if (cpf == reserva.getCpf()){             
                
                reservas.remove(reserva);
                this.status = "cancelado";
                JOptionPane.showMessageDialog(null,"reserva cancelada");
                return;

            }

        }

        JOptionPane.showMessageDialog(null, "Sem reserva para esse cpf");
    }

    public void verificarDisponibilidade(String dataEntrada, String dataSaida, Tipo tipo, int numeroHospedes){
        if

    }

    public void adicionarReserva(GerenciamentoReservas reserva){
        reservas.add(reserva);
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getNumeroHospedes() {
        return numeroHospedes;
    }

    public void setNumeroHospedes(int numeroHospedes) {
        this.numeroHospedes = numeroHospedes;
    }

    
    
}