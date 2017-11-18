package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.R;


/**
 * Created by Sergio on 07-Dec-16.
 */

public class MainViewHolder extends RecyclerView.ViewHolder {

    public TextView tv_name;
    public TextView tv_date;

    public MainViewHolder(View view) {
        super(view);

        tv_name = view.findViewById(R.id.tv_name);
        tv_date = view.findViewById(R.id.tv_description);

    }

}
