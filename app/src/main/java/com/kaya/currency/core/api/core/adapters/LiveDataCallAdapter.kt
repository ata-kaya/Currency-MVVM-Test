package com.kaya.currency.core.api.core.adapters

import android.util.Log
import androidx.lifecycle.LiveData
import com.kaya.currency.core.api.core.ApiResponse
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type

class LiveDataCallAdapter<R>(private val responseType: Type) :
    CallAdapter<R, LiveData<ApiResponse<R>>> {
    override fun adapt(call: Call<R>): LiveData<ApiResponse<R>> {
        return object : LiveData<ApiResponse<R>>() {
            private var isSuccess = false
            override fun onActive() {
                super.onActive()
                Log.d("atakaya", "onActive isSuccess = $isSuccess")
                if (!isSuccess) enqueue()
            }

            override fun onInactive() {
                super.onInactive()
                Log.d("atakaya", "onInactive")
                dequeue()
            }

            private fun dequeue() {
                Log.d("atakaya", "dequeue call.isExecuted = ${call.isExecuted}")
                if (call.isExecuted) call.cancel()
            }

            private fun enqueue() {
                Log.d("atakaya", "enqueue")
                call.clone().enqueue(object : Callback<R> {
                    override fun onFailure(call: Call<R>, t: Throwable) {
                        postValue(ApiResponse.create(1, t))
                        Log.d("atakaya", "fail")
                        call.cancel()
                    }

                    override fun onResponse(call: Call<R>, response: Response<R>) {
                        postValue(ApiResponse.create(response))
                        Log.d("atakaya", "success")
                        isSuccess = true
                        if (!call.isCanceled) {
                            call.cancel()
                        }
                    }
                })
            }
        }
    }

    override fun responseType(): Type = responseType
}