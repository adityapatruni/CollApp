(function () {
    'use strict';

    angular.module('collapp.components').component('lvgActivityComment', {
        bindings: {
            event: '<'
        },
        controller: [ActivityCommentController],
        template: '<div translate>{{\'activity.comment.\' + $ctrl.event.event}}</div>'
    });

    function ActivityCommentController() {
    }
}());
