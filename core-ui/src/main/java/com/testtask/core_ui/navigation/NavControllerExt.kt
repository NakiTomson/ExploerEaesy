package com.testtask.core_ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph

fun NavController.changeNodeDestination(nodeId: Int, destinationId: Int): NavController {
    val graph = graph.findNode(nodeId) as NavGraph
    graph.setStartDestination(destinationId)
    return this
}
