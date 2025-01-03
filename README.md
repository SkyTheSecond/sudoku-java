# Intro
- Simple sudoku app made in Swing
# How to run
- Ensure you have java installed
```sh
java --version
```
- If it shows a version continue on, otherwise install java
- Clone the github repository
```sh
git clone https://github.com/SkyTheSecond/sudoku-java.git && cd sudoku-java
```
- Run the Main.java file
```sh
java Main.java
```
- A sample file has been provided as board.txt
- It can be modified to display any game that you wish
- It should be a 9 by 9 grid (Spaces are ignored automatically)
- 0 means that the square is empty

# How to play
- You can use the mouse to click on any square
- You can also use the keyboard (after selecting a square) to move your selected square
- It also works with vim-motions if that suits your fancy
- backspace/delete to remove any number
- escape to deselect your selected square

# TODO:
- [ ] Clean up the code
- [ ] Add a solver to it
- [ ] Add a win state to the game object
- [ ] Make the keyboard bindings more intuitive
