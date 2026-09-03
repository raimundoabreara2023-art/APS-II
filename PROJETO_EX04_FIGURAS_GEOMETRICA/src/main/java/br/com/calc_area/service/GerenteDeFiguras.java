package br.com.calc_area.service;

import br.com.calc_area.modelo.FiguraGeometrica;
import java.util.ArrayList;
import java.util.List;

public class GerenteDeFiguras {
    private List<FiguraGeometrica> figuras;

    public GerenteDeFiguras() {
        this.figuras = new ArrayList<>();
    }

    public void adicionaFigura(FiguraGeometrica figura) {
        this.figuras.add(figura);
    }

    public List<FiguraGeometrica> getFiguras() {
        return figuras;
    }

    public double calculaAreaTotalDeFiguras() {
        double total = 0;
        for (FiguraGeometrica f : figuras) {
            total += f.calculaArea();
        }
        return total;
    }

    public double getMaiorAreaDeFigura() {
        if (figuras.isEmpty()) return 0;
        double maior = figuras.get(0).calculaArea();
        for (int i = 1; i < figuras.size(); i++) {
            double areaAtual = figuras.get(i).calculaArea();
            if (areaAtual > maior) {
                maior = areaAtual;
            }
        }
        return maior;
    }

    public String imprimeFiguras() {
        StringBuilder sb = new StringBuilder();
        for (FiguraGeometrica f : figuras) {
            sb.append(f.getNomeFigura()).append(" - Área: ").append(f.calculaArea()).append("\n");
        }
        return sb.toString();
    }
}