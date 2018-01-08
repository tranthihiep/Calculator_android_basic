package com.haha.calculator_android_basic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonAC, buttonAddSub, buttonPercent, buttonDiv, button7,button8,button9,buttonMul,button4,
            button5,button6,buttonSub,button1,button2,button3,buttonAdd,button0, buttonDot,buttonEqual;
    TextView textViewResult;
    private final int ADD = 1;
    private final int SUB = 2;
    private final int MUL = 3;
    private final int DIV = 4;
    DecimalFormat df = new DecimalFormat("###.#######");
    double var1, var2;
    boolean add, sub, div, mul;
    static double s_result = 0;
    int operation = 0;
    boolean isOperation = false;
    boolean isFirst = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        textViewResult.setText(df.format(s_result));
        isFirst = true;
        var1 = 0; var2 = 0;
        setOnClick();

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
    private void setOnClick() {
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonAC.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonAddSub.setOnClickListener(this);
        buttonPercent.setOnClickListener(this);
    }

    private String getNumFromKey(int id)
    {
        String temp = "";
        switch(id)
        {
            case 1:
                temp = "1";
                break;
            case 2:
                temp = "2";
                break;
            case 3:
                temp = "3";
                break;
            case 4:
                temp = "4";
                break;
            case 5:
                temp = "5";
                break;
            case 6:
                temp = "6";
                break;
            case 7:
                temp = "7";
                break;
            case 8:
                temp = "8";
                break;
            case 9:
                temp = "9";
                break;
            case 0:
                temp = "0";
                break;
            case -1:
                temp = ".";
                break;
        }

        String txt = textViewResult.getText().toString();
        if( txt.equalsIgnoreCase("0") && !temp.equals("."))
        {
            txt = "";
        }

        if(!isOperation)
            temp = txt + temp;
        else
            isOperation = false;

        return temp;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn0:
                textViewResult.setText(getNumFromKey(0));
                break;
            case R.id.btn1:
                textViewResult.setText(getNumFromKey(1));
                break;
            case R.id.btn2:
                textViewResult.setText(getNumFromKey(2));
                break;
            case R.id.btn3:
                textViewResult.setText(getNumFromKey(3));
                break;
            case R.id.btn4:
                textViewResult.setText(getNumFromKey(4));
                break;
            case R.id.btn5:
                textViewResult.setText(getNumFromKey(5));
                break;
            case R.id.btn6:
                textViewResult.setText(getNumFromKey(6));
                break;
            case R.id.btn7:
                textViewResult.setText(getNumFromKey(7));
                break;
            case R.id.btn8:
                textViewResult.setText(getNumFromKey(8));
                break;
            case R.id.btn9:
                textViewResult.setText(getNumFromKey(9));
                break;
            case R.id.btnDot:
                if (!textViewResult.getText().toString().contains("."))
                {
                    textViewResult.setText(getNumFromKey(-1));
                }
                break;
            case R.id.btnAC:
                isFirst = true;
                isOperation = false;
                s_result = 0;
                textViewResult.setText(df.format(s_result)+"");
                break;
            case R.id.btnPercent:
                if (textViewResult.length()!=0){
                    textViewResult.setText(Double.parseDouble(textViewResult.getText().toString())/100 +"");}
                break;
            case R.id.btnAddSub:
                if (textViewResult.length()!=0){
                    textViewResult.setText(df.format(Double.parseDouble(textViewResult.getText().toString())*(-1))+"");}
                break;
            case R.id.btnAdd:
                isOperation = true;
                add = true;
                if(isFirst)
                {
                    var1 = Double.parseDouble(textViewResult.getText().toString());
                    textViewResult.setText(df.format(var1)+ "");
                }else {
                    var2 = Double.parseDouble(textViewResult.getText().toString());
                    s_result = calculator(operation, var1, var2);
                    textViewResult.setText(df.format(s_result) + "");
                    var1 = s_result;
                }
                operation = ADD;
                isFirst=false;
                break;
            case R.id.btnSub:
                isOperation = true;
                sub = true;
                if(isFirst)
                {
                    var1 = Double.parseDouble(textViewResult.getText().toString());
                    textViewResult.setText(df.format(var1) + "");
                }else {
                    var2 = Double.parseDouble(textViewResult.getText().toString());
                    s_result = calculator(operation, var1, var2);
                    textViewResult.setText(df.format(s_result) + "");
                    var1 = s_result;
                }
                operation = SUB;
                isFirst=false;
                break;
            case R.id.btnMul:
                isOperation = true;
                mul = true;
                if(isFirst)
                {
                    var1 = Double.parseDouble(textViewResult.getText().toString());
                    textViewResult.setText(df.format(var1) + "");
                }else {
                    var2 = Double.parseDouble(textViewResult.getText().toString());
                    s_result = calculator(operation, var1, var2);
                    textViewResult.setText(df.format(s_result) + "");
                    var1 = s_result;
                }
                operation = MUL;
                isFirst=false;
                break;
            case R.id.btnDiv:
                isOperation = true;
                div = true;

                if(isFirst)
                {
                    var1 = Double.parseDouble(textViewResult.getText().toString());
                    textViewResult.setText(df.format(var1) + "");
                }else {
                    var2 = Double.parseDouble(textViewResult.getText().toString());
                    s_result = calculator(operation, var1, var2);
                    textViewResult.setText(df.format(var1) + "");
                    var1 = s_result;
                }
                operation = DIV;
                isFirst=false;
                break;
            case R.id.btnEqual:
                isOperation = true;
                var2 = Double.parseDouble(textViewResult.getText().toString());
                isFirst=true;
                var2 = Double.parseDouble(textViewResult.getText().toString());
                s_result = calculator(operation, var1, var2);
                textViewResult.setText(df.format(s_result) + "");
                break;
        }
    }




    private Double calculator(int o, double varFirst, double varSecond)
    {
        double resultTemp = 0;
        switch (o)
        {
            case ADD:
                resultTemp = varFirst + varSecond;
                break;
            case SUB:
                resultTemp = varFirst - varSecond;
                break;
            case MUL:
                resultTemp = varFirst * varSecond;
                break;
            case DIV:
                resultTemp = varFirst / varSecond;
                break;
        }

        return resultTemp;
    }

}
