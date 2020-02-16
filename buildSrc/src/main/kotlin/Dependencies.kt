import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.atomicFu(
    module: String = "common",
    version: String = "0.14.1"
) = "org.jetbrains.kotlinx:atomicfu-$module:$version"

fun DependencyHandlerScope.jUnit(
    module: String = "junit",
    version: String = "4.12"
) = "junit:$module:$version"
