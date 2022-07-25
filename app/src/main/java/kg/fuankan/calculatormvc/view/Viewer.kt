package kg.fuankan.calculatormvc.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kg.fuankan.calculatormvc.R
import kg.fuankan.calculatormvc.controller.Controller

class Viewer : AppCompatActivity() {

    private val controller: Controller

    private lateinit var textView: TextView
    private lateinit var button: Button

    init {
        controller = Controller(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)

        button.setOnClickListener(controller)
    }

    fun getTV(): String {
        return textView.text.toString()
    }

    fun upload(command: String) {
        textView.text = command
    }


}