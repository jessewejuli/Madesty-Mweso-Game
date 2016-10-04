package com.madesty.madestymwesogame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    Button human;
    Button computer;
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        human = (Button) findViewById(R.id.human);
        computer = (Button) findViewById(R.id.computer);
        username = (TextView) findViewById(R.id.username);
        username.setText(LoginActivity.player.getName());

    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.outgame, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case R.id.exitapp:

                return true;

            case R.id.settings:

                return true;

            default:
                return super.onOptionsItemSelected(menuItem);
        }

    }


    public void onClick(View view){
        int id = view.getId();

        if(id == R.id.human){

            startActivity(new Intent(this, EnterActivity.class));

        }else if(id == R.id.computer){



        }
    }

}
