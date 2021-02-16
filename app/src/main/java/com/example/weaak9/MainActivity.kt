package com.example.weaak9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weaak9.Adapter.UserAdapter
import com.example.weaak9.model.realm.realmclass
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var realm: Realm
    lateinit var useradapter : UserAdapter
    var ln = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addData()
        initView()
        getAlluser()
    }
    fun addData(){
        button2.setOnClickListener {
            realm.beginTransaction()
            var count  = 0
            realm.where(realmclass::class.java).findAll().let {
                for (i in it){
                    count ++
                }
            }
            var user = realm.createObject(realmclass::class.java)
            user.setId(count+1)
            user.setNama(et.text.toString())
            user.setEmail(et2.text.toString())
            getAlluser()
            // tv3.text = user.getId().toString()+"\n"+user.getNama()+"\n"+user.getEmail()
            ett.setText("")
            et.setText("")
            et2.setText("")
            realm.commitTransaction()
        }
        button3.setOnClickListener {
            realm.beginTransaction()
            realm.where(realmclass::class.java).equalTo("id",ett.text.toString().toInt()).findFirst().let {
                it!!.setNama(et.text.toString())
                it!!.setEmail(et2.text.toString())
            }
            realm.commitTransaction()
        }
        button4.setOnClickListener {
            realm.beginTransaction()
            realm.where(realmclass::class.java).equalTo("id",ett.text.toString().toInt()).findFirst().let {
                it!!.deleteFromRealm()
                getAlluser()

            }
            realm.commitTransaction()
        }

    }

    fun initView(){
        rcy.layoutManager = ln
        useradapter = UserAdapter(this)
        rcy.adapter = useradapter
        realm = Realm.getDefaultInstance()
        getAlluser()


    }
    fun getAlluser(){
        realm.where(realmclass::class.java).findAll().let {
            useradapter.setUser(it)
        }
    }
}