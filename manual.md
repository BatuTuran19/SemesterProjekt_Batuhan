# Bedienungsanleitung Minesweeper

## Programm starten

1. Projekt in IntelliJ öffnen
2. `src/Minesweeper/Minesweeper.java` öffnen
3. Auf den grünen Pfeil neben `main` klicken
4. Das Spiel läuft in der Konsole unten in IntelliJ. Dort werden auch die Befehle eingegeben.

## Ziel des Spiels

Auf dem 9x9-Spielfeld sind 10 Minen versteckt. Du musst alle Felder aufdecken, auf denen **keine** Mine liegt.
Wenn du eine Mine aufdeckst, hast du verloren.

## Befehle

Jeder Befehl wird in eine Zeile geschrieben und mit Enter bestätigt.
Zeilen und Spalten werden von 1 bis 9 gezählt, zuerst kommt immer die Zeile, dann die Spalte.

| Eingabe | Bedeutung | Beispiel |
|---|---|---|
| `a <zeile> <spalte>` | Feld aufdecken | `a 3 5` deckt Zeile 3, Spalte 5 auf |
| `m <zeile> <spalte>` | Fahne setzen oder wieder entfernen | `m 1 1` setzt eine Fahne oben links |
| `q` | Spiel beenden | `q` |

## Das Spielfeld

```
    1 2 3 4 5 6 7 8 9
   ------------------
1 | F # # # # # # # #
2 | # # # # # # # # #
3 | # # # # # 2 1 2 1
4 | # # 2 1 1 1
5 | # 1 1
```

| Zeichen | Bedeutung |
|---|---|
| `#` | verdecktes Feld |
| `F` | Fahne (hier vermutest du eine Mine) |
| `1`–`8` | so viele Minen liegen in den 8 Nachbarfeldern |
| leer | keine Mine in der Nähe |
| `*` | Mine (wird erst am Spielende angezeigt) |

## Spielablauf

1. **Erster Zug:** Decke ein beliebiges Feld auf. Der erste Zug ist immer sicher, weil die Minen erst danach
   verteilt werden, und zwar nie auf oder direkt neben dem ersten Feld.
2. **Zahlen lesen:** Eine Zahl sagt dir, wie viele Minen um dieses Feld herum liegen. Damit kannst du herausfinden,
   welche Felder sicher sind.
3. **Leere Felder:** Deckst du ein Feld ohne Minen in der Nähe auf, werden alle Nachbarfelder automatisch mit aufgedeckt.
4. **Fahnen:** Markiere Felder, auf denen du eine Mine vermutest, mit `m`. Ein Feld mit Fahne kann nicht aus Versehen
   aufgedeckt werden. Mit `m` auf dasselbe Feld wird die Fahne wieder entfernt.
5. **Spielende:**
   - Gewonnen: Alle Felder ohne Mine sind aufgedeckt.
   - Verloren: Du hast eine Mine aufgedeckt. Danach werden alle Minen mit `*` angezeigt.

## Fehlermeldungen

| Meldung | Ursache |
|---|---|
| `Ungueltige Eingabe!` | Nach dem Befehl stehen keine zwei Zahlen |
| `Zeile und Spalte muessen zwischen 1 und 9 liegen!` | Das Feld liegt außerhalb des Spielfelds |
| `Unbekannter Befehl: ...` | Es wurde ein anderer Buchstabe als `a`, `m` oder `q` eingegeben |
| `Hier steht eine Fahne. Entferne sie zuerst mit 'm'.` | Ein Feld mit Fahne sollte aufgedeckt werden |
| `Dieses Feld ist schon aufgedeckt.` | Auf ein aufgedecktes Feld sollte eine Fahne gesetzt werden |
