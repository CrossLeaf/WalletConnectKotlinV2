package com.walletconnect.web3.modal.ui.navigation

//Todo Think about split it into own graphs routes

enum class Route(val path: String, val title: String? = null) {
    //Common
    WEB3MODAL("web3_modal"),

    //Connect routes
    CONNECT_YOUR_WALLET("connect_your_wallet", "Connect Your Wallet"),
    QR_CODE("qr_code", "Mobile Wallets"),
    HELP("modal_help", "What is Wallet?"),
    GET_A_WALLET("get_a_wallet", "Get a Wallet"),
    ALL_WALLETS("all_wallets", "All wallets"),
    REDIRECT("redirect"),

    //Session routes
    ACCOUNT("account"),
    CHANGE_NETWORK("change_network", "Change Network"),
    RECENT_TRANSACTION("recent_transaction")
}
