package br.com.fiap.telaconfiguracoes.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.telaconfiguracoes.R

@Composable
fun Cadastro(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,


        ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(80.dp),

            )
        Text(
            "Cadastrar-se",
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)

        )
        Text(
            "Preencha os detalhes para concluir seu cadastro.",
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(16.dp))
        Registros(navController)
    }
}

@Composable
fun Registros(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nome") },
            shape = RoundedCornerShape(12.dp),
            placeholder = { Text("Digite seu nome") }
        )




        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            shape = RoundedCornerShape(12.dp),
            placeholder = {
                Text("Digite seu email")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text("Senha") },
            placeholder = { Text("Digite sua senha") },
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(12.dp)
        )

        TextField(
            value = confirmarSenha,
            onValueChange = { confirmarSenha = it },
            label = { Text("Confirme a Senha") },
            placeholder = { Text("Repita sua senha") },
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(12.dp),

            )


        Text(
            text = "Sua senha deve ter no mínimo 8 caracteres.",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp)
        )
        Spacer(modifier = Modifier.height(1.dp))

        Button(
            onClick = { navController.navigate("login") },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF087F73)),
            shape = RoundedCornerShape(8.dp)


        ) {
            Text(text = "Próximo", fontSize = 16.sp)
        }


        Row {
            Text(text = "Já possui uma conta?")
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Entrar",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF087F73),
                modifier = Modifier.clickable { navController.navigate("login") })
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Ou conecte-se", fontSize = 14.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = "Logo",
                modifier = Modifier.size(36.dp)
            )


            Image(
                painter = painterResource(id = R.drawable.ic_facebook),
                contentDescription = "Logo",
                modifier = Modifier.size(36.dp)
            )

            @Composable
            fun CampoTexto(
                Valor: String,
                onValorMudado: (String) -> Unit,
                label: String,
                placeholder: String
            ) {
                OutlinedTextField(
                    value = Valor,
                    onValueChange = onValorMudado,
                    label = { Text(label) },
                    placeholder = { Text(placeholder) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    textStyle = TextStyle(fontSize = 14.sp)

                )

            }

            @Composable
            fun CampoSenha(
                Valor: String,
                onValorMudado: (String) -> Unit,
                label: String,
                placeholder: String,
                senhaVisivel: Boolean,
                onSenhaVisivelMudado: (Boolean) -> Unit
            ) {
                OutlinedTextField(

                    value = Valor,
                    onValueChange = onValorMudado,
                    placeholder = { Text(text = placeholder) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    textStyle = TextStyle(fontSize = 14.sp),
                    singleLine = true,
                    visualTransformation = if (senhaVisivel) VisualTransformation.None else PasswordVisualTransformation(),
                    shape = RoundedCornerShape(8.dp)


                )


            }

        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//private fun cadastroScreenPreview() {
//    Cadastro()
//
//}