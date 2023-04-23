package com.fasdevapps.beethovenbreedfinder.repository

import com.fasdevapps.beethovenbreedfinder.model.Dog
import com.fasdevapps.beethovenbreedfinder.remote.DogDTOMapper
import com.fasdevapps.beethovenbreedfinder.remote.DogsApi.retrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {

    // suspend pq está dentro de una corrutina
    suspend fun downloadDogs(): List<Dog> {
        return withContext(Dispatchers.IO) { // esto especifica que la corrutina se usa para obtener los resultados de una peticion REST
            val dogListApiResponse = retrofitService.getAllDogs()
            val dogDTOList = dogListApiResponse.data.dogs
            val dogDTOMapper = DogDTOMapper()
            dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList)
        }
    }
}