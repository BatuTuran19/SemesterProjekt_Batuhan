# Anweisungen für KI-Assistenten

## Projekt

- Minesweeper als Konsolenanwendung in Java
- Semesterprojekt im 1. Semester (Strukturiertes Programmieren)
- Abgegeben wird nur `src/Minesweeper/`. Den Ordner `src/Test` nicht verändern.

## Vorgabe (muss immer eingehalten werden)

> The project should use structured programming in Java including records or simple classes.
> No abstractions, inheritance, Collections or other higher level Java features may be used.

Das heißt konkret:

- Erlaubt: statische Methoden, Arrays (auch 2D), `if`/`switch`, Schleifen, Rekursion, Records und einfache Klassen
- Erlaubt aus der Standardbibliothek: `Scanner` für Eingaben, `Random` für Zufallszahlen, `Math`
- Verboten: `extends`, `abstract`, `interface`
- Verboten: Collections wie `ArrayList`, `List`, `HashMap`, `Set`
- Verboten: Lambdas, Streams, Generics, `var`, Exceptions als Programmlogik

## Stil

- Namen von Variablen und Methoden auf Deutsch (z.B. `spielfeld`, `aufdecken`)
- Einfacher, gut lesbarer Code für Anfänger. Lieber eine Zeile mehr als ein Trick.
- Kurze Kommentare nur dort, wo etwas nicht offensichtlich ist
- Keine Umlaute in Konsolenausgaben (`ue` statt `ü`)

## Arbeitsweise

- Nach jeder Änderung `features.md` aktualisieren, wenn eine Funktion dazukommt oder sich ändert
- Änderungen kurz erklären, damit der Autor sie versteht und in der Prüfung erklären kann
