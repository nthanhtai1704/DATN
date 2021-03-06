<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>ShopGuitar</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
<link href='//fonts.googleapis.com/css?family=Exo+2' rel='stylesheet'
	type='text/css'>
<script type="text/javascript" src="js/jquery1.min.js"></script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<!--start slider -->
<script src="js/jquery-ui.min.js"></script>
<script src="js/css3-mediaqueries.js"></script>
<!--end slider -->
<script src="js/jquery.easydropdown.js"></script>
</head>
<body>
	<script
		src='//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>
	<script src="//m.servedby-buysellads.com/monetization.js"
		type="text/javascript"></script>
	<script>
		(function() {
			if (typeof _bsa !== 'undefined' && _bsa) {
				// format, zoneKey, segment:value, options
				_bsa.init('flexbar', 'CKYI627U', 'placement:w3layoutscom');
			}
		})();
	</script>
	<script>
		(function() {
			if (typeof _bsa !== 'undefined' && _bsa) {
				// format, zoneKey, segment:value, options
				_bsa.init('fancybar', 'CKYDL2JN', 'placement:demo');
			}
		})();
	</script>
	<script>
		(function() {
			if (typeof _bsa !== 'undefined' && _bsa) {
				// format, zoneKey, segment:value, options
				_bsa.init('stickybox', 'CKYI653J', 'placement:w3layoutscom');
			}
		})();
	</script>
	<script type="text/javascript"
		src="//services.bilsyndication.com/adv1/?d=353" defer="" async=""></script>
	<script>
		var vitag = vitag || {};
		vitag.gdprShowConsentTool = false;
		vitag.outStreamConfig = {
			type : "slider",
			position : "left"
		};
	</script>
	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async
		src="https://www.googletagmanager.com/gtag/js?id=UA-125810435-1"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag() {
			dataLayer.push(arguments);
		}
		gtag('js', new Date());

		gtag('config', 'UA-125810435-1');
	</script>
	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script',
				'//www.google-analytics.com/analytics.js', 'ga');
		ga('create', 'UA-30027142-1', 'w3layouts.com');
		ga('send', 'pageview');
	</script>
<body>
	<div class="header-top">
		<div class="wrap">
			<!---728x90--->

			<div class="cssmenu">
				<ul>
					<li><a href="${pageContext.request.contextPath}/login">Đăng
							nhập </a></li> |
					<li><a href="${pageContext.request.contextPath}/signUp">Ðăng
							ký </a></li>
				</ul>
			</div>

			<div class="clear"></div>
		</div>
	</div>
	<div class="header-bottom">
		<div class="wrap">
			<div class="header-bottom-left">
				<div class="logo">
					<a href="${pageContext.request.contextPath}/home"><b><h1
								style="font-size: 30px; color: red;">Guitar Shop</h1></b></a>
				</div>
				<div class="menu">
					<ul class="megamenu skyblue">

						<li class="active grid"><a
							href="${pageContext.request.contextPath}/home">Home</a></li>
						<li><a class="color6"
							href="${pageContext.request.contextPath}/seachBySpecies?idLoai=1">Guitar
								Classic</a></li>
						<li><a class="color7"
							href="${pageContext.request.contextPath}/seachBySpecies?idLoai=2">Guitar
								Acoustic</a></li>

					</ul>
				</div>
			</div>
			<div class="header-bottom-right">
				<div class="search">
					<form action="searchByName" method="get">
						<input type="text" placeholder="Search" name="productName"
							required="required"> <input type="submit"
							value="Subscribe" id="submit" name="submit">
						<div id="response"></div>
					</form>
				</div>
				<div class="tag-list">

					<ul class="icon1 sub-icon1 profile_img">
						<li><a class="active-icon c2"
							href="${pageContext.request.contextPath}/cart"> </a>
							<ul class="sub-icon1 list">
								<li><h3>Shopping Card</h3> <a href=""></a>${"count"}</li>
								<li><p>
										List of products you have added to your shopping cart <a
											href="">adipiscing elit, sed diam</a>
									</p></li>
							</ul></li>
					</ul>
				</div>
			</div>
				<div class="clear"></div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>
