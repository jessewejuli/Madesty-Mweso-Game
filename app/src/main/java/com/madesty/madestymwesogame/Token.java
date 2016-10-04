package com.madesty.madestymwesogame;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by Aiko on 9/26/2016.
 */
public class Token extends Button{

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
        this.setX(coord.getX());
        this.setY(coord.getY());
    }

    private Coordinate coord;

    public Token(Context context){
        super(context);

    }

    public Token(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    public Token(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

}
