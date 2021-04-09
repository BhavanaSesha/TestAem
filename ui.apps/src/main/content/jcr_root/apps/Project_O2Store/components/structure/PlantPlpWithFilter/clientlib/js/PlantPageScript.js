$(document).ready(function(){
    alert("invoked");
    	$("#medicinal").hide();
        $("#foilage").hide();
        $("#flowering").hide();
        $("#RangeOne").hide();
        $("#RangeTwo").hide();
        $("#RangeThree").hide();
        $("#MedRange1").hide();
	    $("#MedRange2").hide();
    	$("#MedRange3").hide();
        $("#FlowRange1").hide();
	    $("#FlowRange2").hide();
 	    $("#FlowRange3").hide();
    	$("#FoilRange1").hide();
    	$("#FoilRange2").hide();
    	$("#FoilRange3").hide();
    function hide(){
        alert('hiding');
        $("#allData").hide();
		$("#medicinal").hide();
        $("#foilage").hide();
        $("#flowering").hide();
        $("#RangeOne").hide();
        $("#RangeTwo").hide();
        $("#RangeThree").hide();
        $("#MedRange1").hide();
	    $("#MedRange2").hide();
    	$("#MedRange3").hide();
        $("#FlowRange1").hide();
	    $("#FlowRange2").hide();
 	    $("#FlowRange3").hide();
        $("#FoilRange1").hide();
    	$("#FoilRange2").hide();
    	$("#FoilRange3").hide();
    }
    $("#btnCheck").click(function () {
        var checked = $("#plantdropdown input[type=checkbox]:checked").length;

        if (checked > 0) {
            alert(checked + " CheckBoxe(s) are checked.");
            if($('input[name="medicine"]').is(':checked') && !$('input[name="flowers"]').is(':checked') && !$('input[name="foilage"]').is(':checked') && !$('input[name="Range1"]').is(':checked') && !$('input[name="Range2"]').is(':checked') && !$('input[name="Range3"]').is(':checked'))
            {
                alert('medicine is selected');
                hide();
                $("#medicinal").show();

            }
            else  if(!$('input[name="medicine"]').is(':checked') && $('input[name="flowers"]').is(':checked') && !$('input[name="foilage"]').is(':checked') && !$('input[name="Range1"]').is(':checked') && !$('input[name="Range2"]').is(':checked') && !$('input[name="Range3"]').is(':checked'))
            {
                alert('flower is selected');
                hide();
                $("#flowering").show();
            }
            else  if(!$('input[name="medicine"]').is(':checked') && !$('input[name="flowers"]').is(':checked') && $('input[name="foilage"]').is(':checked') && !$('input[name="Range1"]').is(':checked') && !$('input[name="Range2"]').is(':checked') && !$('input[name="Range3"]').is(':checked'))
            {
                alert('foilage is selected');
                hide();
                $("#foilage").show();
            }
            else if(!$('input[name="medicine"]').is(':checked') && !$('input[name="flowers"]').is(':checked') && !$('input[name="foilage"]').is(':checked') && $('input[name="Range1"]').is(':checked') && !$('input[name="Range2"]').is(':checked') && !$('input[name="Range3"]').is(':checked'))
            {
                alert('range 1 selected');
                hide();
                 $("#RangeOne").show();
            }
            else if(!$('input[name="medicine"]').is(':checked') && !$('input[name="flowers"]').is(':checked') && !$('input[name="foilage"]').is(':checked') && !$('input[name="Range1"]').is(':checked') && $('input[name="Range2"]').is(':checked') && !$('input[name="Range3"]').is(':checked'))
            {
                alert('range 2 selected');
                hide();
                 $("#RangeTwo").show();

            }
            else if(!$('input[name="medicine"]').is(':checked') && !$('input[name="flowers"]').is(':checked') && !$('input[name="foilage"]').is(':checked') &&!$('input[name="Range1"]').is(':checked') && !$('input[name="Range2"]').is(':checked') && $('input[name="Range3"]').is(':checked'))
            {
                alert('range 3 selected');
                hide();
                $("#RangeThree").show();
            }
            else if($('input[name="medicine"]').is(':checked') && !$('input[name="flowers"]').is(':checked') && !$('input[name="foilage"]').is(':checked') && !$('input[name="Range1"]').is(':checked') && $('input[name="Range2"]').is(':checked') && !$('input[name="Range3"]').is(':checked'))
            {
                alert('medicine and range2 is selected ');
                hide();
                $("#MedRange2").show();

            }  
            else if($('input[name="medicine"]').is(':checked') && !$('input[name="flowers"]').is(':checked') && !$('input[name="foilage"]').is(':checked') && $('input[name="Range1"]').is(':checked') && !$('input[name="Range2"]').is(':checked') && !$('input[name="Range3"]').is(':checked'))
            {
                alert('medicine and range1 is selected');
                hide();
                $("#MedRange1").show();
            }
            else if($('input[name="medicine"]').is(':checked') && !$('input[name="flowers"]').is(':checked') && !$('input[name="foilage"]').is(':checked') && !$('input[name="Range1"]').is(':checked') && !$('input[name="Range2"]').is(':checked') && $('input[name="Range3"]').is(':checked'))
            {
                alert('medicine and range3 is selected');
                hide();
                $("#MedRange3").show();
            }
            else if(!$('input[name="medicine"]').is(':checked') && $('input[name="flowers"]').is(':checked') && !$('input[name="foilage"]').is(':checked') && $('input[name="Range1"]').is(':checked') && !$('input[name="Range2"]').is(':checked') && !$('input[name="Range3"]').is(':checked'))
            {
                alert('flowers and range1 is selected');
                hide();
                $("#FlowRange1").show();
            }
            else if(!$('input[name="medicine"]').is(':checked') && $('input[name="flowers"]').is(':checked') && !$('input[name="foilage"]').is(':checked') && !$('input[name="Range1"]').is(':checked') && $('input[name="Range2"]').is(':checked') && !$('input[name="Range3"]').is(':checked'))
            {
                 alert('flowers and range2 is selected');
                hide();
                $("#FlowRange2").show();
            }
            else if(!$('input[name="medicine"]').is(':checked') && $('input[name="flowers"]').is(':checked') && !$('input[name="foilage"]').is(':checked') && !$('input[name="Range1"]').is(':checked') && !$('input[name="Range2"]').is(':checked') && $('input[name="Range3"]').is(':checked'))
            {
                alert('flowers and range3 is selected');
                hide();
                $("#FlowRange3").show();
            }
            else if(!$('input[name="medicine"]').is(':checked') && !$('input[name="flowers"]').is(':checked') && $('input[name="foilage"]').is(':checked') && $('input[name="Range1"]').is(':checked') && !$('input[name="Range2"]').is(':checked') && !$('input[name="Range3"]').is(':checked'))
            {
                alert('floilage and range1 is selected');
                hide();
                $("#FoilRange1").show();
            }
            else if(!$('input[name="medicine"]').is(':checked') && !$('input[name="flowers"]').is(':checked') && $('input[name="foilage"]').is(':checked') && !$('input[name="Range1"]').is(':checked') && $('input[name="Range2"]').is(':checked') && !$('input[name="Range3"]').is(':checked'))
            {
                alert('floilage and range2 is selected');
                hide();
                $("#FoilRange2").show();
            }
            else if(!$('input[name="medicine"]').is(':checked') && !$('input[name="flowers"]').is(':checked') && $('input[name="foilage"]').is(':checked') && !$('input[name="Range1"]').is(':checked') && !$('input[name="Range2"]').is(':checked') && $('input[name="Range3"]').is(':checked'))
            {
                alert('floilage and range3 is selected');
                hide();
                $("#FoilRange3").show();
            }
            else{
                alert('Kindly select one checkbox from respective filter');
            }

            return true;
        } else {
            alert("No FIlter Active");
			hide();
            $("#allData").show();
            return false;
        }
    });
  });