package pages.Google

import org.openqa.selenium.By
import pages.WebPage

class GoogleLanding: WebPage {
    private val searchBar = By.xpath("//input[@name='q']")
    private val searchButton = By.name("btnK")

    fun <PageType: WebPage> searchFor(text: String): PageType {
        this
            .waitForVisibility<GoogleLanding>(searchBar)
            .getElement(searchBar).sendKeys(text)

        return this
            .clickElement(searchButton) as PageType
    }
}