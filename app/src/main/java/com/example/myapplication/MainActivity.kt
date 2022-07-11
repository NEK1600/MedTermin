package com.example.myapplication

import android.app.ProgressDialog.show
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.model.ResponceN
import com.example.myapplication.data.remote.ApiServise
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewModel.MyViewModelFactory
import com.example.myapplication.viewModel.RepositoryTermin
import com.example.myapplication.viewModel.ViewModelTermin
import kotlinx.coroutines.*
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
     var desc=""
     var desc2=""
    private var list1 = mutableListOf<String>()
    lateinit var viewModel: ViewModelTermin
    private val retrofitService = ApiServise.create()

    //private val repositoryTermin = RepositoryTermin(retrofitService)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this, MyViewModelFactory(RepositoryTermin(retrofitService,this )))
            .get(ViewModelTermin::class.java)


        //inputText()

    }

    fun inputText():String{
        desc2 = binding.input.text.toString()
        return desc2
    }


    fun learnButton(view: View) {
        inputText()

        viewModel.mutableLiveData.observe(this, Observer {
            Log.d("test", "OnCreate " + it.get(0).def.get(0).sseq.get(0).get(0).get(1).toString())

            desc=it.get(0).def.get(0).sseq.get(0).get(0).get(1).toString()

            binding.textView.text = desc

        })

        viewModel.errorMessage.observe(this, Observer {
            //Log.d("test" ,"error " + it)
        })

        viewModel.getAllTermin()
    }


}




























