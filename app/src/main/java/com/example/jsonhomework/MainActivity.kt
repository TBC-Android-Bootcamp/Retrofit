package com.example.jsonhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var adapter:Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        val model = UserModel() // User model
        val ad = UserModel.Ad() // User Model ad
        val data= mutableListOf<UserModel.Data>() // Data list for user information
        val list= mutableListOf<UserModel.Ad>() // ad list for company and etc.
        val json=JSONObject(json)
        val userModelAd=json.getJSONObject("ad")

        // adapter for recyclerView
        adapter = Adapter(data)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter

        val dataArray= json.getJSONArray("data")
        if(json.has("data")){
            for (index in 0 until dataArray.length()) {
                val dataObj=dataArray.getJSONObject(index)
                data.add(UserModel.Data(dataObj.getInt("id"),dataObj.getString("email"),dataObj.getString("first_name"),dataObj.getString("last_name"),dataObj.getString("avatar")))
            }
        }
        ad.company = userModelAd.getString("company")
        ad.text = userModelAd.getString("text")
        ad.url = userModelAd.getString("url")
        list.add(ad)
        model.adlist=list

        company.text = ad.company
        url.text = ad.url
        text.text = ad.text
    }

    private val json = "{\n" +
            "  \"page\": 2,\n" +
            "  \"per_page\": 6,\n" +
            "  \"total\": 12,\n" +
            "  \"total_pages\": 2,\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"id\": 7,\n" +
            "      \"email\": \"michael.lawson@reqres.in\",\n" +
            "      \"first_name\": \"Michael\",\n" +
            "      \"last_name\": \"Lawson\",\n" +
            "      \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 8,\n" +
            "      \"email\": \"lindsay.ferguson@reqres.in\",\n" +
            "      \"first_name\": \"Lindsay\",\n" +
            "      \"last_name\": \"Ferguson\",\n" +
            "      \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/araa3185/128.jpg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 9,\n" +
            "      \"email\": \"tobias.funke@reqres.in\",\n" +
            "      \"first_name\": \"Tobias\",\n" +
            "      \"last_name\": \"Funke\",\n" +
            "      \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/vivekprvr/128.jpg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 10,\n" +
            "      \"email\": \"byron.fields@reqres.in\",\n" +
            "      \"first_name\": \"Byron\",\n" +
            "      \"last_name\": \"Fields\",\n" +
            "      \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/russoedu/128.jpg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 11,\n" +
            "      \"email\": \"george.edwards@reqres.in\",\n" +
            "      \"first_name\": \"George\",\n" +
            "      \"last_name\": \"Edwards\",\n" +
            "      \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/mrmoiree/128.jpg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 12,\n" +
            "      \"email\": \"rachel.howell@reqres.in\",\n" +
            "      \"first_name\": \"Rachel\",\n" +
            "      \"last_name\": \"Howell\",\n" +
            "      \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/hebertialmeida/128.jpg\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"ad\": {\n" +
            "    \"company\": \"StatusCode Weekly\",\n" +
            "    \"url\": \"http://statuscode.org/\",\n" +
            "    \"text\": \"A weekly newsletter focusing on software development, infrastructure, the server, performance, and the stack end of things.\"\n" +
            "  }\n" +
            "}"
}
