package com.example.accelerometer_ml_app






//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            AppNavigation()
//        }
//    }
//}
//
//@Composable
//fun AppNavigation() {
//    val navController = rememberNavController()
//    NavHost(navController, startDestination = "sensor") {
//        composable("sensor") { SensorScreen(navController) }
//        composable("history") { HistoryScreen() }
//    }
//}
//
//@Composable
//fun SensorScreen(navController: NavController) {
//    val viewModel: SensorViewModel = viewModel()
//    val context = LocalContext.current
//    LaunchedEffect(true) {
//        viewModel.startCollecting(context)
//    }
//
//    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
//        Text(text = "Sensor Readings", style = MaterialTheme.typography.headlineMedium)
//        Text(text = "X: ${viewModel.x.value}", style = MaterialTheme.typography.headlineMedium)
//        Text(text = "Y: ${viewModel.y.value}", style = MaterialTheme.typography.headlineMedium)
//        Text(text = "Z: ${viewModel.z.value}", style = MaterialTheme.typography.headlineMedium)
//        Spacer(modifier = Modifier.height(20.dp))
//        Button(onClick = { navController.navigate("history") }) {
//            Text("View History")
//        }
//    }
//}
//
//@Composable
//fun HistoryScreen() {
//    // Will be implemented
//}
//
//





/////////////////////////////////////////////////



//
//
//@Composable
//fun HistoryScreen(navController: NavHostController) {
//    // Will be implemented
//}


//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MainScreen()
//        }
//    }
//
//    @Composable
//    fun MainScreen() {
//        val navController = rememberNavController()
//        NavHost(navController, startDestination = "sensorScreen") {
//            composable("sensorScreen") { SensorScreen(navController) }
//            composable("historyScreen") { HistoryScreen(navController) }
//        }
//    }
//
//    @Composable
//    fun SensorScreen(navController: NavController) {
//        val context = LocalContext.current
//        val sensorDao = AppDatabase.getDatabase(context).sensorDao()
//        val viewModel: SensorViewModel = viewModel(factory = SensorViewModelFactory(sensorDao))
//
//        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
//            Text(text = "Real-time Sensor Readings", style = MaterialTheme.typography.headlineMedium)
//            Text(text = "X Angle: ${viewModel.angleX.value}°", style = MaterialTheme.typography.bodyLarge)
//            Text(text = "Y Angle: ${viewModel.angleY.value}°", style = MaterialTheme.typography.bodyLarge)
//            Text(text = "Z Angle: ${viewModel.angleZ.value}°", style = MaterialTheme.typography.bodyLarge)
//            Spacer(modifier = Modifier.height(20.dp))
//            Button(onClick = { viewModel.startCollecting(context, SensorManager.SENSOR_DELAY_FASTEST) }) {
//                Text("Set Fastest Delay")
//            }
//            Button(onClick = { viewModel.startCollecting(context, SensorManager.SENSOR_DELAY_GAME) }) {
//                Text("Set Game Delay")
//            }
//            Button(onClick = { viewModel.startCollecting(context, SensorManager.SENSOR_DELAY_UI) }) {
//                Text("Set UI Delay")
//            }
//            Button(onClick = { viewModel.startCollecting(context, SensorManager.SENSOR_DELAY_NORMAL) }) {
//                Text("Set Normal Delay")
//            }
//            Spacer(modifier = Modifier.height(20.dp))
//            Button(onClick = { navController.navigate("historyScreen") }) {
//                Text("View History")
//            }
//        }
//    }
//
//    @Composable
//    fun HistoryScreen(navController: NavController) {
//        val context = LocalContext.current
//        val sensorDao = AppDatabase.getDatabase(context).sensorDao()
//        val viewModel: SensorViewModel = viewModel(factory = SensorViewModelFactory(sensorDao))
//
//        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
//            Text(text = "Historical Sensor Data", style = MaterialTheme.typography.headlineMedium)
//            Button(onClick = { viewModel.exportData(context) }) {
//                Text("Export Data")
//            }
//            Button(onClick = { navController.navigate("sensorScreen") }) {
//                Text("Back to Sensor Screen")
//            }
//        }
//    }
//}



//import androidx.compose.runtime.collectAsState


//import com.github.tehras.charts.line.LineChart
//import com.github.tehras.charts.line.renderer.point.SimplePointDrawer
//import com.github.tehras.charts.line.renderer.xaxis.SimpleXAxisDrawer
//import com.github.tehras.charts.line.renderer.yaxis.SimpleYAxisDrawer




//import androidx.lifecycle.viewmodel.compose.collectAsState
//
//import androidx.compose.runtime.livedata.collectAsState
import android.content.Context
import android.graphics.Color
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

//import androidx.compose.runtime.flow.collectAsState




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

    @Composable
    fun MainScreen() {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "sensorScreen") {
            composable("sensorScreen") { SensorScreen(navController) }
            composable("historyScreen") { HistoryScreen(navController) }
        }
    }

    @Composable
    fun SensorScreen(navController: NavController) {
        val context = LocalContext.current
        val sensorDao = AppDatabase.getDatabase(context).sensorDao()
        val viewModel: SensorViewModel = ViewModelProvider(this, SensorViewModelFactory(sensorDao)).get(SensorViewModel::class.java)

        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Text(text = "Real-time Sensor Readings", style = MaterialTheme.typography.headlineMedium)
            Text(text = "X: ${viewModel.x.value}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Y: ${viewModel.y.value}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Z: ${viewModel.z.value}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { viewModel.startCollecting(context, SensorManager.SENSOR_DELAY_FASTEST) }) {
                Text("Set Fastest Delay")
            }
            Button(onClick = { viewModel.startCollecting(context, SensorManager.SENSOR_DELAY_GAME) }) {
                Text("Set Game Delay")
            }
            Button(onClick = { viewModel.startCollecting(context, SensorManager.SENSOR_DELAY_UI) }) {
                Text("Set UI Delay")
            }
            Button(onClick = { viewModel.startCollecting(context, SensorManager.SENSOR_DELAY_NORMAL) }) {
                Text("Set Normal Delay")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { navController.navigate("historyScreen") }) {
                Text("View History")
            }
        }
    }

//    @Composable
//    fun HistoryScreen(navController: NavController) {
//        val context = LocalContext.current
//        val sensorDao = AppDatabase.getDatabase(context).sensorDao()
//        val viewModel: SensorViewModel = ViewModelProvider(this, SensorViewModelFactory(sensorDao)).get(SensorViewModel::class.java)
//
//        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
//            Text(text = "Historical Sensor Data", style = MaterialTheme.typography.headlineMedium)
//            Button(onClick = { viewModel.exportData(context) }) {
//                Text("Export Data")
//            }
//            Button(onClick = { navController.navigate("sensorScreen") }) {
//                Text("Back to Sensor Screen")
//            }
//        }
//    }



    
//
//    @Composable
//    fun HistoryScreen(navController: NavController) {
////        val context = LocalContext.current
////        val sensorDao = AppDatabase.getDatabase(context).sensorDao()
////        val viewModel: SensorViewModel = viewModel(factory = SensorViewModelFactory(sensorDao))
////        val sensorDataList = viewModel.getSensorData().collectAsState(initial = emptyList())
//
//        val context = LocalContext.current
//        val sensorDao = AppDatabase.getDatabase(context).sensorDao()
//        val viewModel: SensorViewModel = viewModel(factory = SensorViewModelFactory(sensorDao))
//        val sensorDataList = viewModel.sensorDataLiveData.observeAsState(initial = emptyList())
//
//
//        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
//            Text(text = "Historical Sensor Data", style = MaterialTheme.typography.headlineMedium)
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(onClick = { viewModel.exportData(context) }) {
//                Text("Export Data")
//            }
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(onClick = { navController.navigate("sensorScreen") }) {
//                Text("Back to Sensor Screen")
//            }
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Display chart using MPAndroidChart
//
//        }
//        Spacer(modifier = Modifier.height(24.dp))
//
//        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
//
//            SensorChart(sensorDataList.value,context)
//        }
//
//
//    }
//
//
//
//    @Composable
//    fun SensorChart(sensorDataList: List<SensorData>, context: Context) {
//        val lineChart = remember { LineChart(context) }
//
//        // Configure chart appearance
//        lineChart.apply {
//            description.text = "Sensor Data Over Time"
//            description.textColor = Color.LTGRAY
//            description.textSize = 10f
//            setTouchEnabled(true)
//            isDragEnabled = true
//            setScaleEnabled(true)
//            setPinchZoom(true)
//            setBackgroundColor(Color.WHITE)
//            extraBottomOffset = 10f  // Adds a little extra space at the bottom
//
//            xAxis.apply {
//                position = XAxis.XAxisPosition.BOTTOM
//                setDrawGridLines(false)
//                textColor = Color.GRAY
//                textSize = 12f
//                granularity = 1f
//                valueFormatter = XAxisValueFormatter()
//            }
//
//            axisLeft.apply {
//                textColor = Color.GRAY
//                textSize = 12f
//                setDrawGridLines(true)
//                gridColor = Color.BLUE
//            }
//
//            axisRight.isEnabled = false
//
//            legend.apply {
//                textSize = 12f
//                form = Legend.LegendForm.LINE
//                horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
//                verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
//                orientation = Legend.LegendOrientation.HORIZONTAL
//                setDrawInside(false)
//            }
//        }
//
//        // Prepare data for chart
//        val entriesX = mutableListOf<Entry>()
//        val entriesY = mutableListOf<Entry>()
//        val entriesZ = mutableListOf<Entry>()
//
//        sensorDataList.forEachIndexed { index, sensorData ->
//            entriesX.add(Entry(index.toFloat(), sensorData.x.toFloat()))
//            entriesY.add(Entry(index.toFloat(), sensorData.y.toFloat()))
//            entriesZ.add(Entry(index.toFloat(), sensorData.z.toFloat()))
//        }
//
//        val dataSetX = LineDataSet(entriesX, "X Axis").apply {
//            color = Color.BLUE
//            lineWidth = 2.5f
//            setCircleColor(Color.BLUE)
//            circleRadius = 4f
//            valueTextSize = 9f
//            setDrawValues(false)
//            mode = LineDataSet.Mode.CUBIC_BEZIER
//        }
//
//        val dataSetY = LineDataSet(entriesY, "Y Axis").apply {
//            color = Color.GREEN
//            lineWidth = 2.5f
//            setCircleColor(Color.GREEN)
//            circleRadius = 4f
//            valueTextSize = 9f
//            setDrawValues(false)
//            mode = LineDataSet.Mode.CUBIC_BEZIER
//        }
//
//        val dataSetZ = LineDataSet(entriesZ, "Z Axis").apply {
//            color = Color.RED
//            lineWidth = 2.5f
//            setCircleColor(Color.RED)
//            circleRadius = 4f
//            valueTextSize = 9f
//            setDrawValues(false)
//            mode = LineDataSet.Mode.CUBIC_BEZIER
//        }
//
//        val lineData = LineData(listOf(dataSetX, dataSetY, dataSetZ))
//        lineChart.data = lineData
//        lineChart.invalidate()  // Refresh chart
//
//        // Display the chart
//        AndroidView(factory = { lineChart })
//    }
//
//    class XAxisValueFormatter : ValueFormatter() {
//        private val dateFormatter = SimpleDateFormat("HH:mm", Locale.US)
//
//        override fun getFormattedValue(value: Float): String {
//            // Assuming your value represents a timestamp
//            return dateFormatter.format(Date(value.toLong()))
//        }
//    }


    @Composable
    fun HistoryScreen(navController: NavController) {
        val context = LocalContext.current
        val sensorDao = AppDatabase.getDatabase(context).sensorDao()
        val viewModel: SensorViewModel = viewModel(factory = SensorViewModelFactory(sensorDao))
        val sensorDataList = viewModel.sensorDataLiveData.observeAsState(listOf()) // use listOf() for clearer intent

        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Text(text = "Historical Sensor Data", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { viewModel.exportData(context) }) {
                Text("Export Data")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("sensorScreen") }) {
                Text("Back to Sensor Screen")
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Display the chart
            SensorChart(sensorDataList = sensorDataList.value, context)
        }
    }

    @Composable
    fun SensorChart(sensorDataList: List<SensorData>, context:Context) {
        val lineChart = remember { LineChart(context) }

        // Configure chart appearance
        lineChart.apply {
            description.text = "Sensor Readings Over Time"
            setTouchEnabled(true)
            isDragEnabled = true
            setScaleEnabled(true)
            setPinchZoom(true)

            xAxis.apply {
                position = XAxis.XAxisPosition.BOTTOM
                setDrawGridLines(false)
                granularity = 1f
                textColor = Color.WHITE
            }

            axisLeft.apply {
                textColor = Color.WHITE
                setDrawGridLines(true)
            }

            axisRight.isEnabled = false

            legend.apply {
                textSize = 12f
                textColor = Color.WHITE
                verticalAlignment = Legend.LegendVerticalAlignment.TOP
                horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
                orientation = Legend.LegendOrientation.HORIZONTAL
                setDrawInside(false)
            }
        }

        // Prepare data for chart
        val entriesX = sensorDataList.mapIndexed { index, sensorData -> Entry(index.toFloat(), sensorData.x) }
        val entriesY = sensorDataList.mapIndexed { index, sensorData -> Entry(index.toFloat(), sensorData.y) }
        val entriesZ = sensorDataList.mapIndexed { index, sensorData -> Entry(index.toFloat(), sensorData.z) }

        val dataSetX = LineDataSet(entriesX, "X").apply {
            color = Color.BLUE
            setCircleColor(Color.BLUE)
            lineWidth = 2f
            circleRadius = 3f
            valueTextColor = Color.BLUE
            setDrawValues(false)
            setDrawCircles(true)
            setDrawCircleHole(false)
        }

        val dataSetY = LineDataSet(entriesY, "Y").apply {
            color = Color.GREEN
            setCircleColor(Color.GREEN)
            lineWidth = 2f
            circleRadius = 3f
            valueTextColor = Color.GREEN
            setDrawValues(false)
            setDrawCircles(true)
            setDrawCircleHole(false)
        }

        val dataSetZ = LineDataSet(entriesZ, "Z").apply {
            color = Color.RED
            setCircleColor(Color.RED)
            lineWidth = 2f
            circleRadius = 3f
            valueTextColor = Color.RED
            setDrawValues(false)
            setDrawCircles(true)
            setDrawCircleHole(false)
        }

        val lineData = LineData(listOf(dataSetX, dataSetY, dataSetZ))

        // Set data to chart
        lineChart.data = lineData
        lineChart.invalidate() // Refresh the chart

        // Display the chart
        AndroidView(factory = { lineChart }, modifier = Modifier.fillMaxSize())
    }



}

