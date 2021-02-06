package com.example.takeahike

import org.koin.dsl.module
import java.util.Collections.singleton

val appModule = module {
    single { ToolbarDesigner() }
}