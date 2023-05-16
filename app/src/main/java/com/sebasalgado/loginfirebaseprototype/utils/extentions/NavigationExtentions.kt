package com.sebasalgado.loginfirebaseprototype.utils.extentions

import android.widget.ImageView
import androidx.navigation.findNavController


fun ImageView.setBackAction() {
    this.setOnClickListener { this.findNavController().navigateUp() }
}

