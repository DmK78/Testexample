package ru.job4j.testexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fm;
    private Fragment authFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager(); // получить FragmentManager
        authFragment = fm.findFragmentById(R.id.frameContainer);
        if (authFragment == null) {
            authFragment = new AutFragment();
            fm.beginTransaction()
                    .add(R.id.frameContainer, authFragment) // добавить фрагмент в контейнер
                    .commit();
        }
    }
}
