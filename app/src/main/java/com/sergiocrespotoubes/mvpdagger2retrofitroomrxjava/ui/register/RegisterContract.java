package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.register;


import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.entity.User;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.root.BaseContract;

/**
 * Created by Sergio Crespo Toubes on 02-Oct-16.
 */
public interface RegisterContract {

    interface View extends BaseContract.View {

        String getName();

        String getPassword();

        void showEmptyNameError();

        void hideEmptyNameError();

        void showEmptyPasswordError();

        void hideEmptyPasswordError();

        void showMessage(String message);

    }

    interface Presenter extends BaseContract.Presenter {

        void onContinueClick();

        void onNameFocusLost();

        void onPasswordFocusLost();

    }

    interface Model extends BaseContract.Model {

        void createUser(User user);

    }

}