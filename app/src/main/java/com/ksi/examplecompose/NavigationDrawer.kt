package com.ksi.examplecompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DrawerHeader() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(text = "Header", fontSize = 20.sp)
    }

}
/* weight(1f)
take rest of row
 */
@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(fontSize = 14.sp),
    onClickItem: (MenuItem) -> Unit
) {
    LazyColumn(modifier = modifier) {
      items(items){item->
          Row(modifier= Modifier
              .fillMaxWidth()
              .clickable { onClickItem(item) }
              .padding(10.dp)

          ) {
              Icon(imageVector = item.icon, contentDescription =null )
             Spacer(modifier = Modifier.width(16.dp))
              Text(text =item.title
                 ,modifier=Modifier.weight(1f),
                  style = textStyle
              )

          }
      }
    }
}

data class MenuItem(
    val id: String,
    val title: String,
    val icon: ImageVector

)