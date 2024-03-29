package com.example.main

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.main.databinding.ItemInitBookBinding

class InitBookAdapter : RecyclerView.Adapter<InitBookAdapter.ViewHolder>(){
    lateinit var items: ArrayList<Init_Book>

    fun build(i: ArrayList<Init_Book>) : InitBookAdapter{
        items = i
        return this
    }

    class ViewHolder(val binding: ItemInitBookBinding, val context: Context) : RecyclerView.ViewHolder(binding.root){


        // Drawable 객체를 비교하는 함수
        fun areDrawablesEqual(drawable1: Drawable, drawable2: Drawable): Boolean {
            val bitmap1 = drawableToBitmap(drawable1)
            val bitmap2 = drawableToBitmap(drawable2)
            return bitmap1.sameAs(bitmap2)
        }


        // Drawable을 Bitmap으로 변환하는 함수
        fun drawableToBitmap(drawable: Drawable): Bitmap {
            if (drawable is BitmapDrawable) {
                return drawable.bitmap
            }

            val width = drawable.intrinsicWidth
            val height = drawable.intrinsicHeight

            val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            drawable.draw(canvas)

            return bitmap
        }
        fun bind(item: Init_Book){

            with(binding){
                titleTv.text = item.title
                when(item.color){
                    1 -> {
                        bookEx1Iv.setImageResource(R.drawable.init_book_card_orange)
                        bookEx1BtnIv.setImageResource(R.drawable.init_book_btn_orange)
                    }
                    2->{
                        bookEx1Iv.setImageResource(R.drawable.init_book_card_blue)
                        bookEx1BtnIv.setImageResource(R.drawable.init_book_btn_blue)
                    }
                    3->{
                        bookEx1Iv.setImageResource(R.drawable.init_book_card_green)
                        bookEx1BtnIv.setImageResource(R.drawable.init_book_btn_green)
                    }
                    4->{
                        bookEx1Iv.setImageResource(R.drawable.init_book_card_purple)
                        bookEx1BtnIv.setImageResource(R.drawable.init_book_btn_purple)
                    }
                    5->{
                        bookEx1Iv.setImageResource(R.drawable.init_book_card_red)
                        bookEx1BtnIv.setImageResource(R.drawable.init_book_btn_red)
                    }

                }
                if(item.heart.toString() == "true"){
                    heartIv.setImageResource(R.drawable.heart)
                }
                else{
                    heartIv.setImageResource(R.drawable.blank_heart)
                }

                //하트클릭 시 이미지 변환
                heartIv.setOnClickListener {
                    val currentImg = binding.heartIv.drawable
                    val heart = ContextCompat.getDrawable(context, R.drawable.heart)
                    val blankheart = ContextCompat.getDrawable(context, R.drawable.blank_heart)
                    if(currentImg != null && heart != null && blankheart != null){
                        if(areDrawablesEqual(currentImg, heart)){
                            binding.heartIv.setImageResource(R.drawable.blank_heart)
                        }
                        else if(areDrawablesEqual(currentImg, blankheart)){
                            binding.heartIv.setImageResource(R.drawable.heart)
                        }
                    }
                }

                keywordRv.apply {
                    adapter = InitKeywordAdapter().build(item.keywords)
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InitBookAdapter.ViewHolder = ViewHolder(
        ItemInitBookBinding.inflate(LayoutInflater.from(parent.context), parent, false), parent.context)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}