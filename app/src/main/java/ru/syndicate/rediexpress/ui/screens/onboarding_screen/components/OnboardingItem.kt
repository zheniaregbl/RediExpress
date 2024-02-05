package ru.syndicate.rediexpress.ui.screens.onboarding_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.rediexpress.R
import ru.syndicate.rediexpress.data.model.OnboardingItemData
import ru.syndicate.rediexpress.ui.theme.MainBlue
import ru.syndicate.rediexpress.ui.theme.TextBlack

@Composable
fun OnboardingItem(
    modifier: Modifier = Modifier,
    data: OnboardingItemData = OnboardingItemData(
        title = "title",
        text = "text",
        image = R.drawable.svg_page1
    )
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier
                .height(346.dp),
            imageVector = ImageVector.vectorResource(id = data.image),
            contentDescription = null
        )

        Spacer(
            modifier = Modifier
                .height(58.dp)
        )

        Text(
            text = data.title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = MainBlue
        )

        Spacer(
            modifier = Modifier
                .height(12.dp)
        )

        Text(
            modifier = Modifier
                .padding(
                    horizontal = 60.dp
                ),
            text = data.text,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = TextBlack
        )
    }
}

@Preview
@Composable
fun PreviewOnboardingItem() {
    OnboardingItem(
        modifier = Modifier
            .fillMaxWidth(),
        data = OnboardingItemData(
            title = "title",
            text = "Enjoy quick pick-up and delivery to your destination",
            image = R.drawable.svg_page1
        )
    )
}