package com.example.user.application_test;

import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import static java.sql.Types.NULL;

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

                String num1Str,num2Str;
                long number1,number2,result;

                num1Str = firstNumEditText.getText().toString();
                num2Str = secondNumEditText.getText().toString();
                try{
                    if(num1Str.isEmpty()||num2Str.isEmpty()){
                        resultTextView.setText("Invalid input");
                    }

                    else if(TextUtils.isDigitsOnly(num1Str)&&TextUtils.isDigitsOnly(num2Str)){

                        number1 = Long.parseLong(num1Str);
                        number2 = Long.parseLong(num2Str);
                        result = number1 + number2;
                        resultTextView.setText(result + "");
                    }
                    else{
                        resultTextView.setText("Invalid input");
                    }
                }
                catch(Exception e){
                    resultTextView.setText("Oops!");
                }
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
