package com.madesty.madestymwesogame;

/**
 * Created by Aiko on 9/23/2016.
 */
public class Coordinate {

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x){ this.x = x;}

    public void setY(int y){ this.y = y;}

    private int x, y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean checkCoord(Coordinate coord){

        if(x == coord.getX() && y == coord.getY()){
            return true;

        }else{

            return false;

        }
    }



}
