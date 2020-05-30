<!-- start slider -->
	<div class="banner-slider">
		<div class="callbacks_container">
			<ul class="rslides" id="slider4">
				<li>
					<div class="banner-img ">
						<img src="images/4.jpg" class="img-responsive" alt=""
							style="width: 2000px; height: 700px;" />
					</div>
				</li>
				<li>
					<div class="banner-img ">
						<img src="images/2.jpg" class="img-responsive" alt=""
							style="width: 2000px; height: 700px;" />
					</div> <!-- <h4>Aluminium Club</h4>
						   <h5>Experience ray ban</h5> -->
				</li>
				<li>
					<div class="banner-img ">
						<img src="images/5.jpg" class="img-responsive" alt=""
							style="width: 2000px; height: 700px;" />
					</div>
				</li>
			</ul>
		</div>
	</div>
	<!--banner Slider starts Here-->
	<script src="js/responsiveslides.min.js"></script>
	<script>
		// You can also use "$(window).load(function() {"
		$(function() {
			// Slideshow 4
			$("#slider4").responsiveSlides({
				auto : true,
				pager : false,
				nav : true,
				speed : 500,
				namespace : "callbacks",
				before : function() {
					$('.events').append("<li>before event fired.</li>");
				},
				after : function() {
					$('.events').append("<li>after event fired.</li>");
				}
			});

		});
	</script>

	<!--/slider -->