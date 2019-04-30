<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 22.12.2016
  Date: 10.04.2019
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="ru.javavision.database.Products,ru.javavision.Models.Product" %>
<%@ page import="java.util.List" %>
<%Products.fillLists();%>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <title>SneakersShop</title>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />

    <style type="text/css" media="screen">
        <%@ include file="/WEB-INF/view/mainRes/css/style.css" %>
        .tabbed { height:420px; }
    </style>

</head>
<body>
<!-- Top -->
<div id="top">

    <div class="shell">

        <!-- Header -->
        <div id="header">
            <h1 id="logo"><a href="#">Urgan Gear</a></h1>
            <div id="navigation">
                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Support</a></li>
                    <li>
                        <form action="checkAuthorized" method="get">
                    <input type="submit" value="My Account" >
                </form></li>
                    <li><a href="#">The Store</a></li>
                    <li class="last"><a href="#">Contact</a></li>
                </ul>
            </div>
        </div>
        <!-- End Header -->

        <!-- Slider -->
        <div id="slider">
            <div id="slider-holder">
                <ul>
                    <li><a href="#"><img src="/WEB-INF/view/mainRes/css/images/slide1.jpg" alt="" /></a></li>
                    <li><a href="#"><img src="css/images/slide2.jpg" alt="" /></a></li>
                    <li><a href="#"><img src="css/images/slide1.jpg" alt="" /></a></li>
                    <li><a href="#"><img src="css/images/slide2.jpg" alt="" /></a></li>
                    <li><a href="#"><img src="css/images/slide1.jpg" alt="" /></a></li>
                    <li><a href="#"><img src="css/images/slide2.jpg" alt="" /></a></li>
                </ul>
            </div>
            <div id="slider-nav">
                <a href="#" class="prev">Previous</a>
                <a href="#" class="next">Next</a>
            </div>
        </div>
        <!-- End Slider -->

    </div>
</div>
<!-- Top -->

<!-- Main -->
<div id="main">
    <div class="shell">

        <!-- Search, etc -->
        <div class="options">
            <div class="search">
                <form action="" method="post">
                    <span class="field"><input type="text" class="blink" value="SEARCH" title="SEARCH" /></span>
                    <input type="text" class="search-submit" value="GO" />
                </form>
            </div>
            <span class="left"><a href="#">Advanced Search</a></span>

            <div class="right">
				<span class="cart">
					<a href="#" class="cart-ico">&nbsp;</a>
					<strong>$<%=Product.CountPrice()%></strong>
				</span>
                <span class="left more-links">
					<a href="#">Checkout</a>
					<a href="#">Details</a>
				</span>
            </div>
        </div>
        <!-- End Search, etc -->

        <!-- Content -->
        <div id="content">

            <!-- Tabs -->
            <div class="tabs">
                <ul>
                    <li><a href="#" class="active"><span>Safety Shoes</span></a></li>
                    <li><a href="#"><span>Sport Shoes</span></a></li>
                    <li><a href="#" class="red"><span>More Shoes</span></a></li>
                </ul>
            </div>
            <!-- Tabs -->

            <!-- Container -->
            <div id="container">

                <div class="tabbed">

                    <!-- First Tab Content -->

                    <div class="tab-content" style="display:block">
                        <div class="items">
                            <div class="cl">&nbsp;</div>
                            <ul>
                                <form action="AddToCart" method="post">
                                <li>
                                    <div class="image">
                                        <img src="/resources/image1.jpg" alt=""/>
                                    </div>

                                    <p><span>
                                        <input type="hidden" name="productName" value="${Products.writeName(0)}"/>
                                        Name: <span><%=Products.writeName(0)%></span><br />
                                        <input type="hidden" name="productSize" value="${Products.writeQuantitySize(0)}"/>
                                        <% List<Integer> a = Products.getSizesList(0);%>
                                        Quantity Size:
                                        <% a = Products.getSizesList(0);
                                        if(a.size()>0){ %>
                                        <select>
                                            <%for(int i=0;i<a.size();i++){%>
                                            <option><%=a.get(i).toString()%></option>
                                            <%}}%>
                                        </select>
                                        <% if(a.size()==0){ %>
                                        Not available <%}%></span>
                                    </p>

                                    <input type="hidden" name="productPrice" value="${Products.writePrice(0)}"/>
                                    <p class="price">Wholesale Price: <strong>$<%=Products.writePrice(0)%></strong></p>
                                    <input type="hidden" name="productId" value="${Products.getProductidInDB(0)}"/>
                                    <input type="submit" value="Add to cart" >
                                </li>
                                </form>
                                <form action="AddToCart" method="post">
                                    <li>
                                        <div class="image">
                                            <img src="/resources/image1.jpg" alt=""/>
                                        </div>

                                        <p>
                                            <input type="hidden" name="productName" value="${Products.writeName(1)}"/>
                                            Name: <span><%=Products.writeName(1)%></span><br />
                                            <input type="hidden" name="productSize" value="${Products.writeQuantitySize(1)}"/>
                                            Quantity Size:
                                            <% a = Products.getSizesList(1);
                                                if(a.size()>0){ %>
                                            <select>
                                                <%for(int i=0;i<a.size();i++){%>
                                                <option><%=a.get(i).toString()%></option>
                                                <%}}%>
                                            </select>
                                            <% if(a.size()==0){ %>
                                            Not available <%}%>
                                        </p>

                                        <input type="hidden" name="productPrice" value="${Products.writePrice(1)}"/>
                                        <p class="price">Wholesale Price: <strong>$<%=Products.writePrice(1)%></strong></p>
                                        <input type="hidden" name="productId" value="${Products.getProductidInDB(1)}"/>
                                        <input type="submit" value="Add to cart" >
                                    </li>
                                </form>
                                <form action="AddToCart" method="post">
                                    <li>
                                        <div class="image">
                                            <img src="/resources/image1.jpg" alt=""/>
                                        </div>

                                        <p>
                                            <input type="hidden" name="productName" value="${Products.writeName(2)}"/>
                                            Name: <span><%=Products.writeName(2)%></span><br />
                                            <input type="hidden" name="productSize" value="${Products.writeQuantitySize(2)}"/>
                                            Quantity Size:
                                            <% a = Products.getSizesList(2);
                                                if(a.size()>0){ %>
                                            <select>
                                                <%for(int i=0;i<a.size();i++){%>
                                                <option><%=a.get(i).toString()%></option>
                                                <%}}%>
                                            </select>
                                            <% if(a.size()==0){ %>
                                            Not available <%}%>
                                        </p>

                                        <input type="hidden" name="productPrice" value="${Products.writePrice(2)}"/>
                                        <p class="price">Wholesale Price: <strong>$<%=Products.writePrice(2)%></strong></p>
                                        <input type="hidden" name="productId" value="${Products.getProductidInDB(2)}"/>
                                        <input type="submit" value="Add to cart" >
                                    </li>
                                </form>
                                <form action="AddToCart" method="post">
                                    <li>
                                        <div class="image">
                                            <img src="/resources/image1.jpg" alt=""/>
                                        </div>

                                        <p>
                                            <input type="hidden" name="productName" value="${Products.writeName(3)}"/>
                                            Name: <span><%=Products.writeName(3)%></span><br />
                                            <input type="hidden" name="productSize" value="${Products.writeQuantitySize(3)}"/>
                                            Quantity Size:
                                            <% a = Products.getSizesList(3);
                                                if(a.size()>0){ %>
                                            <select>
                                                <%for(int i=0;i<a.size();i++){%>
                                                <option><%=a.get(i).toString()%></option>
                                                <%}}%>
                                            </select>
                                            <% if(a.size()==0){ %>
                                            Not available <%}%>
                                        </p>

                                        <input type="hidden" name="productPrice" value="${Products.writePrice(3)}"/>
                                        <p class="price">Wholesale Price: <strong>$<%=Products.writePrice(3)%></strong></p>
                                        <input type="hidden" name="productId" value="${Products.getProductidInDB(3)}"/>
                                        <input type="submit" value="Add to cart" >
                                    </li>
                                </form>
                                <form action="AddToCart" method="post" >
                                    <li>
                                    <li>

                                    <div class="image">
                                            <img src="/resources/image1.jpg" alt=""/>
                                        </div>

                                        <p>
                                            <input type="hidden" name="productName" value="${Products.writeName(4)}"/>
                                            Name: <span><%=Products.writeName(4)%></span><br />
                                            <input type="hidden" name="productSize" value="${Products.writeQuantitySize(4)}"/>
                                            Quantity Size:
                                            <% a = Products.getSizesList(4);
                                                if(a.size()>0){ %>
                                            <select>
                                                <%for(int i=0;i<a.size();i++){%>
                                                <option><%=a.get(i).toString()%></option>
                                                <%}}%>
                                            </select>
                                            <% if(a.size()==0){ %>
                                            Not available <%}%>
                                        </p>

                                        <input type="hidden" name="productPrice" value="${Products.writePrice(4)}"/>
                                        <p class="price">Wholesale Price: <strong>$<%=Products.writePrice(4)%></strong></p>
                                        <input type="hidden" name="productId" value="${Products.getProductidInDB(4)}"/>
                                        <input type="submit" value="Add to cart" >
                                </li>
                                    </li>
                                </form>
                                <form action="AddToCart" method="post">
                                    <li>
                                        <div class="image">
                                            <img src="/resources/image1.jpg" alt=""/>
                                        </div>

                                        <p>
                                            <input type="hidden" name="productName" value="${Products.writeName(5)}"/>
                                            Name: <span><%=Products.writeName(5)%></span><br />
                                            <input type="hidden" name="productSize" value="${Products.writeQuantitySize(5)}"/>
                                            Quantity Size:
                                            <% a = Products.getSizesList(5);
                                                if(a.size()>0){ %>
                                            <select>
                                                <%for(int i=0;i<a.size();i++){%>
                                                <option><%=a.get(i).toString()%></option>
                                                <%}}%>
                                            </select>
                                            <% if(a.size()==0){ %>
                                            Not available <%}%>
                                        </p>

                                        <input type="hidden" name="productPrice" value="${Products.writePrice(5)}"/>
                                        <p class="price">Wholesale Price: <strong>$<%=Products.writePrice(5)%></strong></p>
                                        <input type="hidden" name="productId" value="${Products.getProductidInDB(5)}"/>
                                        <input type="submit" value="Add to cart" >
                                    </li>
                                </form>
                                <form action="AddToCart" method="post">
                                    <li>
                                        <div class="image">
                                            <img src="/resources/image1.jpg" alt=""/>
                                        </div>

                                        <p>
                                            <input type="hidden" name="productName" value="${Products.writeName(6)}"/>
                                            Name: <span><%=Products.writeName(6)%></span><br />
                                            <input type="hidden" name="productSize" value="${Products.writeQuantitySize(6)}"/>
                                            Quantity Size:
                                            <% a = Products.getSizesList(6);
                                                if(a.size()>0){ %>
                                            <select>
                                                <%for(int i=0;i<a.size();i++){%>
                                                <option><%=a.get(i).toString()%></option>
                                                <%}}%>
                                            </select>
                                            <% if(a.size()==0){ %>
                                            Not available <%}%>
                                        </p>

                                        <input type="hidden" name="productPrice" value="${Products.writePrice(6)}"/>
                                        <p class="price">Wholesale Price: <strong>$<%=Products.writePrice(6)%></strong></p>
                                        <input type="hidden" name="productId" value="${Products.getProductidInDB(6)}"/>
                                        <input type="submit" value="Add to cart" >
                                    </li>
                                </form>
                                <form action="AddToCart" method="post">
                                    <li>
                                        <div class="image">
                                            <img src="/resources/image1.jpg" alt=""/>
                                        </div>

                                        <p>
                                            <input type="hidden" name="productName" value="${Products.writeName(7)}"/>
                                            Name: <span><%=Products.writeName(7)%></span><br />
                                            <input type="hidden" name="productSize" value="${Products.writeQuantitySize(7)}"/>
                                            Quantity Size:
                                            <% a = Products.getSizesList(7);
                                                if(a.size()>0){ %>
                                            <select>
                                                <%for(int i=0;i<a.size();i++){%>
                                                <option><%=a.get(i).toString()%></option>
                                                <%}}%>
                                            </select>
                                            <% if(a.size()==0){ %>
                                            Not available <%}%>
                                        </p>

                                        <input type="hidden" name="productPrice" value="${Products.writePrice(7)}"/>
                                        <p class="price">Wholesale Price: <strong>$<%=Products.writePrice(7)%></strong></p>
                                        <input type="hidden" name="productId" value="${Products.getProductidInDB(7)}"/>
                                        <input type="submit" value="Add to cart" >
                                    </li>
                                </form>
                            </ul>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <!-- End First Tab Content -->



                </div>

                <!-- Brands -->
                <div class="brands">
                    <h3>Brands</h3>
                    <div class="logos">
                        <a href="#"><img src="css/images/logo1.gif" alt="" /></a>
                        <a href="#"><img src="css/images/logo2.gif" alt="" /></a>
                        <a href="#"><img src="css/images/logo3.gif" alt="" /></a>
                        <a href="#"><img src="css/images/logo4.gif" alt="" /></a>
                        <a href="#"><img src="css/images/logo5.gif" alt="" /></a>
                    </div>
                </div>
                <!-- End Brands -->

                <!-- Footer -->
                <div id="footer">
                    <div class="right">
                        &copy; Sitename.com. Design by <a href="http://chocotemplates.com" target="_blank" title="CSS Templates">ChocoTemplates.com</a>
                    </div>
                </div>
                <!-- End Footer -->

            </div>
            <!-- End Container -->

        </div>
        <!-- End Content -->

    </div>
</div>
<!-- End Main -->

</body>
</html>
