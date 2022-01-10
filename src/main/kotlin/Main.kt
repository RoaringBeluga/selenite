import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.support.ui.ExpectedConditions
import support.Context
import support.Context.Companion.createContext
import support.Context.Companion.driver
import support.Context.Companion.wait
import support.config.HardcodedConfig
import support.config.YamlConfig

fun main(args: Array<String>) {

    createContext(YamlConfig("config.yaml"))

    driver.get("https://www.google.com")

    driver.findElement(By.name("q")).sendKeys("Antipasti", Keys.ENTER)

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='result-stats']")))
    assert(driver.findElement(By.xpath("//div[@id='result-stats']")).text.contains("About"))
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//aPogoStick")))

    Context.closeContext()//p[@role='heading']
}