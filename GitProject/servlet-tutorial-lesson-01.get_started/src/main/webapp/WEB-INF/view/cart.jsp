<%@ page import="java.util.HashMap" %>
<%@ page import="ru.javavision.Models.Product" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 22.12.2016
  Date: 03.05.2019
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Shopping Cart</title>
    <meta name="robots" content="noindex,follow" />
    <style>
        <%@ include file="/WEB-INF/view/shopping-cart/style.css" %>
    </style>
</head>
<body>
<div class="shopping-cart">
    <!-- Title -->
    <div class="title">
        Shopping Bag
    </div>
<%List<Product> productList = Product.getProductsList();
for(int i=0;i<productList.size();i++){%>

    <div class="item">
        <div class="buttons">
            <span class="delete-btn"></span>
            <span class="like-btn"></span>
        </div>

        <div class="image">
            <img src="item-1.png" alt="" />
        </div>

        <div class="description">
            <span><%=productList.get(i).getName() %></span>
            <span><%=productList.get(i).getAvaibleSizes()%></span>
            <span>White</span>
        </div>
<form action="RemoveProduct" method="post">

            <input type="hidden" name="prodNum" value="<%=String.valueOf(i)%>"/>
            <input type="submit"  value="Remove" >

</form>

        <div class="total-price">$<%=String.valueOf(productList.get(i).getPrice()) %></div>
    </div>

<%
}
%>

<script type="text/javascript">
    $('.minus-btn').on('click', function(e) {
        e.preventDefault();
        var $this = $(this);
        var $input = $this.closest('div').find('input');
        var value = parseInt($input.val());

        if (value > 1) {
            value = value - 1;
        } else {
            value = 0;
        }

        $input.val(value);

    });

    $('.plus-btn').on('click', function(e) {
        e.preventDefault();
        var $this = $(this);
        var $input = $this.closest('div').find('input');
        var value = parseInt($input.val());

        if (value < 100) {
            value = value + 1;
        } else {
            value =100;
        }

        $input.val(value);
    });

    $('.like-btn').on('click', function() {
        $(this).toggleClass('is-active');
    });

</script>
</body>
</html>
