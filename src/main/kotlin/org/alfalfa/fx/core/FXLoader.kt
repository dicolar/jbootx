package org.alfalfa.fx.core

import javafx.fxml.FXMLLoader
import javafx.scene.image.Image
import javafx.util.Callback
import java.io.IOException
import java.io.InputStream
import java.net.URL

object FXLoader {
    @JvmField
	var controllerFactory: Callback<Class<*>, Any>? = null

    fun load(url: URL): FXMLLoader {
        val loader = FXMLLoader(url)
        if (controllerFactory != null) loader.controllerFactory = controllerFactory
        try {
            loader.load<Any>()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return loader
    }

    fun load(cls: Class<*>, fxmlName: String): FXMLLoader {
        var fxmlName = fxmlName
        if (!fxmlName.endsWith(".fxml")) fxmlName += ".fxml"
        val loader = FXMLLoader(cls.getResource(fxmlName))
        if (controllerFactory != null) loader.controllerFactory = controllerFactory
        try {
            loader.load<Any>()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return loader
    }

    fun getImage(cls: Class<*>, imageName: String): Image? {
        val stream = cls.getResourceAsStream(imageName) ?: return null
        return Image(stream)
    }

	fun getImage(stream: InputStream?): Image? {
        return if (stream == null) null else Image(stream)
    }
}
