package com.example.project

import io.kvision.*
import io.kvision.panel.root
import io.kvision.react.react
import kotlin.js.json

class App : Application() {
    override fun start() {
        root("kvapp") {
            react(state = this.getElement()?.parentElement?.parentElement?.outerHTML ?: "") { getState, changeState ->
                AceEditor {
                    value = getState()
                    mode = "html"
                    theme = "tomorrow"
                    fontSize = "1.25em"
                    width = "100%"
                    height = "40em"
                    onChange = { value ->
                        changeState {
                            value
                        }
                    }
                    setOptions = json(
                        "showLineNumbers" to true,
                        "enableBasicAutocompletion" to true,
                        "enableLiveAutocompletion" to true,
                        "tabSize" to 2,
                    )
                }
            }
        }
    }

    init {
//        require("ace-builds/src-noconflict/ace") // required to fix "ReferenceError: ace is not defined" error
        require("ace-builds/src-noconflict/ext-language_tools")
        require("ace-builds/webpack-resolver") // required since webpack 5
    }
}

fun main() {
    startApplication(
        ::App,
        module.hot,
        BootstrapModule,
        BootstrapCssModule,
        CoreModule
    )
}
