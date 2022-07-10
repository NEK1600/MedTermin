package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.data.model.ResponceN
import com.example.myapplication.data.remote.ApiServise
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var desc=""
    private var list1 = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        CoroutineScope(Dispatchers.IO).launch {
            initConect()
        }

        binding.textView.text = desc
}


    fun initConect(){
            val apiInterface = ApiServise.create().getTermin(binding.input.text.toString(),
                "7688f877-5af1-4c1d-9cab-4f36b65646e1")

            apiInterface.enqueue( object : Callback<ResponceN> {
                override fun onResponse(call: Call<ResponceN>?, response: Response<ResponceN>?) {

                    desc=response?.body()?.get(0)?.def?.get(0)?.sseq?.get(0)?.get(0)?.get(1).toString()

/*
                    val strs = desc.split("").toTypedArray()
                    for (i in strs){
                        list1.add(i)
                    }
                    Log.d("test", "OnResponse " + list1)*/

                }

                override fun onFailure(call: Call<ResponceN>?, t: Throwable?) {
                    Log.d("test", "OnFailure " + t?.message)
                }
            })

    }

    fun learnButton(view: View) {
        CoroutineScope(Dispatchers.IO).launch {
            initConect()
        }

        binding.textView.text = desc
    }
}




























