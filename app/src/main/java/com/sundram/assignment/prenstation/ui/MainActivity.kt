package com.sundram.assignment.prenstation.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sundram.assignment.R
import com.sundram.assignment.data.datamodel.PostsItem
import com.sundram.assignment.databinding.ActivityMainBinding
import com.sundram.assignment.prenstation.adapter.PostAdapter
import com.sundram.assignment.prenstation.viewmodel.PostViewModel
import com.sundram.assignment.prenstation.viewmodel.PostViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var postViewModelFactory: PostViewModelFactory

    @Inject
    lateinit var adapter: PostAdapter
    lateinit var postViewModel: PostViewModel
    lateinit var activityMainBinding: ActivityMainBinding
    private var dataList = mutableListOf<PostsItem>()
    private var apiResponseDataList = mutableListOf<PostsItem>()

    // Page size for pagination
    private val pageSize = 10
    var current = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding =
            DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        activityMainBinding.loader.visibility = View.VISIBLE
        postViewModel =
            ViewModelProvider(this@MainActivity, postViewModelFactory)[PostViewModel::class.java]
        initPostRecyclerView()
        postViewModel.getPostLiveData.observe(this@MainActivity) {
            if (it.size > 0) {
                apiResponseDataList.addAll(it)
                onLoad(0)
                activityMainBinding.postRV.visibility = View.VISIBLE
            } else {
                activityMainBinding.postRV.visibility = View.GONE
                activityMainBinding.noData.visibility = View.VISIBLE

            }
            activityMainBinding.loader.visibility = View.GONE
        }
        postViewModel.execute()
    }

    fun onLoad(page: Int) {
        // Calculate the start and end index for the current page
      try {
          CoroutineScope(Dispatchers.IO).launch {
              val startIndex = page * pageSize
              val endIndex = startIndex + pageSize
              val paginateList = ArrayList<PostsItem>()
              if (apiResponseDataList.size >= endIndex) {
                  // Simulate loading data for the current page
                  for (i in startIndex until endIndex) {
                      paginateList.add(apiResponseDataList[i])

                  }
                  Handler(Looper.getMainLooper()).post {
                      dataList.addAll(paginateList)
                      adapter.differ.submitList(dataList)
                      adapter.notifyDataSetChanged()
                  }
              } else {
                  Handler(Looper.getMainLooper()).post {
                      Toast.makeText(
                          /* context = */ this@MainActivity,
                          /* text = */ resources.getString(R.string.you_reached_at_the_end_of_the_page),
                          /* duration = */ Toast.LENGTH_LONG
                      ).show()
                  }
              }
          }
      }catch (ex:Exception){
          Toast.makeText(this@MainActivity,resources.getString(R.string.something_went_wrong),Toast.LENGTH_LONG).show()
      }
    }

    private fun initPostRecyclerView() {
        activityMainBinding.postRV.layoutManager = GridLayoutManager(this@MainActivity, 1)
        adapter.setContext(this@MainActivity)
        activityMainBinding.postRV.adapter = adapter

        activityMainBinding.postRV.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    current += 1
                    onLoad(current)
                }
            }
        })
        adapter.setOnItemClickListener {
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("data", it)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}