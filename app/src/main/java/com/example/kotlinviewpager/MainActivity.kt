package com.example.kotlinviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {

    var titliList = mutableListOf<String>()

    var descList = mutableListOf<String>()

    var lottieList = mutableListOf<String>()
    lateinit var view_pager: ViewPager2

    lateinit var skip: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_pager = findViewById(R.id.view_pager)
        postToList()
        view_pager.adapter = ViewPagerAdapter(titliList, descList, lottieList)
        view_pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indecator: CircleIndicator3 = findViewById(R.id.indicator)
        indecator.setViewPager(view_pager)

        var started :Button=findViewById(R.id.started)
        skip = findViewById(R.id.skip)

        skip.setOnClickListener {
            if (view_pager.currentItem ==0) {

                view_pager.currentItem = view_pager.currentItem + 1
            }

            else if(view_pager.currentItem ==1){


                view_pager.currentItem = view_pager.currentItem+1

                skip.visibility=View.GONE
                started.visibility=View.VISIBLE


            }
            else{view_pager.currentItem = view_pager.currentItem}

        }
    }

    fun addtoList(title: String, detail: String, lottie: String) {
        titliList.add(title)
        descList.add(detail)
        lottieList.add(lottie)
    }

    fun postToList() {
        for (i in 1..3 step 1) {
            addtoList("Title $i", "Abaut $i", "a$i.json")
        }
    }
}