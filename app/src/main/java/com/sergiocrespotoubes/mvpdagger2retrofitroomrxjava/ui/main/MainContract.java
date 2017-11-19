package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.main;


import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.pojo.Post;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.root.BaseContract;

import java.util.Observable;

/**
 * Created by Sergio Crespo Toubes on 02-Oct-16.
 */
public interface MainContract {

    interface View extends BaseContract.View {

    }

    interface Presenter extends BaseContract.Presenter {
        void loadData();
    }

    interface Model extends BaseContract.Model {
        Observable result();
    }

}