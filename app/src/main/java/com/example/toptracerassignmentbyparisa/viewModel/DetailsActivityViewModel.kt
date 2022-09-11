package com.example.toptracerassignmentbyparisa.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.toptracerassignmentbyparisa.DataResult
import com.example.toptracerassignmentbyparisa.network.RetroInstance
import com.example.toptracerassignmentbyparisa.network.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsActivityViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var liveDataList: MutableLiveData<DataResult>

    init {
        liveDataList = MutableLiveData<DataResult>()
    }

    fun getLiveDataObserver(): MutableLiveData<DataResult> {
        return liveDataList
    }

    fun makeApicall() {

        val retrofit = RetroInstance.getRetroInstance()

        val retroService = retrofit.create(RetroServiceInterface::class.java)
        retroService.getGifs()?.enqueue(object : Callback<DataResult?> {
            override fun onResponse(call: Call<DataResult?>, response: Response<DataResult?>) {


                if (response.isSuccessful) {
                    liveDataList.postValue(response.body())
                } else {
                    liveDataList.postValue(null)
                }


            }

            override fun onFailure(call: Call<DataResult?>, t: Throwable) {
                liveDataList.postValue(null)
            }
        })
    }
}