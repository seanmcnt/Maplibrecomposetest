package com.example.maplibre_compose_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import org.maplibre.android.MapLibre
import org.maplibre.android.camera.CameraPosition
import org.maplibre.android.geometry.LatLng
import org.maplibre.android.maps.MapView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MapView()
        }
    }
    @Composable
    fun MapView(
        modifier: Modifier = Modifier
    ) {
        AndroidView(
            modifier = modifier,
            factory = { context ->
                // Init MapLibre
                MapLibre.getInstance(context)

                // Init the MapView
                MapView(context).apply{
                    getMapAsync { map ->
                        map.setStyle("https://demotiles.maplibre.org/style.json")
                        map.cameraPosition =
                            CameraPosition.Builder().target(LatLng(0.0, 0.0)).zoom(1.0).build()
                    }
                }
            }
        )
    }
}



