interface Database {
    //To be put in config file:
    var dbType: String
    var dbUsername: String
    var dbPasswd: String

    fun readConf()

}