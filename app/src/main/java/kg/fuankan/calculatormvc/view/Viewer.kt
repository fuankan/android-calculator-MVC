package kg.fuankan.calculatormvc.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kg.fuankan.calculatormvc.controller.Controller
import kg.fuankan.calculatormvc.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class Viewer : AppCompatActivity() {

    private var controller: Controller
    private lateinit var binding: ActivityMainBinding

    private var viewArray: ArrayList<Button>

    init {
        controller = Controller(this)
        viewArray = ArrayList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnClear.setOnClickListener { clear() }
            btnEqual.setOnClickListener(controller)
            Collections.addAll(
                viewArray, btnOpenBrace, btnCloseBrace, btnDivide, btnSeven, btnEight, btnNine,
                btnMultiply, btnFour, btnFive, btnSix, btnMinus, btnOne, btnTwo, btnThree, btnPlus,
                btnDot, btnZero,
            )
        }
        for (element in viewArray) {
            element.setOnClickListener { addToCurrent(element.tag.toString()) }
        }
    }

    fun getCurrent(): String {
        return binding.tvCurrent.text.toString()
    }


    private fun clear() {
        binding.tvCurrent.text = ""
    }

    private fun addToCurrent(command: String) {
        binding.tvCurrent.append(command)
    }

    fun updateCurrent(command: String) {
        binding.tvCurrent.text = ""
        binding.tvCurrent.text = command
    }
}
