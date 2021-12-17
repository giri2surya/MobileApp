package nl.inholland.androideatinapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import nl.inholland.androideatinapplication.Common.Common;
import nl.inholland.androideatinapplication.Model.User;

public class LogIn extends AppCompatActivity {


    EditText editTextPhone, editTextPassword;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        editTextPhone = (MaterialEditText) findViewById(R.id.editTextPhone);
        editTextPassword = (MaterialEditText) findViewById(R.id.editTextPassword);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        // Initialisation of firebase database
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(LogIn.this);
                mDialog.setMessage("Please waiting.... ");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(editTextPhone.getText().toString()).exists()) {

                            mDialog.dismiss();
                            User user = dataSnapshot.child(editTextPhone.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(editTextPassword.getText().toString())) {

                                Intent homeIntent = new Intent(LogIn.this, Home.class);
                                Common.currentUser=user;
                                startActivity(homeIntent);
                                finish();
                                //Toast.makeText(LogIn.this, "Login successful", Toast
                                // .LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LogIn.this, "Wrong password !",
                                        Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            mDialog.dismiss();
                            Toast.makeText(LogIn.this, "User doesn't exists on database",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
