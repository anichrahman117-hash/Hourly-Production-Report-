package com.hourlyproduction.report

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { HourlyProductionApp() }
    }
}

private enum class AppRole { ADMIN, EMPLOYEE }

@Composable
private fun HourlyProductionApp() {
    var role by remember { mutableStateOf(AppRole.ADMIN) }
    var page by remember { mutableStateOf("Dashboard") }

    val adminMenu = listOf(
        "Dashboard", "Production Reports", "Target Management",
        "Buyer & Style", "Employee Access", "Production History",
        "Daily Summary", "Line Performance", "Settings"
    )
    val employeeMenu = listOf("Dashboard", "Production Entry", "My Production History")
    val menu = if (role == AppRole.ADMIN) adminMenu else employeeMenu

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBarCompat(
                    title = "HOURLY PRODUCTION REPORT",
                    subtitle = if (role == AppRole.ADMIN) "Admin Panel" else "Employee Panel"
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier.padding(padding).fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SingleChoiceSegmentedButtonRowCompat(
                    role = role,
                    onRoleChange = {
                        role = it
                        page = "Dashboard"
                    }
                )
                Text(page, style = MaterialTheme.typography.headlineSmall)
                Text(
                    if (role == AppRole.ADMIN)
                        "৩টি Floor · ৩০টি Sewing Line"
                    else
                        "অনুমোদিত Floor-এর Production Entry"
                )
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(menu) { item ->
                        OutlinedButton(
                            onClick = { page = item },
                            modifier = Modifier.fillMaxWidth()
                        ) { Text(item) }
                    }
                }
                Text(
                    "প্রাথমিক Android project scaffold — Login, database ও sync সংযুক্তির কাজ বাকি।",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBarCompat(title: String, subtitle: String) {
    Column(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 10.dp)) {
        Text(title, style = MaterialTheme.typography.titleMedium)
        Text(subtitle, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
private fun SingleChoiceSegmentedButtonRowCompat(
    role: AppRole,
    onRoleChange: (AppRole) -> Unit
) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        FilterChip(
            selected = role == AppRole.ADMIN,
            onClick = { onRoleChange(AppRole.ADMIN) },
            label = { Text("Admin") }
        )
        FilterChip(
            selected = role == AppRole.EMPLOYEE,
            onClick = { onRoleChange(AppRole.EMPLOYEE) },
            label = { Text("Employee") }
        )
    }
}
