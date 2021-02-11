package org.fundacionjala.at13.spaceinvaders;

import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Gameboard {
    
    private ArrayList<Alien> aliens;
    private static JLabel[][] space;
    private final JFrame frame = new JFrame();
    private final JPanel panel = new JPanel();

    private static final int GO_LEFT = 37;
    private static final int GO_RIGHT = 39;
    private static final int SIZE_IMAGE = 20;
    private static final int SCALE_WIDTH = Constants.SPACE_SIZE_WIDTH * 5;
    private static final int SCALE_HEIGHT = Constants.SPACE_SIZE_HEIGHT * 15;
    private final Spaceship spaceship = new Spaceship(Constants.SPACESHIP_INITIAL_X_POS, Constants.SPACESHIP_INITIAL_Y_POS, Constants.INITIAL_RANGE, Constants.SPACE_SIZE_WIDTH);

    public Gameboard() {
        init();
    }

    /**
     * Method initialize the graphical interface.
     */
    public void init() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                frame.setSize(Constants.UI_WIDTH, Constants.UI_HEIGHT);
                frame.getContentPane().add(panel);
                frame.setVisible(true);
                frame.setTitle("Jala AT13 - Space Invanders");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                panel.setFocusable(true);
                panel.setBackground(Color.BLACK);
                panel.requestFocusInWindow();
                panel.setLayout(new GridLayout(Constants.SPACE_SIZE_HEIGHT, Constants.SPACE_SIZE_WIDTH, 0, 0));
                fillGridsWithLabels();
                //spaceShipImage(POS_X, POS_Y);
                updateSpace();
            }
        };
        SwingUtilities.invokeLater(r);
        eventKey();
        updateSpace();
    }
    /**
     * Create labels for the panel grids and add them.
     */
    public void fillGridsWithLabels() {
        space = new JLabel[Constants.SPACE_SIZE_HEIGHT][Constants.SPACE_SIZE_WIDTH];
        //setLayout(new GridLayout(Constants.SPACE_SIZE_HEIGHT, Constants.SPACE_SIZE_WIDTH, 0, 0));
        for (int row = 0; row < Constants.SPACE_SIZE_HEIGHT; row++) {
            for (int col = 0; col < Constants.SPACE_SIZE_WIDTH; col++) {
                JLabel label = new JLabel();
                label.setOpaque(true);
                label.setBackground(Color.black);
                label.setVisible(true);
                space[row][col] = label;
                panel.add(label);
            }
        }
    }
    /**
     * Method initialize the image.
     */
    public final void spaceShipImage(final int posX, final int posY) {
        //ship.setBounds(posX, posY, SIZE_IMAGE, SIZE_IMAGE);
        //panel.add(ship);
    }
    public void updateSpace() {
        for (int row = 0; row < Constants.SPACE_SIZE_HEIGHT; row++) {
            for (int col = 0; col < Constants.SPACE_SIZE_WIDTH; col++) {
                if (row == spaceship.getPosY() && col == spaceship.getPosX()) {
                    ImageIcon iconLogo = new ImageIcon("src/resources/spaceship.png");
                    space[row][col].setIcon(iconLogo);
                }
            }
        }
    }
    public void clearSpace() {
        for (int row = 0; row < Constants.SPACE_SIZE_HEIGHT; row++) {
            for (int col = 0; col < Constants.SPACE_SIZE_WIDTH; col++) {
                space[row][col].setIcon(null);
            }
        }
    }
    /**
     * Method for the key.
     */
    public void eventKey() {
        KeyListener keyEvent = new KeyListener() {

            @Override
            public void keyTyped(final KeyEvent e) { }

            @Override
            public void keyPressed(final KeyEvent e) {
                if (e.getKeyCode() == GO_LEFT) {
                    clearSpace();
                    spaceship.moveLeft();
                    updateSpace();
                    //ship.setBounds(spaceship.getPosX(), POS_Y, SIZE_IMAGE, SIZE_IMAGE);
                }
                if (e.getKeyCode() == GO_RIGHT) {
                    clearSpace();
                    spaceship.moveRight();
                    updateSpace();
                    //ship.setBounds(spaceship.getPosX(), POS_Y, SIZE_IMAGE, SIZE_IMAGE);
                }
            }

            @Override
            public void keyReleased(final KeyEvent e) { }

        };
        panel.addKeyListener(keyEvent);
    }
}
