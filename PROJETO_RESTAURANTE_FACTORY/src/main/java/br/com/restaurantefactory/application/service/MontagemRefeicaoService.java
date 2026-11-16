package br.com.restaurantefactory.application.service;

import br.com.restaurantefactory.domain.factory.FabricaRefeicao;
import br.com.restaurantefactory.domain.model.Bebida;
import br.com.restaurantefactory.domain.model.PratoPrincipal;
import br.com.restaurantefactory.domain.model.Sobremesa;
import br.com.restaurantefactory.domain.pedido.Pedido;

/**
 * Serviço de aplicação responsável por orquestrar a montagem de refeições
 * utilizando o padrão Abstract Factory. Este serviço não conhece as implementações
 * concretas (Fitness, Tradicional ou Vegetariana), dependendo exclusivamente
 * da abstração da fábrica.
 */
public class MontagemRefeicaoService {

    /**
     * Monta um pedido completo com base na família de produtos fornecida pela fábrica.
     * 
     * @param fabricaRefeicao A fábrica concreta escolhida (ex: FabricaFitness, FabricaTradicional, etc.)
     * @return Um objeto Pedido contendo o prato principal, a bebida e a sobremesa correspondentes.
     */
    public Pedido montarRefeicao(FabricaRefeicao fabricaRefeicao) {
        if (fabricaRefeicao == null) {
            throw new IllegalArgumentException("A fábrica de refeição não pode ser nula.");
        }

        // Utiliza a fábrica abstrata para criar os produtos da família específica
        PratoPrincipal pratoPrincipal = fabricaRefeicao.criarPratoPrincipal();
        Bebida bebida = fabricaRefeicao.criarBebida();
        Sobremesa sobremesa = fabricaRefeicao.criarSobremesa();

        // Retorna o pedido consolidado com os itens gerados
        return new Pedido(pratoPrincipal, bebida, sobremesa);
    }
}