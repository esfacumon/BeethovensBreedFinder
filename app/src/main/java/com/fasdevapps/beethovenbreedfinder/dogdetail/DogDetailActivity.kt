package com.fasdevapps.beethovenbreedfinder.dogdetail

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fasdevapps.beethovenbreedfinder.R
import com.fasdevapps.beethovenbreedfinder.databinding.ActivityDogDetailBinding
import com.fasdevapps.beethovenbreedfinder.model.Dog

class DogDetailActivity : AppCompatActivity() {

    companion object {
        const val DOG_KEY = "dog"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_detail)
        val binding = ActivityDogDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dog: Dog? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent?.getParcelableExtra<Dog>(DOG_KEY, Dog::class.java)
        }
        else {
            intent?.getParcelableExtra<Dog>(DOG_KEY)
        }

        if (dog == null) {
            Toast.makeText(this, R.string.error_showing_dog_not_found, Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        binding.dogIndex.text = getString(R.string.dog_index_format, dog.index)
        binding.lifeExpectancy.text = getString(R.string.dog_life_expectancy_format, dog.lifeExpectancy)
        binding.dog = dog
    }
}