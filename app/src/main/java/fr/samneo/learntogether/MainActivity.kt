package fr.samneo.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.samneo.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MainWindow()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.bg_compose_background),
        contentDescription = null,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainWindow(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            AppTopBar(Modifier.fillMaxWidth())
        },
    ) { paddingValue ->
        Column(modifier.padding(paddingValue)) {
            Text(
                text = stringResource(id = R.string.title),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Justify
            )
            Text(
                text = stringResource(id = R.string.description),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
            Text(
                text = stringResource(id = R.string.content),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainWindowPreview() {
    LearnTogetherTheme {
        MainWindow()
    }
}