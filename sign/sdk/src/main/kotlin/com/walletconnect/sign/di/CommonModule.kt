@file:JvmSynthetic

package com.walletconnect.sign.di

import com.squareup.moshi.Moshi
import com.tinder.scarlet.utils.getRawType
import com.walletconnect.android.internal.common.di.AndroidCommonDITags
import com.walletconnect.sign.common.adapters.SessionRequestVOJsonAdapter
import com.walletconnect.sign.common.model.vo.clientsync.session.payload.SessionRequestVO
import com.walletconnect.utils.addSdkBitsetForUA
import org.koin.core.qualifier.named
import org.koin.dsl.module
import java.util.*
import kotlin.reflect.jvm.jvmName

private const val BIT_ORDER = 0 // https://github.com/WalletConnect/walletconnect-docs/blob/main/docs/specs/clients/core/relay/relay-user-agent.md#schema
private val bitset: BitSet
    get() = BitSet().apply {
        set(BIT_ORDER)
    }

@JvmSynthetic
internal fun commonModule() = module {

    addSdkBitsetForUA(bitset)

    single {
        get<Moshi.Builder>(named(AndroidCommonDITags.MOSHI))
            .add { type, _, moshi ->
                when (type.getRawType().name) {
                    SessionRequestVO::class.jvmName -> SessionRequestVOJsonAdapter(moshi)
                    else -> null
                }
            }
    }
}