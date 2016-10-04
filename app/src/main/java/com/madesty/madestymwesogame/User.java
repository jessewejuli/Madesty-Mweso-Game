package com.madesty.madestymwesogame;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Aiko on 9/30/2016.
 */
public class User {

    private String name;
    private Gameboard paused;
    private Gameboard saved;
    private Gameboard current;

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSaved(Gameboard saved){
        this.saved = saved;
    }

    public Gameboard getSaved(){
        return saved;
    }

    public void setPaused(Gameboard paused){
        this.paused = paused;
    }

    public Gameboard getPaused(){
        return paused;
    }

    public void saveGame(Gameboard gameboard, Context context){

        String FILENAME = name;

        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(gameboard);
            oos.close();
            fos.close();
        }catch(IOException e){

        }
    }

    public void loadGame( Context context){

        String fileName = name;

        try{

            FileInputStream fis = context.openFileInput(name);
            ObjectInputStream ois = new ObjectInputStream(fis);
            current = (Gameboard) ois.readObject();
            ois.close();
            fis.close();

        }catch (ClassNotFoundException e){

        }catch (IOException e){

        }

    }

}
