package support.config

class HardcodedConfig(
    browser: String): ConfigProvider {

    private val configData: LinkedHashMap<String, Any> = linkedMapOf(
        // General configuration
        "browser" to browser,
        "headless" to false,
        "headless-screensize" to "1920x1080", // Size for screen if headless
        "screenshot-dir" to "log/screenshots",
        "wait-timeout" to 120L,
        "wait-polling" to 500L,
        // Browser arguments
        "chrome" to listOf("--start-maximized", "--no-sandbox", "--disable-site-isolation-trials", "--auto-open-devtools-for-tabs"),
        "edge" to listOf("--start-maximized", "--no-sandbox", "--disable-site-isolation-trials", "--auto-open-devtools-for-tabs"),
        "firefox" to listOf<String>("--devtools", "--new-instance"),
    )
    private val keys: Set<String> = setOf(
        // Browsers
        "chrome", "edge", "firefox",
        // Options
        "browser", // Browser to use
        "headless", // Use headless
        "screenshot-dir", // Headless screen resolution
        "screenshot-dir", // Directory to save screenshots
        "wait-timeout", // Wait timeout in seconds
        "wait-polling", // Wait polling interval
    )
    override var config = Config(configData, keys)
}