import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import support.config.HardcodedConfig
import java.io.File



fun main(args: Array<String>) {
    val config = HardcodedConfig("chrome").config
    var mapper = ObjectMapper(YAMLFactory())

    mapper.findAndRegisterModules()
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
    mapper.writeValue(File("config.yaml"), config)
}