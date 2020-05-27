package com.example.cristobalbuenoexam.Fragments

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cristobalbuenoexam.Activities.DetailActivity
import com.example.cristobalbuenoexam.Activities.MainActivity

import com.example.cristobalbuenoexam.Adapter.EventsAdapter
import com.example.cristobalbuenoexam.Api.ApiRest
import com.example.cristobalbuenoexam.Interfaces.CustomItemListener
import com.example.cristobalbuenoexam.Models.DataHolder
import com.example.cristobalbuenoexam.Models.Result
import com.example.cristobalbuenoexam.Models.ResultItem
import com.example.cristobalbuenoexam.R
import kotlinx.android.synthetic.main.fragment_characters.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class CharactersFragment : Fragment(), CustomItemListener {

    var dataGenres: ArrayList<ResultItem> = ArrayList()
    private var adapter: EventsAdapter? = null

    val TAG = "miapp"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ApiRest.initService()
        getEventsMain()

        recyclerView()
    }

    fun recyclerView() {
        val mLayoutManager = GridLayoutManager(context, 2)
        charactersRecycler.layoutManager = mLayoutManager
        adapter = EventsAdapter(dataGenres,this)
        charactersRecycler.adapter = adapter
    }

    private fun getEventsMain() {
        val call = ApiRest.service.getEvents()
        call.enqueue(object : Callback<Result> {

            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                val body = response.body()

                if (response.isSuccessful && body != null) {

                    Log.w("miapp", "${body}")
                    dataGenres.clear()
                    dataGenres.addAll(body)
                    adapter?.notifyDataSetChanged()

                } else {
                    Log.e(TAG, response.errorBody()?.string())
                }
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                Log.e(TAG, t.message)
            }
        })
    }


    fun alertDialog(item: ResultItem) {
        val builder = AlertDialog.Builder(context)

        builder
            .setPositiveButton("Yes") { dialog, id ->

                DataHolder.favoritesResult.add(item)
            }
            .setNegativeButton("No") { dialog, id ->
                dialog.cancel()
            }

        builder.setTitle("Add to favorite?")
        builder.setCancelable(false).create().show()
    }

    override fun onItemClick(item: ResultItem) {
        DataHolder.currentResult = item
        (activity as MainActivity).gotoActivity(DetailActivity())
    }

    override fun onLongItemClick(item: ResultItem) {
        alertDialog(item)
    }

}
