# Features

1. Spielfeld mit 9x9 Feldern und 10 Minen (Größe und Minenanzahl über `GROESSE` und `ANZAHL_MINEN` änderbar)
2. Zufällige Verteilung der Minen
3. Sicherer erster Zug: Die Minen werden erst nach dem ersten Zug verteilt, nie auf oder direkt neben dem ersten Feld
4. Felder aufdecken mit `a <zeile> <spalte>`
5. Fahnen setzen und wieder entfernen mit `m <zeile> <spalte>`
6. Anzeige der Anzahl benachbarter Minen auf jedem aufgedeckten Feld
7. Automatisches Aufdecken aller Nachbarn bei Feldern ohne Minen in der Nähe (rekursiv)
8. Schutz vor Fehlklicks: Felder mit Fahne können nicht aufgedeckt werden
9. Prüfung ungültiger Eingaben (falscher Befehl, keine Zahl, Feld außerhalb des Spielfelds)
10. Spielfeld mit nummerierten Zeilen und Spalten in der Konsole
11. Gewinnen, wenn alle Felder ohne Mine aufgedeckt sind
12. Verlieren beim Aufdecken einer Mine, danach werden alle Minen angezeigt
13. Spiel jederzeit beenden mit `q`
