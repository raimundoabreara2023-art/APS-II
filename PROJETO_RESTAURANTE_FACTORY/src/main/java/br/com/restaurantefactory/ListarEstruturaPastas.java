package br.com.restaurantefactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class ListarEstruturaPastas {

    public static void main(String[] args) {

        File rootDir = new File(
                "C:/Users/raimu/Faculdade/4_semestre/Analise_e_Projeto_de_Sistemas_II/PROJETO_RESTAURANTE_FACTORY");

        String dataHoraArquivo =
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        File saida = new File("estrutura_projeto_" + dataHoraArquivo + ".txt");

        try (PrintWriter writer = new PrintWriter(new FileWriter(saida))) {

            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatoExibicao =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            writer.println("=================================================");
            writer.println("ESTRUTURA DO PROJETO");
            writer.println("Gerado em: " + agora.format(formatoExibicao));
            writer.println("=================================================\n");

            writer.println("=== VERSÃO ENXUTA (somente pastas e arquivos) ===\n");
            imprimirEstruturaEnxuta(rootDir, "", writer);

            writer.println("\n=== VERSÃO DETALHADA (com código) ===\n");
            imprimirEstruturaDetalhada(rootDir, "", writer);

            System.out.println("Estrutura gerada em: "
                    + saida.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Define arquivos/pastas que não devem aparecer no relatório
     */
    private static boolean deveIgnorar(File arquivo) {

        String nome = arquivo.getName();

        return nome.equals("target")
                || nome.equals("ListarEstruturaPastas.java")
                || nome.equals("ListarEstruturaPastas.class")
                || nome.startsWith("estrutura_projeto_");
    }

    private static void imprimirEstruturaEnxuta(
            File dir,
            String indentacao,
            PrintWriter writer) {

        if (deveIgnorar(dir)) {
            return;
        }

        if (dir.isDirectory()) {

            writer.println(indentacao + "[DIR] " + dir.getName());

            File[] arquivos = dir.listFiles();

            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    imprimirEstruturaEnxuta(
                            arquivo,
                            indentacao + "   ",
                            writer);
                }
            }

        } else {

            writer.println(indentacao + dir.getName());
        }
    }

    private static void imprimirEstruturaDetalhada(
            File dir,
            String indentacao,
            PrintWriter writer) {

        if (deveIgnorar(dir)) {
            return;
        }

        if (dir.isDirectory()) {

            writer.println(indentacao + "[DIR] " + dir.getName());

            File[] arquivos = dir.listFiles();

            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    imprimirEstruturaDetalhada(
                            arquivo,
                            indentacao + "   ",
                            writer);
                }
            }

        } else {

            writer.println(indentacao + dir.getName());

            if (dir.getName().endsWith(".java")
                    || dir.getName().endsWith(".xml")
                    || dir.getName().endsWith(".fxml")
                    || dir.getName().endsWith(".txt")
                    || dir.getName().endsWith(".css")) {

                try (Stream<String> linhas = Files.lines(dir.toPath())) {

                    linhas.forEach(
                            linha -> writer.println(
                                    indentacao + "      " + linha));

                } catch (IOException e) {

                    writer.println(
                            indentacao + "      [ERRO ao ler arquivo]");
                }
            }
        }
    }
}