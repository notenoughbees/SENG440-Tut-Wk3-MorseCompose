package nz.ac.uclive.dsi61.morsecompose

import android.annotation.SuppressLint
import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
//import androidx.compose.material3.Button
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nz.ac.uclive.dsi61.morsecompose.ui.theme.MorseComposeTheme

class MainActivity : ComponentActivity() {
//    @OptIn(ExperimentalMaterial3Api::class) // TopAppBar is experimental
//    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toner = ToneGenerator(AudioManager.STREAM_ALARM, ToneGenerator.MAX_VOLUME)
        val dotTime = 200
        val dashTime = 3 * dotTime

        setContent {
            MorseComposeTheme {
                Scaffold (
                    topBar = {
                        TopAppBar (
                            title = {
                                Text(
                                    text = getString(R.string.app_name)
                                )
                            }
                        )
                    }
                ) {
                    // layout the buttons
                    Column (modifier = Modifier.fillMaxHeight()) {
                        // wrap each SoundButton into a Box component, to give them styling
                        Box(
                            modifier = Modifier
                                .weight(2f)
                                .padding(all = 2.dp)
                        ) {
                            // create the buttons
                            SoundButton(label = getString(R.string.dotButtonText)) {
                                toner.startTone(ToneGenerator.TONE_SUP_DIAL, dotTime)
                            }
                        }
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(all = 2.dp)
                        ) {
                            SoundButton(label = getString(R.string.dashButtonText)) {
                                toner.startTone(ToneGenerator.TONE_SUP_DIAL, dashTime)
                            }
                        }
                    }
                }
            }
        }
    }


    @Composable
    fun SoundButton(label: String, onClick: () -> Unit) {
        Button(
            modifier = Modifier.fillMaxSize(), // make the buttons fill out the space of their parent - the Box component
            onClick = onClick,
        ) {
            Text(
                text = label,
            )
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun SoundButtonPreview() {
        SoundButton("Test") { }
    }

}

