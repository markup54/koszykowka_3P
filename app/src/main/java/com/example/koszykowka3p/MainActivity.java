package com.example.koszykowka3p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.koszykowka3p.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Button button1;
    private Button button2;
    private Button button3;
    private int punkty=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding
                .inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.button
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dodajPunkty(1);
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dodajPunkty(2);
            }
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dodajPunkty(3);
            }
        });
    }

    private void dodajPunkty(int i){
        punkty=punkty+i;
        binding.textView.setText(Integer.toString(punkty));
    }
}

