package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.myapplication.data.model.ResponceN
import com.example.myapplication.data.model.ResponceNItem
import com.example.myapplication.data.remote.ApiServise
import com.example.myapplication.data.remote.Termin
import com.example.myapplication.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var desc=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initConect()


}


    fun initConect(){
            val apiInterface = ApiServise.create().getTermin()

            apiInterface.enqueue( object : Callback<List<ResponceNItem>> {
                override fun onResponse(call: Call<List<ResponceNItem>>?, response: Response<List<ResponceNItem>>?) {

                    //Log.d("test", "OnResponse "+ response?.body()?.get(0)?.results?.get(0)?.meta)
                    desc=response?.body()?.get(0)?.def.toString()
                    Log.d("test", "OnResponse "+ response?.body()?.get(0)?.def)

                }

                override fun onFailure(call: Call<List<ResponceNItem>>?, t: Throwable?) {
                    Log.d("test", "OnFailure")
                }
            })

    }

    fun learnButton(view: View) {
        initConect()
        binding.textView.text = desc
    }
}




























