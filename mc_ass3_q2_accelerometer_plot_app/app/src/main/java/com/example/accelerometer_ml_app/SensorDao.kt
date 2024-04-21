package com.example.accelerometer_ml_app
//package com.example.accelerometer_ml_app
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.Query
//
//@Dao
//interface SensorDao {
//    @Query("SELECT * FROM SensorData")
//    fun getAll(): List<SensorData>
//
//    @Insert
//    fun insertAll(vararg data: SensorData)
//}



import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SensorDao {
    @Query("SELECT * FROM SensorData")
    fun getAll(): List<SensorData>

    @Insert
    fun insert(data: SensorData)
}
