import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class GerenciamentoReservas{
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();

    public void CadastrarReserva(Reserva reserva){
        try{
            if (verificarDisponibilidadeQuartos(reserva.getQuarto().getNumQuarto(), reserva.getDataEntrada(), reserva.getDataSaida())) {
                reservas.add(reserva);
                reserva.getQuarto().setDisponivel("ocupado");
                JOptionPane.showMessageDialog(null,"sua reserva foi cadatrada com sucesso");
        }
            else{
                JOptionPane.showMessageDialog(null,"o quarto nao esta disponivel para reserva");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"erro: " + e.getMessage());
        }
}

    public void CancelarReserva(int cpf, int numero){
        for(Reserva r: reservas ){
            if (r.getHospede().getCpf() == cpf && r.getQuarto().getNumQuarto() == numero)  {     
                reservas.remove(r);
                r.getQuarto().setDisponivel("disponível");
                JOptionPane.showMessageDialog(null,"reserva cancelada");
                return;
        }
            else{
                JOptionPane.showMessageDialog(null,"Sem reserva para esse cpf");
            }
        }
        }

    
    public boolean verificarDisponibilidadeQuartos(int numeroQ, Date date, Date date2){
        try{

            for(Reserva reserva: reservas){
                if(reserva.getQuarto().getNumQuarto() == numeroQ){
                    if (!(date.compareTo(reserva.getDataSaida()) < 0 && date2.compareTo(reserva.getDataEntrada()) > 0)){
                        JOptionPane.showMessageDialog(null,"quartos disponiveis nas datas previstas, que são " + date + " a " + date2 + " sendo o tipo de quarto " + reserva.getTipo());
                        return false;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "não há quartos disponiveis para a data " + date + " a "+ date2);
                    }
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Teve-se um erro no momento de verificar a disponibilidade: " + e.getMessage());
        }
        return true;
              
    }

    public Reserva buscarReservaPorHospedeEQuarto(int cpfHospede, int numeroQuarto) {
        for (Reserva reserva : reservas) {
            if (reserva.getHospede().getCpf() == cpfHospede && reserva.getQuarto().getNumQuarto() == numeroQuarto) {
                return reserva;
            }
        }
        return null;
    }

    public void removerReserva(int cpfHospede, int numQuarto) {
        Reserva reservaARemover = null;
    
        for (Reserva reserva : reservas) {
            if (reserva.getHospede().getCpf() == cpfHospede && reserva.getQuarto().getNumQuarto() == numQuarto) {
                reservaARemover = reserva;
                break;
            }
        }
    
        if (reservaARemover != null) {
            reservas.remove(reservaARemover);
            reservaARemover.getQuarto().setDisponivel("disponível"); 
            JOptionPane.showMessageDialog(null, "Reserva removida com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "nao foi encontrado a reserva");
        }
    }

    public Reserva buscarReservaPorQuarto(int numQuarto, Date dataEntrada, Date dataSaida) {
        for (Reserva reserva : reservas) {
            
            if (reserva.getQuarto().getNumQuarto() == numQuarto &&
                reserva.getDataEntrada().equals(dataEntrada) &&
                reserva.getDataSaida().equals(dataSaida)) {
                return reserva;
            }
        }
        return null; 
    }
    }
