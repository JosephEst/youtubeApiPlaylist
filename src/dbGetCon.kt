class dbGetCon: Database, DbConnect {
    /**
     * This method makes a connection to MySQL Server
     */
    override fun connect(): Connection {
        val connectionProps = Properties()
        var conn?: DriverManager = null

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