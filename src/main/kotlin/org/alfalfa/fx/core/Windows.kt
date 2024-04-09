package org.alfalfa.fx.core

import javafx.fxml.FXMLLoader
import javafx.stage.Stage

object Windows {

    fun <C : AbstractController> create(scenes: Scenes, loader: FXMLLoader, stage: Stage? = null): WindowStub<C> {
        return WindowStub(Controllers.create(scenes, loader, stage))
    }

}
