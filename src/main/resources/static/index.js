angular.module('market', []).controller('indexController', function ($scope, $http) {

    $scope.fillTable = function () {
        $http.get('http://localhost:8189/market/api/v1/products')
            .then(function (response) {
                $scope.products = response.data;
                //console.log($scope.products);
            });
    }

     $scope.cartTable = function () {
         $http.get('http://localhost:8189/market/api/v1/cart')
             .then(function (response) {
                 $scope.cart = response.data;
                 //console.log($scope.cart)
             });
    }

    $scope.deleteProduct = function (id) {
        $http.delete('http://localhost:8189/market/api/v1/products/' + id)
            .then(function (response) {
                $scope.fillTable();
            });
    }

    $scope.createNewProduct = function () {
        // console.log($scope.newProduct);
        $http.post('http://localhost:8189/market/api/v1/products', $scope.newProduct)
            .then(function (response) {
                $scope.newProduct = null;
                $scope.fillTable();
            });
    }

     $scope.addToCart = function (productId) {
         $http.get('http://localhost:8189/market/api/v1/cart/add/' + productId)
             .then(function (response) {
                console.log(response)
                $scope.cartTable();
             });
    }

     $scope.clearCart = function () {
         $http.delete('http://localhost:8189/market/api/v1/cart/')
             .then(function (response) {
                console.log(response)
                $scope.cartTable();
             });
    }

     $scope.deleteFromCart = function (productId) {
         $http.delete('http://localhost:8189/market/api/v1/cart/' + productId)
             .then(function (response) {
                console.log(response)
                $scope.cartTable();
             });
    }

    $scope.fillTable();
    $scope.cartTable();
});