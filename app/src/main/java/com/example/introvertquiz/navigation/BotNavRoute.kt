package com.example.introvertquiz.navigation

import com.example.introvertquiz.R

sealed class BotNavRoute(val title:String,val route:String, val icon:Int = 0) {
    object Dashboard:BotNavRoute("Dashboard","dashboard", R.drawable.dashboard_icon)
    object Calendar:BotNavRoute("Kalender","calendar",R.drawable.calendar_icon)
    object Notification:BotNavRoute("Notifikasi","notification",R.drawable.notification_icon)
    object Value:BotNavRoute("Nilai","value",R.drawable.value_icon)
    object Account:BotNavRoute("Akun","account",R.drawable.account_icon)
}
