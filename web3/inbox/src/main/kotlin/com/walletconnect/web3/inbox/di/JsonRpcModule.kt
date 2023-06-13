@file:JvmSynthetic

package com.walletconnect.web3.inbox.di

import com.walletconnect.utils.addDeserializerEntry
import com.walletconnect.utils.addSerializerEntry
import com.walletconnect.web3.inbox.json_rpc.Web3InboxMethods
import com.walletconnect.web3.inbox.json_rpc.Web3InboxRPC
import org.koin.dsl.module


//todo split into multiple files
@JvmSynthetic
internal fun jsonRpcModule() = module {
    // chat serializer requests 👇
    addSerializerEntry(Web3InboxRPC.Request.Chat.Register::class)
    addSerializerEntry(Web3InboxRPC.Request.Chat.GetReceivedInvites::class)
    addSerializerEntry(Web3InboxRPC.Request.Chat.GetSentInvites::class)
    addSerializerEntry(Web3InboxRPC.Request.Chat.GetThreads::class)
    addSerializerEntry(Web3InboxRPC.Request.Chat.GetMessages::class)
    addSerializerEntry(Web3InboxRPC.Request.Chat.Resolve::class)
    addSerializerEntry(Web3InboxRPC.Request.Chat.Accept::class)
    addSerializerEntry(Web3InboxRPC.Request.Chat.Reject::class)
    addSerializerEntry(Web3InboxRPC.Request.Chat.Message::class)
    addSerializerEntry(Web3InboxRPC.Request.Chat.Invite::class)
    // chat serializer requests 👆

    // push serializer requests 👇
    addSerializerEntry(Web3InboxRPC.Request.Push.GetActiveSubscriptions::class)
    addSerializerEntry(Web3InboxRPC.Request.Push.Approve::class)
    addSerializerEntry(Web3InboxRPC.Request.Push.Reject::class)
    addSerializerEntry(Web3InboxRPC.Request.Push.Subscribe::class)
    addSerializerEntry(Web3InboxRPC.Request.Push.Update::class)
    addSerializerEntry(Web3InboxRPC.Request.Push.DeleteSubscription::class)
    addSerializerEntry(Web3InboxRPC.Request.Push.GetMessageHistory::class)
    addSerializerEntry(Web3InboxRPC.Request.Push.DeletePushMessage::class)
    // push serializer requests 👆

    // chat serializer events 👇
    addSerializerEntry(Web3InboxRPC.Call.Chat.Invite::class)
    addSerializerEntry(Web3InboxRPC.Call.Chat.Message::class)
    addSerializerEntry(Web3InboxRPC.Call.Chat.InviteAccepted::class)
    addSerializerEntry(Web3InboxRPC.Call.Chat.InviteRejected::class)
    addSerializerEntry(Web3InboxRPC.Call.Chat.Leave::class)
    // chat serializer events 👆
    addSerializerEntry(Web3InboxRPC.Call.SyncUpdate::class)
    // push serializer events 👇
    addSerializerEntry(Web3InboxRPC.Call.Push.Request::class)
    addSerializerEntry(Web3InboxRPC.Call.Push.Message::class)
    addSerializerEntry(Web3InboxRPC.Call.Push.Subscription::class)
    addSerializerEntry(Web3InboxRPC.Call.Push.Update::class)
    addSerializerEntry(Web3InboxRPC.Call.Push.Delete::class)
    // push serializer events 👆

    // chat deserializer requests 👇
    addDeserializerEntry(Web3InboxMethods.Request.REGISTER, Web3InboxRPC.Request.Chat.Register::class)
    addDeserializerEntry(Web3InboxMethods.Request.GET_RECEIVED_INVITES, Web3InboxRPC.Request.Chat.GetReceivedInvites::class)
    addDeserializerEntry(Web3InboxMethods.Request.GET_SENT_INVITES, Web3InboxRPC.Request.Chat.GetSentInvites::class)
    addDeserializerEntry(Web3InboxMethods.Request.GET_THREADS, Web3InboxRPC.Request.Chat.GetThreads::class)
    addDeserializerEntry(Web3InboxMethods.Request.GET_MESSAGES, Web3InboxRPC.Request.Chat.GetMessages::class)
    addDeserializerEntry(Web3InboxMethods.Request.RESOLVE, Web3InboxRPC.Request.Chat.Resolve::class)
    addDeserializerEntry(Web3InboxMethods.Request.ACCEPT, Web3InboxRPC.Request.Chat.Accept::class)
    addDeserializerEntry(Web3InboxMethods.Request.REJECT, Web3InboxRPC.Request.Chat.Reject::class)
    addDeserializerEntry(Web3InboxMethods.Request.MESSAGE, Web3InboxRPC.Request.Chat.Message::class)
    addDeserializerEntry(Web3InboxMethods.Request.INVITE, Web3InboxRPC.Request.Chat.Invite::class)
    // chat deserializer requests 👆

    // push deserializer requests 👆
    addDeserializerEntry(Web3InboxMethods.Request.Push.GET_ACTIVE_SUBSCRIPTIONS, Web3InboxRPC.Request.Push.GetActiveSubscriptions::class)
    addDeserializerEntry(Web3InboxMethods.Request.Push.APPROVE, Web3InboxRPC.Request.Push.Approve::class)
    addDeserializerEntry(Web3InboxMethods.Request.Push.REJECT, Web3InboxRPC.Request.Push.Reject::class)
    addDeserializerEntry(Web3InboxMethods.Request.Push.SUBSCRIBE, Web3InboxRPC.Request.Push.Subscribe::class)
    addDeserializerEntry(Web3InboxMethods.Request.Push.UPDATE, Web3InboxRPC.Request.Push.Update::class)
    addDeserializerEntry(Web3InboxMethods.Request.Push.DELETE_SUBSCRIPTION, Web3InboxRPC.Request.Push.DeleteSubscription::class)
    addDeserializerEntry(Web3InboxMethods.Request.Push.GET_MESSAGE_HISTORY, Web3InboxRPC.Request.Push.GetMessageHistory::class)
    addDeserializerEntry(Web3InboxMethods.Request.Push.DELETE_PUSH_MESSAGE, Web3InboxRPC.Request.Push.DeletePushMessage::class)
    // push deserializer requests 👆

    // chat deserializer events 👇
    addDeserializerEntry(Web3InboxMethods.Call.Chat.INVITE, Web3InboxRPC.Call.Chat.Invite::class)
    addDeserializerEntry(Web3InboxMethods.Call.Chat.MESSAGE, Web3InboxRPC.Call.Chat.Message::class)
    addDeserializerEntry(Web3InboxMethods.Call.Chat.INVITE_ACCEPTED, Web3InboxRPC.Call.Chat.InviteAccepted::class)
    addDeserializerEntry(Web3InboxMethods.Call.Chat.INVITE_REJECTED, Web3InboxRPC.Call.Chat.InviteRejected::class)
    addDeserializerEntry(Web3InboxMethods.Call.Chat.LEAVE, Web3InboxRPC.Call.Chat.Leave::class)
    // chat deserializer events 👆
    addDeserializerEntry(Web3InboxMethods.Call.SYNC_UPDATE, Web3InboxRPC.Call.SyncUpdate::class)
    // push deserializer events 👇
    addDeserializerEntry(Web3InboxMethods.Call.Push.REQUEST, Web3InboxRPC.Call.Push.Request::class)
    addDeserializerEntry(Web3InboxMethods.Call.Push.MESSAGE, Web3InboxRPC.Call.Push.Message::class)
    addDeserializerEntry(Web3InboxMethods.Call.Push.SUBSCRIPTION, Web3InboxRPC.Call.Push.Subscription::class)
    addDeserializerEntry(Web3InboxMethods.Call.Push.UPDATE, Web3InboxRPC.Call.Push.Update::class)
    addDeserializerEntry(Web3InboxMethods.Call.Push.DELETE, Web3InboxRPC.Call.Push.Delete::class)
    // push deserializer events 👆

}