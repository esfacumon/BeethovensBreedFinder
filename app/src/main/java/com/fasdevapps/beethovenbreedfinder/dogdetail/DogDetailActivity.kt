package com.fasdevapps.beethovenbreedfinder.dogdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fasdevapps.beethovenbreedfinder.R
import com.fasdevapps.beethovenbreedfinder.databinding.ActivityDogDetailBinding

class DogDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_detail)
        val binding = ActivityDogDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}