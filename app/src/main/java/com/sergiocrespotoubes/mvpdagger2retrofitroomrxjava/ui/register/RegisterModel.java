package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.register;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.MyApplication;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.entity.User;

/**
 * Created by Sergio Crespo Toubes on 01/11/2017.
 * SergioCrespoToubes@gmail.com
 * www.SergioCrespoToubes.com
 */

public class RegisterModel implements RegisterContract.Model {

    RegisterModel() {

    }

    @Override
    public void createUser(User user) {
        MyApplication.db.userDao().insert(user);
    }

}
