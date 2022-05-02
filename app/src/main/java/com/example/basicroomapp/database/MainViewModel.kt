package com.example.basicroomapp.database

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    fun saveUser(user: User){
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            MyCoroutines(userDao).save(user)
            Log.d("usuarios ", "se guardo con exito")
        }
    }
    fun deleteUser(user: User) {
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            MyCoroutines(userDao).delete(user)
        }

    }
        val savedUsers = MutableLiveData<List<User>>()

        fun getUsers(){
                viewModelScope.launch {
                    val userDao = DatabaseManager.instance.database.userDao()
                    savedUsers.value = MyCoroutines(userDao).getUsers().value
                    Log.d("usuarios ", "se recupero con exito")
                }
            }



}
