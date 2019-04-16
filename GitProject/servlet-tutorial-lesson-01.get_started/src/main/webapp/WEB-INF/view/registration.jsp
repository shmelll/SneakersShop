<%--
  Created by IntelliJ IDEA.
  User: 22.12.2016
  Date: 11.04.2019
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=windows-1251">
    <title>Форма регистрации</title>
    <link rel="shortcut icon" href="/favicon.ico" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script src="WEB-INF/view/css3_signup_form/jquery.placeholder.js"></script>
    <script>
        $(function() {
            $('input').placeholder();
        });
    </script>
    <style>

        body {
            background: #eee;
        }

        /*------------------------------*/

        #signup {
            width: 550px;
            height: 530px;
            margin: 100px auto 50px auto;
            padding: 20px;
            position: relative;
            background: #fff url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAMAAAAECAMAAAB883U1AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAAlQTFRF7+/v7u7u////REBVnAAAAAN0Uk5T//8A18oNQQAAABZJREFUeNpiYGJiYmBiYgRiBhAGCDAAALsAFJhiJ+UAAAAASUVORK5CYII=);
            border: 1px solid #ccc;
            -moz-border-radius: 3px;
            -webkit-border-radius: 3px;
            border-radius: 3px;
        }

        #signup::before,
        #signup::after {
            content: "";
            position: absolute;
            bottom: -3px;
            left: 2px;
            right: 2px;
            top: 0;
            z-index: -1;
            background: #fff;
            border: 1px solid #ccc;
        }

        #signup::after {
            left: 4px;
            right: 4px;
            bottom: -5px;
            z-index: -2;
            -moz-box-shadow: 0 8px 8px -5px rgba(0,0,0,.3);
            -webkit-box-shadow: 0 8px 8px -5px rgba(0,0,0,.3);
            box-shadow: 0 8px 8px -5px rgba(0,0,0,.3);
        }

        /*------------------------------*/

        #signup h1 {
            position: relative;
            font: italic 1em/3.5em 'trebuchet MS',Arial, Helvetica;
            color: #999;
            text-align: center;
            margin: 0 0 20px;
        }

        #signup h1::before,
        #signup h1::after{
            content:'';
            position: absolute;
            border: 1px solid rgba(0,0,0,.15);
            top: 10px;
            bottom: 10px;
            left: 0;
            right: 0;
        }

        #signup h1::after{
            top: 0;
            bottom: 0;
            left: 10px;
            right: 10px;
        }

        /*------------------------------*/

        ::-webkit-input-placeholder {
            color: #bbb;
        }

        :-moz-placeholder {
            color: #bbb;
        }

        .placeholder{
            color: #bbb; /* polyfill */
        }

        #signup input{
            margin: 5px 0;
            padding: 15px;
            width: 100%;
            *width: 518px;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            border: 1px solid #ccc;
            -moz-border-radius: 3px;
            -webkit-border-radius: 3px;
            border-radius: 3px;
        }

        #signup input:focus{
            outline: 0;
            border-color: #aaa;
            -moz-box-shadow: 0 2px 1px rgba(0, 0, 0, .3) inset;
            -webkit-box-shadow: 0 2px 1px rgba(0, 0, 0, .3) inset;
            box-shadow: 0 2px 1px rgba(0, 0, 0, .3) inset;
        }

        #signup button{
            margin: 20px 0 0 0;
            padding: 15px 8px;
            width: 100%;
            cursor: pointer;
            border: 1px solid #2493FF;
            overflow: visible;
            display: inline-block;
            color: #fff;
            font: bold 1.4em arial, helvetica;
            text-shadow: 0 -1px 0 rgba(0,0,0,.4);
            background-color: #2493ff;
            background-image: -webkit-gradient(linear, left top, left bottom, from(rgba(255,255,255,.5)), to(rgba(255,255,255,0)));
            background-image: -webkit-linear-gradient(top, rgba(255,255,255,.5), rgba(255,255,255,0));
            background-image: -moz-linear-gradient(top, rgba(255,255,255,.5), rgba(255,255,255,0));
            background-image: -ms-linear-gradient(top, rgba(255,255,255,.5), rgba(255,255,255,0));
            background-image: -o-linear-gradient(top, rgba(255,255,255,.5), rgba(255,255,255,0));
            background-image: linear-gradient(top, rgba(255,255,255,.5), rgba(255,255,255,0));
            -webkit-transition: background-color .2s ease-out;
            -moz-transition: background-color .2s ease-out;
            -ms-transition: background-color .2s ease-out;
            -o-transition: background-color .2s ease-out;
            transition: background-color .2s ease-out;
            -moz-border-radius: 3px;
            -webkit-border-radius: 3px;
            border-radius: 3px;
            -moz-box-shadow:  0 2px 1px rgba(0, 0, 0, .3),
            0 1px 0 rgba(255, 255, 255, .5) inset;
            -webkit-box-shadow: 0 2px 1px rgba(0, 0, 0, .3),
            0 1px 0 rgba(255, 255, 255, .5) inset;
            box-shadow: 0 2px 1px rgba(0, 0, 0, .3),
            0 1px 0 rgba(255, 255, 255, .5) inset;
        }

        #signup button:hover{
            background-color: #7cbfff;
            border-color: #7cbfff;
        }

        #signup button:active{
            position: relative;
            top: 3px;
            text-shadow: none;
            -moz-box-shadow: 0 1px 0 rgba(255, 255, 255, .3) inset;
            -webkit-box-shadow: 0 1px 0 rgba(255, 255, 255, .3) inset;
            box-shadow: 0 1px 0 rgba(255, 255, 255, .3) inset;
        }

        /* ------------------------------------------------- */

        #about{
            color: #999;
            text-align: center;
            font: 0.9em Arial, Helvetica;
        }

        #about a{
            color: #777;
        }
    </style>
</head>

<body>


<form action="registration" method="post" id="signup">
    <h1>Registration</h1>
    <input placeholder="email@email.com" required="" type="email" name="email">
    <input placeholder="password" required="" type="password" name="password">
    <input placeholder="confirm password" required="" type="password" name="confirmPassword">
    <input placeholder="phone" required="" type="text" name="phone">
    <input placeholder="postcode" required="" type="text" name="postcode">
    <input placeholder="address" required="" type="text" name="address">

    <button type="submit">Зарегистрироваться</button>
</form>

<!-- pcvector.net -->
<script type="text/javascript" src="http://pcvector.net/templates/pcv/js/pcvector.js"></script>
<!-- /pcvector.net -->
</body>
</html>
