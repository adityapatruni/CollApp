(function () {
    'use strict';

    angular.module('collapp.components').component('lvgCardFile', {
        bindings: {
            file: '<',
            onDelete: '&'
        },
        controller: angular.noop,
        templateUrl: 'app/components/card/file/card-file.html'
    });
}());
