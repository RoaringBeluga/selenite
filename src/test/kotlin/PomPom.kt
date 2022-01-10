import pages.Google.GoogleLanding
import pages.Google.GoogleSearchResults
import support.Context.Companion.closeContext
import support.Context.Companion.createContext
import support.config.YamlConfig
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

class PomPom {
    @BeforeTest
    fun prepare() {
        createContext(YamlConfig("config.yaml"))
    }

    @AfterTest
    fun dismantle() {
        closeContext()
    }

    @Test
    fun testGoogle() {
        val pageURL = "https://www.google.com/"
        assert(
        GoogleLanding()
            .open<GoogleLanding>(pageURL)
            .searchFor<GoogleSearchResults>("Antipasti")
            .getresultNumber() > 0
        )

    }
}

