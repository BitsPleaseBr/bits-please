<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<div class="row">
		<div class="col-md-1"></div>
		
          <div class="col-md-8">
            <div class="card">
              <div class="card-header">
                <h5 class="card-title" id="prontuario"><script>document.getElementById("prontuario").innerHTML = moment().format('LL')</script></h5>
                <hr>
              </div>
              <div class="card-body">
			    <form method="get" action="#">
			    
                  <label>Diagnóstico:</label>
                  <div class="row">
	                 <div class="form-group col-sm-10">
	                   <input type="text" class="form-control" id="diagnostico">
	                 </div>
	                 
	                 <div class="col-sm-2" style="padding: 0">
                  		<button type="button" class="btn btn-primary btn-round" style="margin: 0" id="add_button">Adicionar</button>
	                 </div>
                  </div>
                  
				  <div class="col-sm-8">
					<input type="text" class="tagsinput form-control" data-role="tagsinput">
                  </div>
                  
                  <label>Observações:</label>
                  <div class="form-group">
                    <textarea class="form-control"></textarea>
                  </div>

                  <div class="row pull-right">
	                 <div class="col-sm-12">
                  		<button type="button" class="btn btn-primary btn-round" id="btn_salve">Salvar</button>
	                 </div>
	              </div>
	              
               </form>
            </div>
          </div>
      </div>
    </div>
    
    <script>
    $('.tagsinput').tagsinput();
    $('#add_button').click(function(){
    	
    	if(!$('#diagnostico').val() == ''){
		
		$('.tagsinput').tagsinput('add', $('#diagnostico').val());
		
		$('#diagnostico').val('');
    	}
    });
    
    </script>