package Main;
import java.awt.*;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;
import tile.Tile;

public class GamePanels extends JPanel implements Runnable {
 
    
        int originalTileSize = 16;
        int scale = 3;
        public int tileSize = originalTileSize * scale;
        public final int maxScreenColumn = 16;
        public final  int maxScreenRows = 12;
        public int screenWidth = maxScreenColumn * tileSize;
        public int screenHeight = maxScreenRows * tileSize;

        public int maxWorldCol = 50;
        public int maxWorldRow = 50;
        public int worldWidth = maxWorldCol*tileSize;
        public int worldHeight = maxWorldRow*tileSize; 

        //fps
        int fps = 60;
        int drawCount; //fps
        int timer;
        KeyHandler keyH = new KeyHandler();
        Thread gameThread;

        public Player player = new Player(this, keyH);
        TileManager TM = new TileManager(this); 

        public CollisionChecker cChecker = new CollisionChecker(this);


        
public GamePanels(){
    
this.setPreferredSize(new Dimension(screenWidth,screenHeight));
this.setBackground(Color.black);
this.setDoubleBuffered(true);// find its work?

this.addKeyListener(keyH);
this.setFocusable(true);

    }

public void startGameThread(){

    gameThread = new Thread(this); //true work of thread?
    gameThread.start();
}


@Override
public void run(){

    double drawInterval = 1000000000/fps;
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;
    long timer=0;
    int drawCount=0;

    while(gameThread!=null){
        currentTime = System.nanoTime();
        delta+= (currentTime-lastTime)/drawInterval;
        timer+=(currentTime-lastTime);

        lastTime = currentTime;
        if(delta>1){
        update();
        repaint();
        delta--;
        drawCount++;
        }
          if(timer>1000000000){
            System.out.println(drawCount);
            drawCount=0;
            timer=0;
        }
        
    }
    
}
public void update()
    {
player.update();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        TM.draw(g2);
        player.draw(g2);
    }
    }



// public void run() {
    
//     long drawInterval = 1000000000/fps;
//     long nextDrawTime= System.nanoTime() + drawInterval;
// while(gameThread != null){


//     update();
//     repaint();

//     long remainingTime = nextDrawTime -System.nanoTime();
//    try{ if(remainingTime<0){
//         remainingTime=0;
//     }
//     remainingTime = remainingTime/10000000;
//     Thread.sleep((long)remainingTime);
//     nextDrawTime += drawInterval;
//     } catch (InterruptedException e) {
//       e.printStackTrace();
//     }

// System.err.println(drawCount);
// }  
// }




// long drawInterval = 1000000000 / fps;

// This calculates the time interval (in nanoseconds) between each 
// frame based on the desired frames per second (fps). It represents the time each frame should take.
// long nextDrawTime = System.nanoTime() + drawInterval;

// This calculates the timestamp for the next expected frame, 
// ensuring a consistent frame rate.
// while (gameThread != null) {

// This starts a loop that continues until gameThread is set 
// to null. The game loop continuously runs, updating the game state and rendering frames.
// update();

// This method is responsible for updating the game state. 
// In your case, it handles player input and updates the player's position.
// repaint();

// This method is called to request a repaint of the panel.
//  It triggers the paintComponent method to redraw the frame with the updated game state.
// long remainingTime = nextDrawTime - System.nanoTime();

// This calculates the time remaining until the next frame should be drawn.
// try { if (remainingTime < 0) { remainingTime = 0; } 
// remainingTime = remainingTime / 10000000; Thread.sleep((long) remainingTime); 
// nextDrawTime += drawInterval; } catch (InterruptedException e) { e.printStackTrace(); }

// This block handles sleeping the thread to achieve a 
// consistent frame rate. It calculates the remaining time until the next 
// frame and sleeps the thread for that duration. It ensures that the game loop runs at the desired frame rate.