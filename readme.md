# Minesweeper

**Autor:** Batuhan

Semesterprojekt im Fach *Strukturiertes Programmieren* (1. Semester Wirtschaftsinformatik).

## Beschreibung

Das bekannte Spiel Minesweeper als Konsolenanwendung in Java. Auf einem 9x9-Spielfeld sind 10 Minen versteckt.
Ziel ist es, alle Felder ohne Mine aufzudecken. Jede Zahl auf einem aufgedeckten Feld zeigt, wie viele Minen
in den acht Nachbarfeldern liegen.

Das Projekt verwendet nur strukturierte Programmierung: statische Methoden, Arrays und eine einfache Klasse
(`Feld`). Es gibt keine Vererbung, keine Abstraktion und keine Collections.

## Starten

1. Projekt in IntelliJ öffnen
2. `src/Minesweeper/Minesweeper.java` öffnen
3. Auf den grünen Pfeil neben `main` klicken

## Bedienung

| Eingabe | Bedeutung |
|---|---|
| `a 3 5` | Feld in Zeile 3, Spalte 5 aufdecken |
| `m 3 5` | Fahne in Zeile 3, Spalte 5 setzen oder entfernen |
| `q` | Spiel beenden |

## Anzeige

| Zeichen | Bedeutung |
|---|---|
| `#` | verdecktes Feld |
| `F` | Fahne |
| `1`–`8` | Anzahl der Minen in den Nachbarfeldern |
| leer | keine Mine in der Nähe |
| `*` | Mine (wird am Spielende angezeigt) |

## Dateien

- `src/Minesweeper/Minesweeper.java`: Spielablauf, Eingabe und Ausgabe
- `src/Minesweeper/Feld.java`: einfache Klasse für ein einzelnes Feld
- `features.md`: Liste der Funktionen
- `agents.md`: Anweisungen für KI-Assistenten
- `promptdiary.md`: alle Prompts, die bei der Entwicklung verwendet wurden

Der Ordner `src/Test` ist eine Übung und gehört nicht zur Abgabe.
