package com.example.myapplication.data.remote
import com.example.myapplication.data.model.ResponceN
import com.example.myapplication.data.model.ResponceNItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiServise {

    @GET("doctor?key=7688f877-5af1-4c1d-9cab-4f36b65646e1")
    fun getTermin() : Call<List<ResponceNItem>>

    companion object {

        var BASE_URL = "https://www.dictionaryapi.com/api/v3/references/medical/json/"

        fun create() : ApiServise {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiServise::class.java)

        }
    }



}



















