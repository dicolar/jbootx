package org.alfalfa.fx.core

import javafx.fxml.FXMLLoader
import javafx.scene.image.Image
import javafx.stage.Stage

/**
 * @author : Val
 * created : 2022-04-21
 * @version : 1.0
 */
object Controllers {
    fun <C : AbstractController> create(scenes: Scenes, loader: FXMLLoader, stage: Stage? = null, iconProvider: (()-> Image)? = null): C {
        val controller = loader.getController<C>() ?: throw RuntimeException("no controller is specified for fxml:" + loader.location)

        controller.stageProperty.set(stage?: Stage())

        // set window icon
        iconProvider?.invoke()?.run { controller.stage.icons.add(this) }
        controller.stage.scene = scenes.create(loader.getRoot(), 400.0, 300.0)
        return controller
    }
}
