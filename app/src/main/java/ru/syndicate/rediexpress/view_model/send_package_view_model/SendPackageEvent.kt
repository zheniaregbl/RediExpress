package ru.syndicate.rediexpress.view_model.send_package_view_model

import ru.syndicate.rediexpress.data.model.DeliveryType

sealed interface SendPackageEvent {

    data class changeAddressOrigin(
        val newAddress: String
    ): SendPackageEvent

    data class changeAddressDestination(
        val newAddress: String
    ): SendPackageEvent

    data class changeStateCountryOrigin(
        val stateCountry: String
    ): SendPackageEvent

    data class changeStateCountryDestination(
        val stateCountry: String
    ): SendPackageEvent

    data class changePhoneNumberOrigin(
        val newPhone: String
    ): SendPackageEvent

    data class changePhoneNumberDestination(
        val newPhone: String
    ): SendPackageEvent

    data class changeOthersOrigin(
        val newOthers: String
    ): SendPackageEvent

    data class changeOthersDestination(
        val newOthers: String
    ): SendPackageEvent

    data class changeItems(
        val newItems: String
    ): SendPackageEvent

    data class changeWeight(
        val newWeight: String
    ): SendPackageEvent

    data class changeWorth(
        val newWorth: String
    ): SendPackageEvent

    data class changeDeliveryType(
        val newType: DeliveryType
    ): SendPackageEvent
}