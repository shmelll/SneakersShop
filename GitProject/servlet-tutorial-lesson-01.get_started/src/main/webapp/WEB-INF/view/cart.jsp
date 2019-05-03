<%--
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

    <!-- Product #1 -->
    <div class="item">
        <div class="buttons">
            <span class="delete-btn"></span>
            <span class="like-btn"></span>
        </div>

        <div class="image">
            <img src="item-1.png" alt="" />
        </div>

        <div class="description">
            <span>Common Projects</span>
            <span>Bball High</span>
            <span>White</span>
        </div>

        <div class="quantity">
            <button class="plus-btn" type="button" name="button">
                <img src="plus.svg" alt="" />
            </button>
            <input type="text" name="name" value="1">
            <button class="minus-btn" type="button" name="button">
                <img src="minus.svg" alt="" />
            </button>
        </div>

        <div class="total-price">$549</div>
    </div>

    <!-- Product #2 -->
    <div class="item">
        <div class="buttons">
            <span class="delete-btn"></span>
            <span class="like-btn"></span>
        </div>

        <div class="image">
            <img src="item-2.png" alt=""/>
        </div>

        <div class="description">
            <span>Maison Margiela</span>
            <span>Future Sneakers</span>
            <span>White</span>
        </div>

        <div class="quantity">
            <button class="plus-btn" type="button" name="button">
                <img src="plus.svg" alt="" />
            </button>
            <input type="text" name="name" value="1">
            <button class="minus-btn" type="button" name="button">
                <img src="minus.svg" alt="" />
            </button>
        </div>

        <div class="total-price">$870</div>
    </div>

    <!-- Product #3 -->
    <div class="item">
        <div class="buttons">
            <span class="delete-btn"></span>
            <span class="like-btn"></span>
        </div>

        <div class="image">
            <img src="item-3.png" alt="" />
        </div>

        <div class="description">
            <span>Our Legacy</span>
            <span>Brushed Scarf</span>
            <span>Brown</span>
        </div>

        <div class="quantity">
            <button class="plus-btn" type="button" name="button">
                <img src="plus.svg" alt="" />
            </button>
            <input type="text" name="name" value="1">
            <button class="minus-btn" type="button" name="button">
                <img src="minus.svg" alt="" />
            </button>
        </div>

        <div class="total-price">$349</div>
    </div>
</div>

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
