
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

public class check {
        private GerenciamentoQuartos gerenciamentoquartos;
        private GerenciamentoHospedes gerenciamentohospedes;
        private GerenciamentoReservas gerenciamentoreservas;

        public check(GerenciamentoQuartos gerenciamentoquartos, GerenciamentoHospedes gerenciamentohospedes,
                GerenciamentoReservas gerenciamentoreservas) {
            this.gerenciamentoquartos = gerenciamentoquartos;
            this.gerenciamentohospedes = gerenciamentohospedes;
            this.gerenciamentoreservas = gerenciamentoreservas;
        }

        public void realizarCheckIn(Hospede hospede, Quarto quarto, Date dataEntrada, Date dataSaida) {
            boolean reservado = gerenciamentoreservas.verificarDisponibilidadeQuartos(quarto.getNumQuarto(), dataEntrada, dataSaida);
            
            if (!reservado) {

                if (quarto.getDisponivel().equalsIgnoreCase("disponível")) {
                    quarto.setDisponivel("ocupado");
                    Reserva novaReserva = new Reserva(hospede, quarto, dataEntrada, dataSaida);
                    gerenciamentoreservas.CadastrarReserva(novaReserva);
                    JOptionPane.showMessageDialog(null,"Check-in foi efetuado com sucesso para o hóspede " + hospede.getNome());
                } else {
                    JOptionPane.showMessageDialog(null,"quarto indisponivel");
                }
            } else {
            
                Reserva reserva = gerenciamentoreservas.buscarReservaPorQuarto(quarto.getNumQuarto(), dataEntrada, dataSaida);
                if (reserva != null && reserva.getHospede().equals(hospede)) {
                    quarto.setDisponivel("ocupado");
                    JOptionPane.showMessageDialog(null,"Check-in realizado com sucesso para o hóspede " + hospede.getNome());
                } else {
                    System.out.println("ja tem uma reserva nesse periodo, vej outro quarto");
                }
            }
        }

        public void realizarCheckOut(Hospede hospede, Quarto quarto) {
            try {
                Reserva reserva = gerenciamentoreservas.buscarReservaPorHospedeEQuarto(hospede.getCpf(), quarto.getNumQuarto());
        
                if (reserva != null) {
                    LocalDate dataEntrada = reserva.getDataEntrada().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    LocalDate dataSaida = LocalDate.now();
                    long diasEstadia = ChronoUnit.DAYS.between(dataEntrada, dataSaida);
    
                    
                    double valorTotal = diasEstadia * quarto.getPreco();
                    quarto.setDisponivel("disponível");
                    gerenciamentoreservas.removerReserva(reserva);
            
            JOptionPane.showMessageDialog(null, "Check-out realizado com sucesso para o hóspede " + hospede.getNome() + ".\nValor total: R$ " + valorTotal);

        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma reserva encontrada para o hóspede e quarto especificados.");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao realizar o check-out: " + e.getMessage());
    }
}

}
