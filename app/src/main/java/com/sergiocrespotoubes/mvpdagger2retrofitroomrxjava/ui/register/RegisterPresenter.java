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
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Sergio on 02-Oct-16.
 */

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View view;
    private RegisterContract.Model model;

    private CompositeDisposable mCompositeDisposable;
    ApiControllerRetrofit apiControllerRetrofit;

    public RegisterPresenter(RegisterContract.Model model) {
        this.model = model;
        apiControllerRetrofit = MyApplication.appComponent.getApiControllerRetrofit();
    }

    private Subscription observeLookupButton(){
        return (Subscription) view.observeButton().subscribe(__ -> {
            view.showMessage("Look up button clicked");
        });
    }

    @Override
    public void setView(BaseContract.View view) {
        this.view = (RegisterContract.View) view;

        mCompositeDisposable.add(apiControllerRetrofit.getPosts()
            .subscribeOn(Schedulers.io()) // Thread operator use
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(posts -> {

            })
        );
    }

    @Override
    public void dropView() {
            mCompositeDisposable.clear();
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