(function () {
    'use strict';

    var components = angular.module('collapp.components');

    components.component('lvgNotification', {
        templateUrl: 'app/components/notification/notification.html',
        controller: function (Notification) {
            this.notifications = Notification.getNotifications();
        }
    });
}());
