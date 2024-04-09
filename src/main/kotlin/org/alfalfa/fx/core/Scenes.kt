package org.alfalfa.fx.core

import javafx.scene.Parent
import javafx.scene.Scene
import java.net.URL

class Scenes internal constructor(private val builder: Builder) {

    enum class ThemeEnum(val filename: String) {
        BOOTSTRAP2("bootstrap2.css"), BOOTSTRAP3("bootstrap3.css")
    }

    internal class Builder {
        var theme: ThemeEnum = ThemeEnum.BOOTSTRAP2
        var externalCssFiles = mutableListOf<URL>()

        fun theme(theme: ThemeEnum) = apply { this.theme = theme }
        fun externalCssFiles(vararg urls: URL) = apply { this.externalCssFiles.addAll(urls) }
        fun build() = Scenes(this)
    }

    fun applyStyles(scene: Scene): Scene {
        scene.stylesheets.add(
            Scenes::class.java.classLoader.getResource(builder.theme.filename)!!.toExternalForm()
        )
        scene.stylesheets.addAll(builder.externalCssFiles.mapNotNull { it.toExternalForm() })
        return scene
    }

	fun create(root: Parent, width: Double, height: Double): Scene {
        return applyStyles(Scene(root, width, height))
    }
}
