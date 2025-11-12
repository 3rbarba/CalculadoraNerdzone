package Barb.CTD;

import javax.swing.*;

public class Controller {

    public static String Verif(String item, boolean button, JRadioButton compButton, JList herbalismo, JList mineracao) {
        String result = "";
        if (item.contains("CABEÇA")) {
            herbalismo.setSelectedValue(1, true);
            mineracao.setSelectedValue(1, true);
            mineracao.setVisible(false);
            herbalismo.setVisible(false);
            if (button) {
                compButton.setSelected(false);
                JOptionPane.showMessageDialog(null, "Não ultilize essa opção para cabeças");
            }
            return result;
        }
        if (button && (item.contains("MINERIO") || item.contains("LINGOTE") || item.equals("REDSTONE        |"))) {
            compButton.setSelected(false);
            JOptionPane.showMessageDialog(null, "Esse item não pode ser compactado");
            return result;
        }
        String[] miner = {"OURO", "REDSTONE"};
        String[] herba = {"CACTO", "ABÓBORA", "FUNGO"};

        for (String s : miner) {
            if (item.contains(s)) {
                herbalismo.setSelectedIndex(1);
                mineracao.setVisible(true);
                herbalismo.setVisible(false);
            }
        }
        for (String s : herba) {
            if (item.contains(s)) {
                mineracao.setSelectedIndex(1);
                herbalismo.setVisible(true);
                mineracao.setVisible(false);
            }
        }

        return result;
    }


    private static final java.util.Map<String, Integer> SUFIXOS_MAP = new java.util.HashMap<>();

    static {
        SUFIXOS_MAP.put("K", 1);
        SUFIXOS_MAP.put("M", 2);
        SUFIXOS_MAP.put("B", 3);
        SUFIXOS_MAP.put("T", 4);
        SUFIXOS_MAP.put("Q", 5);
        SUFIXOS_MAP.put("QQ", 6);
        //
        SUFIXOS_MAP.put("k", 1);
        SUFIXOS_MAP.put("m", 2);
        SUFIXOS_MAP.put("b", 3);
        SUFIXOS_MAP.put("t", 4);
        SUFIXOS_MAP.put("q", 5);
        SUFIXOS_MAP.put("qq", 6);
    }

    public static long Quantitens(String QuantItens) {
        switch (QuantItens.toLowerCase()) {
            case "bau":
                return 1728;
            case "baú":
                return 1728;
            case "inv":
                return 2304;
            case "inventario":
                return 2304;
        }
        if (QuantItens.isEmpty()) {
            return 1;
        }
        String Numero;
        String Sufixo;

        int suffixPower = 0;

        for (String suffix : SUFIXOS_MAP.keySet()) {
            if (QuantItens.endsWith(suffix) && suffix.length() > 0) {
                Numero = QuantItens.substring(0, QuantItens.length() - suffix.length());
                Sufixo = suffix;
                suffixPower = SUFIXOS_MAP.get(Sufixo);

                long baseValue = Long.parseLong(Numero);

                long multiplier = (long) Math.pow(1000, suffixPower);

                return baseValue * multiplier;
            }
        }

        return Long.parseLong(QuantItens);
    }

    private static final String[] SUFIXOS = {"K", "M", "B", "T", "Q", "QQ", "S"};


    public static String FormatTotal(String total, double totD) {
        int length = total.length();
        if (length < 4) {
            total = String.format("%.2f", totD);
            return total;
        }

        int suffixIndex = (length - 1) / 3;

        if (suffixIndex >= SUFIXOS.length) {
            return total;
        }

        String sufixo = SUFIXOS[suffixIndex];

        int numCharsToTake = length % 3;
        if (numCharsToTake == 0) {
            numCharsToTake = 3;
        }

        total = total.substring(0, numCharsToTake) + sufixo;

        return total;
    }
}
