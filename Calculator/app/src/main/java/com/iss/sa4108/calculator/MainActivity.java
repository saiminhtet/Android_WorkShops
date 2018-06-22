package com.iss.sa4108.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private double accumulator, operand;
    private char op;
    TextView view;

    private void init() {
        accumulator = 0.0;
        operand = 0.0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        view = (TextView) findViewById(R.id.textView1);
    }

    public void input(char c) {
        switch (c) {
            case 'C':
                operand = 0.0;
                accumulator= 0.0;
                break;
            case 'E':
                accumulator= 0.0;
                break;
            case '+' :;
            case '-' :;
            case '*' :;
            case '/' :
                op = c;
                operand = accumulator;
                accumulator = 0.0;
                break;
            case '=' :
                switch (op) {
                    case '+':
                        accumulator = operand + accumulator;
                        break;
                    case '-':
                        accumulator = operand - accumulator;
                        break;
                    case '*':
                        accumulator = operand * accumulator;
                        break;
                    case '/':
                        accumulator = operand / accumulator;
                        break;
                    default:
                        break;
                }
                break;
            case '0': ;
            case '1': ;
            case '2': ;
            case '3': ;
            case '4': ;
            case '5': ;
            case '6': ;
            case '7': ;
            case '8': ;
            case '9':
                accumulator = accumulator * 10.0 + (c-'0');
                break;
            default:
                break;
        }
    }

    public void output(double m) {
        view.setText(String.format("%f",m));
    }

    public void onClick0(View v) {
        input('0');
        output(accumulator);
    }

    public void onClick1(View v) {
        input('1');
        output(accumulator);
    }

    public void onClick2(View v) {
        input('2');
        output(accumulator);
    }

    public void onClick3(View v) {
        input('3');
        output(accumulator);
    }

    public void onClick4(View v) {
        input('4');
        output(accumulator);
    }

    public void onClick5(View v) {
        input('5');
        output(accumulator);
    }

    public void onClick6(View v) {
        input('6');
        output(accumulator);
    }

    public void onClick7(View v) {
        input('7');
        output(accumulator);
    }

    public void onClick8(View v) {
        input('8');
        output(accumulator);
    }

    public void onClick9(View v) {
        input('9');
        output(accumulator);
    }

    public void onClickMul(View v) {
        input('*');
        output(accumulator);
    }

    public void onClickDiv(View v) {
        input('/');
        output(accumulator);
    }

    public void onClickAdd(View v) {
        input('+');
        output(accumulator);
    }

    public void onClickMinus(View v) {
        input('-');
        output(accumulator);
    }

    public void onClickC(View v) {
        input('C');
        output(accumulator);
    }


    public void onClickEqual(View v) {
        input('=');
        output(accumulator);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
