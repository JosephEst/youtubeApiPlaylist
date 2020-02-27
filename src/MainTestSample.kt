object MainTestSample {
    @JvmStatic
    fun main(args: Array<String>) {
        // make a connection to MySQL Server
        getConnection()
        // execute the query via connection object
        executeMySQLQuery()
    }
}