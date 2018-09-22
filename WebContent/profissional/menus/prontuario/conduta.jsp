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
			    
                  <div id="froala-editor"></div>
                  
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
    $('#froala-editor')
    .on('froalaEditor.initialized', function (e, editor) {
        editor.events.bindClick($('body'), '#btn_salve', function () {
            editor.html.set('');
            editor.events.focus();
          });
        })
	.froalaEditor({
	  height: 250,
      language: 'pt_br',
      placeholderText: '',
      toolbarButtons: ['bold', 'italic', 'fontSize', 'insertHR', '|', 'paragraphFormat', 'align', 'formatOL', 'formatUL', '-'],
      toolbarButtonsMD: ['bold', 'italic', 'align'],
      fontSizeSelection: true,
  })
    </script>