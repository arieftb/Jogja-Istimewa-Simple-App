package com.arieftb.jogjaistimewa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var culinaryList: MutableList<Culinary> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val culinaryName = resources.getStringArray(R.array.culinary_name)
        val culinaryImage = resources.obtainTypedArray(R.array.culinary_image)
        culinaryList.clear()

        for (i in culinaryName.indices) {
            culinaryList.add(Culinary(culinaryName[i], culinaryImage.getResourceId(i, -1)))
        }

        culinaryImage.recycle()

        val culinaryRecyclerAdapter = RecyclerViewAdapter(this, culinaryList)

        recycler_culinary_list.apply {
            adapter = culinaryRecyclerAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            hasFixedSize()
        }
    }
}
