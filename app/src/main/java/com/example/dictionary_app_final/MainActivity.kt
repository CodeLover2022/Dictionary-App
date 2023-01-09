package com.example.dictionary_app_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import org.json.JSONArray
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn.setOnClickListener {
            val queue= Volley.newRequestQueue(this@MainActivity)
            val api="e39d4701-1638-4851-b8cd-2884bf902dad"
            val word=et_name.text.toString()
            val url="https://www.dictionaryapi.com/api/v3/references/learners/json/$word?key=$api"
          
            val request= StringRequest(Request.Method.GET,url,
            {
                response ->
                try{
                    Log.d("tag",response.toString())
                    extract_details(response)

                }
                catch(e:Exception){
                    e.printStackTrace()
                }
            },{
                error -> Toast.makeText(this,"error",Toast.LENGTH_SHORT).show()
            })
        queue.add(request)
        }
    }

    private fun extract_details(response: String?) {
        val arr=JSONArray(response)
        val obj1=arr.getJSONObject(0)
        val obj2=obj1.getJSONArray("shortdef")
        val obj3=obj2.get(0)

        val intent= Intent(this,MainActivity2::class.java)
        intent.putExtra("msg",obj3.toString())
        startActivity(intent)
        finish()
    }
}
