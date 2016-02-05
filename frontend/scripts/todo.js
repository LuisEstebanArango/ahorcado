angular.module('app', [])
  .controller('TodoListController', ['$http', function($http) {
    var todo = this;
    todo.attempts = 0;
    todo.totalAttempts = 0;
    todo.word = "";
    todo.path = "";

    todo.newGame = function() {
      $http.put('/word').success(function(data){
        todo.attempts = data.intentos;
        todo.totalAttempts = data.maxIntentos;
        todo.word = data.shownWord;
        todo.enabledBotons();
      }).error(function(error){
        console.log(error);
      });
      /*$(document).ready(function(){
          $("#winner").clic(function(){
              $(this).hide();
          });
      });*/
      $("#winner").fadeIn();//slideUp(2000);//.animate({left: '250px'});
    };

    todo.sendLetter = function(c){
      $http.get('/letter/' + c).success(function(data){
        console.log(data);
        todo.attempts = data.intentos;
        todo.totalAttempts = data.maxIntentos;
        todo.word = data.shownWord;
        _(data.letter).forEach(function(value) {
          for (index = 0; index < todo.todos.length; index++) {
            if(value == todo.todos[index].text){
              todo.todos[index].done = false;
            }
          }
        });
        if(todo.attempts >= todo.totalAttempts){
          todo.disabledBotons();
        }
        todo.changeImage();
        // TODO verificar si gano, mirando los intentos
      }).error(function(error){
        console.log(error);
      });
    };

    todo.disabledBotons = function(c){
      for (index = 0; index < todo.todos.length; index++) {
        todo.todos[index].done = false;
      }
    }

    todo.enabledBotons = function(c){
      for (index = 0; index < todo.todos.length; index++) {
        todo.todos[index].done = true;
      }
    }

    todo.changeImage = function(){
      switch(todo.attempts){
        case 0:
          todo.path = "images/default.jpg";
          break;
        case 1:
          todo.path = "images/1.jpg";
          break;
        case 2:
          todo.path = "images/2.jpg";
          break;
        case 3:
          todo.path = "images/3.jpg";
          break;
        case 4:
          todo.path = "images/4.jpg";
          break;
        case 5:
          todo.path = "images/5.jpg";
          break;
        case 6:
          todo.path = "images/6.jpg";
      }
    };

    todo.changeImage();

    todo.todos = [
      {text:'A', done:true},
      {text:'B', done:true},
      {text:'C', done:true},
      {text:'D', done:true},
      {text:'E', done:true},
      {text:'F', done:true},
      {text:'G', done:true},
      {text:'H', done:true},
      {text:'I', done:true},
      {text:'J', done:true},
      {text:'K', done:true},
      {text:'L', done:true},
      {text:'M', done:true},
      {text:'N', done:true},
      {text:'O', done:true},
      {text:'P', done:true},
      {text:'Q', done:true},
      {text:'R', done:true},
      {text:'S', done:true},
      {text:'T', done:true},
      {text:'U', done:true},
      {text:'V', done:true},
      {text:'X', done:true},
      {text:'Y', done:true},
      {text:'Z', done:true},];

    todo.addTodo = function() {
      todo.todos.push({text:todo.todoText, done:false});
      todo.todoText = '';
    };

    todo.remaining = function() {
      var count = 0;
      angular.forEach(todo.todos, function(todo) {
        count += todo.done ? 0 : 1;
      });
      return count;
    };

    todo.archive = function() {
      var oldTodos = todo.todos;
      todo.todos = [];
      angular.forEach(oldTodos, function(todo) {
        if (!todo.done) todo.todos.push(todo);
      });
    };

  }]);