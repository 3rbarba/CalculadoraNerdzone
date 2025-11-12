package Barb.CTD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Barb.CTD.preco.*;

public class panel {
    private JPanel Calc;
    private JTextArea Titulotxt;
    private JTextArea ARMADURAtxt;
    private JTextArea bolsatxt;
    private JTextArea presidentetxt;
    private JTextArea Skilltxt;
    private JTextArea ranktxt;
    private JTextArea itemtxt;
    private JTextArea boostertxt;
    private JTextArea QuantItenstxt;
    private JTextField Bolsa;
    private JTextField presidente;
    private JTextField booster;
    private JList Capacete;
    private JList peitoral;
    private JList Calca;
    private JList bota;
    private JList herbalismo;
    private JList Mineração;
    private JList itemList;
    private JList rank;
    private JButton Calcular;
    private JTextPane Total;
    private JRadioButton compButton;
    private JTextField QuantItens;
    private JRadioButton DesatreButton;

    private void createUIComponents() {
        Capacete = new JList();
        peitoral = new JList();
        Calca = new JList();
        bota = new JList();
        Bolsa = new JTextField();
        itemList = new JList();
        presidente = new JTextField();
        herbalismo = new JList();
        Mineração = new JList();
    }

    public void run() {
        JFrame frame = new JFrame("Nerdzone Calculadora");
        frame.setContentPane(this.Calc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        ImageIcon imageIcon = new ImageIcon("src/main/resources/Icons/CalculatorPanel.png");
        frame.setIconImage(imageIcon.getImage());
        Botao();
    }

    public void Botao() {
        Calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (getItem().contains("CABEÇA") && getCompButton()) {
                        compButton.setSelected(false);
                        JOptionPane.showMessageDialog(null, "Não ultilize essa opção para cabeças");
                    }
                    double tot = calcular.calculo(Precobase(getItem()),
                            RankBase(getRank()),
                            armor(getCapacete(), getPeitoral(), getCalca(), getBota()),
                            skill(getHerbalismo(), getMineração()),
                            getBolsa(),
                            getPresidente(),
                            getBooster(), getCompButton());
                    double tot64x = tot * 64;
                    double tot2304x = tot * 2304;

                    String totF = String.format("%.2f", tot);
                    String totF64 = String.format("%.2f", tot64x);
                    String totF2304x = String.format("%.2f", tot2304x);
                    if (totF2304x.length() > 11){System.out.println(totF2304x.trim().chars());}
                    Total.setText("1x: " + totF + "  64x: " + totF64 + "  2304x: " + totF2304x);
                    Total.setForeground(new Color(50, 205, 50));
                    Total.setFont(new Font("Consolas", Font.BOLD, 12));


                } catch (
                        NullPointerException err) {
                    JOptionPane.showMessageDialog(null, "Erro ao calcular, verifique se todos os campos foram preenchidos corretamente.");
                } catch (
                        NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "Digite apena números");
                    System.out.println(err);
                }

            }
        });
    }

    public String getItem() {
        try {
            String item = itemList.getSelectedValue().toString();
            return item;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public String getRank() {
        String Rank = rank.getSelectedValue().toString();
        return Rank;
    }

    public String getCapacete() {
        String capacete = Capacete.getSelectedValue().toString();
        return capacete;
    }

    public String getPeitoral() {
        String Peitoral = peitoral.getSelectedValue().toString();
        return Peitoral;
    }

    public String getCalca() {
        String calca = Calca.getSelectedValue().toString();
        return calca;
    }

    public String getBota() {
        String Bota = bota.getSelectedValue().toString();
        return Bota;
    }

    public String getHerbalismo() {
        String Herbalismo = herbalismo.getSelectedValue().toString();
        return Herbalismo;
    }

    public String getMineração() {
        String mineração = Mineração.getSelectedValue().toString();
        return mineração;
    }

    public String getPresidente() {
        String Presidente = presidente.getText();
        return Presidente;
    }

    public String getBolsa() {
        String bolsa = Bolsa.getText();
        return bolsa;
    }

    public String getBooster() {
        String Booster = booster.getText();
        return Booster;
    }

    public boolean getCompButton() {
        boolean compButton = this.compButton.isSelected();
        return compButton;
    }

    public String getQuantItens() {
        String quantItens = QuantItens.getText();
        return quantItens;
    }

}
