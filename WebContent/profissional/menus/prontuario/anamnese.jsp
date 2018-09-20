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
			    
                  <label>Queixa Principal</label>
                  <div class="form-group">
                    <input type="text" class="form-control">
                  </div>
                  
                  <label>História</label>
                  <div class="form-group">
                    <textarea class="form-control"></textarea>
                  </div>
                  
                  <label>Problemas:</label>
                  <p>
                  <div class="form-check form-check-inline text-left">
                    <label class="form-check-label">
                      <input type="checkbox" name="renais" class="form-check-input">
                      <span class="form-check-sign"></span>
                      Renais
                    </label>
                  </div>
                  
                  <div class="form-check form-check-inline text-left">
                    <label class="form-check-label">
                      <input type="checkbox" name="articulares" class="form-check-input">
                      <span class="form-check-sign"></span>
                      Articulares ou Reumatismo
                    </label>
                  </div>
                  
                  <div class="form-check form-check-inline text-left">
                    <label class="form-check-label">
                      <input type="checkbox" name="cardiacos" class="form-check-input">
                      <span class="form-check-sign"></span>
                      Cardíacos
                    </label>
                  </div>
                  
                  <div class="form-check form-check-inline text-left">
                    <label class="form-check-label">
                      <input type="checkbox" name="respiratorios" class="form-check-input">
                      <span class="form-check-sign"></span>
                      Respiratórios
                    </label>
                  </div>
                  
                  <div class="form-check form-check-inline text-left">
                    <label class="form-check-label">
                      <input type="checkbox" name="gastricos" class="form-check-input">
                      <span class="form-check-sign"></span>
                      Gástricos
                    </label>
                  </div>
                  
                  <div class="problemas"></div>

				  <div class="row mt-2">
				  	<div class="col-sm-3">
				  	  <label>Hepatite:</label>
				  	  <p>
					  <div class="form-check-radio form-check-inline">
					    <label class="form-check-label">
					        <input class="form-check-input" type="radio" name="radiosHepatite" id="sim">
					        Sim
					        <span class="form-check-sign"></span>
					    </label>
					  </div>
					  <div class="form-check-radio form-check-inline">
					    <label class="form-check-label">
					        <input class="form-check-input" type="radio" name="radiosHepatite" id="não">
					        Não
					        <span class="form-check-sign"></span>
					    </label>
					  </div>
				    </div>
				    
				  	<div class="col-sm-3">
				  	  <label>Gravidez:</label>
				  	  <p>
					  <div class="form-check-radio form-check-inline">
					    <label class="form-check-label">
					        <input class="form-check-input" type="radio" name="radiosGravidez" id="sim">
					        Sim
					        <span class="form-check-sign"></span>
					    </label>
					  </div>
					  <div class="form-check-radio form-check-inline">
					    <label class="form-check-label">
					        <input class="form-check-input" type="radio" name="radiosGravidez" id="não">
					        Não
					        <span class="form-check-sign"></span>
					    </label>
					  </div>
				    </div>
				  
				  	<div class="col-sm-3">
				  	  <label>Diabetes:</label>
				  	  <p>
					  <div class="form-check-radio form-check-inline">
					    <label class="form-check-label">
					        <input class="form-check-input" type="radio" name="radiosDiabetes" id="sim">
					        Sim
					        <span class="form-check-sign"></span>
					    </label>
					  </div>
					  <div class="form-check-radio form-check-inline">
					    <label class="form-check-label">
					        <input class="form-check-input" type="radio" name="radiosDiabetes" id="não">
					        Não
					        <span class="form-check-sign"></span>
					    </label>
					  </div>
				    </div>
				    
				  	<div class="col-sm-3">
				  	  <label>Problemas de cicatrização:</label>
				  	  <p>
					  <div class="form-check-radio form-check-inline">
					    <label class="form-check-label">
					        <input class="form-check-input" type="radio" name="radiosCicatrizacao" id="sim">
					        Sim
					        <span class="form-check-sign"></span>
					    </label>
					  </div>
					  <div class="form-check-radio form-check-inline">
					    <label class="form-check-label">
					        <input class="form-check-input" type="radio" name="radiosCicatrizacao" id="não">
					        Não
					        <span class="form-check-sign"></span>
					    </label>
					  </div>
				    </div>
				  </div>                 

                  <label>Uso de medicamentos:</label>
                  <div class="form-group">
                    <input type="text" class="form-control">
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
    $('input[type="checkbox"]').click(function(){
    	
    if($('input[name="renais"]').is(":checked")){
    	if($('.problemas').find('#renais').length == 0){
    	$('.problemas').append('<div class="form-group renais"><input type="text" class="form-control" id="renais" placeholder="Renais..."></div>')
    	}
    }else{
    	$('.renais').remove();
    }

    if($('input[name="articulares"]').is(":checked")){
    	if($('.problemas').find('#articulares').length == 0){
    	$('.problemas').append('<div class="form-group articulares"><input type="text" class="form-control" id="articulares" placeholder="Articulares ou Reumatismo..."></div>')
    	}
    }else{
    	$('.articulares').remove();
    }

    if($('input[name="cardiacos"]').is(":checked")){
    	if($('.problemas').find('#cardiacos').length == 0){
    	$('.problemas').append('<div class="form-group cardiacos"><input type="text" class="form-control" id="cardiacos" placeholder="Cardíacos..."></div>')
    	}
    }else{
    	$('.cardiacos').remove();
    }

    if($('input[name="respiratorios"]').is(":checked")){
    	if($('.problemas').find('#respiratorios').length == 0){
    	$('.problemas').append('<div class="form-group respiratorios"><input type="text" class="form-control" id="respiratorios" placeholder="Respiratórios..."></div>')
    	}
    }else{
    	$('.respiratorios').remove();
    }

    if($('input[name="gastricos"]').is(":checked")){
    	if($('.problemas').find('#gastricos').length == 0){
    	$('.problemas').append('<div class="form-group gastricos"><input type="text" class="form-control" id="gastricos" placeholder="Gástricos..."></div>')
    	}
    }else{
    	$('.gastricos').remove();
    }

    })
    </script>