package com.madesty.madestymwesogame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    Button submit;
    //ScrollView existingUsers;
    EditText editText;
    LinearLayout linlay;
    ArrayList<String> users = new ArrayList();
    public static User player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        submit = (Button) findViewById(R.id.newUserSubmit);
        //existingUsers = (ScrollView) findViewById(R.id.existinguserscrollable);
        editText = (EditText) findViewById(R.id.newUseredittxt);
        linlay = (LinearLayout) findViewById(R.id.linlay);

        getUsers();
        userButtons();

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

        if(id == R.id.newUserSubmit){

            String name = editText.getText().toString();
            users.add(name);
            setUsers();
            startActivity(new Intent(this, WelcomeActivity.class));
            player = new User(name);

        }
    }

    public void getUsers(){

        try{
            FileInputStream fis = openFileInput("users");
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (ArrayList) ois.readObject();
            ois.close();
            fis.close();

        }catch (FileNotFoundException e){

        }catch (ClassNotFoundException e){

        }catch (IOException e){}
    }

    public void setUsers(){

        String name = "users";

        try {
            FileOutputStream fos = openFileOutput(name, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
            fos.close();
        }catch(IOException e){

        }
    }

    public void userButtons(){

        for(int i = 0; i < users.size(); i++) {
            Button button = new Button(linlay.getContext());
            button.setText(users.get(i));
            //existingUsers.addView(button, i);
            linlay.addView(button, i);

        }

    }

}
