package com.haha.calculator_android_basic;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by trant on 09/01/2018.
 */

public class FragmentCalcultor extends Fragment implements View.OnClickListener {
    Button btnAC, btnAddSub, btnPercent, btnDiv, btn7, btn8, btn9, btnMul, btn4,
            btn5, btn6, btnSub, btn1, btn2, btn3, btnAdd, btn0, btnDot, btnEqual;
    TextView txtResult;
    private final int ADD = 1;
    private final int SUB = 2;
    private final int MUL = 3;
    private final int DIV = 4;
    private DecimalFormat df = new DecimalFormat("###.#######");
    private double var1, var2;
    private boolean add, sub, div, mul;
    private static double s_result = 0;
    private int operation = 0;
    private boolean isOperation = false;
    private boolean isFirst = false;
    private SharedPreferences shared;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator,container,false);
        init(view);
        isFirst = true;
        var1 = 0;
        var2 = 0;
        setOnClick();
        String result = txtResult.getText().toString();
        shared = getActivity().getSharedPreferences("SaveData", MODE_PRIVATE);
        result = shared.getString("result", String.valueOf(0));
        txtResult.setText(result);
        return view;}
    private void init(View view) {
        btn0 = (Button) view.findViewById(R.id.btn0);
        btn1 = (Button) view.findViewById(R.id.btn1);
        btn2 = (Button) view.findViewById(R.id.btn2);
        btn3 = (Button) view.findViewById(R.id.btn3);
        btn4 = (Button) view.findViewById(R.id.btn4);
        btn5 = (Button) view.findViewById(R.id.btn5);
        btn6 = (Button) view.findViewById(R.id.btn6);
        btn7 = (Button) view.findViewById(R.id.btn7);
        btn8 = (Button) view.findViewById(R.id.btn8);
        btn9 = (Button) view.findViewById(R.id.btn9);
        btnAC = (Button) view.findViewById(R.id.btnAC);
        btnAddSub = (Button) view.findViewById(R.id.btnAddSub);
        btnPercent = (Button) view.findViewById(R.id.btnPercent);
        btnDiv = (Button) view.findViewById(R.id.btnDiv);
        btnMul = (Button) view.findViewById(R.id.btnMul);
        btnSub = (Button) view.findViewById(R.id.btnSub);
        btnEqual = (Button) view.findViewById(R.id.btnEqual);
        btnDot = (Button) view.findViewById(R.id.btnDot);
        btnAdd = (Button) view.findViewById(R.id.btnAdd);
        txtResult = (TextView) view.findViewById(R.id.txtResult);
    }

    private void setOnClick() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnAC.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnAddSub.setOnClickListener(this);
        btnPercent.setOnClickListener(this);
    }

    private String getNumFromKey(int id) {
        String temp = "";
        switch (id) {
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

        String txt = txtResult.getText().toString();
        if (txt.equalsIgnoreCase("0") && !temp.equals(".")) {
            txt = "";
        }

        if (!isOperation)
            temp = txt + temp;
        else
            isOperation = false;

        return temp;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn0:
                txtResult.setText(getNumFromKey(0));
                break;
            case R.id.btn1:
                txtResult.setText(getNumFromKey(1));
                break;
            case R.id.btn2:
                txtResult.setText(getNumFromKey(2));
                break;
            case R.id.btn3:
                txtResult.setText(getNumFromKey(3));
                break;
            case R.id.btn4:
                txtResult.setText(getNumFromKey(4));
                break;
            case R.id.btn5:
                txtResult.setText(getNumFromKey(5));
                break;
            case R.id.btn6:
                txtResult.setText(getNumFromKey(6));
                break;
            case R.id.btn7:
                txtResult.setText(getNumFromKey(7));
                break;
            case R.id.btn8:
                txtResult.setText(getNumFromKey(8));
                break;
            case R.id.btn9:
                txtResult.setText(getNumFromKey(9));
                break;
            case R.id.btnDot:
                if (!txtResult.getText().toString().contains(".")|| txtResult.length()==0) {
                    txtResult.setText(getNumFromKey(-1));
                }
                break;
            case R.id.btnAC:
                isFirst = true;
                isOperation = false;
                s_result = 0;
                txtResult.setText(df.format(s_result) + "");
                break;
            case R.id.btnPercent:
                if (txtResult.length() != 0) {
                    txtResult.setText(Double.parseDouble(txtResult.getText().toString()) / 100 + "");
                }
                break;
            case R.id.btnAddSub:
                if (txtResult.length() != 0) {
                    txtResult.setText(df.format(Double.parseDouble(txtResult.getText().toString()) * (-1)) + "");
                }
                break;
            case R.id.btnAdd:
                isOperation = true;
                add = true;
                if (isFirst) {
                    var1 = Double.parseDouble(txtResult.getText().toString());
                    txtResult.setText(df.format(var1) + "");
                } else {
                    var2 = Double.parseDouble(txtResult.getText().toString());
                    s_result = calculator(operation, var1, var2);
                    txtResult.setText(df.format(s_result) + "");
                    var1 = s_result;
                }
                operation = ADD;
                isFirst = false;
                break;
            case R.id.btnSub:
                isOperation = true;
                sub = true;
                if (isFirst) {
                    var1 = Double.parseDouble(txtResult.getText().toString());
                    txtResult.setText(df.format(var1) + "");
                } else {
                    var2 = Double.parseDouble(txtResult.getText().toString());
                    s_result = calculator(operation, var1, var2);
                    txtResult.setText(df.format(s_result) + "");
                    var1 = s_result;
                }
                operation = SUB;
                isFirst = false;
                break;
            case R.id.btnMul:
                isOperation = true;
                mul = true;
                if (isFirst) {
                    var1 = Double.parseDouble(txtResult.getText().toString());
                    txtResult.setText(df.format(var1) + "");
                } else {
                    var2 = Double.parseDouble(txtResult.getText().toString());
                    s_result = calculator(operation, var1, var2);
                    txtResult.setText(df.format(s_result) + "");
                    var1 = s_result;
                }
                operation = MUL;
                isFirst = false;
                break;
            case R.id.btnDiv:
                isOperation = true;
                div = true;

                if (isFirst) {
                    var1 = Double.parseDouble(txtResult.getText().toString());
                    txtResult.setText(df.format(var1) + "");
                } else {
                    var2 = Double.parseDouble(txtResult.getText().toString());
                    s_result = calculator(operation, var1, var2);
                    txtResult.setText(df.format(var1) + "");
                    var1 = s_result;
                }
                operation = DIV;
                isFirst = false;
                break;
            case R.id.btnEqual:
                isOperation = true;
                var2 = Double.parseDouble(txtResult.getText().toString());
                isFirst = true;
                var2 = Double.parseDouble(txtResult.getText().toString());
                s_result = calculator(operation, var1, var2);
                txtResult.setText(df.format(s_result) + "");
                break;
        }
    }


    private Double calculator(int mark, double varFirst, double varSecond) {
        double resultTemp = 0;
        switch (mark) {
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



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
                inflater.inflate(R.menu.menu, menu);
                super.onCreateOptionsMenu(menu,inflater);
            }

             @Override
     public boolean onOptionsItemSelected(MenuItem item) {
               switch (item.getItemId()) {
                      case R.id.menuClear:
                                txtResult.setText("0");
                                break;
                        case R.id.menuSave:
                            SharedPreferences.Editor editer = shared.edit();
                            editer.putString("result", txtResult.getText().toString());
                            editer.commit();
                            break;

                           }
                return super.onOptionsItemSelected(item);
            }


}
