import java.awt.Color;
/*
    Square:
    int state-> 0 through 9 or -1 in case of empty
    Color color -> color of the square, selected should be red otherwise black
    setState(int state)
    int getState()
    setColor()
*/
public class Square {
    int state;
    Color color;
    Square(){
        state = 0;
        color = Color.WHITE;
    }
    void setState(int state){
        this.state = state;
    }
    int getState(){
        return state;
    }
    void setColor(Color color){
        this.color = color;
    }
}