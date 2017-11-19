package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.main;


import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.root.BaseContract;

import rx.Subscription;

/**
 * Created by Sergio on 02-Oct-16.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private MainContract.Model model;

    private Subscription subscription = null;

    public MainPresenter(MainContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(BaseContract.View view) {
        this.view = (MainContract.View) view;
    }

    @Override
    public void dropView() {
        if(subscription != null && !subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }

    @Override
    public void loadData() {

    }
}
