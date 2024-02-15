package ru.syndicate.rediexpress.view_model.send_package_view_model

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import ru.syndicate.rediexpress.data.model.DeliveryType
import javax.inject.Inject

@HiltViewModel
class SendPackageViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences,
): ViewModel() {

    val addressOriginText = MutableStateFlow("")
    val stateCountryOriginText = MutableStateFlow("")
    val phoneNumberOriginText = MutableStateFlow("")
    val otherOriginText = MutableStateFlow("")

    val addressDestinationText = MutableStateFlow("")
    val stateCountryDestinationText = MutableStateFlow("")
    val phoneNumberDestinationText = MutableStateFlow("")
    val otherDestinationText = MutableStateFlow("")

    val itemsPackageText = MutableStateFlow("")
    val weightText = MutableStateFlow("")
    val worthText = MutableStateFlow("")

    val deliveryType = MutableStateFlow(DeliveryType.NONE)

    fun onEvent(event: SendPackageEvent) {
        when (event) {

            is SendPackageEvent.changeAddressDestination -> {
                addressDestinationText.update { event.newAddress }
            }

            is SendPackageEvent.changeAddressOrigin -> {
                addressOriginText.update { event.newAddress }
            }

            is SendPackageEvent.changeDeliveryType -> {
                deliveryType.update { event.newType }
            }

            is SendPackageEvent.changeItems -> {
                itemsPackageText.update { event.newItems }
            }

            is SendPackageEvent.changeOthersDestination -> {
                otherDestinationText.update { event.newOthers }
            }

            is SendPackageEvent.changeOthersOrigin -> {
                otherOriginText.update { event.newOthers }
            }

            is SendPackageEvent.changePhoneNumberDestination -> {
                phoneNumberDestinationText.update { event.newPhone }
            }

            is SendPackageEvent.changePhoneNumberOrigin -> {
                phoneNumberOriginText.update { event.newPhone }
            }

            is SendPackageEvent.changeStateCountryDestination -> {
                stateCountryDestinationText.update { event.stateCountry }
            }

            is SendPackageEvent.changeStateCountryOrigin -> {
                stateCountryOriginText.update { event.stateCountry }
            }

            is SendPackageEvent.changeWeight -> {
                weightText.update { event.newWeight }
            }

            is SendPackageEvent.changeWorth -> {
                worthText.update { event.newWorth }
            }
        }
    }
}