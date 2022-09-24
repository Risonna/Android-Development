package com.example.nestedlayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView1: TextView = findViewById(R.id.Textview1L1);
        var textView2: TextView = findViewById(R.id.Textview1L2);
        var textView3: TextView = findViewById(R.id.textView1C1);
        var textView4: TextView = findViewById(R.id.Textview2L1);
        var textView5: TextView = findViewById(R.id.Textview2L2);
        var textView6: TextView = findViewById(R.id.textView2C1);
        var textView7: TextView = findViewById(R.id.Textview3L1);
        var textView8: TextView = findViewById(R.id.Textview3L2);
        var textView9: TextView = findViewById(R.id.textView3C1);

        var b_: Int = 1
        var i_: Int = 2

        var rollButton: Button = findViewById(R.id.MainButton);
        rollButton.setOnClickListener{
            if (b_ == 1){
                textView1.text = ""
                textView2.text = ""
                textView3.text = ""

                textView4.text = i_.toString()
                textView5.text = i_.toString()
                textView6.text = i_.toString()

                textView7.text = ""
                textView8.text = ""
                textView9.text = ""
                b_ = 2
            }
            else{
                if (b_==2){
                    textView1.text = ""
                    textView2.text = ""
                    textView3.text = ""

                    textView4.text = ""
                    textView5.text = ""
                    textView6.text = ""

                    textView7.text = i_.toString()
                    textView8.text = i_.toString()
                    textView9.text = i_.toString()
                    b_ = 3
                }
                else{
                    if(b_==3){
                        textView1.text = i_.toString()
                        textView2.text = i_.toString()
                        textView3.text = i_.toString()

                        textView4.text = ""
                        textView5.text = ""
                        textView6.text = ""

                        textView7.text = ""
                        textView8.text = ""
                        textView9.text = ""
                        b_ = 1
                    }
                }
            }
            i_ += +1
        }
    }

}