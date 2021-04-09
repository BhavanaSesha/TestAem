(function ($) {
	var id;
    var name;
    var price;
    var count;
	var customerId;
    var cart=[];



        var shoppingCart = function () {

                              $(function() {
                                            customerId = -1;
                                            var status = 0;
                                           var customername = "email" + "=";
                                            var ca = document.cookie.split(';');
                                        
                                            for(var i = 0; i < ca.length; i++) {
                                                var c = ca[i];
                                                while (c.charAt(0) == ' ') {
                                                    c = c.substring(1);
                                                }
                                                if (c.indexOf(customername) == 0) {
                                                    customerId = c.substring(customername.length, c.length-3);
                                                    status = 1;
                                                }
                                            }
                                        
                                            if(status == 1) {
                                                fetchCartData(customerId);
                                                //alert("I am bacj");
                                        
                                        
                                        
                                        
                                            }
                                            else {
                                                $(".show-cart").html("Login To View Cart!...");

                                        
                                            }
                                        

                                        });

            		function fetchCartData(customerId) {
                            $.ajax({
                                url: '/bin/Cart/CartServlet',
                                type: 'POST',
                                data: {
                                    customerID: customerId,
                                    action: "fetch"
                                },
                                success : function(data, textStatus, jqXHR) {
                               // alert(textStatus)
                                    if (textStatus == "success") {
                                    //alert(data);
                                    cart = JSON.parse(data);
                    
                                    saveCart();
                                    displayCart();
                    
                                    }
                                    else {
                                        //alert("Error");
                                    }
                                }
                            });
                    
                        }
                    

            function Item(id,name, price, count) {
				this.id = id;

                this.name = name;
                this.price = price;
                this.count = count;
            }
       		 function saveCart() {
               sessionStorage.setItem('shoppingCart', JSON.stringify(cart));
              	//$.cookie("shoppingCart", JSON.stringify(cart));
            }
            function loadCart() {
               cart = JSON.parse(sessionStorage.getItem('shoppingCart'));
               //cart = JSON.parse($.cookie("shopingCart"))

            }
           if (sessionStorage.getItem("shoppingCart") != null) {
          	// if($.cookie("shopingCart") != null){
            //if(jQuery.cookie('cart')!=null){


                loadCart();
            }
            var obj = {};
            console.log(cart);

            // Add to cart
            obj.addItemToCart = function (id,name, price, count) {
            console.log(id);
                for (var item in cart) {
                    if (cart[item].id === id) {
                    	console.log(cart[item].id);

                        cart[item].count++;
                        saveCart();
                        return;
                    }
                    console.log(id);
                }
                var item = new Item(id,name, price, count);
                cart.push(item);
                saveCart();
            };
            console.log(id);
            // Set count from item
            obj.setCountForItem = function (id,name, count) {
            console.log(id);
                for (var i in cart) {
                    if (cart[i].id === id) {
                        cart[i].count = count;
                        break;
                    }
                }
            };
            // Remove item from cart
            obj.removeItemFromCart = function (id) {
                for (var item in cart) {
                    if (cart[item].id === id) {
                        cart[item].count--;
                        if (cart[item].count === 0) {
                            cart.splice(item, 1);
                        }
                        break;
                    }
                }
                saveCart();
            };

            // Remove all items from cart
            obj.removeItemFromCartAll = function (id) {
                for (var item in cart) {
                    if (cart[item].id === id) {
                        cart.splice(item, 1);
                        break;
                    }
                }
                saveCart();
            };

            // Clear cart
            obj.clearCart = function () {
                cart = [];

                saveCart();

                $.ajax({
    		type : "POST",    
       	 	url : '/bin/Cart/CartServlet',    
        	data : { 
                customerID:customerId,
				action:"removeAllCart"
        	},    
        	success : function(data, textStatus, jqXHR) {
        		//alert(data);
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {        

        	}
        });
            };

            // Count cart 
            obj.totalCount = function () {
                var totalCount = 0;
                for (var item in cart) {
                    totalCount += cart[item].count;
                }
                return totalCount;
            };

            // Total cart
            obj.totalCart = function () {
                var totalCart = 0;
                for (var item in cart) {
                    totalCart += cart[item].price * cart[item].count;
                }
                return Number(totalCart.toFixed(2));
            };

			//calculating index of cart based on id
            obj.presentIndex = function(id){
            var indexItem=0;
            for(var item in cart) {
                if(cart[item].id == id) {
 
                        indexItem=item;
                        }
                }
                return indexItem;
            }

            // List cart
            obj.listCart = function () {
                var cartCopy = [];
                for (i in cart) {
                    item = cart[i];
                    itemCopy = {};
                    for (p in item) {
                        itemCopy[p] = item[p];

                    }
                    itemCopy.total = Number(item.price * item.count).toFixed(2);
                    cartCopy.push(itemCopy);
                }
                return cartCopy;
            };
            return obj;
        }();

        $('.add-to-cart').click(function (event) {
            event.preventDefault();
            var id = $(this).data('id');
            var name = $(this).data('name');
            var price = Number($(this).data('price'));
            shoppingCart.addItemToCart(id,name, price, 1);
            displayCart();
        });


        // Clear items
        $('.clear-cart').click(function () {
            shoppingCart.clearCart();

            displayCart();
        });


        function displayCart() {
            var cartArray = shoppingCart.listCart();

            var output = "";
            for (var i in cartArray) {
				console.log("Inside cart array");
                output += "<tr>" +

                    "<td >" + cartArray[i].name + "</td>" +
                    "<td>(" + cartArray[i].price + ")</td>" +
                    "<td><div class='input-group'><button class='minus-item input-group-addon btn btn-primary' data-name=" + cartArray[i].name + " data-id="+ cartArray[i].id+ ">-</button>" +
                    "<input type='number' class='item-count form-control' data-name='" + cartArray[i].name + "' value='" + cartArray[i].count + "'>" +
                    "<button class='plus-item btn btn-primary input-group-addon' data-name=" + cartArray[i].name + " data-id="+ cartArray[i].id+ ">+</button></div></td>" +
                    "<td><button class='delete-item btn btn-danger' data-name=" + cartArray[i].name + "  data-id="+ cartArray[i].id+ ">X</button></td>" +
                    " = " +
                    "<td>" + cartArray[i].total + "</td>" +
                    "</tr>";
            }
            $('.show-cart').html(output);
            $('.total-cart').html(shoppingCart.totalCart());
            $('.total-count').html(shoppingCart.totalCount());
        }

        // Delete item button

        $('.show-cart').on("click", ".delete-item", function (event) {
        	var id = $(this).data('id');
            shoppingCart.removeItemFromCartAll(id);
            $('.total-cart').html(shoppingCart.totalCart());
            $('.total-count').html(shoppingCart.totalCount());


            $.ajax({
    		type : "POST",    
       	 	url : '/bin/Cart/CartServlet',    
        	data : {  
				plantId:id,
                customerID:customerId,
				action:"removeItem"
        	},    
        	success : function(data, textStatus, jqXHR) {
        		//alert(data);
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {        

        	}
        });


            displayCart();
        });


        // -1
        $('.show-cart').on("click", ".minus-item", function (event) {
            var name = $(this).data('name');
            var id = $(this).data('id');
            shoppingCart.removeItemFromCart(id);

			$('.total-cart').html(shoppingCart.totalCart());
            $('.total-count').html(shoppingCart.totalCount());
			var item = shoppingCart.presentIndex(id);
			var productQuantity = cart[item].count;
			//alert(productQuantity);

            $.ajax({
    		type : "POST",    
       	 	url : '/bin/Cart/CartServlet',    
        	data : {  
				plantId:id,
                customerID:customerId,
                quantity:productQuantity,
				action:"updateQuantity"
        	},    
        	success : function(data, textStatus, jqXHR) {
        		//alert(data);
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {        

        	}
        });
            displayCart();
        });
        // +1
        $('.show-cart').on("click", ".plus-item", function (event) {
            var name = $(this).data('name');
            var id = $(this).data('id');
            console.log($(this));
            shoppingCart.addItemToCart(id);
            $('.total-cart').html(shoppingCart.totalCart());
            $('.total-count').html(shoppingCart.totalCount());
			var item = shoppingCart.presentIndex(id);
			var productQuantity = cart[item].count;
			//alert(productQuantity);

            $.ajax({
    		type : "POST",    
       	 	url : '/bin/Cart/CartServlet',    
        	data : {  
				plantId:id,
                customerID:customerId,
                quantity:productQuantity,
				action:"updateQuantity"
        	},    
        	success : function(data, textStatus, jqXHR) {
        		//alert(data);
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {        

        	}
        });

            displayCart();
        });

        // Item count input
        $('.show-cart').on("change", ".item-count", function (event) {
            var name = $(this).data('name');
            var count = Number($(this).val());
            var id = $(this).data('id');
            shoppingCart.setCountForItem(id,name, count);
            displayCart();
        });

        displayCart();




$('.add-to-cart').click(function(){ 

	var length = cart.length;
  //  alert(cart[length-1].name);
    //alert(cart[length-1].price);
	//alert(cart[length-1].id);
	var name =  cart[length-1].name;
    var price = cart[length-1].price;
    var id = cart[length-1].id;
    var quantity = cart[length-1].count;
	//alert(cart[length-1].count);
	var jsoncart = JSON.stringify(cart);
    //alert(jsoncart);
	$.ajax({
    		type : "POST",    
       	 	url : '/bin/Cart/CartServlet',    
        	data : {  
				cartArray:jsoncart,
                customerID:customerId,
				action:"insert"
        	},    
        	success : function(data, textStatus, jqXHR) {
        		//alert(data);
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {        

        	}
        });
});

})(jQuery);