/*function mostrarEquipos(){
    document.getElementById("manEquipos").style.display = "block";
    document.getElementById("manCualquierCosa").style.display = "none";
}
function mostrarOtraCosa(){
    document.getElementById("manCualquierCosa").style.display = "block";
    document.getElementById("manEquipos").style.display = "none";
}*/
function buscarRegistro(idTxt, idTb){
    var tableReg = document.getElementById(idTb);
    var searchText = document.getElementById(idTxt).value.toLowerCase();
    var cellsOfRow="";
    var found=false;
    var compareWith="";

    // Recorremos todas las filas con contenido de la tabla
    for (var i = 1; i < tableReg.rows.length; i++)
    {
            cellsOfRow = tableReg.rows[i].getElementsByTagName('td');
            found = false;
            // Recorremos todas las celdas
            for (var j = 0; j < cellsOfRow.length && !found; j++)
            {
                    compareWith = cellsOfRow[j].innerHTML.toLowerCase();
                    // Buscamos el texto en el contenido de la celda
                    if (searchText.length == 0 || (compareWith.indexOf(searchText) > -1))
                    {
                            found = true;
                    }
            }
            if(found)
            {
                    tableReg.rows[i].style.display = 'table-row';
            } else {
                    // si no ha encontrado ninguna coincidencia, esconde la
                    // fila de la tabla
                    tableReg.rows[i].style.display = 'none';
            }
    }
}

/*function seleccionarElemento(id){
    document.getElementById("test"+id).checked = true;
    document.getElementById("btnConsultar").click();
}*/
function enabledID(){
    var txtId = document.getElementById("disabled");
    txtId.removeAttribute("disabled");
}
/*
function resetForm(id){
   document.getElementById(id).reset();
}*/
function inicBtn(){
    $("#btnGuardar").removeClass('disabled');
    $("#btnModificar").addClass('disabled');
    $("#btnEliminar").addClass('disabled');
}
function botones(estado){//se utilizará para jugar con los botones
    if(estado){
        $("#btnGuardar").parent().removeClass('disabled');
        $("#btnModificar").parent().addClass('disabled');
        $("#btnEliminar").parent().addClass('disabled');
    }else{
        $("#btnGuardar").parent().addClass('disabled');
        $("#btnModificar").parent().removeClass('disabled');
        $("#btnEliminar").parent().removeClass('disabled');
    }
}
function ocultar(){
    $("#tbData th:last-child").attr("style", "display: none;");
    $("#tbData td:last-child").attr("style", "display: none;");
    $("#tbData thead").attr("style", "display: none;");
}
var btn =document.getElementById("btnReporte");
function seleccionarElemento(){
$("#tbData tr").click(function(event) {
    var id = $(this).find("td:last-child").html();
    //var nombre = $(this).find("td:nth-child(1)").html();
    document.getElementById("FormCons:codigo").value = id;
    var btn = document.getElementById("FormCons:btnConsultar");
    btn.click();
    //setMessage('MESS_SUCC', 'Ha seleccionado a: ' + nombre.trim());
    setTimeout('$("select").material_select()',800);//se genera un retraso, ya que la construcción del
    //select es mas veloz que la petición ajax
    
});
}