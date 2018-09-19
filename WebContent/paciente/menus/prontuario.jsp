<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="row">
          <div class="col-md-4">
            <div class="card">
            <div class="row">
              <div class="card-header col-sm-9">
                <h4 class="card-title text-center">Prontuários</h4>
              </div>
              </div>
              <div class="card-body pront" style="display: none">
                <div class="toolbar">
                  <!--        Here you can write extra buttons/actions for the toolbar              -->
                </div>
                <table id="datatable" class="table table-striped table-bordered" cellspacing="0" width="100%">
                  <thead>
                    <tr>
                      <th>Descrição</th>
                      <th>Médico</th>
                      <th>Data da consulta</th>
                      <th class="disabled-sorting text-right">Prontuário</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>Descrição</th>
                      <th>Paciente</th>
                      <th>Data da Consulta</th>
                      <th class="disabled-sorting text-right">Prontuário</th>
                    </tr>
                  </tfoot>
                  <tbody>
                    <tr>
                      <th>Câncer</th>
                      <td>Tiger Nixon</td>
                      <td>01/09/2018</td>
                      <td class="text-right">
                        <a href="#" class="btn btn-default btn-link btn-icon btn-sm see"><i class="fa fa-file-alt"></i></a>
                      </td>
                    </tr>
                    <tr>
                      <th>HIV</th>
                      <td>Garrett Winters</td>
                      <td>01/09/2018</td>
                      <td class="text-right">
                        <a href="#" class="btn btn-default btn-link btn-icon btn-sm see"><i class="fa fa-file-alt"></i></a>
                      </td>
                    </tr>
                    <tr>
                      <th>Tetris</th>
                      <td>Ashton Cox</td>
                      <td>01/09/2018</td>
                      <td class="text-right">
                        <a href="#" class="btn btn-default btn-link btn-icon btn-sm see"><i class="fa fa-file-alt"></i></a>
                      </td>
                    </tr>
                    <tr>
                      <th>Gorgonzola</th>
                      <td>Cedric Kelly</td>
                      <td>01/09/2018</td>
                      <td class="text-right">
                        <a href="#" class="btn btn-default btn-link btn-icon btn-sm see"><i class="fa fa-file-alt"></i></a>
                      </td>
                    </tr>
                    <tr>
                      <th>Pare de usar drogas</th>
                      <td>Airi Satou</td>
                      <td>01/09/2018</td>
                      <td class="text-right">
                        <a href="#" class="btn btn-default btn-link btn-icon btn-sm see"><i class="fa fa-file-alt"></i></a>
                      </td>
                    </tr>
                    <tr>
                      <th>Psicoterapia</th>
                      <td>Brielle Williamson</td>
                      <td>01/09/2018</td>
                      <td class="text-right">
                        <a href="#" class="btn btn-default btn-link btn-icon btn-sm see"><i class="fa fa-file-alt"></i></a>
                      </td>
                    </tr>
                    <tr>
                      <th>Sangue</th>
                      <td>Herrod Chandler</td>
                      <td>01/09/2018</td>
                      <td class="text-right">
                        <a href="#" class="btn btn-default btn-link btn-icon btn-sm see"><i class="fa fa-file-alt"></i></a>
                      </td>
                    </tr>
                    <tr>
                      <th>Barriga</th>
                      <td>Rhona Davidson</td>
                      <td>01/09/2018</td>
                      <td class="text-right">
                        <a href="#" class="btn btn-default btn-link btn-icon btn-sm see"><i class="fa fa-file-alt"></i></a>
                      </td>
                    </tr>
                    <tr>
                      <th>Olhos</th>
                      <td>Colleen Hurst</td>
                      <td>01/09/2018</td>
                      <td class="text-right">
                        <a href="#" class="btn btn-default btn-link btn-icon btn-sm see"><i class="fa fa-file-alt"></i></a>
                      </td>
                    </tr>
                    <tr>
                      <th>Ta quase acabando</th>
                      <td>Sonya Frost</td>
                      <td>01/09/2018</td>
                      <td class="text-right">
                        <a href="#" class="btn btn-default btn-link btn-icon btn-sm see"><i class="fa fa-file-alt"></i></a>
                      </td>
                    </tr>
                    <tr>
                      <th>Cuidado</th>
                      <td>Jena Gaines</td>
                      <td>01/09/2018</td>
                      <td class="text-right">
                        <a href="#" class="btn btn-default btn-link btn-icon btn-sm see"><i class="fa fa-file-alt"></i></a>
                      </td>
                    </tr>
                    <tr>
                      <th>Ninfomaniaco</th>
                      <td>Quinn Flynn</td>
                      <td>01/09/2018</td>
                      <td class="text-right">
                        <a href="#" class="btn btn-default btn-link btn-icon btn-sm see"><i class="fa fa-file-alt"></i></a>
                      </td>
                    </tr>
                    <tr>
                      <th>Saudavel</th>
                      <td>Charde Marshall</td>
                      <td>01/09/2018</td>
                      <td class="text-right">
                        <a href="#" class="btn btn-default btn-link btn-icon btn-sm see"><i class="fa fa-file-alt"></i></a>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
             <div class="text-center">
                  <button type="button" class="btn btn-primary btn-round toshow" id="showhide">Mostrar</button>
              </div>
              <!-- end content-->
            </div>
            <!--  end card  -->
          </div>
          <!-- end col-md-12 -->
        </div>
        <!-- end row -->
        
        <script>
        $('#datatable').DataTable({
	        "pagingType": "full_numbers",
	        "lengthMenu": [
	          [5, 10, 25, 50, -1],
	          [5, 10, 25, 50, "Todos"]
	        ],
	        responsive: true,
	        language: {
	          search: "_INPUT_",
	          searchPlaceholder: "Procurar registro",
	        }

	      });

	      var table = $('#datatable').DataTable();

	      // Ver Registro
	      table.on('click', '.see', function() {
	        $tr = $(this).closest('tr');

	        var data = table.row($tr).data();
	        alert('You press on Row: ' + data[0] + ' ' + data[1] + '\'s row.');
	      });
        
		$('#showhide').click(function(){
			
			if($(this).hasClass('toshow')){
				
				$('.col-md-4').removeClass('col-md-4').addClass('col-md-9');
				$('.pront').css('display','block');
				$(this).text('Minimizar');
				$(this).removeClass('toshow').addClass('tohide');
			}else{
				
				$('.col-md-9').removeClass('col-md-9').addClass('col-md-4');
				$('.pront').css('display','none');
				$(this).text('Mostrar');
				$(this).removeClass('tohide').addClass('toshow');
			}
		});
        </script>