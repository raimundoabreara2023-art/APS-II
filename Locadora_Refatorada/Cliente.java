import java.util.*;

public class Cliente {
    private String nome;
    private List<Aluguel> alugueis = new ArrayList<>();

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionaAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    /*
     * REFATORAÇÃO 1 - EXTRACT METHOD
     *
     * O método extrato() original concentrava várias responsabilidades:
     * cálculo do valor, cálculo dos pontos, montagem das linhas e cálculo
     * do total.
     *
     * A responsabilidade de calcular o valor e os pontos foi extraída para
     * métodos de Aluguel. O extrato() ficou mais simples e legível.
     *
     * Benefício: cada método passa a ter uma responsabilidade mais clara,
     * facilitando a leitura, os testes e futuras alterações.
     */
    public String extrato() {
        double valorTotal = 0;
        int pontosDeAlugadorFrequente = 0;

        String resultado = "Registro de Alugueis de " + getNome() + "\n";

        for (Aluguel aluguel : alugueis) {
            double valorCorrente = aluguel.calcularValor();

            pontosDeAlugadorFrequente += aluguel.calcularPontos();

            resultado += criarLinhaExtrato(aluguel, valorCorrente);

            valorTotal += valorCorrente;
        }

        resultado += "Valor total devido: " + valorTotal + "\n";
        resultado += "Você ganhou " + pontosDeAlugadorFrequente
                + " pontos de alugador frequente";

        return resultado;
    }

    /*
     * REFATORAÇÃO 1 - EXTRACT METHOD
     *
     * A montagem de cada linha do extrato foi extraída do método principal.
     * Assim, extrato() fica concentrado no controle geral da operação.
     */
    private String criarLinhaExtrato(Aluguel aluguel, double valor) {
        return "\t" + aluguel.getFita().getTitulo() + "\t" + valor + "\n";
    }
}
