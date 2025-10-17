package projeto.pratico;

import java.util.Scanner;

public class RegistroVeiculo {

    private int tipo;
    private String placa;
    private String nome;
    private String marca;
    private String modelo;
    private String cor;
    private int hora;
    private int minuto;
    private int vaga;

    private static int codigo = 0;
    private static int proximaVaga = 1;
    public static final int MAX_VAGAS = 10;
    private static RegistroVeiculo[] vagas = new RegistroVeiculo[MAX_VAGAS];

    public static RegistroVeiculo getVeiculoNaVaga(int indice) {
        if (indice >= 0 && indice < MAX_VAGAS) {
            return vagas[indice];
        }
        return null;
    }

    public static RegistroVeiculo[] getVagas() {
        return vagas;
    }

    public void registrar() {
        Scanner input = new Scanner(System.in);
        char opcao;

        if (proximaVaga > MAX_VAGAS) {
            System.out.println("Estacionamento cheio!");
            return;
        }

        do {
            // Tipo
            do {
                System.out.print("\n--- Tipo de Veículo ---\n1- Carro\n2- Moto\n3- Caminhão/Caminhonete\nDigite o tipo: ");
                tipo = input.nextInt();
                input.nextLine();
                if (tipo < 1 || tipo > 3) {
                    System.out.println("Tipo inválido! Digite 1, 2 ou 3.");
                }
            } while (tipo < 1 || tipo > 3);

            // Placa
            do {
                System.out.print("Digite a placa (7 caracteres): ");
                placa = input.nextLine();
                if (placa.length() != 7) System.out.println("Placa inválida!");
            } while (placa.length() != 7);

            // Nome
            do {
                System.out.print("Nome do condutor: ");
                nome = input.nextLine();
                if (nome.isEmpty()) System.out.println("Nome não pode estar vazio!");
            } while (nome.isEmpty());

            // Marca
            do {
                System.out.print("Marca do veículo: ");
                marca = input.nextLine();
                if (marca.isEmpty()) System.out.println("Marca não pode estar vazia!");
            } while (marca.isEmpty());

            // Modelo
            do {
                System.out.print("Modelo do veículo: ");
                modelo = input.nextLine();
                if (modelo.isEmpty()) System.out.println("Modelo não pode estar vazio!");
            } while (modelo.isEmpty());

            // Cor
            do {
                System.out.print("Cor do veículo: ");
                cor = input.nextLine();
                if (cor.isEmpty()) System.out.println("Cor não pode estar vazia!");
            } while (cor.isEmpty());

            // Hora
            do {
                System.out.print("Hora de entrada (0-23): ");
                hora = input.nextInt();
                if (hora < 0 || hora > 23) System.out.println("Hora inválida!");
            } while (hora < 0 || hora > 23);

            // Minuto
            do {
                System.out.print("Minuto de entrada (0-59): ");
                minuto = input.nextInt();
                if (minuto < 0 || minuto > 59) System.out.println("Minuto inválido!");
            } while (minuto < 0 || minuto > 59);

            // Registro
            RegistroVeiculo veiculo = new RegistroVeiculo();
            veiculo.tipo = this.tipo;
            veiculo.placa = this.placa;
            veiculo.nome = this.nome;
            veiculo.marca = this.marca;
            veiculo.modelo = this.modelo;
            veiculo.cor = this.cor;
            veiculo.hora = this.hora;
            veiculo.minuto = this.minuto;
            veiculo.vaga = proximaVaga;

            vagas[proximaVaga - 1] = veiculo;
            System.out.println("Veículo registrado na vaga " + proximaVaga + ".");
            proximaVaga++;
            codigo++;

            // Deseja continuar
            System.out.print("Deseja registrar outro veículo? (S/N): ");
            opcao = input.next().toUpperCase().charAt(0);
            input.nextLine();
            System.out.println();

        } while (opcao == 'S');
    }

    // GETTERS
    public int getTipo() { return tipo; }
    public String getPlaca() { return placa; }
    public String getNome() { return nome; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getCor() { return cor; }
    public int getHora() { return hora; }
    public int getMinuto() { return minuto; }
    public int getVaga() { return vaga; }
    public static int getCodigo() { return codigo; }
}
