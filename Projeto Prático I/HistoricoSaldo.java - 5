package projeto.pratico;

public class HistoricoSaldo {

    
    static class Pagamento {
        int codigoVeiculo;
        double valor;
        String formaPagamento;

        Pagamento(int codigoVeiculo, double valor, String formaPagamento) {
            this.codigoVeiculo = codigoVeiculo;
            this.valor = valor;
            this.formaPagamento = formaPagamento;
        }
    }

    private static Pagamento[] historico = new Pagamento[100]; 
    private static int totalPagamentos = 0;
    private static double saldoTotal = 0;

    public static void registrarPagamento(int codigoVeiculo, double valor, String formaPagamento) {
        historico[totalPagamentos] = new Pagamento(codigoVeiculo, valor, formaPagamento);
        totalPagamentos++;
        saldoTotal += valor;
    }

    public static void exibirHistorico() {
        System.out.println("===== HISTÓRICO DE PAGAMENTOS =====");
        System.out.println("-----------------------------------");

        if (totalPagamentos == 0) {
            System.out.println("Nenhum pagamento registrado ainda.");
        } else {
            for (int i = 0; i < totalPagamentos; i++) {
                System.out.println("Código do Veículo: " + historico[i].codigoVeiculo);
                System.out.println("Valor Pago: R$ " + String.format("%.2f", historico[i].valor));
                System.out.println("Forma de Pagamento: " + historico[i].formaPagamento);
                System.out.println("-----------------------------------");
            }
        }

        System.out.println("SALDO TOTAL ARRECADADO: R$ " + String.format("%.2f", saldoTotal));
    }
}
