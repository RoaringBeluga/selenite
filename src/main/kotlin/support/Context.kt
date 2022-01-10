package support

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.edge.EdgeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.support.ui.FluentWait

import support.config.ConfigProvider
import java.time.Duration


class Context {
    companion object {

        lateinit var driver: WebDriver
        lateinit var wait: FluentWait<WebDriver>

        /**
         * Init the driver/Release the Kraken!
         */
        fun createContext(config: ConfigProvider) {
            val browser: String = config.getData("browser") as String
            var options: Any
            when (browser) {
                "chrome" -> {
                    options = ChromeOptions().addArguments((config.getData(browser) as List<String>))
                    if(config.getData("headless") as Boolean) {
                        options.setHeadless(config.getData("headless") as Boolean)
                        options.addArguments(config.getData("headless-screen-size") as String)
                    }

                    WebDriverManager.chromedriver().setup()
                    this.driver = ChromeDriver(options)

                }
                "edge" -> {
                    options = EdgeOptions().addArguments((config.getData(browser) as List<String>))
                    if(config.getData("headless") as Boolean) {
                        options.setHeadless(config.getData("headless") as Boolean)
                        options.addArguments(config.getData("headless-screen-size") as String)
                    }

                    WebDriverManager.edgedriver().setup()
                    driver = EdgeDriver(options)
                }
                "firefox" -> {
                    options = FirefoxOptions().addArguments((config.getData(browser) as List<String>))
                    if(config.getData("headless") as Boolean) {
                        options.setHeadless(config.getData("headless") as Boolean)
                        options.addArguments(config.getData("headless-screen-size") as String)
                    }

                    WebDriverManager.firefoxdriver().setup()
                    driver = FirefoxDriver(options)
                }
                else -> {
                    WebDriverManager.chromedriver().setup()
                    driver = ChromeDriver()
                }
            }

            wait = FluentWait(driver)
                .withTimeout(Duration.ofSeconds(config.getData("wait-timeout") as Long))
                .pollingEvery(Duration.ofMillis(config.getData("wait-polling") as Long))
        }

        fun closeContext() {
            driver.quit()
        }
    }


}