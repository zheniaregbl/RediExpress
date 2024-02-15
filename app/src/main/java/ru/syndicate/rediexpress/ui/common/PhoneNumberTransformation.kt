package ru.syndicate.rediexpress.ui.common

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import kotlin.math.absoluteValue

class PhoneNumberTransformation(private val mask: String) : VisualTransformation {

    private val specialSymbolsIndices = mask.indices.filter { mask[it] != '#' }

    override fun filter(text: AnnotatedString): TransformedText {
        return makeFilter(text, mask, specialSymbolsIndices)
    }
}

private fun makeFilter(text: AnnotatedString, mask: String, specialSymbolsIndices: List<Int>): TransformedText {

    // +N NNN NNN NN NN

    var out = ""
    var maskIndex = 0
    text.forEach { char ->
        while (specialSymbolsIndices.contains(maskIndex)) {
            out += mask[maskIndex]
            maskIndex++
        }
        out += char
        maskIndex++
    }
    return TransformedText(AnnotatedString(out), offsetTranslator(mask))
}

private fun offsetTranslator(mask: String) = object : OffsetMapping {
    override fun originalToTransformed(offset: Int): Int {
        val offsetValue = offset.absoluteValue
        if (offsetValue == 0) return 0
        var numberOfHashtags = 0
        val masked = mask.takeWhile {
            if (it == '#') numberOfHashtags++
            numberOfHashtags < offsetValue
        }
        return masked.length + 1
    }

    override fun transformedToOriginal(offset: Int): Int {
        return mask.take(offset.absoluteValue).count { it == '#' }
    }
}