package com.example.btgiuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private EditText Name;
    private  EditText Password;
    private TextView Info;
    private Button Login;
    private int Counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText)findViewById(R.id.edtName);
        Password = (EditText)findViewById(R.id.edtpass);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);

        Info.setText("Không nhập sai quá: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    private void validate(String username , String userpassword){
        if((username.equals("admin")) && (userpassword.equals("12345"))){
            Intent intent = new Intent(Login.this,MainActivity.class);
            startActivity(intent);
        }else{
            Counter--;

            Info.setText("Không nhập sai quá:"+ String.valueOf(Counter));

            if(Counter == 0){
                Login.setEnabled(false);
            }


        }
    }
};