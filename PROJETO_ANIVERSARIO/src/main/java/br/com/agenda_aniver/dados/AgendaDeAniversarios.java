package br.com.agenda_aniver.dados;

import br.com.agenda_aniver.modelo.Aniversariante;

public interface AgendaDeAniversarios {
    void adicionarAniversariante(Aniversariante a);
    void removerAniversariante(Aniversariante a);
}