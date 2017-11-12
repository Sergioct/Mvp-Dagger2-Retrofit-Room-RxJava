package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.entity;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

/**
 * Created by Sergio Crespo Toubes on 24/10/2017.
 * SergioCrespoToubes@gmail.com
 * www.SergioCrespoToubes.com
 */

@Dao
public interface UserDao {

    //@Query("SELECT * FROM " + Event.TABLE_NAME + " WHERE " + Event.DATE_FIELD + " > :minDate")
    //LiveData<List<Event>> getEvents(LocalDateTime minDate);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(User user);

    @Query("SELECT * FROM user LIMIT 1")
    User getUser();

}