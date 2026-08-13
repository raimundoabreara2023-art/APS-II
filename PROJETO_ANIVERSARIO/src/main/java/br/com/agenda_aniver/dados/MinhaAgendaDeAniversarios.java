package br.com.agenda_aniver.dados;

import br.com.agenda_aniver.modelo.Aniversariante;
import java.util.ArrayList;
import java.util.List;

public class MinhaAgendaDeAniversarios implements AgendaDeAniversarios {
    
    private List<Aniversariante> aniversariantes;

    public MinhaAgendaDeAniversarios() {
        this.aniversariantes = new ArrayList<>();
    }

    @Override
    public void adicionarAniversariante(Aniversariante a) {
        this.aniversariantes.add(a);
    }

    @Override
    public void removerAniversariante(Aniversariante a) {
        // Usa o método equals da classe Aniversariante para encontrar e remover
        this.aniversariantes.remove(a);
    }

    public List<Aniversariante> getAniversariantes() {
        return aniversariantes;
    }
}