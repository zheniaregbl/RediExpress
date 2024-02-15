package ru.syndicate.rediexpress.ui.screens.send_package_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import ru.syndicate.rediexpress.R
import ru.syndicate.rediexpress.data.model.DeliveryType
import ru.syndicate.rediexpress.extensions.advancedShadow
import ru.syndicate.rediexpress.ui.screens.send_package_screen.components.PackageTextField
import ru.syndicate.rediexpress.ui.theme.CustomGray
import ru.syndicate.rediexpress.ui.theme.MainBlue
import ru.syndicate.rediexpress.ui.theme.TextBlack

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun SendPackageScreen(
    modifier: Modifier = Modifier,
    addressOriginText: String = "",
    stateCountryOriginText: String = "",
    phoneNumberOriginText: String = "",
    otherOriginText: String = "",
    addressDestinationText: String = "",
    stateCountryDestinationText: String = "",
    phoneNumberDestinationText: String = "",
    otherDestinationText: String = "",
    itemsPackageText: String = "",
    weightText: String = "",
    worthText: String = "",
    deliveryType: DeliveryType = DeliveryType.NONE,
    changeAddressOrigin: (String) -> Unit = { },
    changeAddressDestination: (String) -> Unit = { },
    changeStateCountryOrigin: (String) -> Unit = { },
    changeStateCountryDestination: (String) -> Unit = { },
    changePhoneNumberOrigin: (String) -> Unit = { },
    changePhoneNumberDestination: (String) -> Unit = { },
    changeOthersOrigin: (String) -> Unit = { },
    changeOthersDestination: (String) -> Unit = { },
    changeItems: (String) -> Unit = { },
    changeWeight: (String) -> Unit = { },
    changeWorth: (String) -> Unit = { },
    changeDeliveryType: (DeliveryType) -> Unit = { },
    onClickBack: () -> Unit = { },
    onClickNext: () -> Unit = { }
) {

    Column(
        modifier = modifier
    ) {

        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            color = Color.White,
            shadowElevation = 12.dp
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 25.dp,
                        vertical = 18.dp
                    )
            ) {

                Icon(
                    modifier = Modifier
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null
                        ) { onClickBack() }
                        .size(24.dp)
                        .rotate(180f),
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_arrow_square),
                    contentDescription = null,
                    tint = MainBlue
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = "Send a package",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = CustomGray
                )

                if (deliveryType != DeliveryType.NONE) {

                    Icon(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .clickable(
                                interactionSource = MutableInteractionSource(),
                                indication = null
                            ) { onClickNext() }
                            .size(24.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.svg_arrow_square),
                        contentDescription = null,
                        tint = MainBlue
                    )
                }
            }
        }

        LazyColumn(
            modifier = Modifier
                .imePadding()
                .fillMaxSize()
                .weight(1f)
                .padding(
                    horizontal = 24.dp
                )
        ) {

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 40.dp
                        ),
                    verticalArrangement = Arrangement.spacedBy(7.dp)
                ) {

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.svg_origin_details),
                            contentDescription = null,
                            tint = MainBlue
                        )

                        Text(
                            text = "Origin Details",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            color = TextBlack
                        )
                    }

                    PackageTextField(
                        modifier = Modifier
                            .advancedShadow(
                                color = Color.Black,
                                alpha = 0.3f,
                                shadowBlurRadius = 8.dp,
                                offsetY = 6.dp
                            )
                            .fillMaxWidth(),
                        value = addressOriginText,
                        onValueChange = {
                            changeAddressOrigin(it)
                        },
                        hintText = "Address"
                    )

                    PackageTextField(
                        modifier = Modifier
                            .advancedShadow(
                                color = Color.Black,
                                alpha = 0.3f,
                                shadowBlurRadius = 8.dp,
                                offsetY = 6.dp
                            )
                            .fillMaxWidth(),
                        value = stateCountryOriginText,
                        onValueChange = {
                            changeStateCountryOrigin(it)
                        },
                        hintText = "State, country"
                    )

                    PackageTextField(
                        modifier = Modifier
                            .advancedShadow(
                                color = Color.Black,
                                alpha = 0.3f,
                                shadowBlurRadius = 8.dp,
                                offsetY = 6.dp
                            )
                            .fillMaxWidth(),
                        value = phoneNumberOriginText,
                        onValueChange = {
                            if (it.isDigitsOnly() && it.length <= 11)
                                changePhoneNumberOrigin(it)
                        },
                        hintText = "Phone number",
                        isPhone = true
                    )

                    PackageTextField(
                        modifier = Modifier
                            .advancedShadow(
                                color = Color.Black,
                                alpha = 0.3f,
                                shadowBlurRadius = 8.dp,
                                offsetY = 6.dp
                            )
                            .fillMaxWidth(),
                        value = otherOriginText,
                        onValueChange = {
                            changeOthersOrigin(it)
                        },
                        hintText = "Others"
                    )
                }
            }

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 40.dp
                        ),
                    verticalArrangement = Arrangement.spacedBy(7.dp)
                ) {

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.svg_destination_details),
                            contentDescription = null,
                            tint = MainBlue
                        )

                        Text(
                            text = "Destination Details",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            color = TextBlack
                        )
                    }

                    PackageTextField(
                        modifier = Modifier
                            .advancedShadow(
                                color = Color.Black,
                                alpha = 0.3f,
                                shadowBlurRadius = 8.dp,
                                offsetY = 6.dp
                            )
                            .fillMaxWidth(),
                        value = addressDestinationText,
                        onValueChange = {
                            changeAddressDestination(it)
                        },
                        hintText = "Address"
                    )

                    PackageTextField(
                        modifier = Modifier
                            .advancedShadow(
                                color = Color.Black,
                                alpha = 0.3f,
                                shadowBlurRadius = 8.dp,
                                offsetY = 6.dp
                            )
                            .fillMaxWidth(),
                        value = stateCountryDestinationText,
                        onValueChange = {
                            changeStateCountryDestination(it)
                        },
                        hintText = "State, country"
                    )

                    PackageTextField(
                        modifier = Modifier
                            .advancedShadow(
                                color = Color.Black,
                                alpha = 0.3f,
                                shadowBlurRadius = 8.dp,
                                offsetY = 6.dp
                            )
                            .fillMaxWidth(),
                        value = phoneNumberDestinationText,
                        onValueChange = {
                            if (it.isDigitsOnly() && it.length <= 11)
                                changePhoneNumberDestination(it)
                        },
                        hintText = "Phone number",
                        isPhone = true
                    )

                    PackageTextField(
                        modifier = Modifier
                            .advancedShadow(
                                color = Color.Black,
                                alpha = 0.3f,
                                shadowBlurRadius = 8.dp,
                                offsetY = 6.dp
                            )
                            .fillMaxWidth(),
                        value = otherDestinationText,
                        onValueChange = {
                            changeOthersDestination(it)
                        },
                        hintText = "Others"
                    )
                }
            }

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 40.dp
                        ),
                    verticalArrangement = Arrangement.spacedBy(7.dp)
                ) {

                    Text(
                        text = "Package Details",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = TextBlack
                    )

                    PackageTextField(
                        modifier = Modifier
                            .advancedShadow(
                                color = Color.Black,
                                alpha = 0.3f,
                                shadowBlurRadius = 8.dp,
                                offsetY = 6.dp
                            )
                            .fillMaxWidth(),
                        value = itemsPackageText,
                        onValueChange = {
                            changeItems(it)
                        },
                        hintText = "Package items"
                    )

                    PackageTextField(
                        modifier = Modifier
                            .advancedShadow(
                                color = Color.Black,
                                alpha = 0.3f,
                                shadowBlurRadius = 8.dp,
                                offsetY = 6.dp
                            )
                            .fillMaxWidth(),
                        value = weightText,
                        onValueChange = {
                            if (it.isDigitsOnly() && it.length <= 4)
                                changeWeight(it)
                        },
                        hintText = "Weight of items (kg)",
                        isNumbers = true
                    )

                    PackageTextField(
                        modifier = Modifier
                            .advancedShadow(
                                color = Color.Black,
                                alpha = 0.3f,
                                shadowBlurRadius = 8.dp,
                                offsetY = 6.dp
                            )
                            .fillMaxWidth(),
                        value = worthText,
                        onValueChange = {
                            changeWorth(it)
                        },
                        hintText = "Worth of items",
                        isNumbers = true
                    )
                }
            }

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 40.dp
                        ),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    Text(
                        text = "Select delivery type",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = TextBlack
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(24.dp)
                    ) {

                        Column(
                            modifier = Modifier
                                .advancedShadow(
                                    color = if (deliveryType == DeliveryType.INSTANT) MainBlue
                                    else Color.Black,
                                    alpha = 0.3f,
                                    cornersRadius = 8.dp,
                                    shadowBlurRadius = 8.dp,
                                    offsetY = 6.dp
                                )
                                .clip(RoundedCornerShape(8.dp))
                                .weight(1f)
                                .fillMaxWidth()
                                .clickable {
                                    changeDeliveryType(DeliveryType.INSTANT)
                                }
                                .background(
                                    color = if (deliveryType == DeliveryType.INSTANT) MainBlue
                                    else Color.White
                                )
                                .padding(
                                    vertical = 12.dp
                                ),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {

                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.svg_clock),
                                contentDescription = null,
                                tint = if (deliveryType == DeliveryType.INSTANT) Color.White
                                else CustomGray
                            )

                            Text(
                                text = "Instant delivery",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                color = if (deliveryType == DeliveryType.INSTANT) Color.White
                                else CustomGray
                            )
                        }

                        Column(
                            modifier = Modifier
                                .advancedShadow(
                                    color = if (deliveryType == DeliveryType.SCHEDULED) MainBlue
                                    else Color.Black,
                                    alpha = 0.3f,
                                    cornersRadius = 8.dp,
                                    shadowBlurRadius = 8.dp,
                                    offsetY = 6.dp
                                )
                                .clip(RoundedCornerShape(8.dp))
                                .weight(1f)
                                .fillMaxWidth()
                                .clickable {
                                    changeDeliveryType(DeliveryType.SCHEDULED)
                                }
                                .background(
                                    color = if (deliveryType == DeliveryType.SCHEDULED) MainBlue
                                    else Color.White
                                )
                                .padding(
                                    vertical = 12.dp
                                ),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {

                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.svg_calendar),
                                contentDescription = null,
                                tint = if (deliveryType == DeliveryType.SCHEDULED) Color.White
                                else CustomGray
                            )

                            Text(
                                text = "Scheduled delivery",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                color = if (deliveryType == DeliveryType.SCHEDULED) Color.White
                                else CustomGray
                            )
                        }
                    }
                }
            }

            item {
                Spacer(
                    modifier = Modifier
                        .height(14.dp)
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
fun PreviewSendPackageScreen() {
    SendPackageScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}