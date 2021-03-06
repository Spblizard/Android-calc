package ru.apps.max.calc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Calc Cl;
    float memory = 0;
    private float numb1;
    private float numb2;
    private float answ;
    private EditText mEdNumber1,mEdNumber2;
    private TextView answerText, secondText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdNumber1 = (EditText)findViewById(R.id.editText1);
        mEdNumber2 = (EditText)findViewById(R.id.editText2);
        answerText = (TextView)findViewById(R.id.textView);
        secondText = (TextView)findViewById(R.id.textView4);

    }
    public void onButtonPlus(View view) {
        if(mEdNumber1.getText().length() == 0 || mEdNumber2.getText().length() == 0)
            Toast.makeText(this, "Одно из полей пустое", Toast.LENGTH_SHORT).show();
        else {
            String s1, s2, s3;
            s1 = mEdNumber1.getText().toString();
            s2 = mEdNumber2.getText().toString();
            numb1 = Float.parseFloat(s1);
            numb2 = Float.parseFloat(s2);
            answ = numb1 + numb2;
            s3 = Float.toString(answ);
            answerText.setText(s3);
        }
    }

    public void onButtonMinus(View view) {
        if(mEdNumber1.getText().length() == 0 || mEdNumber2.getText().length() == 0)
            Toast.makeText(this, "Одно из полей пустое", Toast.LENGTH_SHORT).show();

        else {
            String s1, s2, s3;
            s1 = mEdNumber1.getText().toString();
            s2 = mEdNumber2.getText().toString();
            numb1 = Float.parseFloat(s1);
            numb2 = Float.parseFloat(s2);
            answ = numb1 - numb2;
            s3 = Float.toString(answ);
            answerText.setText(s3);
        }
    }

    public void onButtonDiv(View view) {
        if(mEdNumber1.getText().length() == 0 || mEdNumber2.getText().length() == 0)
            Toast.makeText(this, "Одно из полей пустое", Toast.LENGTH_SHORT).show();
        else {
            String s1, s2, s3;
            s1 = mEdNumber1.getText().toString();
            s2 = mEdNumber2.getText().toString();
            numb1 = Float.parseFloat(s1);
            numb2 = Float.parseFloat(s2);
            if (numb2 != 0) {
                answ = numb1 / numb2;
                s3 = Float.toString(answ);
                answerText.setText(s3);
            } else
                answerText.setText("\u221E, при x->0");
        }
    }

    public void onButtonMult(View view) {
        if(mEdNumber2.getText().length() == 0 || mEdNumber1.getText().length() == 0)
            Toast.makeText(this,"Одно из полей пустое", Toast.LENGTH_SHORT).show();
        else {
        String s1, s2, s3;
        s1 = mEdNumber1.getText().toString();
        s2 = mEdNumber2.getText().toString();
        numb1 = Float.parseFloat(s1);
        numb2 = Float.parseFloat(s2);
        answ = numb1 * numb2;
        s3 = Float.toString(answ);
        answerText.setText(s3);}}

    public void onButtonFact(View view) {
        if(mEdNumber2.getText().length() > 0)
            Toast.makeText(this, "считывает толь первое число", Toast.LENGTH_SHORT).show();
        if(mEdNumber1.getText().length() == 0)
            Toast.makeText(this, "Поле пустое", Toast.LENGTH_SHORT).show();
        else {
            String s1;
            s1 = mEdNumber1.getText().toString();
            numb1 = Float.parseFloat(s1);
            long n = 1;
            for (int i = 1; i < numb1 + 1; i++)
                n = n * i;
            s1 = Long.toString(n);
            answerText.setText(s1);
        }
    }

    public void onButtonSimpleNumber(View view) {
        if(mEdNumber2.getText().length() > 0)
            Toast.makeText(this, "считывает толь первое число", Toast.LENGTH_SHORT).show();
        if(mEdNumber1.getText().length() == 0)
            Toast.makeText(this, "Поле пустое", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(this, "Считывает только целые числа, десятичные считает за целое", Toast.LENGTH_LONG).show();
            String s1;
            s1 = mEdNumber1.getText().toString();
            numb1 = Float.parseFloat(s1);
            int b, c, count, count1;
            count = 0;
            count1 = 0;
            int sumsn = 0;
            if (numb1 != 0) {
                for (int n = 2; n <= numb1; n++) {
                    for (int i = 2; i <= n; i++) {
                        b = n % i;
                        c = n / i;
                        if (b == 0 && c != 1)
                            count1++;
                        if (b == 0 && c == 1 && count1 == 0)
                            count++;
                    }
                    sumsn = sumsn + count;
                    count = 0;
                    count1 = 0;
                }

                s1 = Integer.toString(sumsn);
                answerText.setText(s1);
            } else
                Toast.makeText(this, "Число должно быть больше 2", Toast.LENGTH_SHORT).show();
        }
    }

    public void onButtonStrCalcMain(View view) {
        Intent intent = new Intent(MainActivity.this, StringCalcActivity.class);
        startActivity(intent);
    }

    public void onButtonCopyPaste(View view) {
        String s;
        s = answerText.getText().toString();
        mEdNumber1.setText(s);
    }

    public void onButtonCopyPaste1(View view) {
        String s;
        s = answerText.getText().toString();
        mEdNumber2.setText(s);
    }

    public void onButtonMemPlus(View view){
        String s;
        s = answerText.getText().toString();
        memory = Float.parseFloat(s);
    }

    public void onButtonMem(View view){
        String s;
        s = Float.toString(memory);
        mEdNumber1.setText(s);
    }
}
