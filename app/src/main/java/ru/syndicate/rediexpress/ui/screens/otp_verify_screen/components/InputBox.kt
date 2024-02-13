package ru.syndicate.rediexpress.ui.screens.otp_verify_screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.rediexpress.ui.theme.CustomYellow
import ru.syndicate.rediexpress.ui.theme.MainBlue
import ru.syndicate.rediexpress.ui.theme.TextBlack

@Composable
fun InputBox(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    focusRequester: FocusRequester
) {

    BasicTextField(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = CustomYellow,
                shape = RoundedCornerShape(0.dp)
            )
            .wrapContentSize()
            .focusRequester(focusRequester),
        value = value,
        onValueChange = onValueChange,
        readOnly = false,
        maxLines = 1,
        cursorBrush = SolidColor(MainBlue),
        textStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = TextBlack
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = null
        )
    ) { innerTextField ->  
        
        Box(
            modifier = Modifier
                .size(32.dp),
            contentAlignment = Alignment.Center
        ) {
            innerTextField()
        }
    }
}