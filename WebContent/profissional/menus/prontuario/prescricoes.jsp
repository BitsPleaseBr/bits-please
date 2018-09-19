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
                  <div class="med">
                  <label>Medicamento:</label>
	                  <div class="row">
		                 <div class="form-group col-sm-9">
		                   <input type="text" class="form-control" id="diagnostico">
		                 </div>
	
						<div class="col-sm-3" style="padding: 0; top: -7px">
							<select class="selectpicker" data-style="select-with-transition" data-size="7">
							    <option value="none">Quantidade</option>
							    <option value="0">Uso Contínuo</option>
							    <option value="1">1</option>
							    <option value="2">2</option>
							    <option value="3">3</option>
							    <option value="4">4</option>
							    <option value="5">5</option>
							    <option value="6">6</option>
							    <option value="7">7</option>
							    <option value="8">8</option>
							    <option value="9">9</option>
							    <option value="10">10</option>
							</select>
						</div>
	                  </div>
	                  
	                  <label>Posologia:</label>
	                  <div class="row">
		                <div class="form-group col-sm-4">
		                  <input type="text" class="form-control">
		                </div>
						<div class="col-sm-8 text-right excluir" style="display: none">
					  		<a class="btn btn-danger btn-link btn-icon btn-sm remove"><i class="fa fa-trash-o"></i></a>
					  	</div>
					  </div>
				  </div>
				  
				  <div id="new">
				  </div>
				  
				  <div class="row pull-right">
	                 <div class="col-sm-7">
                  		<button type="button" class="btn btn-primary btn-round" id="add_button">+1 Medicamento</button>
	                 </div>
	                 
	                 <div class="col-sm-5">
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
    	$('.selectpicker').selectpicker();
    	
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
    		$('.med:first').clone().prependTo('#new');
    		$('.excluir:not(:first)').css('display', 'inline-block');
    	
        	$('a').click(function(){
        		$(this).parents('.med').remove();
        	});
    	});
    	
    })
    </script>