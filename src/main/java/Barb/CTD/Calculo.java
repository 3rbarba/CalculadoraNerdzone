package Barb.CTD;

import java.util.SplittableRandom;

public class Calculo {
    public static double calculo(double preco, double rank, double armor, double skill, String bolsa, String presidente, String booster, boolean compButton, String qitenInv, String QuantItem) {
        switch (qitenInv) {
            case "Unidade":
                qitenInv = String.valueOf(1);
                break;
            case "Baú":
                qitenInv = String.valueOf(1728);
                break;
            case "Inventário":
                qitenInv = String.valueOf(2304);
                break;
            case "Baú duplo":
                qitenInv = String.valueOf(3456);
                break;
        }
        double total;
        total = preco;
        double booste = Double.parseDouble(String.valueOf(Double.parseDouble(String.valueOf(booster).replace(",", "."))));
        if(bolsa != "0")total += total * (Double.parseDouble(String.valueOf(bolsa).replace(",", ".")) / 100);
        if(rank != 0)total += total * (rank / 100);
        if(skill != 0)total += total * (skill / 100);
        if(presidente != "0")total -= total * (Double.parseDouble(String.valueOf(presidente).replace(",", ".")) / 100);
        if(armor != 0)total *= armor;
        if(booste != 0) total *= booste;
        if(compButton) total = total * 64;
        total = total * Double.parseDouble(QuantItem);
        total = total * Long.parseLong(qitenInv);
        System.out.println(total);
        return total;
    }
}
