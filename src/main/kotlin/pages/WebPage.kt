package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import support.Context.Companion.driver
import support.Context.Companion.wait

interface WebPage {

    fun <PageType : WebPage> open(url: String): PageType {
        driver.get(url)

        return this as PageType
    }

    fun <PageType : WebPage> waitForVisibility(locator: By): PageType {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator))

        return this as PageType
    }

    fun <PageType : WebPage> waitForClickability(locator: By): PageType {
        wait.until(ExpectedConditions.elementToBeClickable(locator))

        return this as PageType
    }

    fun <PageType : WebPage> clickElement(locator: By): PageType {

        return this as PageType
    }

    fun getElement(locator: By): WebElement {

        return driver.findElement(locator)
    }

    fun getText(locator: By): String {
        return getElement(locator).text
    }

}