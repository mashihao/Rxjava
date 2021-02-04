package com.kds.rxjava

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

/**
 * @author : 马世豪
 * time : 2020/12/7 19
 * email : ma_shihao@yeah.net
 * des :
 */

internal class Adapter(var num: MutableList<String>, var mcontext: Context) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(
                mcontext
            ).inflate(
                R.layout.item, parent,
                false
            )
        )
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.setText(num.get(position))

        var i = Random.nextInt()

        if (i % 6 == 0) {
            holder.text.setBackgroundColor(mcontext.getColor(R.color.design_default_color_error))
        }else
        {
            holder.text.setBackgroundColor(mcontext.getColor(R.color.design_default_color_primary))
        }
    }

    override fun getItemCount(): Int {
        return num.size
    }

    internal inner class ViewHolder :
        RecyclerView.ViewHolder {

        lateinit var text: TextView

        constructor(view: View) : super(view) {
            text = view.findViewById(R.id.text)
        }
    }
}
