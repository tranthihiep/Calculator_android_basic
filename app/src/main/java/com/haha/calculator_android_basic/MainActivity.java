package com.haha.calculator_android_basic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity{
    Button buttonAC, buttonAddSub, buttonPercent, buttonDiv, button7,button8,button9,buttonMul,button4,
            button5,button6,buttonSub,button1,button2,button3,buttonAdd,button0, buttonDot,buttonEqual;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        textViewResult.setText("0");

    }

    private void Init() {
        button0 = (Button)  findViewById(R.id.btn0);
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        button4 = (Button) findViewById(R.id.btn4);
        button5 = (Button) findViewById(R.id.btn5);
        button6 = (Button) findViewById(R.id.btn6);
        button7 = (Button) findViewById(R.id.btn7);
        button8 = (Button) findViewById(R.id.btn8);
        button9 = (Button) findViewById(R.id.btn9);
        buttonAC = (Button) findViewById(R.id.btnAC);
        buttonAddSub = (Button) findViewById(R.id.btnAddSub);
        buttonPercent = (Button) findViewById(R.id.btnPercent);
        buttonDiv = (Button) findViewById(R.id.btnDiv);
        buttonMul = (Button) findViewById(R.id.btnMul);
        buttonSub = (Button) findViewById(R.id.btnSub);
        buttonEqual = (Button) findViewById(R.id.btnEqual);
        buttonDot = (Button) findViewById(R.id.btnDot);
        buttonAdd = (Button) findViewById(R.id.btnAdd);
        textViewResult = (TextView) findViewById(R.id.txtResult);
    }
}
