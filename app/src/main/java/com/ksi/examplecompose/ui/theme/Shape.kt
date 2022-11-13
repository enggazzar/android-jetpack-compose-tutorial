package com.ksi.examplecompose.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)
val BottomShape = Shapes(medium = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp))
val SearchShape = Shapes(medium = RoundedCornerShape(12.dp))