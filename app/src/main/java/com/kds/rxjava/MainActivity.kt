package com.kds.rxjava

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recycler = findViewById<RecyclerView>(R.id.recycler)
        var button = findViewById<TextView>(R.id.btn)


        recycler.layoutManager = GridLayoutManager(this, 6)

        var text = mutableListOf<String>()
        for (i in 0..100) {
            text.add("$i")
        }
        recycler.adapter = Adapter(text, this)

        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager

                if (layoutManager is GridLayoutManager) {

                    var i = (layoutManager.findFirstVisibleItemPosition() / 6) + 1
                    var firstView =
                        layoutManager.findViewByPosition(layoutManager.findFirstVisibleItemPosition())
                    firstView?.let {
                        var height = it.height

                        if (dy > 0) {
                            //上滑  隐藏
                            //上滑 不需要特殊处理
                        } else {
                            //下滑  展示

                            if ((height -Math.abs( it.y)) > height / 4) {

                            } else {
                                i++
                            }
                        }
                        button.setText("第 $i 行")
                    }
                }
            }
        })
    }
}