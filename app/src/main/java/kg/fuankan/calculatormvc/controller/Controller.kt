package kg.fuankan.calculatormvc.controller

import android.view.View
import kg.fuankan.calculatormvc.model.Model
import kg.fuankan.calculatormvc.view.Viewer

class Controller: View.OnClickListener {

    var model: Model

    constructor(viewer: Viewer) {
        model = Model(viewer)
    }

    override fun onClick(p0: View?) {
        model.calculate()
    }
}