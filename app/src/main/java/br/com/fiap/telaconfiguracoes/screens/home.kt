package br.com.fiap.telaconfiguracoes.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.telaconfiguracoes.R

@Composable
fun EnergySavingsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        HeaderSection()

        Spacer(modifier = Modifier.height(16.dp))

        // Energy Savings Display
        Text(
            text = "Parabéns!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Text(
            text = "Você já economizou um total de:",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Circular Progress Indicator Simulation
        EnergySavingsIndicator(value = 850)

        Spacer(modifier = Modifier.height(16.dp))

        // Report Section
        ReportSection()

        Spacer(modifier = Modifier.weight(1f))

        // Bottom Navigation

        Row(
            Modifier
                .fillMaxWidth()
                .height(90.dp)
                .background(
                    colorResource(R.color.backgroud_cinza),
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                )
                .align(Alignment.End),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(R.drawable.gear_solid),
                    //                    painter = painterResource(R.drawable.door_closed_solid),
                    modifier = Modifier.size(30.dp).clickable(onClick = { navController.navigate("configuracoes") }),
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

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "22 de novembro de 2024",
                fontSize = 12.sp,
                color = Color.Gray
            )
            Text(
                text = "Bem-vindo, Lucas!",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

@Composable
fun EnergySavingsIndicator(value: Int) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(150.dp)
    ) {
        CircularProgressIndicator(
            progress = 0.85f, // Simulando 85% do progresso
            color = Color(0xFF4CAF50),
            modifier = Modifier.fillMaxSize(),
            strokeWidth = 8.dp
        )
        Text(
            text = "${value}kWh",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ReportSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ReportCard(title = "Energia gerada/Dia", value = "20.1kWh")
        ReportCard(title = "Consumo Atual", value = "1.3kWh")
        ReportCard(title = "Gasto Atual", value = "R$ 1,66")
    }
}

@Composable
fun ReportCard(title: String, value: String) {
    Column(
        modifier = Modifier
            .background(Color(0xFF00695C), shape = MaterialTheme.shapes.medium)
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, color = Color.White, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = value, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

//@Composable
//fun BottomNavigationBar() {
//    NavigationBar {
//        NavigationBarItem(
//            selected = false,
//            onClick = { },
//            icon = { Icon(Icons.Default.Settings, contentDescription = "Configurações") },
//            label = { Text("Configurações") }
//        )
//        NavigationBarItem(
//            selected = false,
//            onClick = { },
//            icon = { Icon(Icons.Default.Flag, contentDescription = "Metas") },
//            label = { Text("Metas") }
//        )
//        NavigationBarItem(
//            selected = true,
//            onClick = { },
//            icon = { Icon(Icons.Default.EnergySavingsLeaf, contentDescription = "Economizado") },
//            label = { Text("Economizado") }
//        )
//        NavigationBarItem(
//            selected = false,
//            onClick = { },
//            icon = { Icon(Icons.Default.CompareArrows, contentDescription = "Comparar") },
//            label = { Text("Comparar") }
//        )
//        NavigationBarItem(
//            selected = false,
//            onClick = { },
//            icon = { Icon(Icons.Default.BarChart, contentDescription = "Relatórios") },
//            label = { Text("Relatórios") }
//        )
//    }
//}

//@Preview
//@Composable
//private fun homeScreenPreview() {
//    EnergySavingsScreen()
//
//}