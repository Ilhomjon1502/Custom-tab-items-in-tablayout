package com.ilhomjon.customtabitemsandcicrleindicatorintablayout

import Adapters.CategoryAdapter
import Models.Category
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tab_item.view.*

class MainActivity : AppCompatActivity() {

    lateinit var categoryList: ArrayList<Category>
    lateinit var categoryAdapter:CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageList = ArrayList<String>()
        for (i in 0..100)
        imageList.add("https://fotouz.uz/uploads/posts/2019-01/medium/1546339821_apple-1986660_1920.png")

        categoryList = ArrayList()
        categoryList.add(Category("ALL", imageList))
        categoryList.add(Category("NEW", imageList))
        categoryList.add(Category("Animal", imageList))
        categoryList.add(Category("Technology", imageList))
        categoryList.add(Category("Nature", imageList))

        categoryAdapter = CategoryAdapter(categoryList, supportFragmentManager)
        view_pager.adapter = categoryAdapter

        tab_layout.setupWithViewPager(view_pager)

        setTabs()

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.tab_indicator?.visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.tab_indicator?.visibility = View.INVISIBLE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }

    private fun setTabs() {
        val tabCount = tab_layout.tabCount

        for (i in 0 until tabCount){
            val tabView = LayoutInflater.from(this).inflate(R.layout.tab_item, null, false)
            val tab = tab_layout.getTabAt(i)
            tab?.customView = tabView

            tabView.txt_title.text = categoryList[i].title

            if (i == 0){
                tabView.tab_indicator.visibility = View.VISIBLE
            }else{
                tabView.tab_indicator.visibility = View.INVISIBLE
            }
        }
    }
}