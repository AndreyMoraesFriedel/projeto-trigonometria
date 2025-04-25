package com.projeto.trigonometria;

import javax.swing.JFrame;

public class Interface {

    public Interface() {
    
        JFrame inicial = new JFrame("Tela Inicial");
        inicial.setSize(500, 500);
        inicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicial.setLocationRelativeTo(null); 
        inicial.setVisible(true); 
    }

    // area teste dos guri
    public static void main(String[] args) {
        new Interface();
    }
}
