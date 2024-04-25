package com.sundram.assignment.prenstation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.sundram.assignment.R
import com.sundram.assignment.data.datamodel.PostsItem
import com.sundram.assignment.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    lateinit var activityDetailBinding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding =
            DataBindingUtil.setContentView(this@DetailActivity, R.layout.activity_detail)
        intent?.let {
            it.extras?.let {
                activityDetailBinding.post = it.get("data") as PostsItem
                activityDetailBinding.noData.visibility = View.GONE
            }

        }
    }
}