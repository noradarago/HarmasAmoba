import java.util.Scanner;

public class Main {
    public static void tablaRajzol(String[][] tabla) {
        System.out.println("    1   2   3  ");
        System.out.println("  +---+---+---+");
        System.out.println("A | " + tabla[0][0] + " | " + tabla[0][1] + " | " + tabla[0][2] + " |");
        System.out.println("  +---+---+---+");
        System.out.println("B | " + tabla[1][0] + " | " + tabla[1][1] + " | " + tabla[1][2] + " |");
        System.out.println("  +---+---+---+");
        System.out.println("C | " + tabla[2][0] + " | " + tabla[2][1] + " | " + tabla[2][2] + " |");

    }

    public static void tablaInit(String[][] tabla) {
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                tabla[i][j] = " ";
            }
        }
    }

    public static int sormegad(String lep1) {
        int sor = -1;
        switch (lep1) {
            case "A":
                sor = 0;
                break;
            case "B":
                sor = 1;
                break;
            case "C":
                sor = 2;
                break;
        }
        return sor;
    }

    public static int oszlopmegad(String lep2) {
        int oszlop = -1;
        switch (lep2) {
            case "1":
                oszlop = 0;
                break;
            case "2":
                oszlop = 1;
                break;
            case "3":
                oszlop = 2;
                break;
        }
        return oszlop;
    }

    public static boolean joLepes(String[][] tabla, int sor, int oszlop) {
        boolean jolepes = true;
        if (sor < 0 || oszlop < 0) {
            jolepes = false;
            System.out.println("A lépésben A,B,C, 1,2,3 szerepelhet");
        } else if (!tabla[sor][oszlop].equals(" ")) {
            jolepes = false;
            System.out.println("Ez a hely már foglalt");
        }

       /* if (!(lep1.equals("A") || lep1.equals("B") || lep1.equals("C")
                && lep2.equals("1") || lep2.equals("2") || lep2.equals("3"))) {
            jolepes = false;
        }

        if (!(tabla[sormegad(lep1)][oszlopmegad(lep2)].equals(" "))) {
            jolepes = false;

        }*/
        return jolepes;
    }

    public static String nyertesVizsgal(String[][] tabla) {
        String jatekos = "hiba";
        if (tabla[0][0].equals(tabla[0][1]) && tabla[0][1].equals(tabla[0][2]) && (tabla[0][0].equals("X"))) {
            jatekos = "X";
        } else if (tabla[0][0].equals(tabla[0][1]) && tabla[0][1].equals(tabla[0][2]) && (tabla[0][0].equals("O"))) {
            jatekos = "O";
        }
        if (tabla[1][0].equals(tabla[1][1]) && tabla[1][1].equals(tabla[1][2]) && (tabla[1][0].equals("X"))) {
            jatekos = "X";
        } else if (tabla[1][0].equals(tabla[1][1]) && tabla[1][1].equals(tabla[1][2]) && (tabla[1][0].equals("O"))) {
            jatekos = "O";
        }
        if (tabla[2][0].equals(tabla[2][1]) && tabla[2][1].equals(tabla[2][2]) && (tabla[2][0].equals("X"))) {
            jatekos = "X";
        } else if (tabla[2][0].equals(tabla[2][1]) && tabla[2][1].equals(tabla[2][2]) && (tabla[2][0].equals("O"))) {
            jatekos = "O";
        }

        if (tabla[0][0].equals(tabla[1][0]) && tabla[1][0].equals(tabla[2][0]) && (tabla[0][0].equals("X"))) {
            jatekos = "X";
        } else if (tabla[0][0].equals(tabla[1][0]) && tabla[1][0].equals(tabla[2][0]) && (tabla[0][0].equals("O"))) {
            jatekos = "O";
        }
        if (tabla[0][1].equals(tabla[1][1]) && tabla[1][1].equals(tabla[2][1]) && (tabla[0][1].equals("X"))) {
            jatekos = "X";
        } else if (tabla[0][1].equals(tabla[1][1]) && tabla[1][1].equals(tabla[2][1]) && (tabla[0][1].equals("O"))) {
            jatekos = "O";
        }
        if (tabla[0][2].equals(tabla[1][2]) && tabla[1][2].equals(tabla[2][2]) && (tabla[0][2].equals("X"))) {
            jatekos = "X";
        } else if (tabla[0][2].equals(tabla[1][2]) && tabla[1][2].equals(tabla[2][2]) && (tabla[0][2].equals("O"))) {
            jatekos = "O";
        }
        if (tabla[0][0].equals(tabla[1][1]) && tabla[1][1].equals(tabla[2][2]) && (tabla[0][0].equals("X"))) {
            jatekos = "X";
        } else if (tabla[0][0].equals(tabla[1][1]) && tabla[1][1].equals(tabla[2][2]) && (tabla[0][0].equals("O"))) {
            jatekos = "O";
        }
        if (tabla[0][2].equals(tabla[1][1]) && tabla[1][1].equals(tabla[2][0]) && (tabla[0][2].equals("X"))) {
            jatekos = "X";
        } else if (tabla[0][2].equals(tabla[1][1]) && tabla[1][1].equals(tabla[2][0]) && (tabla[0][2].equals("O"))) {
            jatekos = "O";
        }
        return jatekos;
    }
    public static String jatekosCsere(String aktJatekos){
        if (aktJatekos.equals("X")) {
            return "O";
        } else {
            return "X";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String aktJatekos = "X";
        String[][] tabla = new String[3][3];
        tablaInit(tabla);
        String lep1;
        String lep2;

        boolean vege = false;


        do {
            boolean jolepes;
            tablaRajzol(tabla);//játékciklus innen
            int sor;
            int oszlop;
            boolean szabadhely = false;
            do {//bekérés ciklus innen
                System.out.println("Kérem " + aktJatekos + "játékos lépését: ");
                String lepes = sc.nextLine();
                lepes = lepes.toUpperCase();

                lep1 = lepes.substring(0, 1);//lépés első karaktere
                lep2 = lepes.substring(1);//lépés 2 karaktere

                sor = sormegad(lep1);//első karakter A;B;C - átalakítani indexekre [0][0]pl
                oszlop = oszlopmegad(lep2);//második karakter 1,2,3

                jolepes = true;
                if (sor < 0 || oszlop < 0) {
                    jolepes = false;
                    System.out.println("A lépésben A,B,C, 1,2,3 szerepelhet");
                } else if (!tabla[sor][oszlop].equals(" ")) {
                    jolepes = false;
                    System.out.println("Ez a hely már foglalt");
                }


            } while (!jolepes);//bekérés ciklus eddig
            //ha a lépés helyes, berakjuk a táblára az aktJatekostb
            tabla[sor][oszlop] = aktJatekos;

            if (nyertesVizsgal(tabla).equals("X") || nyertesVizsgal(tabla).equals("O")) {
                System.out.println("Gratulálunk " + aktJatekos + ", nyertél!");
                vege = true;
            }
            for (int i = 0; i < tabla.length; i++) {
                for (int j = 0; j < tabla.length; j++) {
                    if ((tabla[i][j].equals(" "))) {
                        szabadhely = true;
                    }
                }
            }

            if (!szabadhely && !vege) {
                System.out.println("Döntetlen");

            }
            //  vege = true;
            aktJatekos = jatekosCsere(aktJatekos);

            //nyertesvizsgálat
            //iftabla00equals tabla01 és tabla 02 és ez equals xvagy 0
            // ha van nyertes, vagy döntetlen
            //ha még nincs vége, akkor aktJatekos csere if(aktJatekos.equals(x)) { aktJatekos = O}else{ aktJatekos =X}

        }

        while (!vege);//játékciklus idáig
        //ha vége, kiirjuk az eredmenyt


    }

}


