package kg.fuankan.calculatormvc.model

import kg.fuankan.calculatormvc.view.Viewer

class Model {

    private var viewer: Viewer
    private var rpn: RPN

    constructor(viewer: Viewer) {
        this.viewer = viewer
        rpn = RPN()
    }

    fun calculate() {
        val expression = viewer.getCurrent()
        viewer.updateCurrent(rpn.calculate(expression))

    }
}