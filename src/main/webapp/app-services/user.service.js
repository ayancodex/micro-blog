(function () {
    'use strict';

    angular
        .module('app')
        .factory('UserService', UserService);

    UserService.$inject = ['$http'];
    function UserService($http) {
        var service = {};

        service.GetAll = GetAll;
        service.GetUserById = GetUserById;
        service.GetByUsername = GetByUsername;
        service.GetAllPostByUser = GetAllPostByUser;
        service.Create = Create;
        service.Update = Update;
        service.Delete = Delete;

        return service;

        function GetAll() {
            return $http.get('rest/user').then(handleSuccess, handleError('Error getting all users'));
        }

        function GetUserById(id) {
            return $http.get('rest/user/' + id).then(handleSuccess, handleError('Error getting user by id'));
        }

        function GetByUsername(username,callback) {
            console.log("inside GetByUsername",username);
            $http.get('rest/user/'+username).
               then(function(response){
                console.log("got user object",response);
                callback(response)
              }, function(response){
                console.log("failed to getuser object",response);
                callback(response);
          });

            //return $http.get('rest/user/' + username).then(handleSuccess, handleError('Error getting user by username'));
        }

        function Create(user) {
            console.log("Createing user",user)
            return $http.post('rest/user', user).then(handleSuccess, handleError('Error creating user'));
        }

        function Update(user) {
            return $http.put('rest/user/' + user.id, user).then(handleSuccess, handleError('Error updating user'));
        }

        function Delete(id) {
            return $http.delete('rest/user/' + id).then(handleSuccess, handleError('Error deleting user'));
        }

        function GetAllPostByUser(userId,callback){
            $http.get('rest/user/'+userId+'/posts').
               then(function(response){
                console.log("got all post object",response);
                callback(response)
              }, function(response){
                console.log("failed to all post object",response);
                callback(response);
          });
           //  console.log("inside GetAllPostByUser: id is :",userId);
           //return $http.get('rest/user/'+userId+'/posts').then(handleSuccess, handleError('Error deleting user'));   
        }

        // private functions

        function handleSuccess(data) {
            return data;
        }

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }

})();
