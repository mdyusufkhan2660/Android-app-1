package com.example.user.application_test;

import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = (Button) findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText) findViewById(R.id.secondNumEditText);
                TextView resultTextView = (TextView) findViewById(R.id.resultTextView);

                int number1 = Integer.parseInt(firstNumEditText.getText().toString());
                int number2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result = number1 + number2;

                resultTextView.setText(result + "");

                /* Hide number pad or key pad after the button is pressed
                ref: https://www.android-examples.com/hide-edittext-soft-keyboard-on-android-programmatically-on-button-click/
                 */
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(firstNumEditText.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(secondNumEditText.getWindowToken(), 0);
            }
        });
    }
}
