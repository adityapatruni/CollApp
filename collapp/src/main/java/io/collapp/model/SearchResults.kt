
package io.collapp.model

class SearchResults(val found: List<CardFullWithCounts>, val count: Int, val currentPage: Int, val countPerPage: Int, val paginate: Boolean) {
    val totalPages: Int

    init {
        this.totalPages = if (paginate) (count + countPerPage - 1) / countPerPage else 1
    }
}
