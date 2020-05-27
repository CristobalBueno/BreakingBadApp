package com.example.cristobalbuenoexam.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cristobalbuenoexam.Models.DataHolder
import com.example.cristobalbuenoexam.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    val currentResult = DataHolder.currentResult

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        updateView()
    }

    fun updateView(){
        Picasso.get().load(currentResult.img).into(imageView)
        text_name.text = currentResult.name
        text_nickname.text = currentResult.nickname
        text_apperance.text = currentResult.appearance.toString()
        text_occupation.text = currentResult.occupation.toString()
    }
}
