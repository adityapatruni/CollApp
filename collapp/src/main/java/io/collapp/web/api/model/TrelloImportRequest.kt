
package io.collapp.web.api.model

class TrelloImportRequest : TrelloRequest() {
    var projectShortName: String? = null
    var boards: List<BoardIdAndShortName>? = null
    var importId: String? = null
    var isImportArchived: Boolean = false

    class BoardIdAndShortName {
        var id: String? = null
        var shortName: String? = null
    }
}
