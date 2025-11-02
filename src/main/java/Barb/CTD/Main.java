package Barb.CTD;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        panel Painel = new panel();
        SwingUtilities.invokeLater(() -> {
            Painel.run();});
    }
}