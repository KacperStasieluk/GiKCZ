package com.zetcode;

import java.io.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.lang.Math.*;

public class Board extends JPanel implements ActionListener {

    private final int B_WIDTH = 300;
    private final int B_HEIGHT = 300;
    private final int DOT_SIZE = 5;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = 29;
    public int DELAY = 100;
	public int SCORE = 0;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private int dots;
    private int apple_x;
    private int apple_y;
	private int apple_x2;
    private int apple_y2;
	
	private int dziura_x;
    private int dziura_y;
	private int dziura_x2;
    private int dziura_y2;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    private Image ball;
    private Image apple;
	private Image apple2;
    private Image head;
	private Image dziura;
	private Image dziura2;

    public Board() {
        
        initBoard();
    }
    
    private void initBoard()  {

        addKeyListener(new TAdapter());
        setFocusable(true);
		setBackground(Color.black);
		
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
		
    }
	


    private void loadImages() {

        ImageIcon iid = new ImageIcon("F:/Programowanie/Testy/Snake/src/resources/dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("F:/Programowanie/Testy/Snake/src/resources/apple.png");
        apple = iia.getImage();
		
		ImageIcon iia2 = new ImageIcon("F:/Programowanie/Testy/Snake/src/resources/apple2.png");
        apple2 = iia2.getImage();

        ImageIcon iih = new ImageIcon("F:/Programowanie/Testy/Snake/src/resources/head.png");
        head = iih.getImage();
		
		ImageIcon iidz = new ImageIcon("F:/Programowanie/Testy/Snake/src/resources/dziura.png");
        dziura = iidz.getImage();
		
		ImageIcon iidz2 = new ImageIcon("F:/Programowanie/Testy/Snake/src/resources/dziura.png");
        dziura2 = iidz2.getImage();
		
		
    }

    private void initGame() {

        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }
        
        locateApple();
		locateApple2();
		locateDziura();
		locateDziura2();
		
        timer = new Timer(DELAY, this);
        timer.start();
    }

    
    private void doDrawing(Graphics g) {
        
        if (inGame) {

            g.drawImage(apple, apple_x, apple_y, this);
			g.drawImage(apple2, apple_x2, apple_y2, this);
			g.drawImage(dziura, dziura_x, dziura_y, this);
			g.drawImage(dziura2, dziura_x2, dziura_y2, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }
			
			stats(g);

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }        
    }

    private void gameOver(Graphics g) {
        
        String msg = "PRZEGRANA";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);
		
		String predkosc = "[ Punkty: "+SCORE+" | Predkosc: "+Integer.toString(Math.abs(DELAY-101))+" Dlugosc: "+dots+" ]";
        Font fpredkosc = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr2 = getFontMetrics(fpredkosc);

        g.setColor(Color.red);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
		
		g.setColor(Color.white);
        g.setFont(fpredkosc);
        g.drawString(predkosc, 15, (B_HEIGHT / 2)+20);
    }
	
	public void stats(Graphics g) {
        
        String predkosc = "Punkty: "+SCORE+" | Predkosc: "+Integer.toString(Math.abs(DELAY-101))+" Dlugosc: "+dots;
        Font fpredkosc = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr2 = getFontMetrics(fpredkosc);

        g.setColor(Color.green);
        g.setFont(fpredkosc);
        g.drawString(predkosc, 0, B_HEIGHT-5);
    }

    private void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {

            dots++;
			DELAY -= 2;
			SCORE++;
            locateApple();
			timer.stop();
			timer = new Timer(DELAY, this);
			timer.start();
        }
    }
	
	private void checkApple2() {

        if ((x[0] == apple_x2) && (y[0] == apple_y2)) {

            dots += 5;
			SCORE += 2;
            locateApple2();
			DELAY -= 2;
			timer.stop();
			timer = new Timer(DELAY, this);
			timer.start();
        }
    }
	
	private void checkDziura() {

        if ((x[0] == dziura_x) && (y[0] == dziura_y)) {

            x[0] = dziura_x2;
			y[0] = dziura_y2;
			
        }
    }
	
	private void checkDziura2() {

        if ((x[0] == dziura_x2) && (y[0] == dziura_y2)) {

            x[0] = dziura_x;
			y[0] = dziura_y;
			
        }
    }

    private void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }

    private void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
        
        if (!inGame) {
            timer.stop();
        }
    }

    private void locateApple() {

        int r = (int) (Math.random() * RAND_POS);
        apple_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple_y = ((r * DOT_SIZE));
    }
	
	private void locateApple2() {

        int r2 = (int) (Math.random() * RAND_POS);
        apple_x2 = ((r2 * DOT_SIZE));

        r2 = (int) (Math.random() * RAND_POS);
        apple_y2 = ((r2 * DOT_SIZE));
    }
	
	private void locateDziura() {

        int r3 = (int) (Math.random() * RAND_POS);
        dziura_x = ((r3 * DOT_SIZE));

        r3 = (int) (Math.random() * RAND_POS);
        dziura_y = ((r3 * DOT_SIZE));
    }
	
	private void locateDziura2() {

        int r4 = (int) (Math.random() * RAND_POS);
        dziura_x2 = ((r4 * DOT_SIZE));

        r4 = (int) (Math.random() * RAND_POS);
        dziura_y2 = ((r4 * DOT_SIZE));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            checkApple();
			checkApple2();
			checkDziura();
			checkDziura2();
            checkCollision();
            move();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }
}
