(function () {
    'use strict';

    angular.module('collapp.components').component('lvgStatsTile', {
        templateUrl: 'app/components/stats/tile/stats-tile.html',
        bindings: {
            tileTitle: '<',
            value: '<',
            subtitle: '<?',
            valueColor: '<?'
        },
        controller: [StatsTileController]
    });

    function StatsTileController() {
        var ctrl = this;

        ctrl.$onInit = function init() {
            if (this.valueColor === undefined) {
                this.valueColor = 0;
            }
        };
    }
}());
