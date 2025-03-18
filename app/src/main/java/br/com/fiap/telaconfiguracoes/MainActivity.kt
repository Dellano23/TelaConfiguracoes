package br.com.fiap.telaconfiguracoes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.telaconfiguracoes.componentes.cardConfiguracoes
import br.com.fiap.telaconfiguracoes.screens.Cadastro
import br.com.fiap.telaconfiguracoes.screens.EnergySavingsScreen
import br.com.fiap.telaconfiguracoes.screens.Registros
import br.com.fiap.telaconfiguracoes.screens.Tela1
import br.com.fiap.telaconfiguracoes.screens.TelaLogin
import br.com.fiap.telaconfiguracoes.ui.theme.TelaConfiguracoesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TelaConfiguracoesTheme {
                Surface() {

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "login") {
                        composable(route = "login") { TelaLogin(onLoginSuccess = {}, onNavigateToRegister = {}, navController)}
                        composable(route = "configuracoes") { ConfigScreen() }
                        composable(route = "home") { EnergySavingsScreen(navController) }
                        composable(route = "cadastro"){ Cadastro(navController) }
                        composable(route = "recuperacaoSenha"){ Tela1(navController) }

                    }


                }

            }
        }
    }
}

@Composable
fun ConfigScreen() {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        Column(
            modifier = Modifier
                .padding(start = 20.dp, top = 40.dp, end = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                IconButton(onClick = { check(true) }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "Voltar",
                        modifier = Modifier.size(35.dp),
                        tint = Color.Black
                    )
                }

                Text(
                    text = "Configurações",
                    fontSize = 25.sp,
                    color = Color.Black
                )

                IconButton(onClick = {}) {

                    Icon(
                        imageVector = Icons.Rounded.AccountCircle,
                        contentDescription = "Perfil",
                        modifier = Modifier.size(35.dp),
                        tint = Color.Black
                    )
                }


            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(
                        color = colorResource(R.color.backgroud_cinza),
                        shape = RoundedCornerShape(12.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                Text(
                    text = "Dispositivos",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Text(
                    text = "Integrações",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Text(
                    text = "Meu Perfil",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )


            }

            Spacer(modifier = Modifier.height(40.dp))

            //Cards
            cardConfiguracoes(
                R.drawable.door_closed_solid,
                descricaoIcon = "Portas Automáticas",
                tempoUso = "20 min"
            )
            cardConfiguracoes(
                R.drawable.lightbulb_regular,
                descricaoIcon = "Lâmpadas",
                tempoUso = "35 min"
            )
            cardConfiguracoes(
                R.drawable.temperature_quarter_solid,
                descricaoIcon = "Ar condicionado",
                tempoUso = "0 min"
            )
            cardConfiguracoes(
                R.drawable.battery_half_solid,
                descricaoIcon = "Gerador",
                tempoUso = "12 min"
            )

        }

        Row(
            Modifier
                .fillMaxWidth()
                .height(90.dp)
                .background(
                    colorResource(R.color.backgroud_cinza),
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                )
                .align(Alignment.BottomCenter),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(R.drawable.gear_solid),
                    //                    painter = painterResource(R.drawable.door_closed_solid),
                    modifier = Modifier.size(30.dp),
                    tint = Color.Gray,
                    contentDescription = ""

                )

                Text(text = "Configurações", fontSize = 12.sp)
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(R.drawable.bullseye_solid),
                    //                    painter = painterResource(R.drawable.door_closed_solid),
                    modifier = Modifier.size(30.dp),
                    tint = Color.Gray,
                    contentDescription = ""

                )

                Text(text = "Metas", fontSize = 12.sp)
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(R.drawable.seedling_solid),
                    //                    painter = painterResource(R.drawable.door_closed_solid),
                    modifier = Modifier.size(30.dp),
                    tint = Color.Gray,
                    contentDescription = ""

                )

                Spacer(Modifier.height(5.dp))

                Text(text = "Energia", fontSize = 12.sp)
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(R.drawable.repeat_solid),
                    //                    painter = painterResource(R.drawable.door_closed_solid),
                    modifier = Modifier.size(30.dp),
                    tint = Color.Gray,
                    contentDescription = ""

                )

                Text(text = "Comprar", fontSize = 12.sp)
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(R.drawable.chart_simple_solid),
                    //                    painter = painterResource(R.drawable.door_closed_solid),
                    modifier = Modifier.size(30.dp),
                    tint = Color.Gray,
                    contentDescription = ""

                )

                Text(text = "Relatórios", fontSize = 12.sp)
            }
        }


    }

}


@Preview(showBackground = true)
@Composable
fun ConfigScreenPreview() {
    TelaConfiguracoesTheme {
        ConfigScreen()
    }
}