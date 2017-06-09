package com.cheng.cc.cccalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Stack;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    Stack<String> optr = new Stack<String>();
    Stack<Double> opnd = new Stack<Double>();

    int index_begin = -1;
    boolean press_answer_flag = false;
    @BindView(R.id.output_window)
    TextView outputWindow;
//    @BindView(R.id.answer_window)
//    TextView answerWindow;
    @BindView(R.id.left_bracket_button)
    Button leftBracketButton;
    @BindView(R.id.right_bracket_button)
    Button rightBracketButton;
    @BindView(R.id.divisor_button)
    Button divisorButton;
    @BindView(R.id.clear_button)
    Button clearButton;
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
    @BindView(R.id.activity_main)
    LinearLayout activityMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
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
                return '#';                //≥ˆœ÷¥ÌŒÛ
            else if (temp.equals(")"))
                return '>';
        }
        return '#';
    }


    @OnClick({R.id.output_window, R.id.answer_window, R.id.left_bracket_button, R.id.right_bracket_button, R.id.divisor_button, R.id.clear_button, R.id.seven_button, R.id.eight_button, R.id.nine_button, R.id.product_button, R.id.four_button, R.id.five_button, R.id.six_button, R.id.minus_button, R.id.one_button, R.id.two_button, R.id.three_button, R.id.plus_button, R.id.zero_button, R.id.point_button, R.id.equal_button})
    public void onViewClicked(View view) {
        Button btnView = (Button) view;
        String show = outputWindow.getText().toString();
        switch (view.getId()) {
            case R.id.left_bracket_button:
            case R.id.right_bracket_button:
            case R.id.divisor_button:
            case R.id.product_button:
            case R.id.minus_button:
            case R.id.plus_button:
                if(press_answer_flag)
                {
                    display.setText(answer.getText());
                    index_begin=-1;
                    press_answer_flag=false;
                    show=answer.getText().toString();
                    answer.setText("");
                }
                if(index_begin!=-1)
                {
                    temp=show.substring(index_begin);
                    opnd.push(Double.valueOf(temp).doubleValue());
                    index_begin=-1;
                    //Toast.makeText(this, "temp is"+temp+". push into opnd,the number is "+Double.valueOf(temp).doubleValue(), Toast.LENGTH_LONG).show();
                }
                show+=btn.getText();
                display.setText(show);

                temp=btn.getText().toString();
                while(!optr.empty()&&!lesser(optr.peek(),temp))
                {
                    switch (precede(optr.peek(), temp)) {
                        case '<':
                            optr.push(temp);
                            break;
                        case '=':
                            optr.pop();
                            return;
                        case '>':
                            double a,b,c;
                            b = opnd.pop();
                            a = opnd.pop();
                            String theta = optr.pop();
                            c = operate(a, theta, b);
                            opnd.push(c);
                            break;
                        case '#':
                            show = "ERROR";
                            display.setText(show);
                            optr.clear();
                            opnd.clear();
                            break;
                    }
                }
                if(optr.empty()||lesser(optr.peek(),temp))
                    optr.push(temp);



                break;
            case R.id.clear_button:
                outputWindow.setText("");
                optr.clear();
                opnd.clear();
                index_begin=-1;
                press_answer_flag=false;
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
                if(press_answer_flag)
                {
                    display.setText("");
                    optr.clear();
                    opnd.clear();
                    index_begin=-1;
                    press_answer_flag=false;
                    show="";
                }
                show += btn.getText();
                display.setText(show);
                if(index_begin==-1)
                {
                    index_begin=show.lastIndexOf(btn.getText().toString());
                    //Toast.makeText(this, "index_begin is changed from -1 to "+index_begin, Toast.LENGTH_LONG).show();
                }





                break;



                break;
            case R.id.equal_button:
                press_answer_flag=true;
                if(index_begin!=-1)
                {
                    temp=show.substring(index_begin);
                    opnd.push(Double.valueOf(temp).doubleValue());
                    index_begin=-1;
                    //Toast.makeText(this, "temp is"+temp+". push into opnd,the number is "+Double.valueOf(temp).doubleValue(), Toast.LENGTH_LONG).show();
                }
                show+=btnView.getText().toString();
                outputWindow.setText(show);

                while(!optr.isEmpty())
                {
                    double a,b,c;
                    b = opnd.pop();
                    a = opnd.pop();
                    String theta = optr.pop();
                    c = operate(a, theta, b);
                    opnd.push(c);
                }
                answer.setText(opnd.peek().toString());
                break;
        }
    }
}
