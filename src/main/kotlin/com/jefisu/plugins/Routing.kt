package com.jefisu.plugins

import com.jefisu.routes.getMember
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.content.*
import io.ktor.http.content.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {

    routing {
        getMember()
        // Static plugin. Try to access `/static/index.html`
        static {
            resources("static")
        }
    }
}
