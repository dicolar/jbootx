package org.alfalfa.fx

import javafx.application.Application
import org.alfalfa.fx.core.Scenes
import org.alfalfa.fx.misc.App
import org.alfalfa.fx.misc.JBootXPreloader
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.system.exitProcess

/**
 * @Author : Val
 * @Created : 2016-01-12
 * @Version : 1.0
 */
class JBootXTests {
    @Test
    fun testBootstrap2() {
        boot(Scenes.ThemeEnum.BOOTSTRAP2)
    }

    @Test
    fun testBootstrap3() {
        boot(Scenes.ThemeEnum.BOOTSTRAP3)
    }

    private fun boot(theme: Scenes.ThemeEnum) {
        Locale.setDefault(Locale.ENGLISH);
        System.setProperty("javafx.preloader", JBootXPreloader::class.java.name)
        Application.launch(App::class.java, theme.name)
        exitProcess(0)
    }
}
