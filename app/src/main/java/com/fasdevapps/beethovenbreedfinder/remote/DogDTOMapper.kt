package com.fasdevapps.beethovenbreedfinder.remote

import com.fasdevapps.beethovenbreedfinder.model.Dog

class DogDTOMapper {

    private fun fromDogDTOtoDogDomain(dogDTO: DogDTO): Dog {
        return Dog(
            dogDTO.id,
            dogDTO.index,
            dogDTO.name,
            dogDTO.type,
            dogDTO.heightFemale,
            dogDTO.heightMale,
            dogDTO.imageUrl,
            dogDTO.lifeExpectancy,
            dogDTO.temperament,
            dogDTO.weightFemale,
            dogDTO.weightMale
        )
    }

    fun fromDogDTOListToDogDomainList(dogDTOList: List<DogDTO>): List<Dog> {
        return dogDTOList.map {
            fromDogDTOtoDogDomain(it)
        }
    }
}