package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.register;


import android.view.View;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.entity.User;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.root.BaseContract;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Sergio on 02-Oct-16.
 */

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View view;
    private RegisterContract.Model model;

    CompositeSubscription compositeSubscription = new CompositeSubscription();

    public RegisterPresenter(RegisterContract.Model model) {
        this.model = model;
    }

    private Subscription observeLookupButton(){
        return (Subscription) view.observeButton().subscribe(__ -> {
            view.showMessage("Look up button clicked");
        });
    }

    @Override
    public void setView(BaseContract.View view) {
        this.view = (RegisterContract.View) view;
        compositeSubscription.add(observeLookupButton());
    }

    @Override
    public void dropView() {
        compositeSubscription.clear();
    }

    @Override
    public void onContinueClick() {

        String name = view.getName();
        String password = view.getPassword();

        if(!name.equals("") && !password.equals("")){
            User user = new User();
            user.setName(name);
            user.setPassword(password);

            model.createUser(user);
        }
    }

    @Override
    public void onNameFocusLost() {
        String name = view.getName();

        if(!name.equals("")){
            view.hideEmptyNameError();
        }else{
            view.showEmptyNameError();
        }
    }

    @Override
    public void onPasswordFocusLost() {
        String password = view.getName();

        if(!password.equals("")){
            view.hideEmptyPasswordError();
        }else{
            view.showEmptyPasswordError();
        }
    }

}