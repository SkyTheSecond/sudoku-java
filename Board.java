/*
    Board:
        void selectSquare(MouseX and Y) -> needs to convert co-ordinates to a square and needs to change state of the square
        void makeMove(int input) -> changes state of selected square and makes selectedSquare to null. If none selected throw exception
        private Square coordinateToSquare(MouseX and Y)
        public squareToCoordinate(int i, j)
        public selectSquare(int i, j)
        public unselectSquare()
*/
public class Board {
    Square[][] squares;
    int[] selectedSquare;
    public Board(){
        this.squares = new Square[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; ++j) {
                this.squares[i][j] = new Square();
            }
        }
        this.selectedSquare = new int[2];
        this.selectedSquare[0] = -1;
        this.selectedSquare[1] = -1;
    }
}