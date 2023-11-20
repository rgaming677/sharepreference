package com.example.sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private Handler handler = new Handler();
    private SharedPrefManager sharedPrefManager;
    private EditText Uname, Upassword;
    private Button btnlg;
    private ProgressBar pbLogin;
    private ImageView Lging;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sharedPrefManager = new SharedPrefManager(this);
        if (sharedPrefManager.getIsLogin()) {
            startHomeUi();
        } else {
            Uname = findViewById(R.id.Uname);
            Upassword = findViewById(R.id.Upassword);
            Lging = findViewById(R.id.Lging);
            btnlg = findViewById(R.id.btnlg);

            login();
        }
    }

    private void startHomeUi() {
        Intent i = new Intent(MainActivity2.this, HomeActivity.class);
        startActivity(i);
        finishActivity();
    }
    private void login() {
        btnlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = Uname.getText().toString();
                final String password = Upassword.getText().toString();

                Lging.setVisibility(View.GONE);

                if (username.isEmpty() || password.isEmpty()) {
                    Lging.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity2.this, "Tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            String spUsername = sharedPrefManager.getUsername();
                            String SpPassword = sharedPrefManager.getPassword();

                            Log.d("username", "user"+username);
                            Log.d("password", "pass"+password);
                        }
                    }, 3000);
                }
            }
        });
    }


}