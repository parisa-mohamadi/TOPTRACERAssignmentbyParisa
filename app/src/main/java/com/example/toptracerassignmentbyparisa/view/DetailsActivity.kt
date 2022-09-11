package com.example.toptracerassignmentbyparisa.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.toptracerassignmentbyparisa.DataResult
import com.example.toptracerassignmentbyparisa.MainActivity
import com.example.toptracerassignmentbyparisa.databinding.ActivityDetailsBinding
import com.example.toptracerassignmentbyparisa.viewModel.DetailsActivityViewModel
import kotlinx.android.synthetic.main.activity_details.*


const val TAG = "DetailsActivity"

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    private lateinit var detailsActivityViewModel: DetailsActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_details)
        setContentView(binding.root)


        //init
        progressBar1.visibility = View.VISIBLE;
        val username: String = intent.getStringExtra("username").toString()
        tv_welcome.text = "Welcome, ${username}!"

        initViewModel()

        btn_logout.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun initViewModel() {

        detailsActivityViewModel = ViewModelProvider(this).get(DetailsActivityViewModel::class.java)
        detailsActivityViewModel.getLiveDataObserver().observe(this, object : Observer<DataResult> {
            override fun onChanged(t: DataResult?) {
                if (t != null) {

                    val res_length = t.res.size
                    val rnd = (0..res_length - 1).random()
                    val giphy_title: String = t.res[rnd].title
                    tv_giphy_info.text = giphy_title
                    val url: String = t.res[rnd].images.ogImage.url

                    val options = RequestOptions()
                    options.fitCenter()

                    Glide.with(iv_giphy)
                        .load(url)
                        .apply(options)
                        .into(iv_giphy)

                    progressBar1.visibility = View.GONE;
                    Log.d(TAG, "title: ${giphy_title}  &&  url: ${url}")


                } else {
                    Toast.makeText(
                        this@DetailsActivity,
                        "error in getting the data",
                        Toast.LENGTH_SHORT
                    ).show()

                    Log.d(TAG, "onResponce: No responce...")
                }
            }
        })
        detailsActivityViewModel.makeApicall()
    }


}