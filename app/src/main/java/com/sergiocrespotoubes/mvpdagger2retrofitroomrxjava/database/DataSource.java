package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database;

import java.util.List;

/**
 * Created by Sergio Crespo Toubes on 29/10/2017.
 * SergioCrespoToubes@gmail.com
 * www.SergioCrespoToubes.com
 */

public interface DataSource<T> {

    void intert(T item);
    void insertItems(List<T> items);
    void updateItem(T item);
    void updateItems(List<T> items);
    void deleteItem(T item);
    void hasData();

}
