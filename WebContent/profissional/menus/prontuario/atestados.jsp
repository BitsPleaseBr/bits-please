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