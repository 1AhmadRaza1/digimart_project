$(document).ready(function(){
	alert("on load")
	$('#example1').DataTable( {
		//"processing": true,
        "serverSide": true, 
		"lengthMenu": [3, 5, 10],
        "ajax": {            
			//"type": "POST",
            "url": "list-stock-dataTable",
			"dataType":"json"
        },
        "columns": [
            { "data": "product_name"},
            { "data": "totalBycompany"},
            { "data": "company_name"},
            { "data": "amount"},
			{"data":"date_time"},
			{"data":"purchase_id",
				"render": function ( data, type, row ) {
                	var edit_data='edit-purchase/'+data;
                return '<a href="'+edit_data+'"> Edit </a>';
                }
			}
        ]
	});
});
