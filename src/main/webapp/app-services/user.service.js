(function () {
    'use strict';

    angular
        .module('app')
        .factory('UserService', UserService);

    UserService.$inject = ['$http'];
    function UserService($http) {
        var service = {};

        service.GetAll = GetAll;
<<<<<<< HEAD
        service.GetUserById = GetUserById;
        service.GetByUsername = GetByUsername;
        service.GetAllPostByUser = GetAllPostByUser;
=======
        service.GetById = GetById;
        service.GetByUsername = GetByUsername;
>>>>>>> 90cd47a7fc8ab920d4e0cd842bd5bdeeeab1ec6a
        service.Create = Create;
        service.Update = Update;
        service.Delete = Delete;

        return service;

        function GetAll() {
<<<<<<< HEAD
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
=======
            return $http.get('/api/users').then(handleSuccess, handleError('Error getting all users'));
        }

        function GetById(id) {
            return $http.get('/api/users/' + id).then(handleSuccess, handleError('Error getting user by id'));
        }

        function GetByUsername(username) {
            return $http.get('/api/users/' + username).then(handleSuccess, handleError('Error getting user by username'));
        }

        function Create(user) {
            return $http.post('/api/users', user).then(handleSuccess, handleError('Error creating user'));
        }

        function Update(user) {
            return $http.put('/api/users/' + user.id, user).then(handleSuccess, handleError('Error updating user'));
        }

        function Delete(id) {
            return $http.delete('/api/users/' + id).then(handleSuccess, handleError('Error deleting user'));
>>>>>>> 90cd47a7fc8ab920d4e0cd842bd5bdeeeab1ec6a
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
