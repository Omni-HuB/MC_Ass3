package com.example.accelerometer_ml_app

//
//import androidx.room.Database
//import androidx.room.RoomDatabase
//
//@Database(entities = [SensorData::class], version = 1)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun sensorDao(): SensorDao
//}



//import androidx.room.Database
//import androidx.room.RoomDatabase
//
//@Database(entities = [SensorData::class], version = 1)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun sensorDao(): SensorDao
//}


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SensorData::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun sensorDao(): SensorDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "sensor_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}