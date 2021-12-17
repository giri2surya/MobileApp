package nl.inholland.androideatinapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn, btnSignUp;
    TextView textViewSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        textViewSlogan = (TextView) findViewById(R.id.textSlogan);

        //DrawerLayout drawerContact;
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Nabila.ttf");
        textViewSlogan.setTypeface(face);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LogIn.class);
                startActivity(intent);
            }
        });
/*
        drawerContact = (DrawerLayout) findViewById(R.id.nav_contact);

        drawerContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent contactIntend = new Intent(MainActivity.this, Contact.class);
                startActivity(contactIntend);
            }
        });

 */
    }
}
