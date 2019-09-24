package ru.job4j.testexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AutFragment extends Fragment {
    private Button buttonSend;
    private EditText editTextEmail;
    private EditText editTextEmailText;
    private TextView textViewStatus;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.auth_fragment, container, false);
        buttonSend=view.findViewById(R.id.buttonSend);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        textViewStatus=view.findViewById(R.id.textViewStatus);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                Validator<String> emailValifator = new EmailValidator();
                if(emailValifator.validate(email)){
                    textViewStatus.setText("Success!");
                } else {
                    textViewStatus.setText("Validation Error!");
                }

            }
        });
        return view;
    }
}
