(function () {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['UserService', '$rootScope'];
    function HomeController(UserService, $rootScope) {
        var vm = this;

        vm.user = null;
<<<<<<< HEAD
        vm.posts=null;
        vm.newpost=null;
        vm.allUsers = [];
        vm.deleteUser = deleteUser;
        vm.userPost=userPost;
        initController();

        function initController() {
            console.log("inside initController");
            loadAllPostByUser();
            //loadCurrentUser();
            //loadAllUsers();
        }

        function loadAllPostByUser() {
             console.log("inside loadAllPostByUser",$rootScope.globals.currentUser);
             console.log("printing rootScope" ,$rootScope);
             UserService.GetByUsername($rootScope.globals.currentUser.username,function(response){
               console.log("got the response form GetByUsername",response.data.id);
               var userId=response.data.id; 

                UserService.GetAllPostByUser(userId,function(response){
                  console.log("create array to hold all the post in",response.data[0]);
                  console.log("now the post is ",response.data[0].blogText);
                  var userPost=[];
                  for(int i=0;i<response.data.length;i++){
                    userPost.push(response.data[i].blogText);
                  }
                  vm.posts=userPost;
                  console.log("printing posts:  ",vm.posts);
                });


            });
            //console.log("got the user",vm.user);  
        }

        function userPost(){

            console.log("posting a post");
        }

        function loadAllUsers() {
            console.log("inside loadAllUsers");
=======
        vm.allUsers = [];
        vm.deleteUser = deleteUser;

        initController();

        function initController() {
            loadCurrentUser();
            loadAllUsers();
        }

        function loadCurrentUser() {
            UserService.GetByUsername($rootScope.globals.currentUser.username)
                .then(function (user) {
                    vm.user = user;
                });
        }

        function loadAllUsers() {
>>>>>>> 90cd47a7fc8ab920d4e0cd842bd5bdeeeab1ec6a
            UserService.GetAll()
                .then(function (users) {
                    vm.allUsers = users;
                });
        }

        function deleteUser(id) {
<<<<<<< HEAD
            console.log("inside deleteUser");
=======
>>>>>>> 90cd47a7fc8ab920d4e0cd842bd5bdeeeab1ec6a
            UserService.Delete(id)
            .then(function () {
                loadAllUsers();
            });
        }
    }

})();