package com.madesty.madestymwesogame;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Aiko on 9/23/2016.
 */
public class Player extends Token{

    private Boolean isSlected = false;

    public Player(Context context){
        super(context);
    }

    public Player(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    public Player(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    public void setIsSlected(){
        isSlected = true;
    }

    public void setIsNotSelected(){
        isSlected = false;
    }

    public Boolean isClicked(){
        return isSlected;
    }

}
