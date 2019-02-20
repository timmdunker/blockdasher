package com.example.martinee.blockuiapp;

import android.util.Log;

import java.util.Random;


public class BlockControl extends Thread {

//    private static int XSIZE = 300;
//    private static int YSIZE = 750;
//    static final int BORDER = 300;
    private MainActivity mainActivity;

    int score = 0;
//    int squareWidth = 25;
//    int squareHeight = 25;
//    int squareYLocation = -squareWidth;
//    boolean numberCreated = false;
    static boolean gameRunning = false;
//    FinishGAME fg;
    private BlockUI bui;
    Player p = new Player(480, 1400, 570, 1490);

    public static Cube[] cub = new Cube[7];

    public BlockControl(MainActivity mainActivity, BlockUI ui) {
//        mainActivity.setText((ui==null)?"null":"!null");
        this.mainActivity = mainActivity;
        bui = ui;
        init();
    }

    public void addCubes() {
        for (int i = 0; i < cub.length; i++) {
            cub[i] = new Cube(this);
        }
    }





//    public void gameOver() {
//        String res = "Du har torskat din jävla sopa" + "\nPoäng: " + score;
//        JOptionPane.showMessageDialog(null, res, "GAME OVER",
//                JOptionPane.YES_NO_OPTION);
//        System.exit(0);
//
//    }

    public void checkColl() {

        for (int i = 0; i < cub.length; i++) {
            if (p.getMyPlayer().intersect(cub[i].getRekt())) {
                mainActivity.setText("Du har torskat din jävla sopa! \n" + "Du fick " + score + " poäng \n" + "Tryck på bakåt-knappen för att börja om");
//                stop();
//                mainActivity.finish();
                gameRunning = false;

            }
        }

    }

    public void init() {
//        bui = new BlockUI();
//        JFrame frame = new JFrame("Block Dasher!");
//        bui.setDoubleBuffered(true);
//        frame.add(bui);
//        frame.setVisible(true);
//        frame.setSize(XSIZE, YSIZE);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setResizable(false);
//        frame.setLocationRelativeTo(null);
        addCubes();
        bui.setActivity(mainActivity);
        bui.setCP(cub,p);
        gameRunning = true;
        start();
    }

    public void updateBoard(){
        bui.updateBoard();
    }

    public BlockUI getUIref(){
        return bui;
    }

    public void run() {
        while (gameRunning) {
            try {
                for (int i = 0; i < cub.length; i++) {
                    cub[i].update();
                    checkColl();



                }
                bui.updateBoard();
                Thread.sleep(9); // testa olika nummer, se resultat.
            } catch (Exception e) {
            }
        }
    }

//    public void startGame () {
//        addCubes();
//        gameRunning = true;
//        run();
//    }


    public void setBla(String g){
        mainActivity.setText(g);
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score
     *            the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the cub
     */
    public static Cube[] getCub() {
        return cub;
    }

    /**
     * @return the xSIZE
     */
//    public static int getXSIZE() {
//        return XSIZE;
//    }
//
//    /**
//     * @return the ySIZE
//     */
//    public static int getYSIZE() {
//        return YSIZE;
//    }

    /**
     * @return the gameRunning
     */
    public static boolean isGameRunning() {
        return gameRunning;
    }

    /**
     * @param gameRunning the gameRunning to set
     */
    public static void setGameRunning(boolean gameRunning) {
        BlockControl.gameRunning = gameRunning;
    }

}
