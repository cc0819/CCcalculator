package com.cheng.cc.cccalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.output_window)
    TextView outputWindow;
    @BindView(R.id.clear_button)
    Button clearButton;
    @BindView(R.id.plusorminus_button)
    Button plusorminusButton;
    @BindView(R.id.percent_button)
    Button percentButton;
    @BindView(R.id.division_button)
    Button divisionButton;
    @BindView(R.id.seven_button)
    Button sevenButton;
    @BindView(R.id.eight_button)
    Button eightButton;
    @BindView(R.id.nine_button)
    Button nineButton;
    @BindView(R.id.product_button)
    Button productButton;
    @BindView(R.id.four_button)
    Button fourButton;
    @BindView(R.id.five_button)
    Button fiveButton;
    @BindView(R.id.six_button)
    Button sixButton;
    @BindView(R.id.minus_button)
    Button minusButton;
    @BindView(R.id.one_button)
    Button oneButton;
    @BindView(R.id.two_button)
    Button twoButton;
    @BindView(R.id.three_button)
    Button threeButton;
    @BindView(R.id.plus_button)
    Button plusButton;
    @BindView(R.id.zero_button)
    Button zeroButton;
    @BindView(R.id.point_button)
    Button pointButton;
    @BindView(R.id.equal_button)
    Button equalButton;

    Stack<String> typeOp = new Stack<>();
    Stack<Double> numberOp = new Stack<>();
    private boolean isFirstNum = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({
            R.id.clear_button,R.id.plusorminus_button,R.id.percent_button,R.id.division_button,
            R.id.seven_button,  R.id.eight_button,R.id.nine_button,R.id.product_button,
            R.id.four_button, R.id.five_button, R.id.six_button,R.id.minus_button,
            R.id.one_button, R.id.two_button,R.id.three_button, R.id.plus_button,
             R.id.zero_button,R.id.point_button, R.id.equal_button})
    public void onViewClicked(View view) {
        Button btnView = (Button) view;
        String show = outputWindow.getText().toString();

        switch (view.getId()) {
            case R.id.clear_button:
                outputWindow.setText("0");
                isFirstNum = true;
                typeOp.clear();
                numberOp.clear();
                break;
            case R.id.plusorminus_button:
                long num = Math.round(Double.valueOf(show));
                Log.e("info","========"+num);
                if (num>=0){
                    outputWindow.setText((-num)+"");
                }else {
                    outputWindow.setText(Math.abs(num)+"");
                }
                break;
            case R.id.percent_button:
                isFirstNum = false;
                Double num1 = Double.valueOf(show);
                outputWindow.setText(num1/100+"");
                break;
            case R.id.division_button:
            case R.id.product_button:
            case R.id.minus_button:
            case R.id.plus_button:
                isFirstNum = false;


                typeOp.add(btnView.getText().toString());




//                if (press_answer_flag) {
//                    display.setText(answer.getText());
//                    index_begin = -1;
//                    press_answer_flag = false;
//                    show = answer.getText().toString();
//                    answer.setText("");
//                }
//                if (index_begin != -1) {
//                    temp = show.substring(index_begin);
//                    opnd.push(Double.valueOf(temp).doubleValue());
//                    index_begin = -1;
//                    //Toast.makeText(this, "temp is"+temp+". push into opnd,the number is "+Double.valueOf(temp).doubleValue(), Toast.LENGTH_LONG).show();
//                }
//                show += btn.getText();
//                display.setText(show);
//
//                temp = btn.getText().toString();
//                while (!optr.empty() && !lesser(optr.peek(), temp)) {
//                    switch (precede(optr.peek(), temp)) {
//                        case '<':
//                            optr.push(temp);
//                            break;
//                        case '=':
//                            optr.pop();
//                            return;
//                        case '>':
//                            double a, b, c;
//                            b = opnd.pop();
//                            a = opnd.pop();
//                            String theta = optr.pop();
//                            c = operate(a, theta, b);
//                            opnd.push(c);
//                            break;
//                        case '#':
//                            show = "ERROR";
//                            display.setText(show);
//                            optr.clear();
//                            opnd.clear();
//                            break;
//                    }
//                }
//                if (optr.empty() || lesser(optr.peek(), temp))
//                    optr.push(temp);


                break;

            case R.id.point_button:
            case R.id.zero_button:
            case R.id.one_button:
            case R.id.two_button:
            case R.id.three_button:
            case R.id.four_button:
            case R.id.five_button:
            case R.id.six_button:
            case R.id.seven_button:
            case R.id.eight_button:
            case R.id.nine_button:
                if (isFirstNum){
                    if (show.equals("0")) {
                        show = "";
                    }
                    show += btnView.getText().toString().trim();
                    outputWindow.setText(show);
                }else {
                    isFirstNum = true;
                    outputWindow.setText(btnView.getText().toString().trim());
                }
                break;
            case R.id.equal_button:



//                press_answer_flag = true;
//                if (index_begin != -1) {
//                    temp = show.substring(index_begin);
//                    opnd.push(Double.valueOf(temp).doubleValue());
//                    index_begin = -1;
//                    //Toast.makeText(this, "temp is"+temp+". push into opnd,the number is "+Double.valueOf(temp).doubleValue(), Toast.LENGTH_LONG).show();
//                }
//                show += btnView.getText().toString();
//                outputWindow.setText(show);
//
//                while (!optr.isEmpty()) {
//                    double a, b, c;
//                    b = opnd.pop();
//                    a = opnd.pop();
//                    String theta = optr.pop();
//                    c = operate(a, theta, b);
//                    opnd.push(c);
//                }
//                outputWindow.setText(opnd.peek().toString());
                break;
        }
    }


    private boolean lesser(String theta, String temp) {
        switch (precede(theta, temp)) {
            case '<':
                return true;
            case '=':
                return false;
            case '>':
                return false;
        }
        return false;
    }

    private double operate(double a, String theta, double b) {
        if (theta.equals("+"))
            return a + b;
        else if (theta.equals("-"))
            return a - b;
        else if (theta.equals("*"))
            return a * b;
        else if (theta.equals("/"))
            return a / b;
        return 0;
    }


    private char precede(String theta, String temp) {
        if (theta.equals("+")) {
            if (temp.equals("+"))
                return '>';
            else if (temp.equals("-"))
                return '>';
            else if (temp.equals("*"))
                return '<';
            else if (temp.equals("/"))
                return '<';
            else if (temp.equals("("))
                return '<';
            else if (temp.equals(")"))
                return '>';
        } else if (theta.equals("-")) {
            if (temp.equals("+"))
                return '>';
            else if (temp.equals("-"))
                return '>';
            else if (temp.equals("*"))
                return '<';
            else if (temp.equals("/"))
                return '<';
            else if (temp.equals("("))
                return '<';
            else if (temp.equals(")"))
                return '>';
        } else if (theta.equals("*")) {
            if (temp.equals("+"))
                return '>';
            else if (temp.equals("-"))
                return '>';
            else if (temp.equals("*"))
                return '>';
            else if (temp.equals("/"))
                return '>';
            else if (temp.equals("("))
                return '<';
            else if (temp.equals(")"))
                return '>';
        } else if (theta.equals("/")) {
            if (temp.equals("+"))
                return '>';
            else if (temp.equals("-"))
                return '>';
            else if (temp.equals("*"))
                return '>';
            else if (temp.equals("/"))
                return '>';
            else if (temp.equals("("))
                return '<';
            else if (temp.equals(")"))
                return '>';
        } else if (theta.equals("(")) {
            if (temp.equals("+"))
                return '<';
            else if (temp.equals("-"))
                return '<';
            else if (temp.equals("*"))
                return '<';
            else if (temp.equals("/"))
                return '<';
            else if (temp.equals("("))
                return '<';
            else if (temp.equals(")"))
                return '=';
        } else if (theta.equals(")")) {
            if (temp.equals("+"))
                return '>';
            else if (temp.equals("-"))
                return '>';
            else if (temp.equals("*"))
                return '>';
            else if (temp.equals("/"))
                return '>';
            else if (temp.equals("("))
                return '#';
            else if (temp.equals(")"))
                return '>';
        }
        return '#';
    }


}
