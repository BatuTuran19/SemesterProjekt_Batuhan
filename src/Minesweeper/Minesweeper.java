package Minesweeper;

import java.util.Random;
import java.util.Scanner;

public class Minesweeper {

    static final int GROESSE = 9;
    static final int ANZAHL_MINEN = 10;

    static Feld[][] spielfeld = new Feld[GROESSE][GROESSE];

    static boolean ersterZug = true;
    static boolean verloren = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int z = 0; z < GROESSE; z++) {
            for (int s = 0; s < GROESSE; s++) {
                spielfeld[z][s] = new Feld();
            }
        }

        System.out.println("=== MINESWEEPER " + GROESSE + "x" + GROESSE + " (" + ANZAHL_MINEN + " Minen) ===");
        System.out.println("Befehle:");
        System.out.println("  a <zeile> <spalte>  -> Feld aufdecken   (z.B. a 3 5)");
        System.out.println("  m <zeile> <spalte>  -> Fahne setzen/entfernen");
        System.out.println("  q                   -> Beenden");

        while (!verloren && !gewonnen()) {
            spielfeldAusgeben(false);
            System.out.print("Dein Zug: ");
            String befehl = scanner.next().toLowerCase();

            if (befehl.equals("q")) {
                System.out.println("Spiel beendet.");
                return;
            }

            if (!scanner.hasNextInt()) {
                System.out.println("Ungueltige Eingabe!");
                scanner.nextLine();
                continue;
            }
            int zeile = scanner.nextInt() - 1;
            if (!scanner.hasNextInt()) {
                System.out.println("Ungueltige Eingabe!");
                scanner.nextLine();
                continue;
            }
            int spalte = scanner.nextInt() - 1;

            if (!imFeld(zeile, spalte)) {
                System.out.println("Zeile und Spalte muessen zwischen 1 und " + GROESSE + " liegen!");
                continue;
            }

            if (befehl.equals("a")) {
                aufdecken(zeile, spalte);
            } else if (befehl.equals("m")) {
                markieren(zeile, spalte);
            } else {
                System.out.println("Unbekannter Befehl: " + befehl);
            }
        }

        spielfeldAusgeben(true);
        if (verloren) {
            System.out.println("BOOM! Du hast eine Mine erwischt. Verloren!");
        } else {
            System.out.println("Glueckwunsch, du hast gewonnen!");
        }
    }

    // Minen werden erst nach dem ersten Zug verteilt, damit man nie sofort verliert
    static void minenVerteilen(int startZeile, int startSpalte) {
        Random zufall = new Random();
        int gesetzt = 0;
        while (gesetzt < ANZAHL_MINEN) {
            int z = zufall.nextInt(GROESSE);
            int s = zufall.nextInt(GROESSE);
            boolean amStart = Math.abs(z - startZeile) <= 1 && Math.abs(s - startSpalte) <= 1;
            if (!spielfeld[z][s].istMine && !amStart) {
                spielfeld[z][s].istMine = true;
                gesetzt++;
            }
        }

        for (int z = 0; z < GROESSE; z++) {
            for (int s = 0; s < GROESSE; s++) {
                spielfeld[z][s].nachbarMinen = zaehleNachbarMinen(z, s);
            }
        }
    }

    static int zaehleNachbarMinen(int zeile, int spalte) {
        int anzahl = 0;
        for (int dz = -1; dz <= 1; dz++) {
            for (int ds = -1; ds <= 1; ds++) {
                int z = zeile + dz;
                int s = spalte + ds;
                if (imFeld(z, s) && spielfeld[z][s].istMine) {
                    anzahl++;
                }
            }
        }
        return anzahl;
    }

    static void aufdecken(int zeile, int spalte) {
        if (ersterZug) {
            minenVerteilen(zeile, spalte);
            ersterZug = false;
        }

        if (spielfeld[zeile][spalte].markiert) {
            System.out.println("Hier steht eine Fahne. Entferne sie zuerst mit 'm'.");
            return;
        }
        if (spielfeld[zeile][spalte].aufgedeckt) {
            return;
        }

        spielfeld[zeile][spalte].aufgedeckt = true;

        if (spielfeld[zeile][spalte].istMine) {
            verloren = true;
            return;
        }

        // Bei 0 Nachbarminen automatisch alle Nachbarn aufdecken
        if (spielfeld[zeile][spalte].nachbarMinen == 0) {
            for (int dz = -1; dz <= 1; dz++) {
                for (int ds = -1; ds <= 1; ds++) {
                    int z = zeile + dz;
                    int s = spalte + ds;
                    if (imFeld(z, s) && !spielfeld[z][s].aufgedeckt && !spielfeld[z][s].markiert) {
                        aufdecken(z, s);
                    }
                }
            }
        }
    }

    static void markieren(int zeile, int spalte) {
        if (spielfeld[zeile][spalte].aufgedeckt) {
            System.out.println("Dieses Feld ist schon aufgedeckt.");
            return;
        }
        spielfeld[zeile][spalte].markiert = !spielfeld[zeile][spalte].markiert;
    }

    static boolean gewonnen() {
        int anzahlAufgedeckt = 0;
        for (int z = 0; z < GROESSE; z++) {
            for (int s = 0; s < GROESSE; s++) {
                if (spielfeld[z][s].aufgedeckt) {
                    anzahlAufgedeckt++;
                }
            }
        }
        return anzahlAufgedeckt == GROESSE * GROESSE - ANZAHL_MINEN;
    }

    static boolean imFeld(int zeile, int spalte) {
        return zeile >= 0 && zeile < GROESSE && spalte >= 0 && spalte < GROESSE;
    }

    // alleZeigen = true deckt am Spielende alle Minen auf
    static void spielfeldAusgeben(boolean alleZeigen) {
        System.out.println();
        System.out.print("    ");
        for (int s = 0; s < GROESSE; s++) {
            System.out.print((s + 1) + " ");
        }
        System.out.println();
        System.out.print("   ");
        for (int s = 0; s < GROESSE; s++) {
            System.out.print("--");
        }
        System.out.println();

        for (int z = 0; z < GROESSE; z++) {
            System.out.print((z + 1) + " | ");
            for (int s = 0; s < GROESSE; s++) {
                System.out.print(feldZeichen(z, s, alleZeigen) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static char feldZeichen(int zeile, int spalte, boolean alleZeigen) {
        if (spielfeld[zeile][spalte].aufgedeckt || (alleZeigen && spielfeld[zeile][spalte].istMine)) {
            if (spielfeld[zeile][spalte].istMine) {
                return '*';
            }
            if (spielfeld[zeile][spalte].nachbarMinen == 0) {
                return ' ';
            }
            return (char) ('0' + spielfeld[zeile][spalte].nachbarMinen);
        }
        if (spielfeld[zeile][spalte].markiert) {
            return 'F';
        }
        return '#';
    }
}
