package org.alfalfa.fx.core

import javafx.scene.Parent
import javafx.scene.image.Image
import javafx.stage.Modality
import javafx.stage.StageStyle
import javafx.stage.Window

open class WindowStub<T : AbstractController>(@JvmField val controller: T) {
    fun <R : Parent?> getRoot(): R {
        return controller.stage.scene.root as R
    }

    fun size(width: Int, height: Int): WindowStub<T> {
        return width(width).height(height)
    }

    fun modal(): WindowStub<T> {
        controller.stage.initModality(Modality.APPLICATION_MODAL)
        return this
    }

    fun wmodal(): WindowStub<T> {
        controller.stage.initModality(Modality.WINDOW_MODAL)
        return this
    }

    fun width(width: Int): WindowStub<T> {
        controller.stage.width = width.toDouble()
        return this
    }

    fun height(height: Int): WindowStub<T> {
        controller.stage.height = height.toDouble()
        return this
    }

    fun owner(window: Window?): WindowStub<T> {
        controller.stage.initOwner(window)
        return this
    }

    fun windowTitle(title: String?): WindowStub<T> {
        controller.stage.title = title
        return this
    }

    fun icon(image: Image?): WindowStub<T> {
        controller.stage.icons.add(image)
        return this
    }

    fun show() {
        controller.stage.show()
    }

    fun showAndWait() {
        controller.stage.showAndWait()
    }

    fun style(style: StageStyle?): WindowStub<T> {
        controller.stage.initStyle(style)
        return this
    }

    fun resizable(resizable: Boolean): WindowStub<T> {
        controller.stage.isResizable = resizable
        return this
    }

    fun close() {
        controller.stage.close()
    }
}
