package ru.syndicate.rediexpress.ui.screens.onboarding_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import ru.syndicate.rediexpress.R
import ru.syndicate.rediexpress.data.model.OnboardingItemData
import ru.syndicate.rediexpress.ui.screens.onboarding_screen.components.OnboardingItem
import ru.syndicate.rediexpress.ui.screens.onboarding_screen.components.PageIndicator
import ru.syndicate.rediexpress.ui.theme.CustomGray
import ru.syndicate.rediexpress.ui.theme.MainBlue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier
) {

    val scope = rememberCoroutineScope()

    val listOnboardingItems = listOf(
        OnboardingItemData(
            title = "Quick pick-up",
            text = "Enjoy quick pick-up and delivery to your destination",
            image = R.drawable.svg_page1
        ),
        OnboardingItemData(
            title = "Flexible Payment",
            text = "Our service has a convenient and flexible payment system",
            image = R.drawable.svg_page2
        ),
        OnboardingItemData(
            title = "Real-time Tracking",
            text = "There is an opportunity to track your orders in real time",
            image = R.drawable.svg_page3
        )
    )

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { listOnboardingItems.size }
    )

    Box(
        modifier = modifier
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(
                modifier = Modifier
                    .height(56.dp)
            )

            HorizontalPager(
                state = pagerState
            ) { page->

                OnboardingItem(
                    modifier = Modifier
                        .fillMaxWidth(),
                    data = listOnboardingItems[page]
                )
            }

            Spacer(
                modifier = Modifier
                    .height(42.dp)
            )

            PageIndicator(
                page = pagerState.currentPage
            )

            Spacer(
                modifier = Modifier
                    .height(82.dp)
            )

            if (pagerState.currentPage != listOnboardingItems.lastIndex) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 24.dp
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .border(
                                width = 1.dp,
                                color = MainBlue,
                                shape = RoundedCornerShape(4.dp)
                            )
                            .clickable {

                                if (pagerState.currentPage != listOnboardingItems.lastIndex) {

                                    scope.launch {
                                        pagerState.animateScrollToPage(
                                            listOnboardingItems.lastIndex
                                        )
                                    }
                                }
                            }
                            .padding(
                                horizontal = 18.dp,
                                vertical = 9.dp
                            ),
                        text = "Skip",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = MainBlue
                    )

                    Text(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(
                                color = MainBlue
                            )
                            .clickable {

                                if (pagerState.currentPage != listOnboardingItems.lastIndex) {

                                    scope.launch {
                                        pagerState.animateScrollToPage(
                                            pagerState.currentPage + 1
                                        )
                                    }
                                }
                            }
                            .padding(
                                horizontal = 18.dp,
                                vertical = 9.dp
                            ),
                        text = "Next",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }

            } else {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 24.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(4.dp))
                            .background(
                                color = MainBlue
                            )
                            .clickable {

                            }
                            .padding(
                                vertical = 15.dp
                            ),
                        text = "Sign Up",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )

                    Spacer(
                        modifier = Modifier
                            .height(8.dp)
                    )

                    Row(
                        modifier = Modifier
                    ) {

                        Text(
                            text = "Already have an account?",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = CustomGray
                        )

                        Spacer(
                            modifier = Modifier
                                .width(2.dp)
                        )

                        ClickableText(
                            text = AnnotatedString(
                                text = "Sign in"
                            ),
                            onClick = {

                            },
                            style = TextStyle(
                                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                color = MainBlue
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewOnboardingScreen() {
    OnboardingScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}