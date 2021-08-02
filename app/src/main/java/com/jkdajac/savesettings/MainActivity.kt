package com.jkdajac.savesettings

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
     var isRmembered = false
     var isRemember = false
     var isRemm = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreference =  getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)
        val name =  sharedPreference.getString("edit", "")
        isRmembered = sharedPreference.getBoolean("language", false)
        isRemember = sharedPreference.getBoolean("grafics", false)
        isRemm = sharedPreference.getBoolean("autosave", false)
        edEdText.setText(name)
        swLang.isChecked = isRmembered
        swGrafics.isChecked = isRemember
        swAutosave.isChecked = isRemm
    }
    private  fun save(){
        val sharedPreference =  getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        editor.putBoolean("language", swLang.isChecked)
        editor.putBoolean("grafics", swGrafics.isChecked)
        editor.putBoolean("autosave", swAutosave.isChecked)
        editor.putString("edit", edEdText.text.toString())
        editor.apply()
    }

    override fun onDestroy() {
        super.onDestroy()
        save()
    }
}
