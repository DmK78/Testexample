package ru.job4j.testexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonSend;
    private EditText editTextEmail;
    private EditText editTextEmailText;
    private TextView textViewStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSend=findViewById(R.id.buttonSend);

        textViewStatus=findViewById(R.id.textViewStatus);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextEmail = findViewById(R.id.editTextEmail);
                String email = editTextEmail.getText().toString();
                Validator<String> emailValifator = new EmailValidator();
                if(emailValifator.validate(email)){
                    textViewStatus.setText("Success!");
                } else {
                    textViewStatus.setText("Validation Error!");
                }

            }
        });
    }
}
