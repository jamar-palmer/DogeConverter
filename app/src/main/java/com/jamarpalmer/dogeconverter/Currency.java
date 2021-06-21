package com.jamarpalmer.dogeconverter;

//class for associating the name of the currency with the rates compared to DOGE

public class Currency {
    //find way to occasionally update rates (daily)

    private String name;

    //rates
    private double rate;

    //GET RID OF ALL OF THESE
    private double xlm;
    private double ada;
    private double ltc;
    private double uni;
    private double dot;

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
                this.rate = 0.00000698;
                break;
            case "Ethereum":
                this.rate = 0.00010386;
                break;
            case "XRP":
                this.rate = 0.30221679;
                break;
            case "Tether":
                this.rate = 0.19886387;
                break;
            case "Ethereum":
                this.rate = 0.000124;
                break;
            case "Ethereum":
                this.rate = 0.000124;
                break;
            case "Ethereum":
                this.rate = 0.000124;
                break;
            case "Ethereum":
                this.rate = 0.000124;
                break;
            case "Ethereum":
                this.rate = 0.000124;
                break;
            default:
        }
    }

    public double getRate(){
        return this.rate;
    }


}
