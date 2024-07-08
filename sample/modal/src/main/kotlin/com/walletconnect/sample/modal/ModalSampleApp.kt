package com.walletconnect.sample.modal

import android.app.Application
import com.google.firebase.appdistribution.FirebaseAppDistribution
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import com.walletconnect.android.Core
import com.walletconnect.android.CoreClient
import com.walletconnect.android.relay.ConnectionType
import com.walletconnect.sample.common.BuildConfig
import com.walletconnect.sample.common.tag
import com.walletconnect.web3.modal.client.Modal
import com.walletconnect.web3.modal.client.Web3Modal
import com.walletconnect.web3.modal.presets.Web3ModalChainsPresets
import timber.log.Timber

class ModalSampleApp : Application() {
    override fun onCreate() {
        super.onCreate()

        val appMetaData = Core.Model.AppMetaData(
            name = "Kotlin Modals",
            description = "Kotlin Modals Lab Sample",
            url = "https://web3modal.com/",
            icons = listOf("https://gblobscdn.gitbook.com/spaces%2F-LJJeCjcLrr53DcT1Ml7%2Favatar.png?alt=media"),
            redirect = "kotlin-modal-wc://request"
        )

        CoreClient.initialize(
            projectId = BuildConfig.PROJECT_ID,
            connectionType = ConnectionType.AUTOMATIC,
            application = this,
            metaData = appMetaData,
        ) {
            Timber.e(it.throwable)
        }

        Web3Modal.initialize(Modal.Params.Init(core = CoreClient)) { error ->
            Timber.e(tag(this), error.throwable.stackTraceToString())
            Firebase.crashlytics.recordException(error.throwable)
        }

        Web3Modal.setChains(Web3ModalChainsPresets.ethChains.values.toList())

        FirebaseAppDistribution.getInstance().updateIfNewReleaseAvailable()
    }
}
