////package com.example.accelerometer_ml_app
////
////import android.os.Bundle
////import androidx.activity.ComponentActivity
////import androidx.activity.compose.setContent
////import androidx.compose.foundation.layout.*
////import androidx.compose.material3.Button
////import androidx.compose.material3.MaterialTheme
////import androidx.compose.material3.Text
////import androidx.compose.runtime.Composable
////import androidx.compose.ui.Alignment
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.unit.dp
////import androidx.lifecycle.ViewModelProvider
////import androidx.navigation.NavController
////import androidx.navigation.compose.rememberNavController
////
////
////import com.github.mikephil.charting.charts.LineChart
////import com.github.mikephil.charting.data.Entry
////import com.github.mikephil.charting.data.LineData
////import com.github.mikephil.charting.data.LineDataSet
////
////class HistoryActivity : ComponentActivity() {
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        setContent {
////            HistoryScreen()
////        }
////    }
////
////    @Composable
////    fun HistoryScreen() {
////        val viewModel = ViewModelProvider(this)[SensorViewModel::class.java]
////        val data = viewModel.getSensorData()
////
////        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
////            Text("History of Sensor Readings", style = MaterialTheme.typography.headlineMedium)
////            Spacer(modifier = Modifier.height(20.dp))
////            val entriesX = data.mapIndexed { index, sensorData -> Entry(index.toFloat(), sensorData.angleX) }
////            val entriesY = data.mapIndexed { index, sensorData -> Entry(index.toFloat(), sensorData.angleY) }
////            val entriesZ = data.mapIndexed { index, sensorData -> Entry(index.toFloat(), sensorData.angleZ) }
////
////            LineChart(Modifier.weight(1f)).apply {
////                data = LineData(LineDataSet(entriesX, "X Angle"), LineDataSet(entriesY, "Y Angle"), LineDataSet(entriesZ, "Z Angle"))
////                description.text = "Sensor Angles Over Time"
////            }
////
////            Button(onClick = { viewModel.exportData() }) {
////                Text("Export Data")
////            }
////        }
////    }
////}
//
//
//
//package com.example.accelerometer_ml_app
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.viewinterop.AndroidView
//import androidx.lifecycle.ViewModelProvider
//import com.aachartmodel.aainfographics.aachartcreator.*
//
//class HistoryActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            HistoryScreen()
//        }
//    }
//
//    @Composable
//    fun HistoryScreen() {
//        val context = LocalContext.current
//        val viewModel = ViewModelProvider(this@HistoryActivity)[SensorViewModel::class.java]
//        val sensorData = viewModel.getSensorData()
//
//        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
//            Text("History of Sensor Readings", style = MaterialTheme.typography.headlineMedium)
//            Spacer(modifier = Modifier.height(20.dp))
//
//            AndroidView(factory = { ctx ->
//                AAChartView(ctx).apply {
//                    val aaChartModel : AAChartModel = AAChartModel()
//                        .chartType(AAChartType.Line)
//                        .title("Sensor Data Over Time")
//                        .backgroundColor("#FFFFFF")
//                        .dataLabelsEnabled(true)
//                        .series(arrayOf(
//                            AASeriesElement()
//                                .name("X Angle")
//                                .data(sensorData.map { it.angleX.toDouble() }.toTypedArray()),
//                            AASeriesElement()
//                                .name("Y Angle")
//                                .data(sensorData.map { it.angleY.toDouble() }.toTypedArray()),
//                            AASeriesElement()
//                                .name("Z Angle")
//                                .data(sensorData.map { it.angleZ.toDouble() }.toTypedArray())
//                        ))
//
//                    this.aa_drawChartWithChartModel(aaChartModel)
//                }
//            }, modifier = Modifier.fillMaxHeight(0.8f).fillMaxWidth())
//
//            Spacer(modifier = Modifier.height(20.dp))
//            Button(onClick = { viewModel.exportData(context) }) {
//                Text("Export Data")
//            }
//        }
//    }
//}
