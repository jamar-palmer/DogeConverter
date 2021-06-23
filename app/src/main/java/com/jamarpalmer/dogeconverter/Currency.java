package com.jamarpalmer.dogeconverter;

//class for associating the name of the currency with the rates compared to DOGE

public class Currency {
    //find way to occasionally update rates (daily)

    private String name;
    private double rate;

    public Currency(){
    }

    public Currency(String currency){
        this.name = currency;
        pairing(currency);
    }

    //method that pairs the name of the currency to its rate
    //updated periodically
    private void pairing(String currency){
        //switch statement to match the name to the proper rate
        switch(currency){
            case "Dogecoin":
                this.rate = 1;
                break;
            case "Bitcoin":
                this.rate = 0.00000674;
                break;
            case "Ethereum":
                this.rate = 0.00011452;
                break;
            case "XRP":
                this.rate = 0.36263059;
                break;
            case "Tether":
                this.rate = 0.22300758;
                break;
            case "Stellar":
                this.rate = 0.88691939;
                break;
            case "Cardano":
                this.rate = 0.18237653;
                break;
            case "Litecoin":
                this.rate = 0.00177711;
                break;
            case "Uniswap":
                this.rate = 0.01270890;
                break;
            case "Polkadot":
                this.rate = 0.01436032;
                break;
            default:
        }
    }

    public double getRate(){
        return this.rate;
    }


}
