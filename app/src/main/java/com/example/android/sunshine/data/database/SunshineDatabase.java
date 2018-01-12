package com.example.android.sunshine.data.database;

/**
 * Created by vamsitallapudi on 1/12/18.
 */

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {WeatherEntry.class},version = 1)
public abstract class SunshineDatabase extends RoomDatabase{
    public abstract WeatherDao mWeatherDao();
}
