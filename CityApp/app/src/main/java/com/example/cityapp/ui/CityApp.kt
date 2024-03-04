package com.example.cityapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.cityapp.R
import com.example.cityapp.data.LocalRecommendationDataProvider

enum class CityAppScreen(val route: String) {
    Categories("categories"),
    Recommendations("recommendations/{category}"),
    RecommendationDetail("recommendation_detail/{recommendationId}")
}

@Composable
fun CityApp(
    windowSize: WindowWidthSizeClass,
    onBackPressed: () -> Unit,
) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = CityAppScreen.Categories.route) {
        composable(CityAppScreen.Categories.route) {
            CategoryListScreen(
                onCategorySelected = { category ->
                    navController.navigate(
                        "${
                            CityAppScreen.Recommendations.route.replace(
                                "{category}",
                                category
                            )
                        }"
                    )
                }
            )
        }
        composable(
            CityAppScreen.Recommendations.route,
            arguments = listOf(navArgument("category") { type = NavType.StringType })
        ) { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category")
            if (category != null) {
                RecommendationListScreen(
                    category = category,
                    onRecommendationSelected = { recommendationId ->
                        navController.navigate(
                            "${
                                CityAppScreen.RecommendationDetail.route.replace(
                                    "{recommendationId}",
                                    recommendationId
                                )
                            }"
                        )
                    }
                )
            }
        }
        composable(
            CityAppScreen.RecommendationDetail.route,
            arguments = listOf(navArgument("recommendationId") { type = NavType.StringType })
        ) { backStackEntry ->
            val recommendationId = backStackEntry.arguments?.getString("recommendationId")
            if (recommendationId != null) {
                RecommendationDetailScreen(
                    recommendationId = recommendationId,
                    onNavigateUp = { navController.popBackStack() }
                )
            }
        }
    }
}

@Composable
fun CategoryListScreen(onCategorySelected: (String) -> Unit) {
    val categories = LocalRecommendationDataProvider.recommendations
        .map { it.category }
        .distinct()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn {
            items(categories) { category ->
                Text(
                    text = stringResource(category),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onCategorySelected(category.toString()) }
                        .padding(16.dp),
                    fontSize = 18.sp
                )
            }
        }
    }

}

@Composable
fun RecommendationListScreen(
    category: String,
    onRecommendationSelected: (String) -> Unit
) {
    val recommendations = LocalRecommendationDataProvider.recommendations
        .filter { it.category.toString() == category }

    LazyColumn {
        itemsIndexed(recommendations) { index, recommendation ->
            Text(
                text = stringResource(recommendation.name),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onRecommendationSelected(recommendation.id.toString()) }
                    .padding(16.dp),
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun RecommendationDetailScreen(
    recommendationId: String,
    onNavigateUp: () -> Unit
) {
    val recommendation = LocalRecommendationDataProvider.recommendations
        .firstOrNull { it.id.toString() == recommendationId }

    if (recommendation != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = stringResource(recommendation.name),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(9.dp))
            Text(text = stringResource(recommendation.category), fontSize = 18.sp)
            Spacer(modifier = Modifier.height(9.dp))
            Text(
                text = stringResource(recommendation.address),
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(9.dp))
            Text(text = stringResource(recommendation.description), fontSize = 16.sp)
            Spacer(modifier = Modifier.height(18.dp))
            Image(
                painter = painterResource(id = recommendation.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(9.dp)),
                contentScale = ContentScale.Crop
            )
        }
    } else {
        Text(stringResource(id = R.string.not_found_message))
    }
}


@Preview
@Composable
fun CategoryListScreenPreview() {
    CategoryListScreen {}
}

@Preview
@Composable
fun RecommendationListScreenPreview() {
    RecommendationListScreen(stringResource(R.string.park_1)) {
    }
}

@Preview
@Composable
fun RecommendationDetailScreenPreview() {
    RecommendationDetailScreen("1") {}
}