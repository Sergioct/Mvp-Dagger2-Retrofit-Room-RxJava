package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.root;

/**
 * Developed by SergioCT
 * <p>
 * www.SergioCrespoToubes.com
 * https://github.com/Sergioct
 * <p>
 * Code autogenerated.
 */

public interface BaseContract {

    interface View {

    }

    interface Presenter {
        /**
         * Binds presenter with a view when resumed. The Presenter will perform initialization here.
         *
         * @param view the view associated with this presenter
         */
        void setView(View view);

        /**
         * Drops the reference to the view when destroyed
         */
        void dropView();
    }

    interface Model {

    }

}