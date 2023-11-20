package com.example.firebaseex2;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class CricketModel extends BaseObservable {
    String Countryname,countryjersey,odiranking;

    public CricketModel() {
    }

    public CricketModel(String countryname, String countryjersey, String odiranking) {
       this.Countryname = countryname;
        this.countryjersey = countryjersey;
        this.odiranking = odiranking;
    }

    @Bindable
    public String getCountryname() {

        return Countryname;
    }

    public void setCountryname(String countryname) {
        this.Countryname = countryname;
        notifyPropertyChanged(BR.countryname);

    }

    @Bindable
    public String getCountryjersey() {
        return countryjersey;
    }

    public void setCountryjersey(String countryjersey) {
        this.countryjersey = countryjersey;
        notifyPropertyChanged(BR.countryjersey);

    }

    @Bindable
    public String getOdiranking() {
        return odiranking;
    }

    public void setOdiranking(String odiranking) {
        this.odiranking = odiranking;
        notifyPropertyChanged(BR.odiranking);
    }
}

