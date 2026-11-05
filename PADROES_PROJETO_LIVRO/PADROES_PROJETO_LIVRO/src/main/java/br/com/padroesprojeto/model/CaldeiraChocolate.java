
package br.com.padroesprojeto.model;

/**
 * Representa a caldeira de chocolate da fábrica.
 *
 * Implementação do padrão Singleton:
 * existe apenas uma instância desta classe durante a execução.
 */
public class CaldeiraChocolate {

    private static CaldeiraChocolate instancia;

    private boolean vazia;
    private boolean aquecida;

    /**
     * Construtor privado impede a criação de objetos
     * por outras classes.
     */
    private CaldeiraChocolate() {
        vazia = true;
        aquecida = false;
    }

    /**
     * Retorna a única instância da caldeira.
     */
    public static synchronized CaldeiraChocolate getInstancia() {
        if (instancia == null) {
            instancia = new CaldeiraChocolate();
        }

        return instancia;
    }

    /**
     * Coloca a mistura de chocolate na caldeira.
     */
    public synchronized String encher() {
        if (!vazia) {
            return "A caldeira já contém chocolate.";
        }

        vazia = false;
        aquecida = false;

        return "Caldeira preenchida com a mistura de chocolate.";
    }

    /**
     * Aquece a mistura de chocolate.
     */
    public synchronized String aquecer() {
        if (vazia) {
            return "Não é possível aquecer: a caldeira está vazia.";
        }

        if (aquecida) {
            return "O chocolate já está aquecido.";
        }

        aquecida = true;

        return "Chocolate aquecido e pronto para processamento.";
    }

    /**
     * Retira o chocolate da caldeira.
     */
    public synchronized String retirar() {
        if (vazia) {
            return "A caldeira já está vazia.";
        }

        if (!aquecida) {
            return "Não é possível retirar: o chocolate ainda não foi aquecido.";
        }

        vazia = true;
        aquecida = false;

        return "Chocolate retirado. Caldeira disponível para novo ciclo.";
    }

    public synchronized boolean estaVazia() {
        return vazia;
    }

    public synchronized boolean estaAquecida() {
        return aquecida;
    }

    /**
     * Descreve a situação atual da caldeira.
     */
    public synchronized String getEstado() {
        if (vazia) {
            return "VAZIA";
        }

        if (aquecida) {
            return "CHOCOLATE AQUECIDO";
        }

        return "CHEIA - AGUARDANDO AQUECIMENTO";
    }
}
