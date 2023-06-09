package org.jetbrains.kotlin.course.old.school.functions

import org.jetbrains.kotlin.course.old.school.photo.Color
import org.jetbrains.kotlin.course.old.school.photo.PhotoCharacter
import org.springframework.stereotype.Service

@Service
class GameFunctionsService {
    fun getAllPossibleColors() = Color.values().map { it.name.lowercase() }

    private fun String.toColor() = Color.valueOf(replaceFirstChar { it.titlecase() })

    private fun Iterable<String>.toPhotoCharacters() =
        map { name -> PhotoCharacter.valueOf(name.replaceFirstChar { it.titlecase() }) }

    fun Iterable<String>.findPhoto(colorStr: String): PhotoCharacter? {
        val color = colorStr.toColor()
        return toPhotoCharacters().find { it.backgroundColor == color }
    }

    fun Iterable<String>.groupByPhotosByColor() = toPhotoCharacters()
        .groupBy { it.backgroundColor }.map { it.value }.flatten()
}
