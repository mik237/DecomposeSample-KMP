package me.ibrahim.decompose.sample.navigation


import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import kotlinx.serialization.Serializable

class RootComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {
    val navigation = StackNavigation<Config>()

    val childStack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.ScreenA,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        config: Config,
        componentContext: ComponentContext
    ): Child {
        return when (config) {
            Config.ScreenA -> {
                Child.ScreenA(ScreenAComponent(componentContext = componentContext))
            }

            is Config.ScreenB -> {
                Child.ScreenB(
                    ScreenBComponent(
                        text = config.text,
                        componentContext = componentContext
                    )
                )
            }
        }
    }
}

sealed class Child {
    data class ScreenA(val component: ScreenAComponent) : Child()
    data class ScreenB(val component: ScreenBComponent) : Child()
}

@Serializable
sealed class Config {

    @Serializable
    data object ScreenA : Config()

    @Serializable
    data class ScreenB(val text: String) : Config()

}