package com.example.tp1

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout

import android.graphics.Color

const val COLOR_BY_DEFAULT = Color.BLACK

class CustomComponent(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private var image: ImageView
    private var editText: EditText

    init {

        inflate(context, R.layout.custom_component, this)
        image = findViewById(R.id.image)
        editText = findViewById(R.id.editText)

        val componentAttributes = context.obtainStyledAttributes(attrs, R.styleable.CustomComponent)
        image.setImageDrawable(componentAttributes.getDrawable(R.styleable.CustomComponent_src))
        editText.setText(componentAttributes.getString(R.styleable.CustomComponent_text))
        editText.setTextColor(componentAttributes.getColor(R.styleable.CustomComponent_textColor, COLOR_BY_DEFAULT))

        componentAttributes.recycle()

    }


}