package com.example.banca.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.banca.model.dao.ArtigoDAO
import com.example.banca.model.dao.EdicaoDAO
import com.example.banca.model.dao.RevistaDAO
import com.example.banca.model.entity.Artigo
import com.example.banca.model.entity.ArtigoEdicao
import com.example.banca.model.entity.Edicao
import com.example.banca.model.entity.Revista
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Revista::class, Artigo::class, Edicao::class, ArtigoEdicao::class), version = 1)
public abstract class BancaRoomDatabase : RoomDatabase() {

    abstract fun artigoDao(): ArtigoDAO
    abstract fun edicaoDao(): EdicaoDAO
    abstract fun revistaDao(): RevistaDAO

    private class BancaDatabaseCallback(
            private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->

                scope.launch {
                    var revistaDAO = database.revistaDao()
                    var artigoDAO = database.artigoDao()
                    var edicaoDAO = database.edicaoDao()

//                    Delete all the magazines
                    revistaDAO.deleteAll()

                    var edicao1 = Edicao(1)
                    edicaoDAO.insert(edicao1)
                    var edicao2 = Edicao(2)
                    edicaoDAO.insert(edicao2)
                    var edicao3 = Edicao(3)
                    edicaoDAO.insert(edicao3)

                    var revista1 = Revista(1,1,"mundo estranho")
                    revistaDAO.insert(revista1)
                    var revista2 = Revista(2,2,"veja")
                    revistaDAO.insert(revista2)
                    var revista3 = Revista(3,3,"saúde")
                    revistaDAO.insert(revista3)

                }

            }

        }

    }

    companion object {

        @Volatile
        private var INSTANCE: BancaRoomDatabase? = null

        fun getDatabase(context: Context,
                        scope: CoroutineScope) : BancaRoomDatabase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        BancaRoomDatabase::class.java,
                        "banca_database"
                )
                        .addCallback(BancaDatabaseCallback(scope))
                        .build()
                INSTANCE = instance

                return instance
            }

        }
    }

}