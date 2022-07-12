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

    val loading = MutableLiveData<Boolean>()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler {_, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    fun getAllTermin2() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch{
            loading.postValue(true)
            val responce = repository.getAllTermin()
            withContext(Dispatchers.Main) {
                mutableLiveData.postValue(responce.body())
                Log.d("test", "coroutines" + responce.body().toString())
            }
        }


    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}
/*responce.enqueue(object : Callback<ResponceN>{
            override fun onResponse(call: Call<ResponceN>?, response: Response<ResponceN>?) {
                mutableLiveData.postValue(response?.body())
                //Log.d("test", "OnResponse  " + response?.body())
                Log.d("test", "Input  " + responce2)
            }

            override fun onFailure(call: Call<ResponceN>?, t: Throwable?) {
                Log.d("test", "OnFailure " + t?.message)
                errorMessage.postValue(t?.message)
            }
        })*/