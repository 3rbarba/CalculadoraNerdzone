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
    private JTextField bolsa;
    private JTextField presidente;
    private JTextField booster;
    private JList capacete;
    private JList peitoral;
    private JList calca;
    private JList bota;
    private JList herbalismo;
    private JList mineracao;
    private JList itemList;
    private JList rank;
    private JButton calcular;
    private JTextPane Total;
    private JRadioButton compButton;
    private JTextField QuantItens;

    private void createUIComponents() {
        capacete = new JList();
        peitoral = new JList();
        calca = new JList();
        bota = new JList();
        bolsa = new JTextField();
        itemList = new JList();
        presidente = new JTextField();
        herbalismo = new JList();
        mineracao = new JList();
    }
    public void run() {
        JFrame frame = new JFrame("Calculadora Nerdzone");
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
        calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Controller.Verif(getItem(), getCompButton(), compButton, herbalismo, mineracao, presidente, rank);
                    double tot = Calculo.calculo(Precobase(getItem()),
                            RankBase(getRank()),
                            armor(getCapacete(), getPeitoral(), getCalca(), getBota()),
                            skill(getHerbalismo(), getMineracao()),
                            getBolsa(),
                            getPresidente(),
                            getBooster(), getCompButton(), String.valueOf(Controller.Quantitens(getQuantItens())));
                    String totF = String.format("%.0f", tot);
                    String Formattot = Controller.FormatTotal(totF, tot);
                    Total.setText(Formattot);
                    Total.setForeground(new Color(0, 0, 0));
                    Total.setFont(new Font("Consolas", Font.BOLD, 20));

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
            return (item != null) ? item : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public String getRank() {
        String Rank = rank.getSelectedValue().toString();
        return (Rank != null) ? Rank.toString() : "";
    }

    public String getCapacete() {
        String Capacete = capacete.getSelectedValue().toString();
        return Capacete;
    }

    public String getPeitoral() {
        String Peitoral = peitoral.getSelectedValue().toString();
        return Peitoral;
    }

    public String getCalca() {
        String Calca = calca.getSelectedValue().toString();
        return Calca;
    }

    public String getBota() {
        String Bota = bota.getSelectedValue().toString();
        return Bota;
    }

    public String getHerbalismo() {
        String Herbalismo = herbalismo.getSelectedValue().toString();
        return Herbalismo;
    }

    public String getMineracao() {
        String Mineracao = mineracao.getSelectedValue().toString();
        return Mineracao;
    }

    public String getPresidente() {
        String Presidente = presidente.getText();
        return Presidente;
    }

    public String getBolsa() {
        String Bolsa = bolsa.getText();
        return Bolsa;
    }

    public String getBooster() {
        String Booster = booster.getText();
        return Booster;
    }

    public boolean getCompButton() {
        boolean CompButton = compButton.isSelected();
        return CompButton;
    }

    public String getQuantItens() {
        String quantItens = QuantItens.getText();
        return (quantItens != null) ? quantItens : "";
    }

}
