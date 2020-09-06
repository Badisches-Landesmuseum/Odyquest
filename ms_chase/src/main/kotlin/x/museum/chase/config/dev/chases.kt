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

package x.museum.chase.config.dev

import kotlinx.coroutines.flow.flowOf
import x.museum.chase.config.security.CustomUser
import x.museum.chase.entity.*
import java.time.LocalDateTime

// import x.museum.chase.config.dev.adminUser

val chases = flowOf(
        Chase(
                id = ChaseId.fromString("10000000-0000-0000-0000-000000000000"),
                title = "Helfe Xaver im Museum",
                comment = null,
                quests = emptyList<Quest>(),
                path = null,
                tags = emptyList<Tag>(),
                lastEdited = LocalDateTime.now(),
                lastEditor = adminUser,
                creationDate = LocalDateTime.now()
        )
)