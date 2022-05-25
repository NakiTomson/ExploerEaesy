pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://plugins.gradle.org/m2/") }
        maven { setUrl("https://jitpack.io") }
    }
}
rootProject.name = "Exploer Eaesy"
include(":network-impl")
include(":network")
include(":entity")
include(":core-ui")
include(":feature-core")
include(":core-di")
include(":feature:home-impl")
//include (":feature:home")
include(":repositories-impl")
include(":repositories")
include(":persistence-impl")
include(":persistence")
include(":interactors-impl")
include(":interactors")
include(":feature:splash-impl")
//include (':feature:splash")
include(":feature:navigation-impl")
//include (":feature:navigation")
include(":ui-kit")
include(":feature:dashboard-impl")
//include (":feature:dashboard")
include(":feature")
include(":app")

include(":feature:user-impl")
include(":feature:base-impl")
include(":feature:base")
