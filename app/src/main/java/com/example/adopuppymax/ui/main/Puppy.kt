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
    ),
    Puppy(
        id = 1003,
        name = "Dyce",
        thumbResource = R.raw.dyce,
        breed = "Shar-Pei Mix",
        age = "4 Month",
        gender = "Male",
        size = "Large",
        color = "White / Black",
        location = "Kansas City, MO",
        healthState = "Spayed / neutered.",
        description = "Hello from the sweetest, most adorable boy there is, Dyce!\n\n" +
                "My name is Dyce and I am a happy-go-lucky boy looking for my forever home. I've been living with my foster parents for a couple of months so they know me pretty well and they say I'm goofy, happiest when I'm around people, and have a medium to low energy level.\n\n" +
                "I've lived in a foster home with small children (5 + 7) and done a good job with loving on them. I've spent some time around a female dog that I really enjoyed, but I would need to meet any potential fur sibling. I am very curious and sometimes enjoy chasing the resident cat around here, so I might do best with a home without cats.\n\n" +
                "The biggest thing for any future fur parents of mine to consider is a medical condition I have that will require a lifelong set of meds and check-ins with their vet. My foster mom can tell you more about this, but it will be the most important thing to consider before adoption as there will be costs associated with my care.\n\n" +
                "For more information, please email my foster mom at kanelson90@gmail.com."
    ),
    Puppy(
        id = 1004,
        name = "Taiko",
        thumbResource = R.raw.taiko,
        breed = "Pointer Mix",
        age = "4 Month",
        gender = "Male",
        size = "Medium",
        color = "White",
        location = "Mission, KS",
        healthState = "Spayed / neutered.",
        description = "Hi there! Taiko here! Nice to meet you.\n" +
                "I'm a two-year-old, 70 pound pointer mix that is now in a foster home with Unleashed. I am a solid, happy, playful boy that would love another dog to play with! They are my favorite. Big or small, male or female doesn't matter.\n" +
                "I love to take walks with my foster mama, am good and quiet in my kennel, and very housetrained.\n" +
                "I've had a rough past, but I'm excited for my future! Please let UPR know if you'd like to meet me. I'd love to meet you!\n" +
                "??, Taiko"
    ),
    Puppy(
        id = 1005,
        name = "Zoey",
        thumbResource = R.raw.zoey,
        breed = "Shepherd Mix",
        age = "6 Month",
        gender = "Female",
        size = "Medium",
        color = "Black, Brown / Chocolate, White / Cream",
        location = "Mission, KS",
        healthState = "Vaccinations up to date, spayed / neutered.",
        description = "Hiyee! I’m Zoey! Are you looking for a great shepherd mix to add to your home? If so, you are in luck! I happen to be looking for my forever person or family!\n" +
                "\n" +
                "I am about two years old, and I am a very athletic gal who loves to run and play. I’m really fast, too! In addition to being athletic, some of the people who know me have told me that I’m gorgeous. I don’t really know if I am because we dogs, well, we’re not really concerned about our appearances! I mean, we roll in stuff in the yard after all! But I think maybe it’s a good thing people think I’m gorgeous because it may help me get adopted.\n" +
                "\n" +
                "I can vouch for some other things on my own, though—like the fact that I’m a very sweet and loving girl. I love to receive some neck scratches. (And some good butt scratches, too, if you don’t mind!) And I can be silly—I’m still a young pup after all! I like to make people laugh."
    ),
    Puppy(
        id = 1006,
        name = "Clark",
        thumbResource = R.raw.clark,
        breed = "Beagle",
        age = "3 Month",
        gender = "Male",
        size = "Small",
        color = "Tricolor (Brown, Black, & White)",
        location = "Shawnee Mission, KS",
        healthState = "Vaccinations up to date, spayed / neutered, special needs. Clark had a rough start in life so will need extra and continued training to feel safe and reach his full potential.",
        description = "Clark is am amazing little guy thats roughly a year old! He does awesome with other dogs and enjoys playing with them and showing them all of his fun beagle noises he can make. And boy, can he make the beagle noises! He loves chew toys and chasing down toys but doesnt always return them to play fetch. Sharing in caring Clark! When hes done playing and its time to nap he loves to be on the couch cuddled up on his person's lap. Hes working hard on his manners and training. Clark is potty trained and does really well with going outside. However, Clark is in the process of completing an extensive training program to help him correct some behaviors he developed from being shuffled around from place to place with no boundaries. He will need a very special home who is willing to continue in and be very invested in continuing Clarks training and be patience with him. Clark gets along great with other dogs and cats. Clark is a little apprehensive as he has never had a loving home, therefore he would do best in a home with no or older children and a home where there are not a lot of children coming and going."
    ),
    Puppy(
        id = 1007,
        name = "Titus Blue",
        thumbResource = R.raw.titus,
        breed = "Pit Bull Terrier Mix",
        age = "7 Month",
        gender = "Male",
        size = "Medium",
        color = "Merle (Blue), White / Cream",
        location = "Shawnee, KS",
        healthState = "Vaccinations up to date, spayed / neutered, special needs. Peach is shy and fearful so needs a home with patient humans who will give her time to warm up.",
        description = "Single, young, hunk of burning love seeks forever home\n" +
                "I'm Titus Blue. I'm a 7 month old puppy in search of a true love to call my own.\n" +
                "Do you like throwing tennis balls? Walks outside on a sunshine filled day? Butt wiggles and face kisses? If so I could be the guy for you!\n" +
                "I'm not perfect, who is? But I'm willing to work on it. My soulmate wouldn't mind working with me to perfect a few furever home manners. But don't worry! I love praise and treats so it won't take long!\n" +
                "I have plenty of animal friends at the shelter, but I do best when we take introductions slow. Don't worry! The hoomans who work here can help us succeed!\n" +
                "If you are ready for your soul mate, I'm right here ready to be adopted!"
    ),
    Puppy(
        id = 1008,
        name = "Hosmer",
        thumbResource = R.raw.hosmer,
        breed = "Pit Bull Terrier Mix",
        age = "3 Years",
        gender = "Male",
        size = "Medium",
        color = "Gray / Blue / Silver",
        location = "Kansas City, MO",
        healthState = "Vaccinations up to date, spayed / neutered.",
        description = "Alright baseball fans, we know everyone is upset about Eric Hosmer leaving the Royals but we promise that his handsome furry namesake is the best sports fan you could ask for! Hosmer is a 3 year old pit bull mix that was left behind when his owners were evicted. He had a very serious skin infection that has now healed but he does have some allergies that are being managed with the right food and medications. Hosmer is still learning manners but he is working really hard and will do anything for a treat. He is fostered with others dogs and does well, especially with small dogs but he is still learning how to play nice and share. Hosmer will need a home that understands his breed and will be firm but understanding and patient. He is very energetic and is learning how to walk better on a leash but he loves car rides and is a fantastic co-pilot. Hosmer is also very vocal when he plays and when he is expressing his feelings and his foster mom says he is the best cuddle bug when he is tired. He does well with kids but he is still learning how big he is and he is unfortunately allergic to cats! If you are looking for a quirky, energetic furry family member than Hosmer is your guy!"
    ),
    Puppy(
        id = 1009,
        name = "Buttercup",
        thumbResource = R.raw.buttercup,
        breed = "Labrador & Shepherd Mix",
        age = "10 Month",
        gender = "Female",
        size = "Medium",
        color = "Yellow / Tan / Blond / Fawn",
        location = "Kansas City, KS",
        healthState = "Vaccinations up to date, spayed / neutered.",
        description = "Date of birth: 4/15/2020\n" +
                "\n" +
                "2/22/2021: Buttercup is an adorable Lab/Shepherd mix! She’s about 10 months old and she currently weighs 40 lbs. She still has some filling out to do. She’s a fun, happy pup with lots of energy! She’s affectionate and likes to give kisses and cuddle.\n" +
                "\n" +
                "• Buttercup is very playful and puppyish. She loves playing with toys and with other dogs. She’ll need a home with someone who can keep up with her energy level, or has a playful dog who’d enjoy her. If you have a dog we’d ask you to bring your dog in to meet Buttercup and see how they play together. She tends to prefer playing with dogs around her size. She isn’t comfortable playing with bigger dogs who play too rough.\n" +
                "\n" +
                "• Buttercup needs a house with a fenced yard and with someone who is home a lot or has a dog to keep her company.\n" +
                "\n" +
                "• She’s just a youngster and will need basic training to learn some manners and house training. She does keep her kennel clean here if let out often enough.\n" +
                "\n" +
                "• She’d do well with older kids who are comfortable with a bouncy, active dog. She’s too rambunctious for young kids at this point.\n" +
                "\n" +
                "• She’s never acted aggressive towards cats, but wants to play and chase them. She’d probably be fine with a cat who tolerates or even enjoys a curious and active pup, but not all cats would find her playfulness amusing.\n" +
                "\n" +
                "• Although she loves people and other dogs, she is sometimes a little timid in new situations for just a bit.\n" +
                "\n" +
                "• She loves to go for walks and is pretty easy to walk on a leash.\n" +
                "\n" +
                "• Buttercup is a sweet-natured, wonderful pup! She’ll be a great match for someone looking for a happy and energetic companion. She has been spayed, vaccinated, microchipped and tested for heartworms."
    ),
    Puppy(
        id = 1010,
        name = "Red",
        thumbResource = R.raw.red,
        breed = "Husky",
        age = "5 Month",
        gender = "Male",
        size = "Large",
        color = "White / Yellow",
        location = "Leavenworth, KS",
        healthState = "Vaccinations up to date, spayed / neutered.",
        description = "You can fill out an adoption application online on our official website."
    ),
    Puppy(
        id = 1011,
        name = "colt",
        thumbResource = R.raw.colt,
        breed = "Cattle Dog Mix",
        age = "2 Years",
        gender = "Male",
        size = "Medium",
        color = "Bicolor, Black, White / Cream",
        location = "Lexington, MO",
        healthState = "Vaccinations up to date, spayed / neutered.",
        description = "Hi! I am Colt.\n" +
                "I am affectionate (if I want to be).\n" +
                "I am sweet (if you have food).\n" +
                "I am quirky.\n" +
                "I NEED a canine buddy that will hang at with me all the time.\n" +
                "I am looking for a home that understands my feral beginnings and has the patience and compassion to let me be me.\n" +
                "I am an attractive 2-3 years old neutered male about 45 lbs.\n" +
                "Please contact my foster mom for details.\n" +
                "\n" +
                "*Colt came from a hoarding situation and only ever around one person. He is good with other dogs. He is currently attached to one dog in his foster home and will need a companion in his new home to help him open up. He is never agressive with people but will take a lot of patience and understanding to gain his trust. He is doing great meeting people now for treats but he still can not be leashed. A fenced in yard is a MUST. He is crate trained and will go in on command. He loads in the vehicle by following his dog friend.\n" +
                "He is fixed and up to date on his shots. He is ready to try to find his forever home.\n" +
                "Odessa Mo."
    ),
    Puppy(
        id = 1012,
        name = "Toby",
        thumbResource = R.raw.toby,
        breed = "Pomeranian",
        age = "8 Month",
        gender = "Male",
        size = "Small",
        color = "Apricot / Beige",
        location = "Auburn, KS",
        healthState = "Vaccinations up to date, spayed / neutered.",
        description = "Toby loves to jump and around and play with other dogs. He is lively and energetic. He has no aggression issues. He needs an energetic and busy family. Go to scarsusa.com to fill out an application...he is not listed yet, but go ahead anyway."
    )
)
