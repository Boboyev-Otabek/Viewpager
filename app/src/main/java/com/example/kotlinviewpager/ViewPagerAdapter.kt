package com.example.kotlinviewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.lottie.LottieAnimationView

class ViewPagerAdapter(
    var title: List<String>,
    var details: List<String>,
    var lottie: MutableList<String>
) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerholder>() {


    class ViewPagerholder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var itemtitle: TextView = itemview.findViewById(R.id.text_title)
        var itemdetail: TextView = itemview.findViewById(R.id.txt_abaut)
        var itemlottie: LottieAnimationView = itemview.findViewById(R.id.lotti)
    }

    override fun getItemCount(): Int {
        return title.size
    }

    override fun onBindViewHolder(holder: ViewPagerholder, position: Int) {
        holder.itemtitle.text = title[position]
        holder.itemdetail.text = details[position]
        holder.itemlottie.setAnimation(lottie[position])

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerholder {
        return ViewPagerholder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_item, parent, false)
        )
    }


}