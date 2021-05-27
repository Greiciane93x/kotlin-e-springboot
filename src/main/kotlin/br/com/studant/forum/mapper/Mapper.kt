package br.com.studant.forum.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}