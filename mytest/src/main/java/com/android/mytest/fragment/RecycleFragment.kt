package com.android.mytest.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.mytest.data.ImageData
import com.android.mytest.adapter.ListAdapter
import com.android.mytest.R


class RecycleFragment : Fragment() {
    private val adapter = ListAdapter()
    private val layoutInflater = LinearLayoutManager(context)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recycle, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutInflater
        return recyclerView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    private fun loadData() {
        val list = mutableListOf<ImageData>()
        list.add(
            ImageData(
                "https://p2.img.cctvpic.com/photoAlbum/page/performance/img/2023/11/29/1701231621558_134.jpg",
                getString(R.string.title1)
            )
        )
        list.add(
            ImageData(
                "https://p3.img.cctvpic.com/photoAlbum/page/performance/img/2023/11/29/1701231557997_300.jpg",
                getString(R.string.title2)
            )
        )
        list.add(
            ImageData(
                "https://p4.img.cctvpic.com/photoAlbum/page/performance/img/2023/11/29/1701231795090_280.jpg",
                getString(R.string.title3)
            )
        )
        adapter.setNewInstance(list)
    }
}
