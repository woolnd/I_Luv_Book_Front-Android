package com.example.main
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class Init_Book(
    var title: String,
    var keywords: ArrayList<String>,
    var heart: Boolean,
    var color: Int
)

data class TaleCreate(
    var model: String?,
    var keywords: ArrayList<String>?
)

data class TaleResponse(
    var title: String?,
    var engTale: String?,
    var keywords: ArrayList<String>?
)

data class TransLate(
    var source: String?,
    var target: String?,
    var text: String?
)

data class QuizData(
    val title: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val answer: Int
)


data class WordCard(
    val imageRes: Int,
    val title: String,
    val successCount: Int,
    val totalCount: Int,
    val btnimageRes: Int
)

@Parcelize
data class WordPair(
    val english: String,
    val korean: String
) : Parcelable

