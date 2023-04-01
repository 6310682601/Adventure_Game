import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adventure_game.ui.GameViewModel
import com.example.adventure_game.ui.theme.Adventure_GameTheme

@Composable
fun Adventure_Game(modifier: Modifier = Modifier, gameViewModel: GameViewModel) {
    val gameUiState by gameViewModel.uiState.collectAsState()
    val story = gameUiState.currentStorys
    val choice = gameUiState.choice
    val index = gameUiState.index
    val ending = gameUiState.ending

    Column(
        Modifier
            .fillMaxSize()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF4A148C))
        ) {
            Text(
                text = "Adventure Game",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(12.dp)
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
            text = story.story,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(200.dp))
        Button(
            onClick = {gameViewModel.check("0")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = choice[0],
                fontSize = 20.sp
            )
        }

        Button(
            onClick = {gameViewModel.check("1")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = choice[1],
                fontSize = 20.sp)
        }

        if (gameUiState.ending == 1) {
            EndDialog(end = 1, onPlayAgain = { gameViewModel.reset(true)})
        } else if (gameUiState.ending == 2) {
            EndDialog(end = 2, onPlayAgain = { gameViewModel.reset(true)})
        } else if (gameUiState.ending == 3) {
            EndDialog(end = 3, onPlayAgain = { gameViewModel.reset(true)})
        } else if (gameUiState.ending == 4) {
            EndDialog(end = 4, onPlayAgain = { gameViewModel.reset(true)})
        }
    }
}

@Composable
fun EndDialog(
    end: Int,
    onPlayAgain: () -> Unit,
) {
    val activity = (LocalContext.current as Activity)

    if (end == 1) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text(text = "Game Over") },
            text = { Text(text = "คุณโดนเต่าด่ากลับ ทำให้คุณหมดกำลังใจในการใช้ชีวิต") },
            dismissButton = {
                TextButton(onClick = {activity.finish()}) {
                    Text(text = "Exit")
                }},
            confirmButton = {
                TextButton(onClick = onPlayAgain) {
                    Text(text = "Reset")
                }
            }
        )
    } else if (end == 2) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text(text = "Game Over") },
            text = { Text(text = "เต่ามีกำลังใจในการวิ่ง จึงวิ่งชนะคุณ") },
            dismissButton = {
                TextButton(onClick = {activity.finish()}) {
                    Text(text = "Exit")
                }},
            confirmButton = {
                TextButton(onClick = onPlayAgain) {
                    Text(text = "Reset")
                }
            }
        )
    } else if (end == 3) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text(text = "Twingle little star ending") },
            text = { Text(text = "คกระต่ายเห็นคุณนอนหลับ จึงมาหลับเป็นเพื่อนคุณ") },
            dismissButton = {
                TextButton(onClick = {activity.finish()}) {
                    Text(text = "Exit")
                }},
            confirmButton = {
                TextButton(onClick = onPlayAgain) {
                    Text(text = "Reset")
                }
            }
        )
    } else if (end == 4) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text(text = "Game Over") },
            text = { Text(text = "คุณโกงจึงถูกปรับแพ้") },
            dismissButton = {
                TextButton(onClick = {activity.finish()}) {
                    Text(text = "Exit")
                }},
            confirmButton = {
                TextButton(onClick = onPlayAgain) {
                    Text(text = "Reset")
                }
            }
        )
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Adventure_GameTheme {

    }
}
