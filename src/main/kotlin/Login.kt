import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.sp
import javax.swing.text.PasswordView

@Composable
@Preview
fun Login() {

    MaterialTheme{
            var name by remember { mutableStateOf("") }


            OutlinedTextField(
                value = name,
                onValueChange = {name = it},
                label = { Text("Usuario") },
            )


    }
}

@Composable
@Preview
fun PasswordView(){
    var password by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = password,
        onValueChange = {password = it},
        placeholder = {
            Text(
                text = "Contraseña"
            )
        }
    ){}

}