package Minesweeper;

// Ein einzelnes Feld auf dem Spielbrett
public class Feld {
    boolean istMine = false;
    boolean aufgedeckt = false;
    boolean markiert = false;
    int nachbarMinen = 0;
}
