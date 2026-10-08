public class Aluguel {
    private int diasAlugada;
    private Fita fita;

    public Aluguel(Fita fita, int diasAlugada) {
        this.fita = fita;
        this.diasAlugada = diasAlugada;
    }

    public Fita getFita() {
        return fita;
    }

    public int getDiasAlugada() {
        return diasAlugada;
    }

    /*
     * REFATORAÇÃO 2 - MOVE METHOD
     *
     * O cálculo do valor do aluguel foi movido de Cliente para Aluguel.
     * Antes, Cliente era responsável por conhecer os detalhes do cálculo
     * para cada tipo de fita. Agora, Aluguel calcula seu próprio valor,
     * pois possui a fita e a quantidade de dias alugados.
     *
     * Benefício: reduz o acoplamento de Cliente e concentra a regra de
     * negócio no objeto que possui os dados necessários para o cálculo.
     */
    public double calcularValor() {
        double valor = 0;

        switch (fita.getCodigoDePreco()) {
            case Fita.NORMAL:
                valor += 2;
                if (diasAlugada > 2) {
                    valor += (diasAlugada - 2) * 1.5;
                }
                break;

            case Fita.LANCAMENTO:
                valor += diasAlugada * 3;
                break;

            case Fita.INFANTIL:
                valor += 1.5;
                if (diasAlugada > 3) {
                    valor += (diasAlugada - 3) * 1.5;
                }
                break;
        }

        return valor;
    }

    /*
     * O cálculo dos pontos também depende das informações deste aluguel.
     * Mantemos essa regra próxima dos dados utilizados por ela.
     */
    public int calcularPontos() {
        int pontos = 1;

        if (fita.getCodigoDePreco() == Fita.LANCAMENTO && diasAlugada > 1) {
            pontos++;
        }

        return pontos;
    }
}
