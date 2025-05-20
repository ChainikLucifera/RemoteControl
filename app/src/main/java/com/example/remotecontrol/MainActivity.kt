package com.example.remotecontrol

import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.TableRow
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.remotecontrol.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        val numberBtnListener = OnClickListener { view ->
            val text = (view as AppCompatButton).text
            with(binding) {
                if (workingText.text.equals("0")) {
                    workingText.text = text
                } else {
                    workingText.text = "${workingText.text} $text"
                }
            }
        }

        with(binding) {
//            controlZeroBtn.setOnClickListener(numberBtnListener)
//            controlOneBtn.setOnClickListener(numberBtnListener)
//            controlEnterBtn.setOnClickListener {
//                if(workingText.text.isNotEmpty()){
//                    selectedText.text = workingText.text
//                }
//                workingText.text = "0"
//            }

            var number = 1
            for (i in 2 until (tableLayout.childCount - 1)) {
                val row: TableRow = tableLayout.getChildAt(i) as TableRow
                for (j in 0 until row.childCount) {
                    val button: AppCompatButton = row.getChildAt(j) as AppCompatButton
                    button.text = "$number"
                    button.setOnClickListener(numberBtnListener)
                    number++
                }
            }

            val bottomRow = tableLayout.getChildAt(tableLayout.childCount - 1) as TableRow

            val deleteButton = bottomRow.getChildAt(0) as AppCompatButton
            deleteButton.text = "Delete"
            deleteButton.setOnClickListener {
                workingText.text = "0"
            }

            val zeroButton = bottomRow.getChildAt(1) as AppCompatButton
            zeroButton.text = "0"
            zeroButton.setOnClickListener(numberBtnListener)

            val enterButton = bottomRow.getChildAt(2) as AppCompatButton
            enterButton.text = "Enter"
            enterButton.setOnClickListener {
                if (workingText.text.isNotEmpty()) {
                    selectedText.text = workingText.text
                }
                workingText.text = "0"
            }
        }

    }
}