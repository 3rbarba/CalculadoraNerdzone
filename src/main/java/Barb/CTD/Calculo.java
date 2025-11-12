package Barb.CTD;

public class Calculo {
    public static double calculo(double preco, double rank, double armor, double skill, String bolsa, String presidente, String booster, boolean compButton, String QuantItem) {
        double total;
        total = preco;
        double booste = Double.parseDouble(String.valueOf(Double.parseDouble(String.valueOf(booster).replace(",", "."))));
        if(bolsa != "0")total += total * (Double.parseDouble(String.valueOf(bolsa).replace(",", ".")) / 100);
        if(skill != 0)total += total * (skill / 100);
        if(rank != 0)total += total * (rank / 100);
        if(presidente != "0")total -= total * (Double.parseDouble(String.valueOf(presidente).replace(",", ".")) / 100);
        if(armor != 0)total *= armor;
        if(booste != 0) total *= booste;
        if(compButton) total = total * 64;
        total = total * Double.parseDouble(QuantItem);
        return total;
    }
}
