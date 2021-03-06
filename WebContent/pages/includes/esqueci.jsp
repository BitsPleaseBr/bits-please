<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="modal fade modal-primary" id="EsqueciModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	      <div class="modal-content">
	        <div class="card card-plain">
	          <div class="modal-header justify-content-center">
	            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	              <span aria-hidden="true">×</span>
	            </button>
	  
	            <div class="header header-primary text-center">
	              <div class="logo-container">
	                  <img src="../assets/img/brand.png" alt="S2 saúde" style="width: 25%;border-radius:0%">
	              </div>
	            </div>
	          </div>
	          <div class="modal-body">
	            <form class="formConfirmaçãoPaciente">
	              <div class="card-body">
	  				<h5 style="text-size: 5%; text-align: center">Vamos lá, informe seus dados e te enviaremos uma redefinição de senha<span><i class="nc-icon nc-satisfed"></i></span></h5>
	                <div class="input-group">
	                  <div class="input-group-prepend">
	                    <span class="input-group-text"><i class="nc-icon nc-email-85"></i></span>
	                  </div>
	                  <input type="email" name="email" class="form-control" autocomplete="off" placeholder="Email..." required="">
	                </div>
	  
                    <div class="input-group">
                      <div class="input-group-prepend">
                        <span class="input-group-text">
                          <i class="nc-icon nc-badge"></i>
                        </span>
                      </div>
                      <input type="text" name="cpf" class="form-control cpf" placeholder="CPF..." required="">
                    </div>
	            
	          </div></form>
	          <div class="modal-footers text-center">
	            <button type="button" class="btn btn-primary btn-round" id="btn_confirmar">Enviar</button>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</div>