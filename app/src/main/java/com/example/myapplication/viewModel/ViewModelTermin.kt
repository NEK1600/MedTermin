package com.example.myapplication.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.MainActivity
import com.example.myapplication.data.model.ResponceN
import com.example.myapplication.data.remote.ApiServise
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelTermin constructor(private val repository: RepositoryTermin): ViewModel() {

     val mutableLiveData = MutableLiveData<ResponceN>()
    //private lateinit var mainActivity: MainActivity
    val errorMessage = MutableLiveData<String>()

    fun getAllTermin() {
        val response = repository.getAllTermin()

        response.enqueue(object : Callback<ResponceN>{
            override fun onResponse(call: Call<ResponceN>?, response: Response<ResponceN>?) {
                mutableLiveData.postValue(response?.body())
                Log.d("test", "OnResponse  " + response?.body())
            }

            override fun onFailure(call: Call<ResponceN>?, t: Throwable?) {
                Log.d("test", "OnFailure " + t?.message)
                errorMessage.postValue(t?.message)
            }
        })

    }


}