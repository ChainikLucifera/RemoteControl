package com.example.remotecontrol

import android.os.Bundle
import android.view.View.OnClickListener
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
                    workingText.text = "${workingText.text} ${text}"
                }
            }
        }

        with(binding){
            controlZeroBtn.setOnClickListener(numberBtnListener)
            controlOneBtn.setOnClickListener(numberBtnListener)
            controlEnterBtn.setOnClickListener {
                if(workingText.text.isNotEmpty()){
                    selectedText.text = workingText.text
                }
                workingText.text = "0"
            }
        }

    }
}