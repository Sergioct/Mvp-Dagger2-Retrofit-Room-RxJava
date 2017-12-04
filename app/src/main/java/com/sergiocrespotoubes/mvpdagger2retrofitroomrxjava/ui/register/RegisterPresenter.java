package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.register;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.MyApplication;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.entity.User;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.ApiControllerRetrofit;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.pojo.Post;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.root.BaseContract;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;
import sergiocrespotoubes.com.sergioctsdk.SergioctSystem;
import sergiocrespotoubes.com.sergioctsdk.SergioctUtils;

/**
 * Created by Sergio on 02-Oct-16.
 */

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View view;
    private RegisterContract.Model model;

    public RegisterPresenter(RegisterContract.Model model) {
        this.model = model;
    }

    private Subscription observeLookupButton(){
        return (Subscription) view.observeButton()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(__ -> {
                    view.hideKeyboard();
                    view.showMessage("Look up button clicked");

                });
    }

    @Override
    public void setView(BaseContract.View view) {
        this.view = (RegisterContract.View) view;
    }

    @Override
    public void dropView() {

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