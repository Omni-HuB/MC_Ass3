package com.example.accelerometer_ml_app







//class SensorViewModel : ViewModel(), SensorEventListener {
//    private lateinit var sensorManager: SensorManager
//    private var accelerometer: Sensor? = null
//
//    val x = mutableStateOf(0f)
//    val y = mutableStateOf(0f)
//    val z = mutableStateOf(0f)
//
//    fun startCollecting(context: Context) {
//        sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
//        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
//        accelerometer?.let {
//            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
//        }
//    }
//
//    override fun onSensorChanged(event: SensorEvent?) {
//        event?.let {
//            if (it.sensor.type == Sensor.TYPE_ACCELEROMETER) {
//                x.value = it.values[0]
//                y.value = it.values[1]
//                z.value = it.values[2]
//            }
//        }
//    }
//
//    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
//        // can be implemented if needed
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        sensorManager.unregisterListener(this)
//    }
//
//
//}





import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Environment
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import kotlin.math.atan2
import kotlin.math.sqrt

class SensorViewModel(private val sensorDao: SensorDao) : ViewModel(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null

    val x = mutableStateOf(0f)
    val y = mutableStateOf(0f)
    val z = mutableStateOf(0f)
    val angleX = mutableStateOf(0f)
    val angleY = mutableStateOf(0f)
    val angleZ = mutableStateOf(0f)

    private val _sensorDataLiveData = MutableLiveData<List<SensorData>>()
    val sensorDataLiveData: LiveData<List<SensorData>> = _sensorDataLiveData

    init {
        loadLiveData()
    }

    private fun loadLiveData() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = getSensorData()
            _sensorDataLiveData.postValue(data)
        }
    }

    fun startCollecting(context: Context, delay: Int = SensorManager.SENSOR_DELAY_NORMAL) {
        sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        accelerometer?.let {
            sensorManager.registerListener(this, it, delay)
        }
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            x.value = event.values[0]
            y.value = event.values[1]
            z.value = event.values[2]

            angleX.value = atan2(y.value, sqrt(x.value * x.value + z.value * z.value)) * (180 / Math.PI).toFloat()
            angleY.value = atan2(x.value, sqrt(y.value * y.value + z.value * z.value)) * (180 / Math.PI).toFloat()
            angleZ.value = atan2(sqrt(x.value * x.value + y.value * y.value), z.value) * (180 / Math.PI).toFloat()

            viewModelScope.launch(Dispatchers.IO) {
                sensorDao.insert(
                    SensorData(timestamp = System.currentTimeMillis(), x = x.value, y = y.value, z = z.value,
                        angleX = angleX.value, angleY = angleY.value, angleZ = angleZ.value)
                )
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}



    override fun onCleared() {
        super.onCleared()
        sensorManager.unregisterListener(this)
    }

    fun getSensorData(): List<SensorData> = sensorDao.getAll()

//    fun exportData(context: Context) {
//        viewModelScope.launch(Dispatchers.IO) {
//            val data = getSensorData()
//            val file = File(context.getExternalFilesDir(null), "sensor_data_export.txt")
//            FileOutputStream(file).use { stream ->
//                stream.bufferedWriter().use { writer ->
//                    data.forEach {
//                        writer.write("${it.timestamp}, ${it.x}, ${it.y}, ${it.z}, ${it.angleX}, ${it.angleY}, ${it.angleZ}\n")
//                    }
//                }
//            }
//            // Code to share or save the file can be implemented here
//        }
//    }


    fun exportData(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = getSensorData()  // Assuming getSensorData returns a list of SensorData objects

            // Attempting to use the Documents directory for file storage
            val documentsDir = ContextCompat.getExternalFilesDirs(context, Environment.DIRECTORY_DOCUMENTS).firstOrNull()

            if (documentsDir != null) {
                try {
                    val file = File(documentsDir, "sensor_data_export.txt")
                    FileOutputStream(file).use { fos ->
                        fos.bufferedWriter().use { writer ->
                            data.forEach { sensorData ->
                                writer.write("${sensorData.timestamp}, ${sensorData.x}, ${sensorData.y}, ${sensorData.z}\n")
                            }
                        }
                    }
                    // Notify user of success on the main thread
                    launch(Dispatchers.Main) {
                        Toast.makeText(context, "Data exported to ${file.absolutePath}", Toast.LENGTH_LONG).show()
                    }
                } catch (e: Exception) {
                    // Handle exceptions such as IOException on the main thread
                    launch(Dispatchers.Main) {
                        Toast.makeText(context, "Failed to export data: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
                    }
                }
            } else {
                // Notify user of failure on the main thread
                launch(Dispatchers.Main) {
                    Toast.makeText(context, "External storage is not available", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
