package com.example.parstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {
    public static final String TAG = "SignupActivity";
    private EditText etUsername2;
    private EditText etPassword2;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        if(ParseUser.getCurrentUser() != null){
            goToMainActivity();
        }

        etUsername2 = findViewById(R.id.etUsername2);
        etPassword2 = findViewById(R.id.etPassword2);
        btnSignup = findViewById(R.id.btnSignup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick button signup");
                String username = etUsername2.getText().toString();
                String password = etPassword2.getText().toString();
                signupUser(username, password);
            }
        });
    }

    private void signupUser(String username, String password) {
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e != null){
                    Log.e(TAG, "Issue with Signup", e);
                    Toast.makeText(SignupActivity.this, "Issue with Signup", Toast.LENGTH_SHORT).show();
                    return;
                }
                goToMainActivity();
                Toast.makeText(SignupActivity.this, "Signup Success!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goToMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}