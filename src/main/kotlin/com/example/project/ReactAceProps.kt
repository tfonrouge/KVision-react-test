package com.example.project

import react.ComponentClass
import react.PropsWithChildren

external interface ReactAceProps : PropsWithChildren {
    var value: String
    var width: String
    var height: String
    var mode: String
    var theme: String
    var onChange: (String) -> Unit
    var fontSize: String
    var setOptions: dynamic
}

val AceEditor: ComponentClass<ReactAceProps> = io.kvision.require("react-ace").default
