package com.example.demoappyoutube

import android.content.Context
import androidx.room.*

@Database(entities = [YoutubeDB::class], version = 1)
abstract class DB : RoomDatabase() {
    abstract fun getMyDao(): YoutubeDao

    companion object {
        @Volatile
        private var INSTANCE: DB? = null
        fun getInstance(context: Context): DB {
            if (INSTANCE != null) return INSTANCE!!
            synchronized(this) {
                INSTANCE = Room.databaseBuilder(context,DB::class.java,"youTube")
                    .build()
                return INSTANCE!!
            }

        }
    }
}

@Entity(tableName = "youtube_model")
data class YoutubeDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var author: String,
    var name: String,
    var views: String,
    var date: String)

@Dao
interface YoutubeDao {

}



