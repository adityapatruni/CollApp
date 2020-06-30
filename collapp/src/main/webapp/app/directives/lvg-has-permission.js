(function () {
    'use strict';

    var directives = angular.module('collapp.directives');

    directives.directive('lvgHasPermission', function (User, $stateParams) {
        return {
            restrict: 'A',
            link: function ($scope, element, attrs) {
                element.addClass('collapp-hide');
                if (attrs.ownerId !== undefined) {
                    User.currentCachedUser().then(function (u) {
                        if (u.id === $scope.$eval(attrs.ownerId)) {
                            element.removeClass('collapp-hide');
                        }
                    });
                }

                if ('withProject' in attrs) {
                    User.hasPermission(attrs.lvgHasPermission, attrs.withProject).then(function () {
                        element.removeClass('collapp-hide');
                    });
                } else {
                    User.hasPermission(attrs.lvgHasPermission, $stateParams.projectName).then(function () {
                        element.removeClass('collapp-hide');
                    });
                }
            }
        };
    });

    directives.directive('lvgHasNotPermission', function (User, $stateParams) {
        return {
            restrict: 'A',
            link: function ($scope, element, attrs) {
                element.addClass('collapp-hide');
                User.hasPermission(attrs.lvgHasNotPermission, $stateParams.projectName).then(function () {
                }, function () {
                    element.removeClass('collapp-hide');
                });
            }
        };
    });

    directives.directive('lvgHasAllPermissions', function (User, $stateParams) {
        return {
            restrict: 'A',
            link: function ($scope, element, attrs) {
                element.addClass('collapp-hide');
                User.hasAllPermissions(attrs.lvgHasAllPermissions.split(','), $stateParams.projectName).then(function () {
                    element.removeClass('collapp-hide');
                });
            }
        };
    });

    directives.directive('lvgHasAtLeastOnePermission', function (User, $stateParams) {
        return {
            restrict: 'A',
            link: function ($scope, element, attrs) {
                element.addClass('collapp-hide');
                User.hasAtLeastOnePermission(attrs.lvgHasAtLeastOnePermission.split(','), $stateParams.projectName).then(function () {
                    element.removeClass('collapp-hide');
                });
            }
        };
    });
}());
