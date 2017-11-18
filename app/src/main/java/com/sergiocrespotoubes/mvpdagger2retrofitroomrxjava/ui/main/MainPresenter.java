package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.main;


import sergiocrespotoubes.com.pregnancycalendar.ui.root.BaseContract;

/**
 * Created by Sergio on 02-Oct-16.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private MainContract.Model model;

    public MainPresenter(MainContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(BaseContract.View view) {
        this.view = (MainContract.View) view;
    }

    @Override
    public void dropView() {

    }

}
