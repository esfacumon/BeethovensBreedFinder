package com.fasdevapps.beethovenbreedfinder.doglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.fasdevapps.beethovenbreedfinder.R
import com.fasdevapps.beethovenbreedfinder.databinding.ActivityDogListBinding
import com.fasdevapps.beethovenbreedfinder.model.Dog
import com.fasdevapps.beethovenbreedfinder.viewmodel.DogListViewModel

class DogListActivity : AppCompatActivity() {

    private val dogListViewModel: DogListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rvDog = binding.rvDog
        rvDog.layoutManager = LinearLayoutManager(this)

        val adapter = DogAdapter()

        adapter.setOnItemClickListener {

        }

        rvDog.adapter = adapter

        // observe: se ejecuta cuando la lista reciba algún cambio
        dogListViewModel.dogList.observe(this) {
            dogList -> adapter.submitList(dogList)
        }
    }


}