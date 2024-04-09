package org.alfalfa.fx.misc

import javafx.application.Application
import javafx.application.Platform
import javafx.event.EventHandler
import javafx.stage.Stage
import javafx.stage.WindowEvent
import org.alfalfa.fx.controller.OverviewController
import org.alfalfa.fx.core.FXLoader.load
import org.alfalfa.fx.core.Scenes
import org.alfalfa.fx.core.Windows.create
import java.io.IOException
import kotlin.system.exitProcess

class App : Application() {

    private lateinit var scenes: Scenes

    @Throws(Exception::class)
    override fun init() {
        scenes = Scenes.Builder().theme(parameters.unnamed.firstOrNull()?.let { Scenes.ThemeEnum.valueOf(it) }?: Scenes.ThemeEnum.BOOTSTRAP2).build()
    }

    @Throws(IOException::class)
    override fun start(primaryStage: Stage) {
        primaryStage.properties["app"] = this

        primaryStage.onCloseRequest = EventHandler { _: WindowEvent? ->
            Platform.exit()

            exitProcess(0)
        }

        primaryStage.title = "JBootX"
//        Windows.WINDOW_TITLE_ICON = Image(logo.inputStream)

        val fxml = javaClass.classLoader.getResource("bootstrap3overview.fxml")
        create<OverviewController>(scenes, load(fxml), primaryStage).size(1280, 800).show()
    }
}
