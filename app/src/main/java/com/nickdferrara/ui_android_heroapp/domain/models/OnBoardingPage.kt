package com.nickdferrara.ui_android_heroapp.domain.models

import androidx.annotation.DrawableRes
import com.nickdferrara.ui_android_heroapp.R

sealed class OnBoardingPage(

    @DrawableRes
    val image: Int,
    val title: String,
    val description: String,
) {
    object First: OnBoardingPage(
        image = R.drawable.greetings,
        title = "Greetings",
        description = "Are you a fan of great heroes? Well, you're in store for a great app!"
    )

    object Second: OnBoardingPage(
        image = R.drawable.explore,
        title = "Explore",
        description = "Find your favorite heroes and lean some of the things that you didn't know about!"
    )

    object Third: OnBoardingPage(
        image = R.drawable.power,
        title = "Power",
        description = "Check out your hero's power and see how much they are strong and how the " +
                "compare to other heroes!"
    )
}
