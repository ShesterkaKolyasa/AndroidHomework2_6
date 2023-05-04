package com.mirea.kt.homework2_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText yourString = findViewById(R.id.String);
        TextView textViewResult = findViewById(R.id.Result);
        Button btnFlip = findViewById(R.id.btnFlip);
        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnIncrease = findViewById(R.id.btnIncrease);
        btnFlip.setOnClickListener(v -> {
            Log.i("simple_app_tag", "Click flip button");
            String str = yourString.getText().toString();
            if(!str.isEmpty()){
                char[] array = str.toCharArray();
                String result = "";
                for (int i = array.length - 1; i >= 0; i--) {
                    result = result + array[i];
                }
                textViewResult.setText(String.valueOf(result));
                Log.i("simple app tag", "Result : " + result);
            }else{
                Log.w("Simple app tag", "Empty term!");
                Toast.makeText(getApplicationContext(), "Invalid terms", Toast.LENGTH_LONG).show();
            }
        });
        btnDelete.setOnClickListener(v -> {
            Log.i("simple_app_tag", "Click delete button");
            String str = yourString.getText().toString();
            if(!str.isEmpty()){
                String[] glasnye = {"e", "y", "u", "i", "o", "a", "й", "у", "е", "ы", "а", "о", "э", "я", "и", "ю"};
                for(int i = 0; i < glasnye.length; i++){
                    str = str.replace(glasnye[i],"");
                    str = str.replace(glasnye[i].toUpperCase(),"");
                }
                textViewResult.setText(String.valueOf(str));
                Log.i("simple app tag", "Result : " + str);
            }else{
                Log.w("Simple app tag", "Empty term!");
                Toast.makeText(getApplicationContext(), "Invalid terms", Toast.LENGTH_LONG).show();
            }
        });
        btnIncrease.setOnClickListener(v -> {
            Log.i("simple_app_tag", "Click increase button");
            String str = yourString.getText().toString();
            if(!str.isEmpty()){
                char[] chars = str.toCharArray();
                String result = "";
                for(int i = 0; i < chars.length; i++) {
                    if ((i+1) % 2 != 0) {
                        result = result+chars[i];
                    }else{
                        result = result+Character.toUpperCase(chars[i]);
                    }
                }
                textViewResult.setText(String.valueOf(result));
                Log.i("simple app tag", "Result : " + result);
            }else{
                Log.w("Simple app tag", "Empty term!");
                Toast.makeText(getApplicationContext(), "Invalid terms", Toast.LENGTH_LONG).show();
            }
        });
    }
}