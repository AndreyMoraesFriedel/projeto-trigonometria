package com.projeto.trigonometria;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.NumberTickUnit;

import javax.swing.*;
import java.util.Scanner;

public class CartesianPlaneChart {
    public void mostrarGrafico() {
        Scanner scanner = new Scanner(System.in);
        XYSeries series = new XYSeries("Pontos");

        // Pergunta os pontos//
        System.out.print("Quantos pontos você deseja adicionar? ");
        int quantidade = scanner.nextInt();

        for (int i = 1; i <= quantidade; i++) {
            System.out.print("Digite o valor de X do ponto " + i + ": ");
            double x = scanner.nextDouble();

            System.out.print("Digite o valor de Y do ponto " + i + ": ");
            double y = scanner.nextDouble();

            series.add(x, y);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createScatterPlot(
                "Plano Cartesiano",
                "Eixo X",
                "Eixo Y",
                dataset,
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new java.awt.Dimension(800, 600));

        JFrame frame = new JFrame("Plano Cartesiano");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        XYPlot plot = chart.getXYPlot();

        //Linha do eixo X e Y//
        plot.setDomainCrosshairVisible(true); // linha no eixo X
        plot.setRangeCrosshairVisible(true);  // linha no eixo Y
        plot.setDomainCrosshairValue(0);      // centraliza no X = 0
        plot.setRangeCrosshairValue(0);       // centraliza no Y = 0

        // Configurações dos eixos X e Y //
        NumberAxis eixoX = (NumberAxis) plot.getDomainAxis();
        eixoX.setTickUnit(new NumberTickUnit(1)); // Ticks de 1 em 1

        NumberAxis eixoY = (NumberAxis) plot.getRangeAxis();
        eixoY.setTickUnit(new NumberTickUnit(1)); // Ticks de 1 em 1

        // Configura o range dos eixos X e Y //
        eixoX.setRange(-10, 10); // mostra de -10 a 10 no eixo X
        eixoY.setRange(-10, 10); // mostra de -10 a 10 no eixo Y

        scanner.close();      
    }

    public void calcularDistanciaEntrePontos() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Digite as coordenadas do primeiro ponto:");
        System.out.print("X1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Y1: ");
        double y1 = scanner.nextDouble();
    
        System.out.println("Digite as coordenadas do segundo ponto:");
        System.out.print("X2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Y2: ");
        double y2 = scanner.nextDouble();
    
        double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.printf("A distância entre os pontos é: %.4f\n", distancia);
    
        scanner.close();
    }
}
