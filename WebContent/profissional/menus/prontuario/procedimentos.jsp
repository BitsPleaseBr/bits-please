<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<div class="row">
		<div class="col-md-1"></div>
		
          <div class="col-md-8">
            <div class="card">
              <div class="card-header">
                <label class="card-title">Data:</label>
                <input type="text" class="form-control col-sm-3 data datepicker">
                <hr>
              </div>
              <div class="card-body">
			    <form method="get" action="#">
			    
                  <label>Indicação clínica:</label>
                  <div class="row">
	                <div class="form-group col-sm-12">
	                  <input type="text" class="form-control">
	                </div>
				  </div>
					  
                  <div class="exam">

	                  <div class="row">
		                <div class="col-sm-10">
			                <label>Exames:</label>
			                <div class="form-group">
			                  <input type="text" class="form-control">
			                </div>
		                </div>
		                
		                <div class="col-sm-2">
			                <label>Quantidades:</label>
	                		<div class="form-group">
			                  <input type="text" class="form-control">
			                </div>
		                </div>
		                <div class="col-sm-1 excluir" style="display: none">
		                	<label></label>
							<div >
						  		<a class="btn btn-danger btn-link btn-icon btn-sm remove"><i class="fa fa-trash-o"></i></a>
						  	</div>
					  	</div>
					  </div>
				  </div>
				  
				  <div id="new">
				  </div>
				  
				  <div class="row pull-right">
	                 <div class="col-sm-6">
                  		<button type="button" class="btn btn-primary btn-round" id="add_button">+1 Exame</button>
	                 </div>
	                 
	                 <div class="col-sm-6">
                  		<button type="button" class="btn btn-primary btn-round" id="salve_button">Salvar</button>
	                 </div>
				  </div>
				  
               </form>
            </div>
          </div>
      </div>
    </div>
    
    <script>
    	$('.datepicker').val(moment().format('L'));
    	
    	$('.datepicker').datetimepicker({
    		locale: "pt-br",
    		format: 'L',
    		icons: {
    	        time: "fa fa-clock-o",
    	        date: "fa fa-calendar",
    	        up: "fa fa-chevron-up",
    	        down: "fa fa-chevron-down",
    	        previous: 'fa fa-chevron-left',
    	        next: 'fa fa-chevron-right',
    	        today: 'fa fa-screenshot',
    	        clear: 'fa fa-trash',
    	        close: 'fa fa-remove'
    	    }
    	});
    	
    $(document).ready(function(){
    	$('#add_button').click(function(){
    		$('.exam:first').clone().prependTo('#new');
    		$('.excluir:not(:first)').css('display', 'inline-block');
    		$('.col-sm-10').removeClass('col-sm-10').addClass('col-sm-9');
    	
        	$('a').click(function(){
        		$(this).parents('.exam').remove();
        		
        		if($('.card').find('a').length == 1){
        			$('.col-sm-9').removeClass('col-sm-9').addClass('col-sm-10');
        		}
        	});
    	});
    	
    })
    </script>