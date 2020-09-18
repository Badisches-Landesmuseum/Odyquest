/*
 * Copyright (C) 2020 - museum x, Karlsruhe
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package x.museum.quest

import org.springframework.context.annotation.Bean
import org.springframework.hateoas.MediaTypes.HAL_JSON
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter // webflux
import x.museum.quest.entity.Chase
import x.museum.quest.entity.Quest
import x.museum.quest.rest.ChaseHandler
import x.museum.quest.rest.QuestHandler

/**
 * @author [Florian Göbel](mailto:alfiron.begoel@gmail.com)
 */
interface Router {

    @Bean
    fun router(
            questHandler: QuestHandler) = coRouter {

        // Quest
        val questPath = "${apiPath}/quest"
        val questIdPathPattern = "{$idPathVar:${Quest.ID_PATTERN}}"
        val questIdPath = "$questPath/$questIdPathPattern"

        accept(HAL_JSON).nest {
            // Quest
            GET(questPath, questHandler::findAll)
            GET(questIdPath, questHandler::findById)
        }

        contentType(MediaType.APPLICATION_JSON).nest {
            // Quest
            POST(questPath, questHandler::create)
            PUT(questIdPath, questHandler::update)

        }

        DELETE(questIdPath, questHandler::deleteById)
    }

    companion object {

        const val idPathVar = "id"

        const val apiPath = "/api"

        const val authPath = "$apiPath/auth"
    }
}