package com.itrex.itrexdemo.logic.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.itrex.itrexdemo.R
import com.itrex.itrexdemo.data.PriceModel
import kotlinx.android.synthetic.main.price_layout_item.view.*

class PriceAdapter(
    private var items: ArrayList<PriceModel>,
    private var listener: View.OnClickListener?
) :
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.price_layout_item, parent, false)

        return MyViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.itemLayout.setOnClickListener {
            holder.itemLayout.tag = item
            listener?.onClick(holder.itemLayout)
        }

        holder.key.text = item.key
        holder.value.text = String.format("%.2f", item.value)
        holder.upDown.setImageResource(
            if (item.up) {
                R.drawable.ic_arrow_drop_up
            } else {
                R.drawable.ic_arrow_drop_down
            }
        )
    }
}

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var key: TextView = view.vTvPriceKey
    var value: TextView = view.vTvPriceValue
    var upDown: ImageView = view.vIvUpDown
    var itemLayout: View = view.vPriceLayout
}