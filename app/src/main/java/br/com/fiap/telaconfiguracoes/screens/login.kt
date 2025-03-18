package br.com.fiap.telaconfiguracoes.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.telaconfiguracoes.R

@Composable
fun TelaLogin(
    onLoginSuccess: () -> Unit,
    onNavigateToRegister: () -> Unit,
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Image(
            painter = painterResource(R.drawable.ic_logo),
            contentDescription = stringResource(R.string.logo_desc),
            modifier = Modifier.size(80.dp)
        )

        Text(
            text = stringResource(R.string.bem_vindo),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Box {
            Text(
                text = stringResource(R.string.logar_desc),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }


        Spacer(modifier = Modifier.height(24.dp))

        // Campo de E-mail
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(stringResource(R.string.email)) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = errorMessage != null
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campo de Senha
        OutlinedTextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text(stringResource(R.string.senha)) },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            isError = errorMessage != null
        )

        // Link "Esqueceu a senha?"
        Text(
            text = stringResource(R.string.esqueceu_senha),
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .clickable(onClick = {navController.navigate("recuperacaoSenha")})
                .align(Alignment.End)
                .padding(top = 4.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Mensagem de erro
        errorMessage?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }

        // Botão de Login
        Button(
            onClick = {

                navController.navigate("home")


            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = stringResource(R.string.entrar),
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Link para Cadastro
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(stringResource(R.string.nao_tem_conta))
            Text(
                text = stringResource(R.string.cadastrar_se),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .clickable(onClick = { navController.navigate("cadastro") })
                    .padding(start = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Divisor
        Text(
            text = stringResource(R.string.login_social),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Login Social
        Row(modifier = Modifier.padding(top = 16.dp)) {
            IconButton(onClick = { /* Google Login */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = stringResource(R.string.entrar_google)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(onClick = { /* Facebook Login */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_facebook),
                    contentDescription = stringResource(R.string.entrar_facebook)
                )
            }
        }
    }
}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//private fun loginScreenPreviwe() {
//
//    TelaLogin(
//        onLoginSuccess = {},
//        onNavigateToRegister = {}
//    )
//
//}