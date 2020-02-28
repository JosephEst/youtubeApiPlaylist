import MySQLDb
import java.sql.ResultSet

object MainTestSample {
    @JvmStatic
    fun main(args: Array<String>) {
        // make a connection to MySQL Server
        val db = MySQLDb.create()
        db.getConnection()
        // execute the query via connection object
        val showDb = "SHOW DATABASES"
        var res: String? = db.mySqlQueryRows(showDb)
        if (res != null)
            println(res)
        var query = "CREATE DATABASE if not exists YoutubePlayList"
        println(db.mySqlUpdate(query))

        res = db.mySqlQueryRows(showDb)
        if (res != null)
            println(res)
    }
}