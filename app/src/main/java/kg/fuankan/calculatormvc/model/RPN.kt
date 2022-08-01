package kg.fuankan.calculatormvc.model

import java.util.*
import java.util.Map


class RPN {

    fun calculate(s: String): String {
        var s1 = s
        val stack: Stack<Double> = Stack()
        s1.replace("\\( ?-".toRegex(), "\\(0-").also { s1 = it }
        convertToRPN(s1).also { s1 = it }
        val ss = s1.split(" ").toTypedArray()
        for (i in ss.indices) {
            if (isNumber(ss[i])) {
                stack.push(ss[i].toDouble())
            } else {
                val b = stack.pop()
                val a = stack.pop()
                val c: Double = when (ss[i]) {
                    "+" -> a + b
                    "-" -> a - b
                    "*" -> a * b
                    "/" -> a / b
                    else -> 0.0
                }
                stack.push(c)
            }
        }
        return stack.pop().toString()
    }

    private fun addSpaces(s: String): String {
        var s1 = s
        s1 = s1.replace(" ".toRegex(), "")
        s1 = s1.replace("(?<=[0-9)])([+\\-*/])(?=[0-9(])".toRegex(), " $1 ")
        s1 = s1.replace("(\\()".toRegex(), "$1 ")
        s1 = s1.replace("(\\))".toRegex(), " $1")
        return s1
    }

    private fun isNumber(s: String): Boolean {
        return try {
            s.toDouble()
            true
        } catch (e: Exception) {
            false
        }
    }

    private val priority = Map.ofEntries(
        Map.entry("(", 0),
        Map.entry(")", 0),
        Map.entry("+", 1),
        Map.entry("-", 1),
        Map.entry("*", 2),
        Map.entry("/", 2)
    )

    private fun convertToRPN(str: String): String {
        var s1 = str
        s1 = addSpaces(s1)
        val sArr = s1.split(" ").toTypedArray()
        val result = StringBuilder()
        val stack: Stack<String> = Stack()
        for (i in sArr.indices) {
            if (isNumber(sArr[i])) {
                result.append(sArr[i])
                result.append(" ")
            } else if (sArr[i] == "(") {
                stack.push(sArr[i])
            } else if (sArr[i] == ")") {
                var op = stack.pop()
                while (op != "(") {
                    result.append(op)
                    result.append(" ")
                    op = stack.pop()
                }
            } else {
                while (!stack.empty() && !stack.peek()
                        .equals("(") && priority[stack.peek()]!! >= priority[sArr[i]]!!
                ) {
                    result.append(stack.pop())
                    result.append(" ")
                }
                stack.push(sArr[i])
            }
        }
        while (!stack.empty()) {
            result.append(stack.pop())
            result.append(" ")
        }
        result.deleteCharAt(result.length - 1)
        return result.toString()
    }
}
