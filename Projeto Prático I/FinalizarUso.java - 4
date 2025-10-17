package projeto.pratico;

import java.util.Scanner;

public class FinalizarUso {

    public void finalizar() {
        Scanner input = new Scanner(System.in);

        if (RegistroVeiculo.getCodigo() == 0) {
            System.out.println("Não há veículos registrados.");
            return;
        }

        System.out.println("--- FINALIZAR USO ---");
        System.out.print("Digite o código do veículo: ");
        int codigoVeiculo = input.nextInt();
        input.nextLine();

        RegistroVeiculo[] vagas = RegistroVeiculo.getVagas();
        RegistroVeiculo veiculoEncontrado = null;
        int indice = -1;

        for (int i = 0; i < vagas.length; i++) {
            if (vagas[i] != null && vagas[i].getVaga() == codigoVeiculo) {
                veiculoEncontrado = vagas[i];
                indice = i;
                break;
            }
        }

        if (veiculoEncontrado == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }

        System.out.print("Digite a hora de saída (0-23): ");
        int horaSaida = input.nextInt();
        System.out.print("Digite o minuto de saída (0-59): ");
        int minutoSaida = input.nextInt();

        int tempoEntrada = veiculoEncontrado.getHora() * 60 + veiculoEncontrado.getMinuto();
        int tempoSaida = horaSaida * 60 + minutoSaida;
        int tempoTotal = tempoSaida - tempoEntrada;

        if (tempoTotal < 0) {
            System.out.println("A hora de saída não pode ser menor que a de entrada. Tente novamente.");
            return;
        }

        double valorTotal = 0;
        int tipo = veiculoEncontrado.getTipo();

        if (tipo == 1) { // Carro
            if (tempoTotal <= 15) valorTotal = 6.00;
            else if (tempoTotal <= 30) valorTotal = 17.00;
            else if (tempoTotal <= 60) valorTotal = 20.00;
            else valorTotal = 20.00 + ((tempoTotal - 60) * 1.35);
        } else if (tipo == 2) { // Moto
            if (tempoTotal <= 15) valorTotal = 3.00;
            else if (tempoTotal <= 30) valorTotal = 7.00;
            else if (tempoTotal <= 60) valorTotal = 10.00;
            else valorTotal = 10.00 + ((tempoTotal - 60) * 1.00);
        } else if (tipo == 3) { // Caminhão
            if (tempoTotal <= 15) valorTotal = 16.00;
            else if (tempoTotal <= 30) valorTotal = 27.00;
            else if (tempoTotal <= 60) valorTotal = 30.00;
            else valorTotal = 30.00 + ((tempoTotal - 60) * 2.35);
        }

        System.out.println("Tempo de permanência: " + tempoTotal + " minutos");
        System.out.println("Valor a pagar: R$ " + String.format("%.2f", valorTotal));

        System.out.print("--- Tipo de pagamento --- \n1-Dinheiro \n2-Cartão \n3-Pix \nDigite o tipo de pagamento:  ");
        int tipoPagamento = input.nextInt();
        String tipoPag = switch (tipoPagamento) {
            case 1 -> "Dinheiro";
            case 2 -> "Cartão";
            case 3 -> "Pix";
            default -> "Desconhecido";
        };
        System.out.println("Pagamento via: " + tipoPag);

        //  SALVA NO HISTÓRICO ANTES DE LIBERAR A VAGA
        HistoricoSaldo.registrarPagamento(codigoVeiculo, valorTotal, tipoPag);

        vagas[indice] = null;
        System.out.println("Veículo removido. Vaga " + (indice + 1) + " liberada.");
    }
}
