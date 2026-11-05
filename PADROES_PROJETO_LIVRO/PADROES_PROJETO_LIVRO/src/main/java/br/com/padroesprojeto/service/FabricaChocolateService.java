
package br.com.padroesprojeto.service;

import br.com.padroesprojeto.model.CaldeiraChocolate;

/**
 * Serviço responsável pelas operações da fábrica.
 */
public class FabricaChocolateService {

    private final CaldeiraChocolate caldeira;

    public FabricaChocolateService() {
        this.caldeira = CaldeiraChocolate.getInstancia();
    }

    public String encherCaldeira() {
        return caldeira.encher();
    }

    public String aquecerChocolate() {
        return caldeira.aquecer();
    }

    public String retirarChocolate() {
        return caldeira.retirar();
    }

    public String consultarEstado() {
        return caldeira.getEstado();
    }

    /**
     * Retorna a referência utilizada pelo serviço.
     * Será útil para demonstrar o Singleton.
     */
    public CaldeiraChocolate getCaldeira() {
        return caldeira;
    }
}
