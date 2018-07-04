var myApp = angular.module('myApp');

myApp.controller('myCtrl', ['$scope','$http', function($scope,$http){
    
	$scope.passwordMatch = false;
	
    $scope.login = function(){
      
        console.log($scope.username);
        console.log($scope.password);
        var input = {"email" : $scope.email,
        			"password" : $scope.password};
       /* var data = document.getElementById('myForm');
        var formData = new FormData();
        formData.set('username',$scope.username);
        formData.set('password',$scope.password);
        
        $.ajax({
            url: '/TestApp/fileUpload',
            type: 'POST',
            data: formData,
            headers : {},
            cache: false,
            processData: false, // Don't process the files
            contentType: false, // Set content type to false as jQuery will tell the server its a query string request
            success: function(data, textStatus, jqXHR)
            {
                if(typeof data.error === 'undefined')
                {
                    // Success so call function to process the form
                    submitForm(event, data);
                }
                else
                {
                    // Handle errors here
                    console.log('ERRORS: ' + data.error);
                }
            },
            error: function(jqXHR, textStatus, errorThrown)
            {
                // Handle errors here
                console.log('ERRORS: ' + textStatus);
                // STOP LOADING SPINNER
            }
        });*/
        $http({
            method : "POST",
            url : "/TestApp/login",
            headers: {
            	   'Content-Type': undefined
            	 },
            data : $scope.user
        }).then(function mySuccess(response) {
            $scope.myWelcome = response.data;
        }, function myError(response) {
            $scope.myWelcome = response.statusText;
        });
    };
    
    $scope.isPasswordMatching = function(){
    	if($scope.user.password==$scope.confPassword)
    		$scope.passwordMatch = false;
    	else
    		$scope.passwordMatch = true;
    };
    
    $scope.createUser = function(){
    
    	
    	 $http({
             method : "POST",
             url : "/TestApp/createUser",
             data : $scope.user
         }).then(function mySuccess(response) {
             $scope.myWelcome = response.data;
         }, function myError(response) {
             $scope.myWelcome = response.statusText;
         });
    };
    
}]);