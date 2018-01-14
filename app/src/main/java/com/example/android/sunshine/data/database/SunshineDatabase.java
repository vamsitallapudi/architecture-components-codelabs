package com.example.android.sunshine.data.database;

/**
 * Created by vamsitallapudi on 1/12/18.
 */

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

@Database(entities = {WeatherEntry.class},version = 1)
@TypeConverters(DateConverter.class)
public abstract class SunshineDatabase extends RoomDatabase{

    public abstract WeatherDao mWeatherDao();

    private static final String DATABASE_NAME = "weather";

//    For Singleton Instantiation

    private static final Object LOCK = new Object();
    private static volatile SunshineDatabase sInstance;//-> volatile is used for the variables which needs to be stored directly in main memory instead of CPU memory cache(CPU mem cache is separately maintained for different threads hence there might be chance of same variable copy maintaining different values which is harmful to synchronization).


    public static SunshineDatabase getInstance(Context context){
        if(sInstance == null){
            synchronized (LOCK){
                if(sInstance == null){
                    sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            SunshineDatabase.class,SunshineDatabase.DATABASE_NAME).build();
                }
            }
        }
        return sInstance;
    }
}
