package ru.alexandrorlov.smarthome.ui.component.tabs

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ru.alexandrorlov.smarthome.ui.theme.SHTypography
import ru.alexandrorlov.smarthome.ui.theme.background
import ru.alexandrorlov.smarthome.ui.theme.backgroundTabIndicator
import ru.alexandrorlov.smarthome.ui.theme.heightIndicator


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabsNavigation(
    tabs: List<TabNavItem>,
    pagerState: PagerState
) {
    val scope = rememberCoroutineScope()

    TabRow(
        modifier = Modifier
            .fillMaxWidth(),
        selectedTabIndex = pagerState.currentPage,
        containerColor = background,
        indicator = { tabPosition ->
            TabRowDefaults.Indicator(
                modifier = Modifier
//                    .pagerTabIndicatorOffset(
//                        pagerState = pagerState,
//                        tabPositions = tabPosition
//                    )
                    .tabIndicatorOffset(
                        tabPosition[pagerState.currentPage]
                    ),
                height = heightIndicator,
                color = backgroundTabIndicator
            )
        }
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = stringResource(id = tab.titleId),
                        style = SHTypography.titleMedium,
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun TabsNavigationPreview() {
    val tabs = listOf(
        TabNavItem.Cameras,
        TabNavItem.Doors
    )
    val pagerState = rememberPagerState { tabs.size }

    TabsNavigation(
        tabs = tabs,
        pagerState = pagerState
    )
}