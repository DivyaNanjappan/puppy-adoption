package com.puppyadoption.androiddevchallenge.model

import com.puppyadoption.androiddevchallenge.R

data class Puppy(
    val id: Int,
    val name: String,
    val age: String,
    val weight: String,
    val gender: String,
    val description: String,
    val contactName: String,
    val imageId: Int
) {

    companion object {
        fun getPuppies(): List<Puppy> {
            val puppies = arrayListOf<Puppy>()

            var i = 0
            names.forEach { name ->
                val puppy = Puppy(
                    i,
                    name,
                    ages[i],
                    "12 kg",
                    breeds[i],
                    descriptions.random(),
                    contactNames[i],
                    images[i]
                )
                i++
                puppies.add(puppy)
            }

            return puppies
        }

        private val names = arrayListOf(
            "Olive",
            "Big Red",
            "Vicente",
            "Bella"
        )

        private val breeds = arrayListOf(
            "Male",
            "Female",
            "Male",
            "Female"
        )

        private val contactNames = arrayListOf(
            "David",
            "Smith",
            "Nicholson",
            "Kelvin"
        )

        private val ages = arrayListOf(
            "2",
            "3",
            "5",
            "4"
        )

        private val descriptions = arrayListOf(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident.",
            "Arcu cursus euismod quis viverra nibh cras pulvinar mattis nunc. Sit amet nisl suscipit adipiscing bibendum. Id cursus metus aliquam eleifend mi in nulla posuere. Vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt ornare massa. Nullam ac tortor vitae purus. Quis eleifend quam adipiscing vitae proin sagittis. Sed ullamcorper morbi tincidunt ornare massa eget egestas."
        )

        private val images = arrayListOf(
            R.drawable.dog1,
            R.drawable.dog2,
            R.drawable.dog3,
            R.drawable.dog4
        )
    }
}
