package Main;

import javax.swing.JFrame;

public class Main{

static JFrame window = new JFrame();
public static void main(String[] args){
window = new JFrame();
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setResizable(false);
window.setTitle("Dream Hunt");

GamePanels gamePanel = new GamePanels();
window.add(gamePanel);
gamePanel.startGameThread();
window.pack();  
window.setVisible(true);
}
}