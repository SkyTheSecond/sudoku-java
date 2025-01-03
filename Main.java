import javax.swing.*;
import java.util.Scanner;
import java.awt.Graphics;

import static java.awt.Color.BLACK;

/*
    Game:
    Board board
    Board solved board
    enum States
    int State
    void drawBoard()
    void checkSolved() -> mutates the state accordingly
    void loadBoard(file)
    void solveBoard() -> mutates the solvedBoard board

    Board:
    Sqaures[] squares
    Square selectedSquare
    void selectSquare(MouseX and Y) -> needs to convert co-ordinates to a square and needs to change state of the square
    void makeMove(int input) -> changes state of selected square and makes selectedSquare to null. If none selected throw exception
    private Square coordinateToSquare(MouseX and Y)
    public squareToCoordinate(int i, j)
    public selectSquare(int i, j)
    public unselectSquare()

    Square:
    int state-> 0 through 9 or -1 in case of empty
    Color color -> color of the square, selected should be red otherwise black
    setState(int state)
    int getState()
    setColor()
 */
class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sudoku");
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel game = new Game();
        frame.add(game);
        frame.setVisible(true);
    }
}