package com.example.concatadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.concatadapter.Adapters.FirstAdapter
import com.example.concatadapter.Adapters.SecondAdapter
import com.example.concatadapter.Adapters.ThirdAdapter
import com.example.concatadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val firstItemList = mutableListOf<String>()
    val secondItemList = mutableListOf<String>()
    val thirdItemList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getFiveItems(firstItemList)
        getFiveItems(secondItemList)
        getFiveItems(thirdItemList)

        val firstAdp = FirstAdapter(firstItemList)
        val secondAdp = SecondAdapter(secondItemList)
        val thirdAdp = ThirdAdapter(thirdItemList)

        val concatAdapter = ConcatAdapter(firstAdp, secondAdp, thirdAdp)

        binding.recyclerView.adapter = concatAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // 추가 버튼이 눌렸을 때 판정들
        with(binding){
            btnAddFirst.setOnClickListener {
                firstItemList.add("${firstItemList.size + 1}번째 아이템")
                firstAdp.notifyItemInserted(firstItemList.size-1)
            }

            btnAddSecond.setOnClickListener {
                secondItemList.add("${secondItemList.size + 1}번째 아이템")
                secondAdp.notifyItemInserted(secondItemList.size-1)
            }

            btnAddThird.setOnClickListener {
                thirdItemList.add("${thirdItemList.size + 1}번째 아이템")
                thirdAdp.notifyItemInserted(thirdItemList.size-1)
            }
        }
    }

    fun getFiveItems(itemList : MutableList<String>) {

        for (no in 1..5) {
            itemList.add("${no}번째 아이템")
        }

    }
}