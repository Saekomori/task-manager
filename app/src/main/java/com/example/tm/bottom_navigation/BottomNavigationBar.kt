package com.example.tm.bottom_navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val listItems = listOf(
        BottomItem.TaskScreen,
        BottomItem.GroupsScreen,
        BottomItem.SettingScreen
    )
    BottomNavigation(
        modifier = Modifier,
        backgroundColor = Color.White
    ) {
       val backStackEntry by navController.currentBackStackEntryAsState()
       val currentRoute = backStackEntry?.destination?.route
       listItems.forEach { item->
           BottomNavigationItem(

               selected = currentRoute == item.route,
               onClick = {
                    navController.navigate(item.route)
               },
               icon = {
                   Icon(
                       painter = painterResource(id = item.iconId),
                       contentDescription = "Icon"
                   )
               },
               label = {
                   Text(
                       text = item.title,
                       fontSize = 9.sp
                   )
               },
               selectedContentColor = Color.Blue,
               unselectedContentColor = Color.Gray
           )
       }
    }
}