(function () {
    'use strict'

    angular.module('collapp.components').component('integrationsAddParameter', {
        bindings: {
            parameter: '<',
            onRemove: '&'
        },
        templateUrl: 'app/components/admin/integrations/add-parameter/integrations-add-parameter.html'
    });
})();


