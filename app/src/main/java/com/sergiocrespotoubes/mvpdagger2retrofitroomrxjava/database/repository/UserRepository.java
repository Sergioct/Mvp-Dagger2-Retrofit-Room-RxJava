package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.repository;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.DataSource;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.entity.User;

/**
 * Created by Sergio Crespo Toubes on 24/10/2017.
 * SergioCrespoToubes@gmail.com
 * www.SergioCrespoToubes.com
 */

public interface UserRepository extends DataSource<User> {

    User getUser();

}
