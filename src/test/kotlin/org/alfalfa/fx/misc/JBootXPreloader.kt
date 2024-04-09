package org.alfalfa.fx.misc

import javafx.application.Preloader
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.image.ImageView
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.BorderPane
import javafx.scene.paint.Color
import javafx.stage.Stage
import javafx.stage.StageStyle

/**
 * @Author : Val
 * @Created : 2016-01-09
 * @Version : 1.0
 */
class JBootXPreloader : Preloader() {
    private lateinit var stage: Stage
    private lateinit var label: Label

    override fun start(stage: Stage) {
        this.stage = stage
        val iv = ImageView()
        iv.fitHeight = 400.0
        iv.fitWidth = 600.0
//        iv.image = ImageHelper["repoint-splash"]
        label = Label()
        label.textFill = Color.web("#aeaeae")
        val anchorPane = AnchorPane(iv, label)
        AnchorPane.setBottomAnchor(label, 5.0)
        AnchorPane.setRightAnchor(label, 5.0)
        val borderPane = BorderPane(anchorPane)
        stage.initStyle(StageStyle.TRANSPARENT)
        stage.scene = Scene(borderPane, 600.0, 400.0)
        stage.show()
    }

    override fun handleStateChangeNotification(info: StateChangeNotification) {
        when (info.type) {
            StateChangeNotification.Type.BEFORE_INIT -> label.text = "Loading..."
            StateChangeNotification.Type.BEFORE_START -> stage.close()
            else -> label.text = "Left actions..."
        }
    }
}
