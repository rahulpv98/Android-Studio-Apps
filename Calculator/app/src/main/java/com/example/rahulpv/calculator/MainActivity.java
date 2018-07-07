package com.example.rahulpv.calculator;


import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonAdd;
    Button buttonSubstract;
    Button buttonMul;
    Button buttonDiv;
    Button buttonClear;
    Button buttonEqual;
    Button buttonRoot;
    Button buttonLog;
    Button buttonTan;
    Button buttonCos;
    Button buttonSin;
    Button buttonPower;
    Button buttonSquare;


    String result;
    String tmp;
    String operator;
    TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
        initControlListener();
    }

    private void initControlListener() {
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("9");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClearButtonClicked();
            }
        });
        buttonSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("-");
            }
        });
        buttonSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOperatorButtonClicked("Sin");
            }
        });
        buttonCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOperatorButtonClicked("Cos");
            }
        });
        buttonTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOperatorButtonClicked("Tan");
            }
        });
        buttonRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOperatorButtonClicked("Root");
            }
        });
        buttonSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOperatorButtonClicked("Square");
            }
        });
        buttonPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOperatorButtonClicked("Power");
            }
        });


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("+");
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("X");
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("/");
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEqualButtonClicked();
            }
        });
        buttonLog.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              onOperatorButtonClicked("Log");
            }
        }));
    }

    private void onEqualButtonClicked() {
        disableButton();
      double res = 0;

        try {
            double number = Integer.valueOf(tmp);
            double number2;
            switch (operator) {
                    case "+":
                        number2 = Integer.valueOf(resultTextView.getText().toString());
                        res = (double)number + number2;
                        break;
                    case "/":
                        number2 = Integer.valueOf(resultTextView.getText().toString());
                        res = (double)number / number2;
                        break;
                    case "-":
                        number2 = Integer.valueOf(resultTextView.getText().toString());
                        res = (double)number - number2;
                        break;
                    case "X":
                        number2 = Integer.valueOf(resultTextView.getText().toString());
                        res = (double)number * number2;
                        break;
                    case "Log":
                        res=((double)Math.log(number))/2.303;
                        break;
                    case "Sin":
                        res=(double)Math.sin(number);
                        break;
                    case "Cos":
                        res=(double)Math.cos(number);
                        break;
                    case "Tan":
                        res=(double)Math.tan(number);
                        break;
                    case "Root":
                        res=(double)Math.sqrt(number);
                        break;
                    case "Square":
                        res=(double)number*number;
                        break;
                    case "Power":
                        number2 = Integer.valueOf(resultTextView.getText().toString());
                        res=(double)Math.pow(number,number2);
                        break;

            }
            result = String.valueOf(res);
            resultTextView.setText(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void onOperatorButtonClicked(String operator) {
        tmp = resultTextView.getText().toString();
        onClearButtonClicked();
        this.operator = operator;
    }

    private void onClearButtonClicked() {
        result = "";
        resultTextView.setText("");
        enableButton();
    }

    private void onNumberButtonClicked(String pos) {
        result = resultTextView.getText().toString();
        result = result + pos;
        resultTextView.setText(result);
    }

    private void initControl() {
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);


        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonSubstract = (Button) findViewById(R.id.buttonSub);
        buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonPower=(Button)findViewById(R.id.buttonPower);
        buttonRoot=(Button)findViewById(R.id.buttonRoot);
        buttonTan=(Button)findViewById(R.id.buttonTan);
        buttonCos=(Button)findViewById(R.id.buttonCos);
        buttonSin=(Button)findViewById(R.id.buttonSin);

        buttonSquare=(Button)findViewById(R.id.buttonSquare);
        buttonLog=(Button)findViewById(R.id.buttonLog);


        resultTextView = (TextView) findViewById(R.id.text_view_result);
    }

    public void disableButton(){
        button0.setEnabled(false);
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);
        button8.setEnabled(false);
        button9.setEnabled(false);
        buttonAdd.setEnabled(false);
        buttonSubstract.setEnabled(false);
        buttonMul.setEnabled(false);
        buttonDiv.setEnabled(false);
        buttonSin.setEnabled(false);
        buttonCos.setEnabled(false);
        buttonTan.setEnabled(false);
        buttonRoot.setEnabled(false);
        buttonSquare.setEnabled(false);
        buttonPower.setEnabled(false);

        buttonLog.setEnabled(false);
    }
    public void enableButton(){
        button0.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button7.setEnabled(true);
        button8.setEnabled(true);
        button9.setEnabled(true);
        buttonAdd.setEnabled(true);
        buttonSubstract.setEnabled(true);
        buttonMul.setEnabled(true);
        buttonDiv.setEnabled(true);
        buttonSin.setEnabled(true);
        buttonCos.setEnabled(true);
        buttonTan.setEnabled(true);
        buttonRoot.setEnabled(true);
        buttonSquare.setEnabled(true);
        buttonPower.setEnabled(true);

        buttonLog.setEnabled(true);
    }
}