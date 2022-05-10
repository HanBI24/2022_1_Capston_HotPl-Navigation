package com.example.hotplenavigation.repository

import androidx.lifecycle.MutableLiveData
import com.example.hotplenavigation.data.get_result_path.GetResultPath
import com.example.hotplenavigation.data.get_result_path.Traavoidtoll
import com.example.hotplenavigation.di.RetrofitModule
import com.example.hotplenavigation.network.NaverMapApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GetResultPathRepository @Inject constructor(
    @RetrofitModule.GetResultPathType private val naverMapGetResultPath: NaverMapApi
) {

    fun makeGetResultPathApiCall(
        apiKeyId: String,
        apiKey: String,
        start: String,
        goal: String,
        option: String,
        liveDataList: MutableLiveData<List<Traavoidtoll>>,
        liveDataListGuide: MutableLiveData<List<Traavoidtoll>>
    ) {
        val call = naverMapGetResultPath.getResultPath(apiKeyId, apiKey, start, goal, option)
        call.enqueue(object : Callback<GetResultPath> {
            override fun onResponse(call: Call<GetResultPath>, response: Response<GetResultPath>) {
                if (response.body() != null && response.isSuccessful) {
                    liveDataList.postValue(response.body()?.route?.traavoidtoll!!)
                    liveDataListGuide.postValue(response.body()?.route?.traavoidtoll!!)
                } else {
                    liveDataList.postValue(null)
                    liveDataListGuide.postValue(null)
                }
            }

            override fun onFailure(call: Call<GetResultPath>, t: Throwable) {
            }
        })
    }
}