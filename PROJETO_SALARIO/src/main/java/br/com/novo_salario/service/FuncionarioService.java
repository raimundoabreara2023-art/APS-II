package br.com.novo_salario.service;

import br.com.novo_salario.modelo.Estagiario;
import br.com.novo_salario.modelo.Funcionario;
import br.com.novo_salario.modelo.FuncionarioCLT;
import br.com.novo_salario.modelo.Gerente;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioService {
    private List<Funcionario> listaFuncionarios = new ArrayList<>();

    public void adicionarFuncionario(Funcionario funcionario) {
        if (funcionario != null) {
            listaFuncionarios.add(funcionario);
        }
    }

    public List<Funcionario> listarFuncionarios() {
        return listaFuncionarios;
    }

    // Método para carregar os dados de exemplo exigidos pelo exercício
    public void carregarDadosExemplo() {
        listaFuncionarios.clear();

        // 1. Funcionario
        listaFuncionarios.add(new Funcionario("Ana Costa", "F001", 2500, "01/03/2020"));

        // 2. FuncionarioCLT
        listaFuncionarios.add(new FuncionarioCLT("Bruno Reis", "C001", 3000, "10/06/2021", 220, 400));

        // 3. Gerente
        listaFuncionarios.add(new Gerente("Carla Mendes", "G001", 8000, "15/01/2018", 300, 500, 12, 0.20));

        // 4. Estagiario
        listaFuncionarios.add(new Estagiario("Diego Alves", "E001", 0, "05/08/2024", 1500, 20));
    }
}