package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.R;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.pojo.Game;

import java.util.List;


/**
 * Created by Sergio on 07-Dec-16.
 */

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    Context context;

    //Vars
    List<Game> lMainData;

    public MainAdapter(Context context, List<Game> lMainData) {
        this.lMainData = lMainData;
        this.context = context;
    }


    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game, parent, false);

        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MainViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return lMainData.size();
    }

}