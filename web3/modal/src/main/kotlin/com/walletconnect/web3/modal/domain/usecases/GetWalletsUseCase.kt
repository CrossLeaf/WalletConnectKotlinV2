package com.walletconnect.web3.modal.domain.usecases

import com.walletconnect.web3.modal.data.explorer.ExplorerRepository
import com.walletconnect.web3.modal.domain.model.Wallet
import com.walletconnect.web3.modal.domain.model.toWallet
internal interface GetWalletsUseCase {
    suspend operator fun invoke(
        chains: List<String>
    ): List<Wallet>
}

private const val RECOMMENDED_WALLET_AMOUNT = 9

internal class GetWalletsUseCaseImpl(
    private val explorerRepository: ExplorerRepository
) : GetWalletsUseCase {
    override suspend fun invoke(
        chains: List<String>
    ): List<Wallet> {
        return explorerRepository.getWalletsList(
            page = 1,
            entries = RECOMMENDED_WALLET_AMOUNT,
            chains = chains
        )?.wallets?.map { it.toWallet() } ?: listOf()
    }
}
