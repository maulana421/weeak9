package com.example.weaak9.model.realm

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class realmclass : RealmObject() {
    private var id : Int = 0
    private var nama : String? = null
    private var email : String? = null

    fun setId( id : Int){
        this.id = id
    }
    fun getId():Int {
        return id
    }
    fun setNama(nama : String){
        this.nama = nama
    }
    fun getNama():String?{
        return nama
    }
    fun setEmail (email : String){
        this.email = email
    }
    fun getEmail():String?{
        return email
    }
}