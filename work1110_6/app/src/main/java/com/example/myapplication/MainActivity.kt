package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_toast = findViewById<Button>(R.id.btn_toast)
        val btn_custom = findViewById<Button>(R.id.btn_custom)
        val btn_dialog1 = findViewById<Button>(R.id.btn_dialog1)
        val btn_dialog2 = findViewById<Button>(R.id.btn_dialog2)
        val btn_dialog3 = findViewById<Button>(R.id.btn_dialog3)

        val list_item = arrayOf("對話框選項1","對話框選項2","對話框選項3","對話框選項4","對話框選項5")

        btn_toast.setOnClickListener{
            Toast.makeText(this,"預設Toast",Toast.LENGTH_SHORT).show()
        }

        btn_dialog1.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("按鍵式對話框")
                .setMessage("對話框內容")
                .setNeutralButton("左按鈕"){dialog,which ->
                    Toast.makeText(this,"左按鈕",Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("中按鈕"){dialog,which ->
                    Toast.makeText(this,"中按鈕",Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("右按鈕"){dialog,which ->
                    Toast.makeText(this,"右按鈕",Toast.LENGTH_SHORT).show()
                }.show()
        }

        btn_custom.setOnClickListener {

            val toast = Toast(this)

            toast.setGravity(Gravity.TOP, 0, 50)

            toast.duration = Toast.LENGTH_SHORT

            toast.view =
                layoutInflater.inflate(R.layout.custom_toast, null)

            toast.show()
        }

        btn_dialog2.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("列表式對話框")
                .setItems(list_item){ dialogInterface,i->
                    Toast.makeText(this,"你選的是"+list_item[i],
                        Toast.LENGTH_SHORT).show()

                }.show()
        }

        btn_dialog3.setOnClickListener {
            var position = 0
            AlertDialog.Builder(this)
                .setTitle("單選式對話框")
                .setSingleChoiceItems(list_item,0){
                        dialogInterface,i-> position=i
                }
                .setPositiveButton("確定"){dialog,which->
                    Toast.makeText(this,"你選的是"+
                            list_item[position],Toast.LENGTH_SHORT).show()
                }.show()
        }
    }

}



