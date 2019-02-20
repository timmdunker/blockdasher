package com.example.martinee.blockuiapp;

import android.graphics.*;
import android.view.MotionEvent;

public class Player {

    private float XSIZE = 1080;
    private float YSIZE = 1750;
    private RectF myPlayer = new RectF();
    private float xPos = 0;
    private float yPos = 0;
    private float width = 0;
    private float height = 0;



    public Player (float _xPos, float _yPos, float _width, float _height) {
        xPos = _xPos;
        yPos = _yPos;
        width = _width;
        height = _height;
        myPlayer.set(_xPos, _yPos, _width, _height);
    }



    public void setMyPlayer (float _xPos) {

        xPos = _xPos;
        width = xPos+90;
        if (xPos > XSIZE-90) {
            myPlayer.set(xPos-90, yPos, width-90, height);
        } else {
            myPlayer.set(xPos, yPos, width, height);
        }
    }


    public RectF getMyPlayer() {

        return myPlayer;
    }

}
