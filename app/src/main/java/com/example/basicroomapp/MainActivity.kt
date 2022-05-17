package com.example.basicroomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.basicroomapp.database.User

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //llamamos el metodo saveUser para ingresar un usuario
        mainViewModel.saveUser(User(
            "User0002",
            "Name0002",
            1.64,
            64.3,
            "pedro@gmail.com",
            "password0002"
        ))

        mainViewModel.getUsers()
        //manejo de errores
        mainViewModel.savedUsers.observe(this,{usersList ->
            if (!usersList.isNullOrEmpty()){
                for(user in usersList){
                    Log.d("user", user.user_email)
                }

            }else{
                Log.d("user", "null or empty")
            }
        })

    }
}