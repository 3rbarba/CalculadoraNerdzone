package Barb.CTD;

public class preco {

    private static double precoBase;
    private static double rankMultiplier;
    private static double armaduraMultiplier;
    private static double skillMultiplier;

    public static double Precobase(String item) {
        // Preço base do item
        switch (item) {
            case "MINERIO DE OURO |":
                precoBase = 4.5;
                break;
            case "LINGOTE DE OURO |":
                precoBase = 18.4;
                break;
                //Bloco é *1.1027
            case "BLOCO DE OURO   |":
                precoBase =182.6;
                break;
            case "OURO COMP.      |":
                precoBase = 5843.2;
                break;
            case "REDSTONE        |":
                precoBase = 4.5;
                break;
            case "BLOCO DE RED    |":
                precoBase = 27;
                break;
            case "FUNGO           |":
                precoBase = 3;
                break;
            case "CACTO           |":
                precoBase = 4.2;
                break;
            case "ABÓBORA         |":
                precoBase = 180;
                break;
            case "CABEÇA DE GAL.  |":
                precoBase = 4;
                break;
            case "CABEÇA DE PORCO |":
                precoBase = 16;
                break;
            case "CABEÇA DE OVELHA|":
                precoBase = 25;
                break;
            case "CABEÇA DE VACA  |":
                precoBase = 180;
                break;
            case "CABEÇA DE ZUMBI |":
                precoBase = 1000;
                break;
            default:
                precoBase = 0;
        }
        return precoBase;
    }

    public static double RankBase(String rank) {
        // Modificador de rank
        switch (rank.toString()) {
            case "AprendizI       |":
                rankMultiplier = 0;
                break;
            case "AprendizII      |":
                rankMultiplier = 10;
                break;
            case "AprendizIII     |":
                rankMultiplier = 20;
                break;
            case "ExploradorI     |":
                rankMultiplier = 30;
                break;
            case "ExploradorII    |":
                rankMultiplier = 40;
                break;
            case "ExploradorIII   |":
                rankMultiplier = 50;
                break;
            case "ConquistadorI   |":
                rankMultiplier = 60;
                break;
            case "ConquistadorII  |":
                rankMultiplier = 70;
                break;
            case "ConquistadorIII |":
                rankMultiplier = 80;
                break;
            case "MestreI         |":
                rankMultiplier = 90;
                break;
            case "MestreII        |":
                rankMultiplier = 100;
                break;
            case "MestreIII       |":
                rankMultiplier = 110;
                break;
            case "GuardiãoI       |":
                rankMultiplier = 120;
                break;
            case "GuardiãoII      |":
                rankMultiplier = 130;
                break;
            case "GuardiãoIII     |":
                rankMultiplier = 140;
                break;
            default:
                rankMultiplier = 0;
        }
        return rankMultiplier;
    }

    public static double armor(String capacete, String peitoral, String calca, String bota) {
        double capaceteMultiplier;
        double peitoralMultiplier;
        double calcaMultiplier;
        double botaMultiplier;
        // Modificadores de armadura
        switch (capacete.toString()){
            case "Sem capacete":
                capaceteMultiplier = 1;
                break;
            case "1.1x":
                capaceteMultiplier = 1.1;
                break;
            case "1.4x":
                capaceteMultiplier = 1.3;
                break;
            default:
                capaceteMultiplier = 1;
        }
        switch (peitoral.toString()){
            case "Sem peitoral":
                peitoralMultiplier = 1;
                break;
            case "1.1x":
                peitoralMultiplier = 1.1;
                break;
            case "1.3x":
                peitoralMultiplier = 1.3;
                break;
            case "1.4X":
                peitoralMultiplier = 1.4;
                break;
            default:
                peitoralMultiplier = 1;
        }
        switch (calca.toString()){
            case "Sem calça":
                calcaMultiplier = 1;
                break;
            case "1.1x":
                calcaMultiplier = 1.1;
                break;
            case "1.3x":
                calcaMultiplier = 1.3;
                break;
            case "1.4x":
                calcaMultiplier = 1.4;
                break;
            default:
                calcaMultiplier = 1;
        }
        switch (bota.toString()){
            case "Sem bota":
                botaMultiplier = 1;
                break;
            case "1.1x":
                botaMultiplier = 1.1;
                break;
            case "1.3x":
                botaMultiplier = 1.3;
                break;
            default:
                botaMultiplier = 1;
        }
        armaduraMultiplier = capaceteMultiplier * peitoralMultiplier * calcaMultiplier * botaMultiplier;
        return armaduraMultiplier;
    }

    public static double skill(String herbalismo, String mineracao) {
        //modificadores de skills
        double skillH = 0;
        double skillM = 0;
        switch (herbalismo.toString()) {
            case "Herbalismo":
                skillH = 0;
                break;
            case "Mais de 300":
                skillH = 3;
                break;
            default:
                skillH = 0;
        }
        switch (mineracao.toString()) {
            case "Mineração":
                skillM = 0;
                break;
            case "Mais de 250":
                skillM += 5;
                break;
            case "Mais de 600":
                skillM += 7;
                break;
            case "Mais de 1000":
                skillM += 10;
                break;
            default:
                skillM = 0;
        }
        skillMultiplier = skillM + skillH;
        return skillMultiplier;
    }
}

