package com.jamarpalmer.dogeconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //views
    Spinner spinner;
    EditText txtCurrency;
    EditText txtDoge;
    ImageView logo;

    //variable for swap button
    Boolean swap = true;

    //variables and data structures
    List<String> currencyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //map views to variables
        spinner = findViewById(R.id.spinner);
        txtCurrency = findViewById(R.id.editCurrency);
        txtDoge = findViewById(R.id.editDoge);
        logo = findViewById(R.id.mainlogo);

        //instantiate variables
        currencyList = new ArrayList<String>();
        addCurrency();

        CoinAdapter adapter = new CoinAdapter(this, currencyList);


        //ArrayAdapter<String> currencyAdpater = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, currencyList);
        spinner.setAdapter(adapter);

        logo.setImageResource(R.drawable.dogecoin);


        txtDoge.setEnabled(false);
        txtDoge.setCursorVisible(false);

        //eventual
        //swap button to reverse entry
        //get doge meme pics
        //regularly updated
        //manually link cryptos first, then fiat currency, gold, etc
    }

    //event handler for the convert button click
    public void convertClick(View view) {
        if(swap){
            String currencyValStr = txtCurrency.getText().toString();
            double currencyVal = Double.parseDouble(currencyValStr);
            String currency = spinner.getSelectedItem().toString();

            //instantiate Currency class objects
            Currency other = new Currency(currency);
            double dogeVal = conversion(currencyVal, other.getRate());

            String result = String.valueOf(dogeVal);
            txtDoge.setText(result);

            //toast after conversion
            Toast.makeText(MainActivity.this, currencyValStr + " " + currency + " = " + result + " Dogecoin", Toast.LENGTH_SHORT).show();
        }else{
            String dogeValStr = txtDoge.getText().toString();
            double dogeVal = Double.parseDouble(dogeValStr);
            String currency = spinner.getSelectedItem().toString();

            //instantiate Currency class objects
            Currency other = new Currency(currency);
            double currencyVal = reverseConversion(dogeVal, other.getRate());

            String result = String.valueOf(currencyVal);
            txtCurrency.setText(result);

            //toast after conversion
            Toast.makeText(MainActivity.this, dogeValStr + " Dogecoin = " + result + " " + currency, Toast.LENGTH_SHORT).show();
        }


    }

    //add currencies to list as program grows
    public void addCurrency(){
        currencyList.add("Dogecoin");
        currencyList.add("Bitcoin");
        currencyList.add("Ethereum");
        currencyList.add("XRP");
        currencyList.add("Tether");
        currencyList.add("Stellar");
        currencyList.add("Cardano");
        currencyList.add("Litecoin");
        currencyList.add("Uniswap");
        currencyList.add("Polkadot");
        currencyList.add("USD Coin");
        currencyList.add("Binance Coin");
        currencyList.add("Binance USD");
        currencyList.add("United States Dollar");
    }

    //method for performing conversion
    public double conversion(double currency, double rate){
        double value = currency * rate;
        return value;
    }

    public double reverseConversion(double doge, double rate){
        double value = doge / rate;
        return value;
    }

    public void swapClick(View view) {

        if(swap){

            txtDoge.setEnabled(true);
            txtDoge.setCursorVisible(true);


            txtCurrency.setEnabled(false);
            txtCurrency.setCursorVisible(false);

            swap = false;
        }else{

            txtDoge.setEnabled(false);
            txtDoge.setCursorVisible(false);

            txtCurrency.setEnabled(true);
            txtCurrency.setCursorVisible(true);
            swap = true;
        }

    }
}