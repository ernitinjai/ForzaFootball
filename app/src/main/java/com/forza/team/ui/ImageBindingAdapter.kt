package com.forza.team.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.forza.team.R
import com.squareup.picasso.Picasso

class ImageBindingAdapter {
    companion object {
        @BindingAdapter("bind:teamBadgeIcon")
        @JvmStatic
        fun loadBadgeIcon(imageView: ImageView, teamId: Long) {
            Picasso.with(imageView.context)
                .load(imageView.context.getString(R.string.badge_url, teamId))
                .into(imageView)
        }
    }
}