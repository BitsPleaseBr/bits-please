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
			    
				      <label>Altura:</label>
				      <div class="row">
		                  <div class="col-sm-5">
			                <div class="form-group">
			                  <input type="text" class="form-control altura">
			                </div>
		                  </div>
		                  <div class="col-sm-1" style="padding: 0px"><p style="position: relative; top: 25%">m</p></div>
	                  </div>
	                  
				      <label>Peso:</label>
				      <div class="row">
		                  <div class="col-sm-5">
			                <div class="form-group">
			                  <input type="text" class="form-control peso">
			                </div>
		                  </div>
		                  <div class="col-sm-1" style="padding: 0px"><p style="position: relative; top: 25%">kg</p></div>
	                  </div>
	                  
				      <label>Frequência Cardíaca:</label>
				      <div class="row">
		                  <div class="col-sm-5">
			                <div class="form-group">
			                  <input type="text" class="form-control frequencia">
			                </div>
		                  </div>
		                  <div class="col-sm-4" style="padding: 0px"><p style="position: relative; top: 25%">batimentos por minutos</p></div>
	                  </div>
                  
				      <label>Pressão arterial sistólica:</label>
				      <div class="row">
		                  <div class="col-sm-5">
			                <div class="form-group">
			                  <input type="text" class="form-control pressao">
			                </div>
		                  </div>
		                  <div class="col-sm-4" style="padding: 0px"><p style="position: relative; top: 25%">mmHg</p></div>
	                  </div>
                
				      <label>Pressão arterial diastólica:</label>
				      <div class="row">
		                  <div class="col-sm-5">
			                <div class="form-group">
			                  <input type="text" class="form-control pressao">
			                </div>
		                  </div>
		                  <div class="col-sm-4" style="padding: 0px"><p style="position: relative; top: 25%">mmHg</p></div>
	                  </div>
	                  
	                  <!-- 				  <div class="row">
				    <div class="col-sm-5">
				      <label>Altura:</label>
				      <div class="form-group">
				        <input type="text" class="form-control altura">
				      </div>
				    </div>
				  	<div class="col-sm-1" style="padding: 0px"><p style="position: relative; top: 50%">m</p></div>
				 
				  	<div class="col-sm-5">
				 	  <label>Peso:</label>
					  <div class="form-group">
				  		<input type="text" class="form-control peso">
					  </div>
				  	</div>
				  	<div class="col-sm-1" style="padding: 0px"><p style="position: relative; top: 50%">kg</p></div>
				  </div>
				     
				  <div class="row justify-content-center">
				    <div class="col-sm-3"></div>
				    
				    <div class="col-sm-5">
				      <label>Frequência Cardíaca:</label>
				      <div class="form-group">
				        <input type="text" class="form-control frequencia">
				      </div>
				    </div>
				    <div class="col-sm-4" style="padding: 0px"><p style="position: relative; top: 50%">batimentos por minutos</p></div>
				  </div>
				            
				  <div class="row mt-1">
				    <div class="col-sm-5">
				      <label>Pressão arterial sistólica:</label>
				      <div class="form-group">
						<input type="text" class="form-control pressao">
				      </div>
				    </div>
				    <div class="col-sm-1" style="padding: 0px"><p style="position: relative; top: 50%">mmHg</p></div>
				            
				    <div class="col-sm-5">
				   	  <label>Pressão arterial diastólica:</label>
				      <div class="form-group">
						<input type="text" class="form-control pressao">
				      </div>
				    </div>
				    <div class="col-sm-1" style="padding: 0px"><p style="position: relative; top: 50%">mmHg</p></div>
				 </div>
	                 -->
	                
                  <label>Obsevações gerais:</label>
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
    $('.altura').mask('0,00', {reverse: true});
    $('.peso').mask('990,00', {reverse: true});
    $('.frequencia').mask('900');
    $('.pressao').mask('900');
    
    </script>