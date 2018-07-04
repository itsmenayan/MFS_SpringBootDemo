angular.module('myApp',['ngRoute'])
            .config(['$routeProvider', function($routeProvider){
                $routeProvider
                .when('/login',{
                	templateUrl:'./views/login.html',
                	controller : 'myCtrl'
                })
                .when('/computers',{
                	templateUrl:'./views/home.html',
                	controller : 'myCtrl'
                }) .when('/createAccount',{
                	templateUrl:'./views/createAccount.html',
                	controller : 'myCtrl'
                })
                .when('/printers',{template:'This is the printers Route'})
                .otherwise({redirectTo:'/login'});
            }]);