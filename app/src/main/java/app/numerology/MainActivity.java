package app.numerology;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import app.numerology.model.Grid;
import app.numerology.util.Calculator;
import app.numerology.util.Validations;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextInputEditText name = findViewById(R.id.name);
        final TextInputEditText day = findViewById(R.id.day);
        final TextInputEditText month = findViewById(R.id.month);
        final TextInputEditText year = findViewById(R.id.year);
        final Drawable originalBackground = day.getBackground();
        final Button calc = findViewById(R.id.calculate);
        final TextView cenaitas = findViewById(R.id.resultado);
        final LinearLayout table = findViewById(R.id.tabelaNum);

        day.setEnabled(false);
        day.setBackgroundColor(Color.GRAY);
        month.setEnabled(false);
        month.setBackgroundColor(Color.GRAY);
        year.setEnabled(false);
        year.setBackgroundColor(Color.GRAY);
        calc.setEnabled(false);

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() >= 1){
                    day.setEnabled(true);
                    day.setBackground(originalBackground);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculator calculator = new Calculator();
                Grid grid = new Grid();
                String nomeStr = name.getText().toString();
                int resultP = calculator.getNameValue(nomeStr);
                int lifeNum = calculator.getNrLicaoDeVida(day.getText().toString(),month.getText().toString(),year.getText().toString());
                hideKeyboard(v);
                cenaitas.setText(
                        "Número da Lição de Vida: " + lifeNum + "\n"+
                                "Número do Destino: " + resultP);

                String birthDate = day.getText().toString() + month.getText().toString() + year.getText().toString();
                populateGrid(grid.allocateAllNumbers(birthDate));
                table.setVisibility(View.VISIBLE);
            }
        });

        day.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0){
                    day.setBackground(originalBackground);
                }
                if(s.length() <= 2 && Validations.isValidMonth(month.getText().toString())){
                    if(!(Validations.isValidDay(day.getText().toString(),month.getText().toString()))){
                        day.setBackgroundColor(Color.RED);
                        month.setBackgroundColor(Color.RED);
                        year.setEnabled(false);
                        year.setBackgroundColor(Color.GRAY);
                    }
                }else if(s.length() == 2 && Validations.isValidDay(s.toString())){
                    month.setBackground(originalBackground);
                    month.setFocusableInTouchMode(true);
                    month.setEnabled(true);
                    month.requestFocus();
                }else if(s.length() == 2 && !(Validations.isValidDay(s.toString()))){
                    day.setBackgroundColor(Color.RED);
                    year.setEnabled(false);
                    year.setBackgroundColor(Color.GRAY);
                }else if(s.length() == 2 && !(Validations.isValidDay(day.getText().toString(),month.getText().toString()))){
                    day.setBackgroundColor(Color.RED);
                    year.setEnabled(false);
                    year.setBackgroundColor(Color.GRAY);
                }else{
                    day.setBackground(originalBackground);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() == 0){
                    if(month.getText().toString().equalsIgnoreCase("")){
                        month.setBackgroundColor(Color.GRAY);
                    }
                }

            }
        });

        month.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0){
                    month.setBackground(originalBackground);
                }else if(s.length() <= 2 && !(Validations.isValidDay(day.getText().toString(),month.getText().toString())) && !(Validations.isValidMonth(day.getText().toString(),s.toString()))){
                    day.setBackgroundColor(Color.RED);
                    month.setBackgroundColor(Color.RED);
                    year.setEnabled(false);
                    year.setBackgroundColor(Color.GRAY);
                }else if(s.length() <= 2 && !(Validations.isValidDay(day.getText().toString(),s.toString()))){
                    day.setBackgroundColor(Color.RED);
                    year.setEnabled(false);
                    year.setBackgroundColor(Color.GRAY);
                }else if(s.length() <= 2 && !(Validations.isValidMonth(day.getText().toString(),s.toString()))){
                    month.setBackgroundColor(Color.RED);
                    day.setBackgroundColor(Color.RED);
                    year.setEnabled(false);
                    year.setBackgroundColor(Color.GRAY);
                }else if(s.length() == 2 && Validations.isValidMonth(day.getText().toString(),s.toString()) && Validations.isValidDay(day.getText().toString(),s.toString())){
                    year.setBackground(originalBackground);
                    month.setBackground(originalBackground);
                    day.setBackground(originalBackground);
                    year.setFocusableInTouchMode(true);
                    year.setEnabled(true);
                    year.requestFocus();
                }else if(s.length() == 1 && Validations.isValidMonth(day.getText().toString(),s.toString()) && Validations.isValidDay(day.getText().toString(),s.toString())){
                    year.setBackground(originalBackground);
                    month.setBackground(originalBackground);
                    day.setBackground(originalBackground);
                    year.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() == 0 && Validations.isValidDay(day.getText().toString())){
                    day.setBackground(originalBackground);
                }
            }
        });

        year.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 4 && Integer.valueOf(s.toString()) <= 2050){
                    calc.setEnabled(true);
                }else if(s.length() == 4 && Integer.valueOf(s.toString()) > 2050){
                    year.setBackgroundColor(Color.RED);
                    calc.setEnabled(false);
                }else{
                    year.setBackground(originalBackground);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void populateGrid(String[][] arr){
        final TextView one = findViewById(R.id.one);
        final TextView two = findViewById(R.id.two);
        final TextView three = findViewById(R.id.three);
        final TextView four = findViewById(R.id.four);
        final TextView five = findViewById(R.id.five);
        final TextView six = findViewById(R.id.six);
        final TextView seven = findViewById(R.id.seven);
        final TextView eight = findViewById(R.id.eight);
        final TextView nine = findViewById(R.id.nine);

        //one
        if(arr[2][0] != null){
            one.setText(arr[2][0]);
        }
        //two
        if(arr[1][0] != null){
            two.setText(arr[1][0]);
        }
        //trhee
        if(arr[0][0] != null){
            three.setText(arr[0][0]);
        }
        //four
        if(arr[2][1] != null){
            four.setText(arr[2][1]);
        }
        //five
        if(arr[1][1] != null){
            five.setText(arr[1][1]);
        }
        //six
        if(arr[0][1] != null){
            six.setText(arr[0][1]);
        }
        //seven
        if(arr[2][2] != null){
            seven.setText(arr[2][2]);
        }
        //eight
        if(arr[0][2] != null){
            eight.setText(arr[0][2]);
        }
        //nine
        if(arr[1][2] != null){
            nine.setText(arr[1][2]);
        }

    }
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
