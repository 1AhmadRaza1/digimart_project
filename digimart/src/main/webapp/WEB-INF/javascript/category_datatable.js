$(document).ready(function(){
	alert("on load")
	$('#example1').DataTable( {
		//"processing": true,
        "serverSide": true, 
		"lengthMenu": [3, 5, 10],
        "ajax": {            
			//"type": "POST",
            "url": "list-dataTable",
			"dataType":"json"
        },
        "columns": [
            { "data": "category_name"},
            { "data": "category_prority"},
            { "data": "category_description"},
            { "data": "category_photo",
            	 render: function (data, type, row, meta) {
        			var imgsrc = 'data:image/jpg;base64,' + data;
        			return '<img src="' + imgsrc +'" height="100px" width="100px">';
    			}
            },
            { "data": "category_id",
                "render": function ( data, type, row ) {
                	var edit_data='edit-category/'+data;
                	var delete_data='delete-category-by/'+data;
                return '<a href="'+edit_data+'"> Edit </a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="'+delete_data+'">Delete </a>';
                }   	
            },
        ]
	});
});
