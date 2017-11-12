package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.register;


import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.entity.User;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.root.BaseContract;

import org.joda.time.DateTime;

/**
 * Created by Sergio on 02-Oct-16.
 */

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View view;
    private RegisterContract.Model model;

    public RegisterPresenter(RegisterContract.Model model) {
        this.model = model;
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