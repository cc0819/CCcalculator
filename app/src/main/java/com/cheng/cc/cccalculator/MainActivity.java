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
            R.id.clear_button, R.id.plusorminus_button, R.id.percent_button, R.id.division_button,
            R.id.seven_button, R.id.eight_button, R.id.nine_button, R.id.product_button,
            R.id.four_button, R.id.five_button, R.id.six_button, R.id.minus_button,
            R.id.one_button, R.id.two_button, R.id.three_button, R.id.plus_button,
            R.id.zero_button, R.id.point_button, R.id.equal_button})
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
                Double num = Double.valueOf(show).doubleValue();
                if (num >= 0) {
                    outputWindow.setText(formatDouble(-num));
                } else {
                    outputWindow.setText(formatDouble(Math.abs(num)));
                }
                break;
            case R.id.percent_button:
                isFirstNum = false;
                Double num1 = Double.valueOf(show).doubleValue();
                outputWindow.setText(formatDouble(num1 / 100 ));
                break;
            case R.id.division_button:
            case R.id.product_button:
            case R.id.minus_button:
            case R.id.plus_button:
                isFirstNum = false;
                typeOp.add(btnView.getText().toString());
                numberOp.add(Double.valueOf(show).doubleValue());



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
                if (isFirstNum) {
                    if (show.equals("0")) {
                        show = "";
                    }
                    show += btnView.getText().toString().trim();
                    outputWindow.setText(show);
                } else {
                    isFirstNum = true;
                    outputWindow.setText(btnView.getText().toString().trim());
                }
                numberOp.add(Double.valueOf(btnView.getText().toString()).doubleValue());
                break;
            case R.id.equal_button:
                isFirstNum = true;
                outputWindow.setText(formatDouble(calculator()));
                typeOp.clear();
                numberOp.clear();

                break;
        }
    }


    private String formatDouble(Double doubleTemp){
        String temp = doubleTemp+"";
        if (temp.contains(".")){
            String[] index = temp.split("\\.");
//            Log.e("info","--传过来信息0---="+index[0]);
//            Log.e("info","--传过来信息1---="+index[1]);
            if ((index[1].length() == 1 && index[1].equals("0")) || (index[1].length() == 2 && index[1].equals("00")) ){
                return Math.round(Double.valueOf(temp))+"";
            }
        }
        return temp;
    }


    private String formatDouble(String temp){
        if (temp.contains(".")){
            String[] index = temp.split(".");
            if ((index[1].length() == 1 && index[1].equals("0")) || (index[1].length() == 2 && index[1].equals("00")) ){
                return Math.round(Double.valueOf(temp))+"";
            }
        }
        return temp;
    }




    private String calculator() {
        if (typeOp.size() <1  || numberOp.size() < 2){
            return  formatDouble(outputWindow.getText().toString());
        }
        String type = typeOp.get(typeOp.size()-1);
        Log.e("type","---------="+type);
        Double numberEnd = numberOp.get(numberOp.size()-1);
        Double number = numberOp.get(numberOp.size()-2);
        switch (type) {
            case "+":
                return formatDouble(number + numberEnd);
            case "—":
                return formatDouble(number - numberEnd);
            case "×":
                return formatDouble(number * numberEnd);
            case "÷":
                return formatDouble(number / numberEnd);
            default:
                break;
        }
        return formatDouble(outputWindow.getText().toString());
    }



}
