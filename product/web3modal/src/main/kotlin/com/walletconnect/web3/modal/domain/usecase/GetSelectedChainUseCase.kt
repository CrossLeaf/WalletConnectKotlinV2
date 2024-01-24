package com.walletconnect.web3.modal.domain.usecase

import com.walletconnect.web3.modal.domain.SessionRepository
import kotlinx.coroutines.runBlocking

internal class GetSelectedChainUseCase(
    private val repository: SessionRepository
) {
    operator fun invoke() = runBlocking { repository.getSelectedChain() }
}