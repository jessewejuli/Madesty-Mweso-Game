package com.madesty.madestymwesogame;

import android.view.View;

/**
 * Created by Aiko on 9/23/2016.
 */
public class Gameboard {

    private Coordinate coord1, coord2, coord3, coord4, coord5, coord6, coord7, coord8, coord9;
    private Player player11, player12, player13, player21, player22, player23;
    private Token token1, token2, token3;
    private boolean isTurnp1, isTurnp2;

    public Gameboard(View view){
        initTokens(view);
        initCoords(view);
        resetButtons(view);
    }

    public void initTokens(View view){
        player11 = (Player) view.findViewById(R.id.p11);
        player12 = (Player) view.findViewById(R.id.p12);
        player13 = (Player) view.findViewById(R.id.p13);
        player21 = (Player) view.findViewById(R.id.p21);
        player22 = (Player) view.findViewById(R.id.p22);
        player23 = (Player) view.findViewById(R.id.p23);
        token1 = (Token) view.findViewById(R.id.chk1);
        token2 = (Token) view.findViewById(R.id.chk2);
        token3 = (Token) view.findViewById(R.id.chk3);
    }


    public void initTokenPosition(){
        player11.setCoord(coord1);
        player12.setCoord(coord2);
        player13.setCoord(coord3);
        player21.setCoord(coord7);
        player22.setCoord(coord8);
        player23.setCoord(coord9);

        token1.setCoord(coord4);
        token2.setCoord(coord5);
        token3.setCoord(coord6);

    }

    public void initCoords(View view){

        final View vw = view;


        vw.post(new Runnable() {
            @Override
            public void run() {
                int maxY = vw.getHeight();
                int maxX = vw.getWidth();
                int half = player11.getWidth() / 2;
                int full = player11.getWidth();

                coord1 = new Coordinate(0, 0);
                coord2 = new Coordinate((int)(maxX*0.5 - half), 0);
                coord3 = new Coordinate(maxX - full, 0);
                coord4 = new Coordinate(0, (int)(maxY*0.5 - half));
                coord5 = new Coordinate((int)(maxX*0.5 - half), (int)(maxY*0.5 - half));
                coord6 = new Coordinate((maxX - full), (int)(maxY*0.5 - half));
                coord7 = new Coordinate(0, (maxY - full));
                coord8 = new Coordinate((int)(maxX*0.5 - half), (maxY - full));
                coord9 = new Coordinate((maxX - full), (maxY - full));

                initTokenPosition();
            }
        });

    }

    public void resetButtons(View view){

        player11.setBackgroundColor(view.getResources().getColor(R.color.button1back));
        player12.setBackgroundColor(view.getResources().getColor(R.color.button1back));
        player13.setBackgroundColor(view.getResources().getColor(R.color.button1back));
        player21.setBackgroundColor(view.getResources().getColor(R.color.button2back));
        player22.setBackgroundColor(view.getResources().getColor(R.color.button2back));
        player23.setBackgroundColor(view.getResources().getColor(R.color.button2back));

        player11.setIsNotSelected();
        player12.setIsNotSelected();
        player13.setIsNotSelected();
        player21.setIsNotSelected();
        player22.setIsNotSelected();
        player23.setIsNotSelected();

    }

    public Boolean legalMove(Coordinate start, Coordinate stop){

        if(start.checkCoord(coord5) || stop.checkCoord(coord5)){

            return true;

        }

        if(start.checkCoord(coord1)){

            if(stop.checkCoord(coord2) || stop.checkCoord(coord4)){

                return true;

            }else {

                return false;

            }

        }

        if(start.checkCoord(coord2)){

            if(stop.checkCoord(coord1) || stop.checkCoord(coord3)){

                return true;

            }else {

                return false;

            }

        }

        if(start.checkCoord(coord3)){

            if(stop.checkCoord(coord2) || stop.checkCoord(coord6)){

                return true;

            }else {

                return false;

            }

        }

        if(start.checkCoord(coord4)){

            if(stop.checkCoord(coord1) || stop.checkCoord(coord7)){

                return true;

            }else {

                return false;

            }

        }

        if(start.checkCoord(coord6)){

            if(stop.checkCoord(coord3) || stop.checkCoord(coord9)){

                return true;

            }else {

                return false;

            }

        }

        if(start.checkCoord(coord7)){

            if(stop.checkCoord(coord4) || stop.checkCoord(coord8)){

                return true;

            }else {

                return false;

            }

        }

        if(start.checkCoord(coord8)){

            if(stop.checkCoord(coord7) || stop.checkCoord(coord9)){

                return true;

            }else {

                return false;

            }

        }

        if(start.checkCoord(coord9)){

            if(stop.checkCoord(coord6) || stop.checkCoord(coord8)) {

                return true;

            }else{

                return false;

            }

        }

        return false;

    }

    public Boolean isWin(Coordinate p1, Coordinate p2, Coordinate p3, int playerId){

        if(playerId == 2){

            if(p1.checkCoord(coord1) && p2.checkCoord(coord2) && p3.checkCoord(coord3)){

                return true;

            }

            return false;

        }else if(playerId == 1){

            if(p1.checkCoord(coord7) && p2.checkCoord(coord8) && p3.checkCoord(coord9)){

                return true;

            }

            return false;

        }

        if(p1.checkCoord(coord1) && p2.checkCoord(coord4) && p3.checkCoord(coord7)){

            return true;

        }else if(p1.checkCoord(coord3) && p2.checkCoord(coord6) && p3.checkCoord(coord9)){

            return true;

        }else if(p1.checkCoord(coord1) && p2.checkCoord(coord5) && p3.checkCoord(coord9)){

            return true;

        }else if(p1.checkCoord(coord4) && p2.checkCoord(coord5) && p3.checkCoord(coord7)){

            return true;

        }else if(p1.checkCoord(coord2) && p2.checkCoord(coord5) && p3.checkCoord(coord8)){

            return true;

        }else if(p1.checkCoord(coord4) && p2.checkCoord(coord5) && p3.checkCoord(coord6)){

            return true;

        }

        return false;

    }

    public void click(View view){

        Coordinate temp1 = new Coordinate(0, 0);
        Coordinate temp2 = new Coordinate(0, 0);

        int id = view.getId();

        if(id == player11.getId()){

            resetButtons(view);
            player11.setIsSlected();
            player11.setBackgroundColor(view.getResources().getColor(R.color.button1pressed));

        }else if(id == player12.getId()){

            resetButtons(view);
            player12.setIsSlected();
            player12.setBackgroundColor(view.getResources().getColor(R.color.button1pressed));

        }else if(id == player13.getId()){

            resetButtons(view);
            player13.setIsSlected();
            player13.setBackgroundColor(view.getResources().getColor(R.color.button1pressed));

        }else if(id == player21.getId()){

            resetButtons(view);
            player21.setIsSlected();
            player21.setBackgroundColor(view.getResources().getColor(R.color.button2pressed));

        }else if(id == player22.getId()){

            resetButtons(view);
            player22.setIsSlected();
            player22.setBackgroundColor(view.getResources().getColor(R.color.button2pressed));

        }else if(id == player23.getId()){

            resetButtons(view);
            player23.setIsSlected();
            player23.setBackgroundColor(view.getResources().getColor(R.color.button2pressed));

        }else if(id == token1.getId()){

            if(player11.isClicked()){

                temp1 = player11.getCoord();
                temp2 = token1.getCoord();

                if(legalMove(temp1, temp2)) {

                    player11.setCoord(temp2);
                    token1.setCoord(temp1);

                }

                player11.setIsNotSelected();
                player11.setBackgroundColor(view.getResources().getColor(R.color.button1back));

            }else if(player12.isClicked()){

                temp1 = player12.getCoord();
                temp2 = token1.getCoord();

                if(legalMove(temp1, temp2)) {

                    player12.setCoord(temp2);
                    token1.setCoord(temp1);

                }

                player12.setIsNotSelected();
                player12.setBackgroundColor(view.getResources().getColor(R.color.button1back));


            }else if(player13.isClicked()){

                temp1 = player13.getCoord();
                temp2 = token1.getCoord();

                if(legalMove(temp1, temp2)) {

                    player13.setCoord(temp2);
                    token1.setCoord(temp1);

                }

                player13.setIsNotSelected();
                player13.setBackgroundColor(view.getResources().getColor(R.color.button1back));


            }else if(player21.isClicked()){

                temp1 = player21.getCoord();
                temp2 = token1.getCoord();

                if(legalMove(temp1, temp2)) {

                    player21.setCoord(temp2);
                    token1.setCoord(temp1);

                }

                player21.setIsNotSelected();
                player21.setBackgroundColor(view.getResources().getColor(R.color.button2back));

            }else if(player22.isClicked()){

                temp1 = player22.getCoord();
                temp2 = token1.getCoord();

                if(legalMove(temp1, temp2)) {

                    player22.setCoord(temp2);
                    token1.setCoord(temp1);

                }

                player22.setIsNotSelected();
                player22.setBackgroundColor(view.getResources().getColor(R.color.button2back));

            }else if(player23.isClicked()){

                temp1 = player23.getCoord();
                temp2 = token1.getCoord();

                if(legalMove(temp1, temp2)) {

                    player23.setCoord(temp2);
                    token1.setCoord(temp1);

                }

                player23.setIsNotSelected();
                player23.setBackgroundColor(view.getResources().getColor(R.color.button2back));

            }

        }else if(id == token2.getId()){

            if(player11.isClicked()){

                temp1 = player11.getCoord();
                temp2 = token2.getCoord();

                if(legalMove(temp1, temp2)) {

                    player11.setCoord(temp2);
                    token2.setCoord(temp1);

                }

                player11.setIsNotSelected();
                player11.setBackgroundColor(view.getResources().getColor(R.color.button1back));

            }else if(player12.isClicked()){

                temp1 = player12.getCoord();
                temp2 = token2.getCoord();

                if(legalMove(temp1, temp2)) {

                    player12.setCoord(temp2);
                    token2.setCoord(temp1);

                }

                player12.setIsNotSelected();
                player12.setBackgroundColor(view.getResources().getColor(R.color.button1back));


            }else if(player13.isClicked()){

                temp1 = player13.getCoord();
                temp2 = token2.getCoord();

                if(legalMove(temp1, temp2)) {

                    player13.setCoord(temp2);
                    token2.setCoord(temp1);

                }

                player13.setIsNotSelected();
                player13.setBackgroundColor(view.getResources().getColor(R.color.button1back));


            }else if(player21.isClicked()){

                temp1 = player21.getCoord();
                temp2 = token2.getCoord();

                if(legalMove(temp1, temp2)) {

                    player21.setCoord(temp2);
                    token2.setCoord(temp1);

                }

                player21.setIsNotSelected();
                player21.setBackgroundColor(view.getResources().getColor(R.color.button2back));

            }else if(player22.isClicked()){

                temp1 = player22.getCoord();
                temp2 = token2.getCoord();

                if(legalMove(temp1, temp2)) {

                    player22.setCoord(temp2);
                    token2.setCoord(temp1);

                }

                player22.setIsNotSelected();
                player22.setBackgroundColor(view.getResources().getColor(R.color.button2back));

            }else if(player23.isClicked()){

                temp1 = player23.getCoord();
                temp2 = token2.getCoord();

                if(legalMove(temp1, temp2)) {

                    player23.setCoord(temp2);
                    token2.setCoord(temp1);

                }

                player23.setIsNotSelected();
                player23.setBackgroundColor(view.getResources().getColor(R.color.button2back));

            }

        }else if(id == token3.getId()) {

            if (player11.isClicked()) {

                temp1 = player11.getCoord();
                temp2 = token3.getCoord();

                if(legalMove(temp1, temp2)) {

                    player11.setCoord(temp2);
                    token3.setCoord(temp1);

                }

                player11.setIsNotSelected();
                player11.setBackgroundColor(view.getResources().getColor(R.color.button1back));

            } else if (player12.isClicked()) {

                temp1 = player12.getCoord();
                temp2 = token3.getCoord();

                if(legalMove(temp1, temp2)) {

                    player12.setCoord(temp2);
                    token3.setCoord(temp1);

                }

                player12.setIsNotSelected();
                player12.setBackgroundColor(view.getResources().getColor(R.color.button1back));


            } else if (player13.isClicked()) {

                temp1 = player13.getCoord();
                temp2 = token3.getCoord();

                if(legalMove(temp1, temp2)) {

                    player13.setCoord(temp2);
                    token3.setCoord(temp1);

                }

                player13.setIsNotSelected();
                player13.setBackgroundColor(view.getResources().getColor(R.color.button1back));


            } else if (player21.isClicked()) {

                temp1 = player21.getCoord();
                temp2 = token3.getCoord();

                if(legalMove(temp1, temp2)) {

                    player21.setCoord(temp2);
                    token3.setCoord(temp1);

                }

                player21.setIsNotSelected();
                player21.setBackgroundColor(view.getResources().getColor(R.color.button2back));

            } else if (player22.isClicked()) {

                temp1 = player22.getCoord();
                temp2 = token3.getCoord();

                if(legalMove(temp1, temp2)) {

                    player22.setCoord(temp2);
                    token3.setCoord(temp1);

                }

                player22.setIsNotSelected();
                player22.setBackgroundColor(view.getResources().getColor(R.color.button2back));

            } else if (player23.isClicked()) {

                temp1 = player23.getCoord();
                temp2 = token3.getCoord();

                if(legalMove(temp1, temp2)) {

                    player23.setCoord(temp2);
                    token3.setCoord(temp1);

                }

                player23.setIsNotSelected();
                player23.setBackgroundColor(view.getResources().getColor(R.color.button2back));

            }
        }
    }

}
