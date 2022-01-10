package pages.Google

import org.openqa.selenium.By
import pages.WebPage


class GoogleSearchResults: WebPage {
    private val resultNumber = By.id("result-stats")

    fun hasResults(): Boolean {
        return this.getText(resultNumber).contains("About")
    }

    fun getresultNumber(): Int {
        return Regex("[^0-9]").replace(getText(resultNumber), "").toInt()
    }
}