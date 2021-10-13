package com.jefisu.plugins

import com.jefisu.routes.getMembers
import io.ktor.routing.*
import io.ktor.http.content.*
import io.ktor.application.*

fun Application.configureRouting() {

    routing {
        getMembers()
        // Static plugin. Try to access `/static/index.html`
        static {
            resources("static")
        }
    }
}
