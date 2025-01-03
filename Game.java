import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
*/
public class Game extends JPanel {
    int state;
    Board board;
    String key_pressed = "none";
    final Color BLACK = new Color(124, 127, 147);
    final Color SELECT = new Color(188, 192, 204);
    final Color TEXT = new Color(76, 79, 105);
    final Color BASE = new Color(239, 241, 245);
    final Color BORDER = new Color(156, 160, 176);
    final Color Mantle = new Color(230, 233, 239);
    Game(){
        state = 0;
        board = new Board();
        loadBoard();
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                int[] mousePos = new int[2];
                int x = e.getX(), y = e.getY();
                // Now I need to calculate square pressed
                // int x = 30 + j * width, y = 150 + i * height;
                if(x < 30 || y < 150 || x > 30 + 9 * 60 || y > 150 + 9 * 60) return;
                mousePos[0] = (x - 30) / 60;
                mousePos[1] = (y - 150) / 60;
                if(board.selectedSquare == null){
                    board.selectedSquare = new int[2];
                }
                board.selectedSquare[0] = mousePos[1];
                board.selectedSquare[1] = mousePos[0];
                repaint();
            }
        });
        addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int key = e.getKeyCode();
                switch(key){
                    case KeyEvent.VK_DELETE:
                    case KeyEvent.VK_BACK_SPACE:
                    case KeyEvent.VK_0:
                        board.squares[board.selectedSquare[0]][board.selectedSquare[1]].setState(0);
                        repaint();
                        break;
                    case KeyEvent.VK_1:
                        board.squares[board.selectedSquare[0]][board.selectedSquare[1]].setState(1);
                        repaint();
                        break;
                    case KeyEvent.VK_2:
                        board.squares[board.selectedSquare[0]][board.selectedSquare[1]].setState(2);
                        repaint();
                        break;
                    case KeyEvent.VK_3:
                        board.squares[board.selectedSquare[0]][board.selectedSquare[1]].setState(3);
                        repaint();
                        break;
                    case KeyEvent.VK_4:
                        board.squares[board.selectedSquare[0]][board.selectedSquare[1]].setState(4);
                        repaint();
                        break;
                    case KeyEvent.VK_5:
                        board.squares[board.selectedSquare[0]][board.selectedSquare[1]].setState(5);
                        repaint();
                        break;
                    case KeyEvent.VK_6:
                        board.squares[board.selectedSquare[0]][board.selectedSquare[1]].setState(6);
                        repaint();
                        break;
                    case KeyEvent.VK_7:
                        board.squares[board.selectedSquare[0]][board.selectedSquare[1]].setState(7);
                        repaint();
                        break;
                    case KeyEvent.VK_8:
                        board.squares[board.selectedSquare[0]][board.selectedSquare[1]].setState(8);
                        repaint();
                        break;
                    case KeyEvent.VK_9:
                        board.squares[board.selectedSquare[0]][board.selectedSquare[1]].setState(9);
                        repaint();
                        break;
                    case KeyEvent.VK_J:
                    case KeyEvent.VK_DOWN:
                        if(board.selectedSquare[0] != 8) {
                            board.selectedSquare[0]++;
                            repaint();
                        }
                        break;
                    case KeyEvent.VK_H:
                    case KeyEvent.VK_LEFT:
                        if(board.selectedSquare[1] != 0) {
                            board.selectedSquare[1]--;
                            repaint();
                        }
                        break;
                    case KeyEvent.VK_L:
                    case KeyEvent.VK_RIGHT:
                        if(board.selectedSquare[1] != 8) {
                            board.selectedSquare[1]++;
                            repaint();
                        }
                        break;
                    case KeyEvent.VK_K:
                    case KeyEvent.VK_UP:
                        if(board.selectedSquare[0] != 0) {
                            board.selectedSquare[0]--;
                            repaint();
                        }
                        break;
                    case KeyEvent.VK_ESCAPE:
                        key_pressed = "remove";
                        board.selectedSquare[0] = -1;
                        board.selectedSquare[1] = -1;
                        repaint();
                        break;
                }
            }
        });
        setFocusable(true);
    }
    protected void paintComponent(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        g.setColor(BASE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(TEXT);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Sudoku", (getWidth() / 2) - 60, (getHeight() / 20) + 30);
        g.setColor(BLACK);
        int width = 60, height = 60;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int x = 30 + j * width, y = 150 + i * height;
                if(i == board.selectedSquare[0] && j == board.selectedSquare[1]){
                    continue;
                }
                else {
                    if((i + j  & 1) == 1){
                        g.setColor(Mantle);
                    }
                    else
                        g.setColor(BASE);
                    g.fillRect(x, y, width, height);
                    g.setColor(BLACK);
                    g.drawRect(x, y, width, height);
                }
                int state = board.squares[i][j].getState();
                if (state != 0) {
                    g.setColor(TEXT);
                    g.setFont(new Font("Arial", Font.BOLD, 24));
                    g.drawString(String.valueOf(state), x + width / 2 - 5, y + height / 2 + 10);
                    g.setColor(BLACK);
                }
            }
        }
        if(board.selectedSquare[0] != -1 && board.selectedSquare[1] != -1) {
            g.setColor(SELECT);
            g.fillRect(board.selectedSquare[1] * width + 31, board.selectedSquare[0] * height + 151, width - 1, height - 1);
            g.setColor(BLACK);
            int state = board.squares[board.selectedSquare[0]][board.selectedSquare[1]].getState();
            if (state != 0) {
                g.setColor(TEXT);
                g.setFont(new Font("Arial", Font.BOLD, 24));
                g.drawString(String.valueOf(state), board.selectedSquare[1] * width + 55, board.selectedSquare[0] * height + 190);
                g.setColor(BLACK);
            }
        }
        g.setColor(BORDER);
        g.fillRect(25, 145, 10, 60 * 9 + 11);
        g.fillRect(25, 145, 60 * 9 + 11, 10);
        g.fillRect(60 * 9 + 30, 145, 10, 60 * 9 + 11);
        g.fillRect(25, 60 * 9 + 150, 60 * 9 + 15, 10);
        g.fillRect(28 + 3 * 60, 150 ,4, 60 * 9);
        g.fillRect(28 + 6 * 60, 150 ,4, 60 * 9);
        g.fillRect(30, 148 + 3 * 60 ,60 * 9, 4);
        g.fillRect(30, 148 + 6 * 60 ,60 * 9, 4);
    }
    void loadBoard(){
        FileReader fr;
        try{
            fr = new FileReader("board.txt");
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            return;
        }
        BufferedReader br = new BufferedReader(fr);
        try {
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    int state = br.read();
                    if(state == '\n' || state == '\r' || state == ' '){
                        j--;
                        continue;
                    }
                    board.squares[i][j].setState(state - '0');
                }
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
