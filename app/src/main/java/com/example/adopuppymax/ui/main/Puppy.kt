package com.example.adopuppymax.ui.main

import androidx.compose.runtime.Immutable
import com.example.adopuppymax.R

@Immutable
data class Puppy(
    val id: Long,
    val name: String,
    val thumbResource: Int,
    val breed: String,
    val age: String,
    val gender: String,
    val size: String,
    val color: String,
    val location: String,
    val healthState: String,
    val description: String = ""
)

object PuppyRepo {
    fun getPuppy(courseId: Long): Puppy = puppies.find { it.id == courseId }!!
    fun getRelatedPuppies(@Suppress("UNUSED_PARAMETER") courseId: Long): List<Puppy> = puppies
}

val puppies = listOf(
    Puppy(
        id = 1001,
        name = "Hambone",
        thumbResource = R.raw.hambone,
        breed = "Labrador & Bulldog Mix",
        age = "5 Month",
        gender = "Male",
        size = "Large",
        color = "Black",
        location = "Kansas City, MO",
        healthState = "Vaccinations up to date, spayed / neutered.",
        description = "We show our dogs by appointment only upon receipt of our online application which can be found at kcpaws.petfinder.com If you are reading this, we are still accepting applications for Hambone. The adoption fee for Hambone is \$175\n" +
                "Hambone is a 2 year old sweet as he can be Lab/bully mix. He is sweet and snuggly and loves other dogs. He is a bit shy when meeting someone knew although he does give a huge smile and a wiggle when he greets you. He keeps his kennel here clean, so it's likely he's had some housetraining.\n" +
                "This is a good boy! Some lucky family is going to hit the jackpot with this boy!\n" +
                "Our online application can be found at kcpaws.petfinder.com"
    ),
    Puppy(
        id = 1002,
        name = "Peach",
        thumbResource = R.raw.peach,
        breed = "Terrier Mix",
        age = "6 Month",
        gender = "Female",
        size = "Medium",
        color = "White / Cream",
        location = "Mission, KS",
        healthState = "Vaccinations up to date, spayed / neutered, special needs. Peach is shy and fearful so needs a home with patient humans who will give her time to warm up.",
        description = "Just look at this doll! Peach is new to The Pet Connection's program, but we know she's pretty darned adorable enjoys lounging, and is super photogenic.\n " +
                "The Pet Connection also offers adopters a FREE veterinary examination and a medical care support plan for 60 days after adoption, as well as lifetime behavioral training, " +
                "safe sanctuary for pets returned in emergency situations, extensive assistance with lost and found pets, and other expert pet services in a variety of areas, including pet " +
                "selection, behavioral issues, general training, nutrition, and transition to adoptive homes."
    )
)
