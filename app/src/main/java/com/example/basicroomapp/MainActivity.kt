package com.example.basicroomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.basicroomapp.database.MainViewModel
import com.example.basicroomapp.database.User

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.saveUser(
            User(
                user_id = "user0005",
                user_name = "Victoria5",
                user_height = 1.91,
                user_weight = 59.4,
                user_email = "vicky454ph@gmail.com22",
                user_pass = "passnumvictoria"
            )
        )

     mainViewModel.getUsers()

         //si es en un fragmen reemplazar el this por: viewLifecycleOwer
     mainViewModel.savedUsers.observe(this,  { usersList ->
         if (!usersList.isNullOrEmpty()){
             for(user in usersList){
                 Log.d("usuarios", user.user_name)}
         }else{
             Log.d("usuarios", "null or empty")
         }
     })

}
}




