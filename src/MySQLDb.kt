import java.sql.*
import java.util.Properties
/**
 * Program to list databases in MySQL using Kotlin
 */
class MySQLDb {
    private var conn: Connection? = null
    private var username = "mt" // provide the username
    private var password = "mt" // provide the corresponding password

    companion object Factory{
        fun create(): MySQLDb = MySQLDb("mt", "mt")
    }
    constructor(username: String, pass: String){
        this.username = username
        this.password = pass
        getConnection()
    }

    fun mySqlQueryRows(query: String): String? {
        var stmt: Statement? = null
        var resultset: ResultSet? = null
        var res: String? = null
        var i: Int = 0
        try {
            stmt = conn!!.createStatement()
            resultset = stmt!!.executeQuery(query)
            if (stmt.execute(query)) {
                resultset = stmt.resultSet
                res = ""
                i = 0
            }
            while (resultset!!.next()) {
                res += resultset.getString("Database") + "\n"
                println(res)
            }
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            if (resultset != null) {
                try {
                    resultset.close()
                } catch (sqlEx: SQLException) {
                }
                resultset = null
            }
            if (stmt != null) {
                try {
                    stmt.close()
                } catch (sqlEx: SQLException) {
                }
                stmt = null
            }
        }
        return res
    }

    fun mySqlUpdate (query: String):Int{
        var res: Int = 0

        if(conn == null) return -1

        try {
            res = conn!!.createStatement()!!.executeUpdate(query)
            println(res)
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
        }
        return res
    }

    fun dbCloseCon() {
        if (conn != null) {
            try {
                conn!!.close()
            } catch (sqlEx: SQLException) {
            }
            conn = null
        }
    }
    /**
     * This method makes a connection to MySQL Server
     * In this example, MySQL Server is running in the local host (so 127.0.0.1)
     * at the standard port 3306
     */
    fun getConnection() {
        val connectionProps = Properties()
        connectionProps.put("user", username)
        connectionProps.put("password", password)
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            conn = DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" +
                        "127.0.0.1" +
                        ":" + "3306" + "/" +
                        "",
                connectionProps)
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
        }
    }
}
