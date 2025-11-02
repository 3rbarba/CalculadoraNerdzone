package Barb.CTD;

public class calcular {
    public static double calculo(double preco, double rank, double armor, double skill, String bolsa, String presidente, String booster) {
        double total;
        if (booster.equals("0")){booster = String.valueOf(1);}
        total = preco;
        if(skill != 0){total += total * (skill / 100);}
        if(rank != 0){total += total * (rank / 100);}
        if(bolsa != "0"){total += total * (Double.parseDouble(String.valueOf(bolsa).replace(",", ".")) / 100);}
        if(presidente != "0"){total -= total * (Double.parseDouble(String.valueOf(presidente).replace(",", ".")) / 100);}
        total *= Double.parseDouble(String.valueOf(booster).replace(",", "."));
        if(armor != 0){total *= armor;}
        return total;
    }
}
