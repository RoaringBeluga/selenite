package support.config

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.File

class YamlConfig(fileName: String) : ConfigProvider {
    override lateinit var config:Config

    init {
        val mapper = ObjectMapper(YAMLFactory()) // Enable YAML parsing
        mapper.registerKotlinModule() // Enable Kotlin support
        mapper.enable(DeserializationFeature.USE_LONG_FOR_INTS)

        try {
            val yamlo = File(fileName)
            config = mapper.readValue<Config>(yamlo)
            //config = Files.newBufferedReader(Path(fileName)).use {
            //    mapper.readValue(it, Config::class.java)
            //}
        } catch (exception: MissingKotlinParameterException) {
            println("Could not read YAML file!")
            println(exception.message)
        }
    }

}