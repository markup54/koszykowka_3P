package com.example.koszykowka3p;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.koszykowka3p.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private SharedPreferences punktySharedPrefences;
    private int punkty=0;
    private PunktyViewModel punktyViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding
                .inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        punktyViewModel = new ViewModelProvider(this).get(PunktyViewModel.class);
        punkty = punktyViewModel.punkty;
        //punktySharedPrefences = getPreferences(MODE_PRIVATE);
        //punkty=odczytajPunkty();
        binding.textView.setText(Integer.toString(punkty));
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
        punktyViewModel.punkty +=i;
        binding.textView.setText(Integer.toString(punktyViewModel.punkty));
    }

    @Override
    protected void onPause() {
        super.onPause();
        //zapiszPunkty();
    }

    private void zapiszPunkty(){
        SharedPreferences.Editor editor
                =punktySharedPrefences.edit();
        editor.putInt("punkty",punkty);
        editor.apply();
    }
    private int odczytajPunkty(){
        int punkty = punktySharedPrefences.getInt("punkty",0);
        return punkty;
    }
}

