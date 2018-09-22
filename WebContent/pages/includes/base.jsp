<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!--   Core JS Files   -->
  <script src="../assets/js/core/jquery.min.js"></script>
  <script src="../assets/js/core/popper.min.js"></script>
  <script src="../assets/js/core/bootstrap.min.js"></script>
  <script src="../assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <script src="../assets/js/plugins/moment.min.js"></script>
  <script src="../assets/js/plugins/moment-with-locales.min.js"></script>
  <!-- Forms Mask Plugin -->
  <script src="../assets/js/plugins/jquery.mask.min.js"></script>
  <!-- Forms Validations Plugin -->
  <script src="../assets/js/plugins/jquery.validate.min.js"></script>
  <script src="../assets/js/plugins/jquery.validate-additional-methods.min.js"></script>
  <!--  Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
  <script src="../assets/js/plugins/jquery.bootstrap-wizard.js"></script>
  <!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
  <script src="../assets/js/plugins/bootstrap-selectpicker.js"></script>
  <!-- Plugin for DateTimePicker -->
  <script src="../assets/js/plugins/bootstrap-datetimepicker.js"></script>
  <!--  Plugin for Sweet Alert -->
  <script src="../assets/js/plugins/sweetalert2.min.js"></script>
  <!--	Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
  <script src="../assets/js/plugins/bootstrap-tagsinput.js"></script>
  <!--  DataTables.net Plugin, full documentation here: https://datatables.net/    -->
  <script src="../assets/js/plugins/jquery.dataTables.min.js"></script>
  <!--  Full Calendar Plugin, full documentation here: https://github.com/fullcalendar/fullcalendar    -->
  <script src="../assets/js/plugins/fullcalendar.min.js"></script>
  <!--  Plugin for the Bootstrap Table -->
  <script src="../assets/js/plugins/nouislider.min.js"></script>
  <!-- Plugin for the Loading PACE -->
  <script src="../assets/js/plugins/pace.min.js"></script>
  <!-- Plugin Froala Editor -->
  <script src="../assets/js/plugins/froala_editor.min.js"></script>
  <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the pages etc -->
  <script src="../assets/js/paper-dashboard.min.js?v=2.0.1"></script>
  <!-- Aplicações dos Plugins -->
  <script src="../assets/js/bitsplease.js"></script>
  <script>  
	function load(element, page) {

		$('.active').removeClass('active');
			
		$(element).parents('li').addClass('active');
		
		$('.content').load(page);
		
		$('.sidebar .sidebar-wrapper, .main-panel').scrollTop(0);

	    $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar('update');
	}
	
  	function checkFullPageBackgroundImage() {
	  $page = $('.full-page');
	  image_src = $page.data('image');

	  if (image_src !== undefined) {
	    image_container = '<div class="full-page-background" style="background-image: url(' + image_src + ') "/>';
	    $page.append(image_container);
	  }
  	}
  	
  	$('content').css('z-index','7');
  
    $(document).ready(function() {
      checkFullPageBackgroundImage();
    });
  </script>
</body>

</html>