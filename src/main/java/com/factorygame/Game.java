package com.factorygame;

import game.Player;
import java.awt.Graphics;

public class Game implements Runnable {
    private Window window;
    private Panel panel;
    private Thread thread;
    private final int fpsLimit = 120;
    private final int tickSet = 200;

    private Player player;

    public Game() {
        initClasses();

        panel = new Panel(this);
        window = new Window(panel);
        panel.requestFocus();

        startGameLoop();
    }

    public Player getPlayer() {
        return player;
    }

    private void initClasses() {
        player = new Player();
    }

    private void startGameLoop() {
        thread = new Thread(this);
        thread.start();
    }

    public void update() {
        player.update();
        panel.updateGame();
    }

    public void render(Graphics g) {
        player.render(g);
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / fpsLimit;
        double timePerTick = 1000000000.0 / tickSet;
        long previousTime = System.nanoTime();

        int frames = 0;
        int ticks = 0;
        long lastCheck = System.currentTimeMillis(); 

        double deltaT = 0;
        double deltaF = 0;

        while (true) {
            long currentTime = System.nanoTime();

            deltaT += (currentTime - previousTime) / timePerTick;
            deltaF += (currentTime - previousTime) / timePerFrame;
            
            previousTime = currentTime;

            if (deltaT >= 1) {
                update(); 
                ticks++;
                deltaT--;
            }

            if (deltaF >= 1) {
                 panel.repaint();
                 deltaF--;
                 frames++;
            }
            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: "+frames + " | Ticks: " + ticks);
                frames = 0;
                ticks = 0;

            }
        }  
    }
}
