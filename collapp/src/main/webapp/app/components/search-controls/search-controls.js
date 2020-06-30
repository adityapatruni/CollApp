(function () {
    'use strict';

    angular.module('collapp.components').component('lvgSearchControls', {
        templateUrl: 'app/components/search-controls/search-controls.html',
        bindings: {
            selectAllInPage: '<',
            deselectAllInPage: '<',
            selectedCardsCount: '<',
            inProject: '<',
            collectIdsByProject: '<',
            triggerSearch: '<',
            project: '<',
            count: '<'
        },
        controller: function (BulkOperationModal) {
            var ctrl = this;

            ctrl.bulkOperationModal = BulkOperationModal;
        }
    });
}());
