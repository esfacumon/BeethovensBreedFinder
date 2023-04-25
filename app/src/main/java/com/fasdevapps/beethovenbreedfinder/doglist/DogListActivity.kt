package com.fasdevapps.beethovenbreedfinder.doglist

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.fasdevapps.beethovenbreedfinder.R
import com.fasdevapps.beethovenbreedfinder.databinding.ActivityDogListBinding
import com.fasdevapps.beethovenbreedfinder.dogdetail.DogDetailActivity
import com.fasdevapps.beethovenbreedfinder.dogdetail.DogDetailActivity.Companion.DOG_KEY
import com.fasdevapps.beethovenbreedfinder.model.Dog
import com.fasdevapps.beethovenbreedfinder.remote.ApiResponseStatus
import com.fasdevapps.beethovenbreedfinder.viewmodel.DogListViewModel

class DogListActivity : AppCompatActivity() {

    private val dogListViewModel: DogListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rvDog = binding.rvDog
        rvDog.layoutManager = LinearLayoutManager(this)

        val loadingWheel = binding.pbLoadingWheel

        val adapter = DogAdapter()

        adapter.setOnItemClickListener {
            val intent = Intent(this, DogDetailActivity::class.java)
            // pasamos el perro a la actividad para mostrar sus datos
            intent.putExtra(DOG_KEY, it)
            startActivity(intent)
        }

        rvDog.adapter = adapter

        // observe: se ejecuta cuando la lista reciba algún cambio
        dogListViewModel.dogList.observe(this) {
            dogList -> adapter.submitList(dogList)
        }

        dogListViewModel.status.observe(this) {
            status ->
            when(status) {
                ApiResponseStatus.LOADING -> {
                    loadingWheel.visibility = View.VISIBLE
                }
                ApiResponseStatus.ERROR -> {
                    loadingWheel.visibility = View.GONE
                    Toast.makeText(this, R.string.error_fetching_data, Toast.LENGTH_SHORT).show()
                }
                ApiResponseStatus.SUCCESS -> {
                    loadingWheel.visibility = View.GONE
                }
                else -> {
                    loadingWheel.visibility = View.GONE
                    Toast.makeText(this, R.string.error_unknown, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}