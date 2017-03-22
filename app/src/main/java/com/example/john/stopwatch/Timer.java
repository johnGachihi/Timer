package com.example.john.stopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Timer extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;

    @OnClick(R.id.cancel)
    public void cancelLastCharacter() {
        char[] chararray = textView.getText().toString().toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int lastChar = chararray.length;
        for(int i = 0; i<lastChar; ++i) {
            stringBuilder.append(" " + chararray[i]);
        }
        Log.e("the array", stringBuilder.toString());

        char[] copier = Arrays.copyOfRange(chararray, 0, lastChar-1);
        String string = new String(copier);
        textView.setText(string);
        int anotherLastChar = copier.length;
        //Log.e("the last char", new StringBuilder().append(copier[anotherLastChar-1]).toString());
    }

    @OnClick({R.id.no1, R.id.no2, R.id.no3, R.id.no4, R.id.no5, R.id.no6, R.id.no7, R.id.no8, R.id.no9, R.id.no0})
    public void appendNumber(Button button) {
        textView.append(button.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        ButterKnife.bind(this);

        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (textView.getText().length() == 2) {
                    textView.append(":");
                }
            }
        });
    }
}
