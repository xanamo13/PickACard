package com.example.finaldraft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finaldraft.ui.theme.FinalDraftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            cardApp()
        }
    }
}

@Composable
fun cardApp(modifier: Modifier = Modifier) {

    var buttonClicked by remember { mutableStateOf(false)}

    Column(modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Row(
            modifier = Modifier,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                if(buttonClicked){
                    chooseCard()
                } else {
                    openingScreen(onStartClick = {buttonClicked = true})
                }


            }
        }
    }
}

@Composable
fun openingScreen(onStartClick: () -> Unit){
    val deliusFont = FontFamily(
        Font(R.font.test, FontWeight.Normal)
    )

    Column (modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Spacer(Modifier.size(200.dp))

        Text(
            "Choose A Card!",
            fontSize = 60.sp,
            fontFamily = deliusFont,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .size(width = 300.dp, height = 300.dp)
                .align(Alignment.CenterHorizontally)
                .background(Color(0xffe1fcf1))
                .padding(50.dp),
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(150.dp))

        Button(
            onClick = onStartClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFB0F5D8)
            )
        )
        {
            Text(
                "Start",
                color = Color.Black
            )
        }

    }
}

@Composable
fun chooseCard(modifier: Modifier = Modifier) {
    var card by remember{mutableStateOf(1)}

    Spacer(Modifier.size(100.dp))

    when (card) {

        1 -> createCard(R.string.japanese, R.drawable.sushi)

        2 -> createCard(R.string.pizza, R.drawable.pizza)

        3 -> createCard(R.string.thai, R.drawable.springrolls)

        4 -> createCard(R.string.mexican, R.drawable.tamales)

        5 -> createCard(R.string.chinese, R.drawable.dumplings)
    }

    Spacer(Modifier.size(30.dp))

    Button(onClick = {
        card = (1..5).random()
    },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFB0F5D8)) )
    {
        Text(
            "Next Card",
            color = Color.Black
        )
    }
}



@Composable
fun createCard(@StringRes textRes: Int, @DrawableRes imgRes: Int) {

    val deliusFont = FontFamily(
        Font(R.font.test, FontWeight.Normal)
    )

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xffd4ffee)
        ),

        modifier = Modifier
            .size(width = 300.dp, height = 450.dp)

        ) {

        Spacer(modifier = Modifier.height(70.dp))

            Image(
                painter = painterResource(id = imgRes),
                contentDescription = stringResource(id = textRes),
                modifier = Modifier
                    .border(BorderStroke(5.dp, Color(0xFFB0F5D8)), RoundedCornerShape(15.dp))
                    .clip(RoundedCornerShape(15.dp))
                    .size(width =200.dp, height = 200.dp)
                    .background(Color(0xffe1fcf1))
                    .align(Alignment.CenterHorizontally)
                    .padding(50.dp)
            )

        Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = stringResource(id = textRes),
                fontFamily = deliusFont,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
            )
        }

    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FinalDraftTheme {
        cardApp()
    }
}