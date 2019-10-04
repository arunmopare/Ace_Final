package com.example.ace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private Button btnLogOut;
    private FirebaseAuth auth;
    private String getEmailFire;
    private TextView result;
    private ImageView event_pic;
    private TextView event_dis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
       //
        super.onCreate(savedInstanceState);

        //result = (TextView) findViewById(R.id.display_user);
       //result.setText("Arun");

        setContentView(R.layout.activity_main2);

        btnLogOut=(Button) findViewById(R.id.logout_buttoin_main2);
        result=(TextView) findViewById(R.id.textView4);
        result.setText("Welcome "+FirebaseAuth.getInstance().getCurrentUser().getEmail());
        auth = FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
    public void signOut() {
        auth.signOut();
    }
    public String getEmail(){
       getEmailFire= auth.getCurrentUser().getEmail();
       getEmailFire.toString();
       return getEmailFire;
    }

//    public void updateTextView(String toThis) {
//        TextView textView11 = (TextView) findViewById(R.id.textView4);
//        textView11.setText(toThis);
//    }
}
