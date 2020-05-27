package com.example.cristobalbuenoexam.AbstractClass

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cristobalbuenoexam.R

abstract class BaseActivity: AppCompatActivity() {

    fun gotoFragment(myfragment: Fragment, toBack: Boolean = false){
        val transaction = supportFragmentManager.beginTransaction().replace(R.id.mainContainer, myfragment)

        if (toBack) {
            transaction.addToBackStack(myfragment.toString())
        }
        transaction.commit()
    }

    fun gotoActivity(myActivity: Activity){
        val intent = Intent(this, myActivity::class.java)
        startActivity(intent)
    }
}