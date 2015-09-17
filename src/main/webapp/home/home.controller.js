(function () {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['UserService', '$rootScope'];
    function HomeController(UserService, $rootScope) {
        var vm = this;

        vm.user = null;
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
            UserService.GetAll()
                .then(function (users) {
                    vm.allUsers = users;
                });
        }

        function deleteUser(id) {
            console.log("inside deleteUser");
            UserService.Delete(id)
            .then(function () {
                loadAllUsers();
            });
        }
    }

})();