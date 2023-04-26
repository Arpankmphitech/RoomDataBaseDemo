package com.example.roomdatabasedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.roomdatabase.dataclass.Contact
import com.example.roomdatabase.dataclass.NoteDatabase
import com.example.roomdatabasedemo.databinding.ActivityMainBinding
import com.example.roomdatabasedemo.roomdatabase.inVisible
import com.example.roomdatabasedemo.roomdatabase.visible
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val noteDatabase by lazy { NoteDatabase.getDatabase(this).noteDao() }
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.visible()

        initView()


    }

    private fun initView() {

//        binding.btnClick.setOnClickListener {
//            binding.txtName.text.toString().concateString()
//        }

        GlobalScope.launch {

            coroutineScope {
                launch { loadConfiguration() }
                delay(1000)
                launch { loadData() }
            }


            coroutineScope {
                launch { loadConfiguration() }
                launch { loadData() }
            }


            coroutineScope {
                launch { loadConfiguration() }
                launch { loadData() }
            }
            
        }

        CoroutineScope(Dispatchers.IO).launch {
            noteDatabase.addNote(Contact(0, "Arpan", "895632598714"))
            Log.e("TAG", "getNotes............." + noteDatabase.getNotes())
        }

        binding.progressBar.inVisible()
    }

    private suspend fun loadData() {

    }

    private suspend fun loadConfiguration() {

    }

}