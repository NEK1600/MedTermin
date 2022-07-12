package com.example.myapplication.viewModel

    import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
    import androidx.lifecycle.viewModelScope
    import com.example.myapplication.MainActivity
import com.example.myapplication.data.model.ResponceN
import com.example.myapplication.data.remote.ApiServise
    import kotlinx.coroutines.*
    import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelTermin constructor(private val repository: RepositoryTermin): ViewModel() {

     val mutableLiveData = MutableLiveData<ResponceN>()
    val errorMessage = MutableLiveData<String>()

    //var job: Job? = null

   /*fun getAllTermin2() {
        job = CoroutineScope(Dispatchers.IO ).launch{
            val responce = repository.getAllTermin()
            withContext(Dispatchers.Main) {
                mutableLiveData.postValue(responce.body())
                Log.d("test", "coroutines" + responce.body().toString())
            }
        }

    }*/
    fun getAllTermin2()= viewModelScope.launch(Dispatchers.IO) {
       val responce = repository.getAllTermin()
       mutableLiveData.postValue(responce.body())
       Log.d("test", "coroutines" + responce.body().toString())
   }


}