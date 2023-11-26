package com.example.mydialer_lab6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import okhttp3.*
import timber.log.Timber
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = this.findViewById(R.id.btn_search)

        Timber.plant(Timber.DebugTree())

        Timber.v("TEST1")
        doGetRequest(this)


    }
}


fun doGetRequest(mainActivity: MainActivity) {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("https://drive.google.com/u/0/uc?id=1-KO-9GA3NzSgIc1dkAsNm8Dqw0fuPxcR&export=download")
        .build()

    Timber.v("TEST2")
    client.newCall(request).enqueue(object : Callback {

        override fun onFailure(call: Call, e: IOException) {
            e.printStackTrace()
        }

        override fun onResponse(call: Call, response: Response) {
            response.use {
                Timber.v("TEST3")
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                val jsonText = response?.body?.string()
                val gsBuilder = GsonBuilder()
                val gs = gsBuilder.create()


                var list = gs.fromJson(jsonText, Array<Contact>::class.java).toList() as ArrayList<Contact>
                var copy1 = list.toList() as ArrayList<Contact>

                val recyclerView: RecyclerView = mainActivity.findViewById(R.id.rView)
                val adapter = Adapter(mainActivity, list, jsonText.toString(), mainActivity)
                mainActivity.runOnUiThread(java.lang.Runnable {
                    recyclerView.layoutManager = LinearLayoutManager(mainActivity)
                    recyclerView.adapter = adapter
                })

                val btn: Button = mainActivity.findViewById(R.id.btn_search)
                val txt: EditText = mainActivity.findViewById(R.id.et_search)
                btn.setOnClickListener {
                    var myText = txt.text.toString()

                    list.clear()
                    list.addAll(copy1)

                    list.filter { myText !in it.name }
                        .forEach { list.remove(it) }
                    adapter.notifyDataSetChanged()
                }

                Timber.d(gs.toJson(list))
            }
        }
    })
}