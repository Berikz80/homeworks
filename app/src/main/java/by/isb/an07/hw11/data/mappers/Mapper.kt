package by.isb.an07.hw11.data.mappers
interface Mapper<F, T> {
    fun map(from: F): T
}