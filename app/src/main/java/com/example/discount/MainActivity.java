package com.example.discount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String my_discount_percent = "0";

    int my_progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final SeekBar seekBar = findViewById(R.id.seekBar);

       final EditText editText = findViewById(R.id.editText);

       final TextView my_discount_tx =  findViewById(R.id.my_discount_tx);

        final TextView after = findViewById(R.id.after);

         ;

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                my_progress = progress;

                Integer my_inpute = 0;

                if(editText.getText().toString().equals(""))  my_inpute = 0;

                else my_inpute = Integer.parseInt(editText.getText().toString());

                my_discount_tx.setText(Integer.toString(progress)+"%");

                Float after_cost = (float) my_inpute * progress/100;

                after.setText(Float.toString(after_cost));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

         editText.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {

             }

             @Override
             public void afterTextChanged(Editable s) {

                    int my_inpute = 0;

                   if(editText.getText().toString().equals(""))  my_inpute = 0;

                    else my_inpute = Integer.parseInt(editText.getText().toString());

                     Float after_cost = (float)my_inpute * my_progress/100;

                    after.setText(Float.toString(after_cost));

             }
         });

    }
}
