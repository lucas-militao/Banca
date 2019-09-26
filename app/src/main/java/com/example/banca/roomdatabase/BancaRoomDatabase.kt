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

@Database(
        entities = [Revista::class, Artigo::class, Edicao::class, ArtigoEdicao::class],
        version = 4,
        exportSchema = false)
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

                    var edicao = Edicao("Filmes de terror", 1)
                    edicaoDAO.insert(edicao)
                    edicao = Edicao("Filmes de terror", 1)
                    edicaoDAO.insert(edicao)
                    edicao = Edicao("Histórias bizarras", 1)
                    edicaoDAO.insert(edicao)
                    edicao = Edicao("História", 2)
                    edicaoDAO.insert(edicao)
                    edicao = Edicao("Curiosidades", 3)
                    edicaoDAO.insert(edicao)

                    var revista1 = Revista("mundo estranho")
                    revistaDAO.insert(revista1)
                    var revista2 = Revista("veja")
                    revistaDAO.insert(revista2)
                    var revista3 = Revista("saúde")
                    revistaDAO.insert(revista3)

                    artigoDAO.deleteAll()

                    var artigo1 = Artigo("tecnologia para animais")
                    artigoDAO.insert(artigo1)
                    var artigo2 = Artigo("filmes que entretem crianças")
                    artigoDAO.insert(artigo2)
                    var artigo3 = Artigo("falar sobre sexo nas escolas")
                    artigoDAO.insert(artigo3)

                }

            }

        }

    }

    companion object {

        @Volatile
        private var INSTANCE: BancaRoomDatabase? = null

        fun getDatabase(context: Context,
                        scope: CoroutineScope): BancaRoomDatabase {

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
                        .fallbackToDestructiveMigration()
                        .build()
                INSTANCE = instance

                return instance
            }

        }
    }

}