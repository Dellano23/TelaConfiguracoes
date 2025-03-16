    package br.com.fiap.telaconfiguracoes.componentes

    import android.graphics.drawable.Icon
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.size
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
    import androidx.compose.material.icons.rounded.AccountCircle
    import androidx.compose.material3.Card
    import androidx.compose.material3.Icon
    import androidx.compose.material3.IconButton
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
    import androidx.compose.ui.res.colorResource
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import br.com.fiap.telaconfiguracoes.R

    @Composable
    fun cardConfiguracoes(iconId: Int, descricaoIcon: String, tempoUso: String) {
        var iconImage = painterResource(id = iconId)

        var porta by remember {
            mutableStateOf(false)
        }

        var estadoDispositivos by remember {
            mutableStateOf("Desligado")
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ) {

            Row(
                Modifier
                    .background(color = colorResource(R.color.card_color))
                    .fillMaxSize()
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Icon(
                        painter = iconImage,
    //                    painter = painterResource(R.drawable.door_closed_solid),
                        contentDescription = descricaoIcon,
                        modifier = Modifier.size(40.dp),
                        colorResource(R.color.white)
                    )

                    Spacer(Modifier.height(5.dp))

                    Text(
                        text = descricaoIcon,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = estadoDispositivos,
                        color = Color.White,
                        fontSize = 12.sp,
                        lineHeight = 2.sp
                    )
                }
                Column(Modifier.padding(bottom = 10.dp)) {
                    Switch(
                        checked = porta,
                        onCheckedChange = {isChecked ->
                            porta = isChecked
                            estadoDispositivos = if (isChecked) "Ligado" else "Desligado"
                        },
                        Modifier
                            .clip(RectangleShape),
                        colors = SwitchDefaults.colors(
                            uncheckedTrackColor = Color.Gray, // Cor do fundo quando está DESLIGADO
                            checkedTrackColor = colorResource(R.color.switch_button),  // Cor do fundo quando está LIGADO
                            uncheckedThumbColor = Color.White, // Cor do botão deslizante quando está DESLIGADO
                            checkedThumbColor = Color.White,   // Cor do botão deslizante quando está LIGADO
                            uncheckedBorderColor = Color.White,   // Borda
                            checkedBorderColor = Color.White
                        ),

                        )
                    Text(
                        text = tempoUso,
                        color = Color.White,
                        fontSize = 14.sp,
                        lineHeight = 1.sp
                    )
                }
            }

        }

        Spacer(Modifier.height(20.dp))

    }