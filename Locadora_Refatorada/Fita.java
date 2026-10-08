public class Fita {

    public static final int NORMAL = 0;
    public static final int LANCAMENTO = 1;
    public static final int INFANTIL = 2;

    private String titulo;
    private int codigoDePreco;

    public Fita(String titulo, int codigoDePreco) {
        this.titulo = titulo;
        this.codigoDePreco = codigoDePreco;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCodigoDePreco() {
        return codigoDePreco;
    }

    public void setcodigoDePreco(int codPreco) {
        this.codigoDePreco = codPreco;
    }

    /*
     * OBSERVAÇÃO DA REFATORAÇÃO
     *
     * Esta classe não precisou ser alterada para realizar as duas
     * refatorações escolhidas. Ela foi mantida para preservar o modelo
     * original e evitar mudanças que não fossem necessárias ao exercício.
     */
}
