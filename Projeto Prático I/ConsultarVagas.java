package projeto.pratico;

class ConsultarVagas {

    void consulta() {
        System.out.println("--- DISPONIBILIDADE DE VAGAS ---");

        int totalOcupadas = 0;
        int totalLivres = 0;

        for (int i = 0; i < RegistroVeiculo.MAX_VAGAS; i++) {
            RegistroVeiculo veiculo = RegistroVeiculo.getVeiculoNaVaga(i);

            if (veiculo != null) {
                System.out.println("Vaga " + (i + 1) + " (Tipo: " + veiculo.getTipo() + "): OCUPADA - Placa: " + veiculo.getPlaca());
                totalOcupadas++;
            } else {
                System.out.println("Vaga " + (i + 1) + " (Tipo: 0): LIVRE");
                totalLivres++;
            }
        }

        System.out.println();
        System.out.println("Total de vagas ocupadas: " + totalOcupadas);
        System.out.println("Total de vagas livres: " + totalLivres);
    }
}
