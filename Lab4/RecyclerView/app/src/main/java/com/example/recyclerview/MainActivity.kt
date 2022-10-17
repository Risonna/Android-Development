package com.example.recyclerview

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), CellClickListener {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(this, fetchList(), this)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun fetchList(): ArrayList<ColorData>{
        val listcolor = getColorList()
        val listhex = getColorHex()
        val list = arrayListOf<ColorData>()

        for (i in 0..6){
            list.add(ColorData(
                listcolor[i], listhex[i]
            ))
        }
        return list
    }

    override fun onCellClickListener(data: ColorData) {
        Toast.makeText(this, "${data.colorName} color was clicked", Toast.LENGTH_SHORT).show()
    }

    private fun getColorList(): List<String>{
        return this.resources.getStringArray(R.array.colornames).toList()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getColorHex(): List<Int> {
        return arrayListOf(
            Color.BLACK,
            Color.YELLOW,
            Color.RED,
            Color.BLUE,
            Color.GREEN,
            Color.MAGENTA,
            Color.DKGRAY
        )
    }


}

class ColorData(
    val colorName: String,
    val colorHex: Int
)

interface CellClickListener {
    fun onCellClickListener(data: ColorData)
}