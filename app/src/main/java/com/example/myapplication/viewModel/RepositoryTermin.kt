package com.example.myapplication.viewModel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.myapplication.MainActivity
import com.example.myapplication.data.model.ResponceN
import com.example.myapplication.data.remote.ApiServise
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryTermin constructor(private val retrofitService: ApiServise,
private val mainActivity: MainActivity) {


    fun getAllTermin() = retrofitService.getTermin(mainActivity.inputText(),
        "7688f877-5af1-4c1d-9cab-4f36b65646e1")
}