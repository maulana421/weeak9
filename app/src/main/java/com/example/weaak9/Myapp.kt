package com.example.weaak9.model

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class Myapp : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder().name("myrealm.realm").build()
        Realm.setDefaultConfiguration(config)
    }
}