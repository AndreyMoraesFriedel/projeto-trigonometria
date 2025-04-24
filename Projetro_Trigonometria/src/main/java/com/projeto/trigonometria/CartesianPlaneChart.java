package com.projeto.trigonometria;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.NumberTickUnit;
import java.awt.BorderLayout;

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

    /////////////mostrar reta grafico////////////

    public void mostrarGraficoComReta() {
        Scanner scanner = new Scanner(System.in);
    
        // Série da reta
        XYSeries reta = new XYSeries("Reta");
    
        System.out.println("Defina dois pontos para desenhar uma reta:");
        System.out.print("X1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("X2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Y2: ");
        double y2 = scanner.nextDouble();
    
        reta.add(x1, y1);
        reta.add(x2, y2);
    
        // Dataset com apenas a reta
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(reta);
    
        // Gráfico de linha
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Reta no Plano Cartesiano",
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
    
        JFrame frame = new JFrame("Reta no Plano Cartesiano");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    
        XYPlot plot = chart.getXYPlot();
    
        // Eixos e grade
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);
        plot.setDomainCrosshairValue(0);
        plot.setRangeCrosshairValue(0);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinesVisible(true);
    
        NumberAxis eixoX = (NumberAxis) plot.getDomainAxis();
        eixoX.setTickUnit(new NumberTickUnit(1));
        eixoX.setRange(-10, 10);
    
        NumberAxis eixoY = (NumberAxis) plot.getRangeAxis();
        eixoY.setTickUnit(new NumberTickUnit(1));
        eixoY.setRange(-10, 10);
        scanner.close();
    }

    ///////////// mostrar reta com todas informçoes  /////////////{

        public void mostrarGraficoComRetaInclinação() {
            Scanner scanner = new Scanner(System.in);
    
            // Pergunta os dois pontos
            System.out.println("Defina dois pontos para desenhar uma reta:");
            System.out.print("X1: ");
            double x1 = scanner.nextDouble();
            System.out.print("Y1: ");
            double y1 = scanner.nextDouble();
            System.out.print("X2: ");
            double x2 = scanner.nextDouble();
            System.out.print("Y2: ");
            double y2 = scanner.nextDouble();
    
            // Calculando a inclinação (coeficiente angular)
            double m = (y2 - y1) / (x2 - x1);  // Inclinação
            // Calculando o intercepto com o eixo Y
            double b = y1 - m * x1;  // Interceptação com Y
            // Calculando o intercepto com o eixo X (se m != 0)
            double x_intercept = (m != 0) ? -b / m : 0;
    
            // Calculando a direção da reta
            String direcao = (m > 0) ? "Crescente (positiva)" : (m < 0) ? "Decrescente (negativa)" : "Horizontal (zero)";
    
            // Calculando o ângulo de inclinação
            double angulo = Math.toDegrees(Math.atan(m)); // ângulo em graus
    
            // Exibindo os resultados no console
            System.out.println("\nPropriedades da Reta:");
            System.out.println("Inclinação (m): " + m);
            System.out.println("Interceptação com o eixo Y (b): " + b);
            System.out.println("Interceptação com o eixo X: " + x_intercept);
            System.out.println("Direção da reta: " + direcao);
            System.out.println("Ângulo de inclinação: " + angulo + "°");
    
            // Criando a reta
            XYSeries reta = new XYSeries("Reta");
            reta.add(x1, y1);
            reta.add(x2, y2);
    
            // Adicionando a reta no dataset
            XYSeriesCollection dataset = new XYSeriesCollection();
            dataset.addSeries(reta);
    
            // Criando o gráfico
            JFreeChart chart = ChartFactory.createXYLineChart(
                    "Reta no Plano Cartesiano",
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
    
            // Criando o frame
            JFrame frame = new JFrame("Reta no Plano Cartesiano");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(panel, BorderLayout.CENTER);
    
            // Criando o painel de informações
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
    
            // Adicionando as informações ao painel
            JLabel inclinaçãoLabel = new JLabel("Inclinação (m): " + m);
            JLabel interceptoYLabel = new JLabel("Interceptação com o eixo Y (b): " + b);
            JLabel interceptoXLabel = new JLabel("Interceptação com o eixo X: " + x_intercept);
            JLabel direçãoLabel = new JLabel("Direção da reta: " + direcao);
            JLabel anguloLabel = new JLabel("Ângulo de inclinação: " + angulo + "°");
    
            infoPanel.add(inclinaçãoLabel);
            infoPanel.add(interceptoYLabel);
            infoPanel.add(interceptoXLabel);
            infoPanel.add(direçãoLabel);
            infoPanel.add(anguloLabel);
    
            // Adicionando o painel de informações ao frame
            frame.getContentPane().add(infoPanel, BorderLayout.EAST);
    
            // Exibindo o frame
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
    
            // Definindo as propriedades dos eixos
            XYPlot plot = chart.getXYPlot();
            plot.setDomainCrosshairVisible(true);
            plot.setRangeCrosshairVisible(true);
            plot.setDomainCrosshairValue(0);
            plot.setRangeCrosshairValue(0);
    
            NumberAxis eixoX = (NumberAxis) plot.getDomainAxis();
            eixoX.setTickUnit(new NumberTickUnit(1));
            eixoX.setRange(-10, 10);
    
            NumberAxis eixoY = (NumberAxis) plot.getRangeAxis();
            eixoY.setTickUnit(new NumberTickUnit(1));
            eixoY.setRange(-10, 10);
        }
    }