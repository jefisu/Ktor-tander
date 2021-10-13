package com.jefisu.routes

import com.jefisu.constants.TanderConstants
import com.jefisu.model.Member
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

const val BASE_URL = "http://192.168.0.2:8080"
val members = listOf(
    Member(1,"Beatriz", "Bia", "$BASE_URL/members/bia.jpg", TanderConstants.description_member1),
    Member(2,"Erika", "Erika-sama", "$BASE_URL/members/erika-san.jpg", TanderConstants.description_member2),
    Member(3,"Giovanna", "Gi", "$BASE_URL/members/gi.jpg", TanderConstants.description_member3),
    Member(4,"Jeferson", "Jefisu", "$BASE_URL/members/jefisu.jpg", TanderConstants.description_member4),
    Member(5,"Renan", "Renanzim", "$BASE_URL/members/renanzim.png", TanderConstants.description_member5),
    Member(6,"Sara", "Sara-chan", "$BASE_URL/members/sara.jpg",TanderConstants.description_member6)
)

fun Route.getMembers() {
    get("/members") {
        call.respond(
            status = HttpStatusCode.OK,
            members
        )
    }
    get("/member/{id}") {
        val id = call.parameters["id"]
        val member = members.find {
            it.id == id?.toInt()
        } ?: return@get call.respondText("No member with id $id", status = HttpStatusCode.NotFound)
        call.respond(member)
    }
}