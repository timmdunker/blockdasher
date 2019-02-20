package blockdasher;

import android.graphics.*;
import java.util.Random;

public class Cube {
    public RectF rekt;

    private float XSIZE = 1080;
    private float YSIZE = 2000;
    float randNumb = 0;
    float fallspeed;
    float squareWidth;
    float squareYLocation = 0;
    float squareHeight = squareYLocation+50;
    boolean numberCreated = false;
    public BlockControl bc;
    float spd = 2.4f;
    int points = 0;
    Random rand = new Random();

    public Cube(BlockControl b) {
        bc = b;
        rekt = new RectF(randNumb, squareYLocation, squareWidth,
                squareHeight);
    }

    public void update() {

        if (!numberCreated) {

            generateRandomNumber();
        }

        if (squareYLocation < YSIZE) {

            squareYLocation += fallspeed;
            squareHeight=squareYLocation+75;

            fallspeed = rand.nextFloat() * (spd) + (spd-0.40f);
            rekt.set(randNumb, squareYLocation, squareWidth, squareHeight);


//			System.out.println(squareYLocation);
        } else {

//            System.out.println(spd);
//            System.out.println(fallspeed);
            points += 5;
//            String pop = valueOf(points);

            bc.setScore(points);
            if (points == 15) {
                spd += 0.5;
            }
            if (points == 35) {
                spd += 0.5;
            }
            if (points == 55) {
                spd += 0.5;
            }
            if (points == 75) {
                spd += 0.5;
            }
            if (points == 95) {
                spd += 0.5;
            }
            if (points == 125) {
                spd += 0.5;
            }
            if (points == 155) {
                spd += 0.4;
            }
            if (points == 200) {
                spd += 0.4;
            }
            if (points == 255) {
                spd += 0.4;
            }
            if (points == 310) {
                spd += 0.4;
            }
            if (points == 370) {
                spd += 0.4;
            }
            if (points == 430) {
                spd+= 0.4;
            }
            if (points == 500) {
                spd+= 0.4;
            }
            if (points == 570) {
                spd+= 1;
            }

            numberCreated = false;
            squareYLocation = -squareHeight;
            bc.setBla("Score: " + points+ "  Speed: " + spd);
        }

    }

    public RectF getRekt() {
        return rekt;

    }

//    public float getX () {
//        return rekt.
//    }
//
//    public double getY () {
//        return rekt.getY();
//    }

    public void generateRandomNumber() {
        randNumb = rand.nextFloat() * (XSIZE);
        squareWidth=randNumb+75;
        squareYLocation=0;
        numberCreated = true;
    }

    /**
     * @param spd
     *            the spd to set
     */
    public void setSpd(Float spd) {
        this.spd = spd;
    }

    /**
     * @return the spd
     */
    public Float getSpd() {
        return spd;
    }

    public int getPoints () {
        return this.points;
    }

}
