package com.harsh.internship;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button signin;
    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        signin = findViewById(R.id.main_singin);
        email = findViewById(R.id.main_email);
        password =findViewById(R.id.main_password);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().trim().equals("")){
                    email.setError("Email required");
                } else if (email.getText().toString().trim().matches("abc@gamil.com")) {
                    email.setError("'abc@gamil.com' format required");
                } else if (password.getText().toString().trim().equals("")){
                    password.setError("Password required");
                } else if (password.getText().toString().trim().length()<6) {
                    password.setError("Min 6 character required in password");
                } else{
//                    System.out.println("login Successfully");
                    Toast.makeText(MainActivity.this, "Login Successfully",Toast.LENGTH_SHORT).show();
                    Snackbar.make(v,"Login Successfully",Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}