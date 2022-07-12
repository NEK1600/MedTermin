package com.example.myapplication.data.remote
import com.example.myapplication.data.model.ResponceN
import com.example.myapplication.data.model.ResponceNItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServise {

    @GET("api/v3/references/medical/json/{test}?key=")
    suspend fun getTermin(
        @Path("test") test:String,
        @Query("key") key:String
    ) : Response <ResponceN>    //ResponceN //List<ResponceN>

//https://dictionaryapi.com/api/v3/references/medical/json/test?key=7688f877-5af1-4c1d-9cab-4f36b65646e1

    companion object {

        var BASE_URL = "https://www.dictionaryapi.com/"

        fun create() : ApiServise {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiServise::class.java)

        }
    }



}



















