<!-- Auther: Pankaj Kathiriya, CIGNEX DATAMATICS -->
<!-- Here.. this is static images we have shown, but it can be dynamic using custom entity or Liferay Web-content -->
<div id="abc">
	<a href="/ihg-photos-portlet/images/photo-homepage04.jpg">
		<img src="/ihg-photos-portlet/images/photo-homepage04-th.jpg"/>
	</a>
	<a href="/ihg-photos-portlet/images/photo-homepage06.jpg">
		<img src="/ihg-photos-portlet/images/photo-homepage06-th.jpg"/>
	</a>
	<a href="/ihg-photos-portlet/images/photo-homepage07.jpg">
		<img src="/ihg-photos-portlet/images/photo-homepage07-th.jpg"/>
	</a>
</div>

<script type="text/javascript">
	AUI().ready('aui-image-viewer-gallery', function(A) {
		var imageGallery1 = new A.ImageGallery({
			links : '#abc a',
			caption : 'Images',
			preloadNeighborImages : true,
			preloadAllImages : true,
			showInfo : true,
			autoPlay : true,
			paginator : {},
			delay : 20000
		}).render();
	});
</script>