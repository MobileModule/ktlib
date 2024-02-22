package com.druid.base.ext.view

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView

fun EditText.afterTextChange(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            TODO("Not yet implemented")
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            TODO("Not yet implemented")
        }

        override fun afterTextChanged(s: Editable?) {
            afterTextChanged.invoke(s.toString())
        }

    })
}

fun EditText.textString(): String {
    return this.text.toString()
}

fun EditText.textStringTrim(): String {
    return this.textString().trim()
}

fun EditText.isEmpty(): Boolean {
    return this.textString().isEmpty()
}

fun EditText.isTrimEmpty(): Boolean {
    return this.textStringTrim().isEmpty()
}

fun TextView.textString(): String {
    return this.text.toString()
}

fun TextView.textStringTrim(): String {
    return this.textString().trim()
}

fun TextView.isEmpty(): Boolean {
    return this.textString().isEmpty()
}

fun TextView.isTrimEmpty(): Boolean {
    return this.textStringTrim().isEmpty()
}