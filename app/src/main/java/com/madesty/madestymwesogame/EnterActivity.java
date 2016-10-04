package com.madesty.madestymwesogame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class EnterActivity extends AppCompatActivity {

    private Gameboard gameboard;

    public static Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        /*context = this;

        player11 = (Player) findViewById(R.id.p11);
        player12 = (Player) findViewById(R.id.p12);
        player13 = (Player) findViewById(R.id.p13);
        player21 = (Player) findViewById(R.id.p21);
        player22 = (Player) findViewById(R.id.p22);
        player23 = (Player) findViewById(R.id.p23);
        chk1 = (Token) findViewById(R.id.chk1);
        chk2 = (Token) findViewById(R.id.chk2);
        chk3 = (Token) findViewById(R.id.chk3);
        */

        gameboard = new Gameboard(findViewById(R.id.gameBoard));

        Intent intent = new Intent(this, AudioPlayer.class);
        startService(intent);


        //Toast.makeText(this, "In Oncreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Intent intent = new Intent(this, AudioPlayer.class);
        stopService(intent);
    }

    public void onStop(){
        super.onStop();
        Intent intent = new Intent(this, AudioPlayer.class);
        stopService(intent);

    }

    public void onStart(){
        super.onStart();
        Intent intent = new Intent(this, AudioPlayer.class);
        startService(intent);
    }

    public void onPause(){
        super.onPause();
        Intent intent = new Intent(this, AudioPlayer.class);
        stopService(intent);

    }

    public void onClick(View view){
        gameboard.click(view);
    }

    /*public void onClick(View view){

        Coordinate temp1 = new Coordinate(0, 0);
        Coordinate temp2 = new Coordinate(0, 0);

        int id = view.getId();

        if(id == player11.getId()){

            gameboard.resetButtons(findViewById(R.id.gameBoard));
            gameboard.player11.setIsSlected();
            player11.setBackgroundColor(getResources().getColor(R.color.button1pressed));

        }else if(id == player12.getId()){

            resetButtons();
            player12.setIsSlected();
            player12.setBackgroundColor(getResources().getColor(R.color.button1pressed));

        }else if(id == player13.getId()){

            resetButtons();
            player13.setIsSlected();
            player13.setBackgroundColor(getResources().getColor(R.color.button1pressed));

        }else if(id == player21.getId()){

            resetButtons();
            player21.setIsSlected();
            player21.setBackgroundColor(getResources().getColor(R.color.button2pressed));

        }else if(id == player22.getId()){

            resetButtons();
            player22.setIsSlected();
            player22.setBackgroundColor(getResources().getColor(R.color.button2pressed));

        }else if(id == player23.getId()){

            resetButtons();
            player23.setIsSlected();
            player23.setBackgroundColor(getResources().getColor(R.color.button2pressed));

        }else if(id == chk1.getId()){

            if(player11.isClicked()){

                temp1 = player11.getCoord();
                temp2 = chk1.getCoord();

                if(gameboard.legalMove(temp1, temp2)) {

                    player11.setCoord(temp2);
                    chk1.setCoord(temp1);

                }

                player11.setIsNotSelected();
                player11.setBackgroundColor(getResources().getColor(R.color.button1back));

            }else if(player12.isClicked()){

                temp1 = player12.getCoord();
                temp2 = chk1.getCoord();

                if(gameboard.legalMove(temp1, temp2)) {

                    player12.setCoord(temp2);
                    chk1.setCoord(temp1);

                }

                player12.setIsNotSelected();
                player12.setBackgroundColor(getResources().getColor(R.color.button1back));


            }else if(player13.isClicked()){

                temp1 = player13.getCoord();
                temp2 = chk1.getCoord();

                if(gameboard.legalMove(temp1, temp2)) {

                    player13.setCoord(temp2);
                    chk1.setCoord(temp1);

                }

                player13.setIsNotSelected();
                player13.setBackgroundColor(getResources().getColor(R.color.button1back));


            }else if(player21.isClicked()){

                temp1 = player21.getCoord();
                temp2 = chk1.getCoord();

                if(gameboard.legalMove(temp1, temp2)) {

                    player21.setCoord(temp2);
                    chk1.setCoord(temp1);

                }

                player21.setIsNotSelected();
                player21.setBackgroundColor(getResources().getColor(R.color.button2back));

            }else if(player22.isClicked()){

                temp1 = player22.getCoord();
                temp2 = chk1.getCoord();

                if(gameboard.legalMove(temp1, temp2)) {

                    player22.setCoord(temp2);
                    chk1.setCoord(temp1);

                }

                player22.setIsNotSelected();
                player22.setBackgroundColor(getResources().getColor(R.color.button2back));

            }else if(player23.isClicked()){

                temp1 = player23.getCoord();
                temp2 = chk1.getCoord();

                if(gameboard.legalMove(temp1, temp2)) {

                    player23.setCoord(temp2);
                    chk1.setCoord(temp1);

                }

                player23.setIsNotSelected();
                player23.setBackgroundColor(getResources().getColor(R.color.button2back));

            }

        }else if(id == chk2.getId()){

            if(player11.isClicked()){

                temp1 = player11.getCoord();
                temp2 = chk2.getCoord();

                if(gameboard.legalMove(temp1, temp2)) {

                    player11.setCoord(temp2);
                    chk2.setCoord(temp1);

                }

                player11.setIsNotSelected();
                player11.setBackgroundColor(getResources().getColor(R.color.button1back));

            }else if(player12.isClicked()){

                temp1 = player12.getCoord();
                temp2 = chk2.getCoord();

                if(gameboard.legalMove(temp1, temp2)) {

                    player12.setCoord(temp2);
                    chk2.setCoord(temp1);

                }

                player12.setIsNotSelected();
                player12.setBackgroundColor(getResources().getColor(R.color.button1back));


            }else if(player13.isClicked()){

                temp1 = player13.getCoord();
                temp2 = chk2.getCoord();

                if(gameboard.legalMove(temp1, temp2)) {

                    player13.setCoord(temp2);
                    chk2.setCoord(temp1);

                }

                player13.setIsNotSelected();
                player13.setBackgroundColor(getResources().getColor(R.color.button1back));


            }else if(player21.isClicked()){

                temp1 = player21.getCoord();
                temp2 = chk2.getCoord();

                if(gameboard.legalMove(temp1, temp2)) {

                    player21.setCoord(temp2);
                    chk2.setCoord(temp1);

                }

                player21.setIsNotSelected();
                player21.setBackgroundColor(getResources().getColor(R.color.button2back));

            }else if(player22.isClicked()){

                temp1 = player22.getCoord();
                temp2 = chk2.getCoord();

                if(gameboard.legalMove(temp1, temp2)) {

                    player22.setCoord(temp2);
                    chk2.setCoord(temp1);

                }

                player22.setIsNotSelected();
                player22.setBackgroundColor(getResources().getColor(R.color.button2back));

            }else if(player23.isClicked()){

                temp1 = player23.getCoord();
                temp2 = chk2.getCoord();

                if(gameboard.legalMove(temp1, temp2)) {

                    player23.setCoord(temp2);
                    chk2.setCoord(temp1);

                }

                player23.setIsNotSelected();
                player23.setBackgroundColor(getResources().getColor(R.color.button2back));

            }

        }else if(id == chk3.getId()) {

            if (player11.isClicked()) {

                temp1 = player11.getCoord();
                temp2 = chk3.getCoord();

                if(gameboard.legalMove(temp1, temp2)) {

                    player11.setCoord(temp2);
                    chk3.setCoord(temp1);

                }

                player11.setIsNotSelected();
                player11.setBackgroundColor(getResources().getColor(R.color.button1back));

            } else if (player12.isClicked()) {

                temp1 = player12.getCoord();
                temp2 = chk3.getCoord();

                if(gameboard.legalMove(temp1, temp2)) {

                    player12.setCoord(temp2);
                    chk3.setCoord(temp1);

                }

                player12.setIsNotSelected();
                player12.setBackgroundColor(getResources().getColor(R.color.button1back));


            } else if (player13.isClicked()) {

                temp1 = player13.getCoord();
                temp2 = chk3.getCoord();

                if(gameboard.legalMove(temp1, temp2)) {

                    player13.setCoord(temp2);
                    chk3.setCoord(temp1);

                }

                player13.setIsNotSelected();
                player13.setBackgroundColor(getResources().getColor(R.color.button1back));


            } else if (player21.isClicked()) {

                temp1 = player21.getCoord();
                temp2 = chk3.getCoord();

                if(gameboard.legalMove(temp1, temp2)) {

                    player21.setCoord(temp2);
                    chk3.setCoord(temp1);

                }

                player21.setIsNotSelected();
                player21.setBackgroundColor(getResources().getColor(R.color.button2back));

            } else if (player22.isClicked()) {

                temp1 = player22.getCoord();
                temp2 = chk3.getCoord();

                if(gameboard.legalMove(temp1, temp2)) {

                    player22.setCoord(temp2);
                    chk3.setCoord(temp1);

                }

                player22.setIsNotSelected();
                player22.setBackgroundColor(getResources().getColor(R.color.button2back));

            } else if (player23.isClicked()) {

                temp1 = player23.getCoord();
                temp2 = chk3.getCoord();

                if(gameboard.legalMove(temp1, temp2)) {

                    player23.setCoord(temp2);
                    chk3.setCoord(temp1);

                }

                player23.setIsNotSelected();
                player23.setBackgroundColor(getResources().getColor(R.color.button2back));

            }
        }
    }
   */

    /*public Display initDisplay(){

        Display mdisp = getWindowManager().getDefaultDisplay();
        float maxX= mdisp.getWidth();
        float maxY= mdisp.getHeight();
        return mdisp;

        Toast.makeText(this, String.valueOf(maxX) + " " + String.valueOf(maxY), Toast.LENGTH_SHORT).show();

        Coordinate c1, c2, c3, c4, c5, c6, c7, c8, c9;

        c1 = new Coordinate(0, 0);
        c2 = new Coordinate((maxX * 0.5f) - (player11.getScaleX()/2f), 0);
        c3 = new Coordinate(maxX - 210f, 0);
        c4 = new Coordinate(0, ((maxY * 0.5F) - 250f));
        c5 = new Coordinate(((maxX * 0.5F) - 105f), ((maxY * 0.5F) - 250f));
        c6 = new Coordinate((maxX - 210f), ((maxY * 0.5F) - 250f));
        c7 = new Coordinate(0, maxY - 500f);
        c8 = new Coordinate(((maxX * 0.5F) - 105f), (maxY - 500f));
        c9 = new Coordinate((maxX - 210f), (maxY - 500f));

        player11.setScaleX(maxX/800f);
        player11.setScaleY(maxY/1000f);
        player12.setScaleX(maxX/800f);
        player12.setScaleY(maxY/1000f);
        player13.setScaleX(maxX/800f);
        player13.setScaleY(maxY/1000f);
        player21.setScaleX(maxX/800f);
        player21.setScaleY(maxY/1000f);
        player22.setScaleX(maxX/800f);
        player22.setScaleY(maxY/1000f);
        player23.setScaleX(maxX/800f);
        player23.setScaleY(maxY/1000f);
        chk1.setScaleX(maxX/800f);
        chk1.setScaleY(maxY/1000f);
        chk2.setScaleX(maxX/800f);
        chk2.setScaleY(maxY/1000f);
        chk3.setScaleX(maxX/800f);
        chk3.setScaleY(maxY/1000f);

        gameboard = new Gameboard();

        player11.setCoord(c1);
        player11.setX(0);
        player11.setY(0);

        player12.setCoord(c2);
        //player12.setX((maxX * 0.5F) - 105f);
        //player12.setY(0);
        player12.setX((maxX * 0.5f) - (player11.getScaleX()/2f));
        player12.setY(0);

        player13.setCoord(c3);
        //player13.setX(maxX - 210f);
        //player13.setY(0);
        player13.setX(maxX - (player13.getScaleX()));
        player13.setY(0);

        player21.setCoord(c7);
        //player21.setX(0);
        //player21.setY(maxY - 500f);
        player21.setX(0);
        player21.setY(maxY - (player21.getScaleY()));

        player22.setCoord(c8);
        //player22.setX((maxX * 0.5F) - 105f);
        //player22.setY(maxY - 500f);
        player22.setX((maxX * 0.5f) - (player22.getScaleX() / 2f));
        player22.setY(maxY - player22.getScaleY());

        player23.setCoord(c9);
        //player23.setX(maxX - 210f);
        //player23.setY(maxY - 500f);
        player23.setX(maxX  - player22.getScaleX());
        player23.setY(maxY - player22.getScaleY());

        chk1.setCoord(c4);
        //chk1.setX(0);
        //chk1.setY((maxY * 0.5F) - 250f);
        chk1.setX(0);
        chk1.setY((maxY * 0.5f)  - (chk1.getScaleY() / 2f));

        chk2.setCoord(c5);
        //chk2.setX((maxX * 0.5F) - 105f);
        //chk2.setY((maxY * 0.5F) - 250f);
        chk2.setX((maxX * 0.5f) - (chk2.getScaleX() / 2f));
        chk2.setY((maxY * 0.5f)  - (chk2.getScaleY() / 2f));

        chk3.setCoord(c6);
        //chk3.setX(maxX - 210f);
        //chk3.setY((maxY * 0.5F) - 250f);
        chk3.setX(maxX - (chk3.getScaleX()));
        chk3.setY((maxY * 0.5f  - (chk3.getScaleY() / 2f)));

        resetButtons();

    }*/

}
