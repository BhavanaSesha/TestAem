
$(document).ready(function(){
		alert("invoked");
         $("#Accesories").hide();
        $("#Materials").hide();
        $('#all-unchecked').hide();

        <!-- unchecked  Function -->
$('#all-unchecked').click(function(){
        if(!$('input[name="Accesories"]').is(':checked') && !$('input[name="Materials"]').is(':checked'))
        {
			$('#all-unchecked').hide();
            $("#allData").show();
        }else{
			alert('atleast one is checked');

        }
    });
$('input[type=checkbox][name="Accesories"]').click(function(){

	$("#allData").hide();
	$("#Accesories").show();
	$('#all-unchecked').show();
	if($(this).prop("checked") == false){
               $("#Accesories").hide();
}
});
$('input[type=checkbox][name="Materials"]').click(function(){

	$("#allData").hide();
	$("#Materials").show();
	$('#all-unchecked').show();
	if($(this).prop("checked") == false){
               $("#Materials").hide();
}
});
 });
