class dbGetCon: Database, DbConnect {
    /**
     * This method makes a connection to MySQL Server
     * In this example, MySQL Server is running in the local host (so 127.0.0.1)
     * at the standard port 3306
     */
    override fun connect(): Connection {
        val connectionProps = Properties()

        connectionProps.put("user", dbUsername)
        connectionProps.put("password", dbPasswd)
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            conn = DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" +
                        "borox283jztnsbsi35gs-mysql.services.clever-cloud.com" +
                        ":" + "3306" + "/" +
                        "",
                connectionProps
            )
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
            conn = null
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
            conn = null
        }
        return conn
    }
}