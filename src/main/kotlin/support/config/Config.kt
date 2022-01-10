package support.config

data class Config(
    val configData: LinkedHashMap<String, Any>,
    val keysAllowed: Set<String>)