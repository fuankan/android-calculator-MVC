package kg.fuankan.calculatormvc.model

import kg.fuankan.calculatormvc.view.Viewer

class Model {

    val viewer: Viewer

    constructor(viewer: Viewer) {
        this.viewer = viewer
    }

    fun plus() {
        val tv = viewer.getTV()

        var tvInt = tv.toInt()
        tvInt += 1

        viewer.upload(tvInt.toString())
    }
}