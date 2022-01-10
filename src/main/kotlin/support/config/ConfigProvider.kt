package support.config



interface ConfigProvider {
    var config: Config

    fun getData(key: String): Any? {
        return if(key in config.keysAllowed) config.configData[key] else null
    }

    fun addData(key: String, data: Any) {
        config.configData[key] = data
    }

    fun dropData(key: String) {
        config.configData.remove(key)
    }
}

