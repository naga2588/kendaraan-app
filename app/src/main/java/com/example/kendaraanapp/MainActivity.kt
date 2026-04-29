package com.example.kendaraanapp

import android.app.Activity
import android.os.Bundle
import android.widget.*
import org.json.JSONArray
import java.net.URL

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.etCari)
        val btn = findViewById<Button>(R.id.btnCari)
        val tv = findViewById<TextView>(R.id.tvResult)

        btn.setOnClickListener {

            Thread {
                try {
                    val url = "http://192.168.1.10:8000/index.php"
                    val data = URL(url).readText()

                    runOnUiThread {
                        tv.text = formatJson(data)
                    }
                } catch (e: Exception) {
                    runOnUiThread {
                        tv.text = "Error: ${e.message}"
                    }
                }
            }.start()
        }
    }

    fun formatJson(json: String): String {
        val obj = JSONArray(json).getJSONObject(0)

        return """
DATA KENDARAAN
════════════════
Nama : ${obj.getString("NamaPemilik")}
NIK  : ${obj.getString("NoKTP")}
Nopol: ${obj.getString("nopol")}
Merk : ${obj.getString("Merk")}
"""
    }
}
