import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import javax.swing.text.PasswordView

@Composable
@Preview
fun Login() {

    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            var usuario by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var viewPassword by remember { mutableStateOf(false) }
            var buttonEnable = usuario.isNotBlank() && password.isNotBlank()

            UsuarioView(usuario) { usuario = it }

            ViewPassword(password, { password = it }, viewPassword, {viewPassword = it})

            Boton({usuario = ""; password = ""}, buttonEnable)
        }
    }
}

@Composable
fun UsuarioView(usuario: String, onValueChange:(String)->Unit){
    OutlinedTextField(
        value = usuario,
        onValueChange = onValueChange,
        label = { Text("Usuario") }
    )
}

@Composable
fun ViewPassword(password: String, onValueChange:(String)->Unit, viewPassword: Boolean, onCheckedChange:(Boolean)->Unit){
    OutlinedTextField(
        value = password,
        onValueChange = onValueChange,
        label = { Text(text = "Contraseña") },
        visualTransformation = if (viewPassword) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconToggleButton(
                checked = viewPassword,
                onCheckedChange = onCheckedChange
            ){
                Icon(
                    imageVector = if (viewPassword) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    contentDescription = "View"
                )
            }
        }
    )
}

@Composable
fun Boton(onClick: () -> Unit, buttonEnable: Boolean){
    Button(
        onClick = onClick,
        enabled = buttonEnable
    ){
        Text("Login")
    }
}