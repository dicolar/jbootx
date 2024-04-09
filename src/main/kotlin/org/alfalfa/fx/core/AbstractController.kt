package org.alfalfa.fx.core

import javafx.beans.property.SimpleObjectProperty
import javafx.stage.Stage

/**
 * @Author : Val
 * @Created : 2016-01-04
 * @Version : 1.0
 */
abstract class AbstractController {
    val stageProperty = SimpleObjectProperty<Stage>().apply {
        addListener { _, _, newValue: Stage ->
            stageSwitched(newValue)
        }
    }

    val stage: Stage
        get() = stageProperty.get()

    protected open fun stageSwitched(stage: Stage) {}
}
