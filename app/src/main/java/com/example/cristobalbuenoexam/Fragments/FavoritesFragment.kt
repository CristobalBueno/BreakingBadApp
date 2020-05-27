package com.example.cristobalbuenoexam.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cristobalbuenoexam.Activities.DetailActivity
import com.example.cristobalbuenoexam.Activities.MainActivity
import com.example.cristobalbuenoexam.Adapter.FavoriteAdapter
import com.example.cristobalbuenoexam.Interfaces.CustomItemListener
import com.example.cristobalbuenoexam.Models.DataHolder
import com.example.cristobalbuenoexam.Models.ResultItem
import com.example.cristobalbuenoexam.R
import kotlinx.android.synthetic.main.fragment_favorites.*

/**
 * A simple [Fragment] subclass.
 */
class FavoritesFragment : Fragment(), CustomItemListener {

    var favorites = DataHolder.favoritesResult

    private var adapter: FavoriteAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView()
    }




    fun recyclerView(){

        val mLayoutManager = GridLayoutManager(context, 2)
        favoriteRecycler.layoutManager = mLayoutManager
        adapter = FavoriteAdapter(favorites,this)
        favoriteRecycler.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter?.notifyDataSetChanged()
    }

    override fun onItemClick(item: ResultItem) {
        DataHolder.currentResult = item
        (activity as MainActivity).gotoActivity(DetailActivity())
    }

    override fun onLongItemClick(item: ResultItem) {
    }

}
