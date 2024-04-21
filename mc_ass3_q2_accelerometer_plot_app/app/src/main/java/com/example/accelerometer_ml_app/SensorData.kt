package com.example.accelerometer_ml_app

//data class com.example.accelerometer_ml_app.SensorData(
//    @PrimaryKey(autoGenerate = true) val id: Int = 0,
//    val timestamp: Long,
//    val x: Float,
//    val y: Float,
//    val z: Float
//)
//
//@Dao
//interface SensorDao {
//    @Query("SELECT * FROM com.example.accelerometer_ml_app.SensorData")
//    fun getAll(): List<com.example.accelerometer_ml_app.SensorData>
//
//    @Insert
//    fun insertAll(vararg sensorData: com.example.accelerometer_ml_app.SensorData)
//}
//
//@Database(entities = [com.example.accelerometer_ml_app.SensorData::class], version = 1)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun sensorDao(): SensorDao
//}


//import androidx.room.Entity
//import androidx.room.PrimaryKey
//
////@Entity
//@Entity
//data class SensorData(
//    @PrimaryKey(autoGenerate = true) val id: Int = 0,
//    val timestamp: Long,
//    val x: Float,
//    val y: Float,
//    val z: Float
//)




import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SensorData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val timestamp: Long,
    val x: Float,
    val y: Float,
    val z: Float,
    val angleX: Float,
    val angleY: Float,
    val angleZ: Float
)
