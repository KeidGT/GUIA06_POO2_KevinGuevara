$(document).ready(function() {
    $.fn.initBootTable = function() {
        $(this).bootstrapTable('destroy');
        $(this).bootstrapTable().
        unbind('check.bs.table').on('check.bs.table', function (e, row) {
            consObje([{name : 'codiObjePara', value : row.id.trim()}]);
        });
        return false;
    };
    //Eliminar
    $.fn.funcElimRegi = function() {
        $(this).confirmation(
        {
            popout: true,
            onConfirm: function() {
                //elimObje();
                $('[data-toggle="confirmation-popout"]').confirmation('hide');
                return false;
            },
            onCancel: function()
            {
                $('[data-toggle="confirmation-popout"]').confirmation('hide');
                return false;
            }
        });
        return false;
    };
    responsive();
    INIT_OBJE();
});
function INIT_OBJE()
{
    $("#TablRegi").initBootTable();
    $("#FormRegi\\:btonElim").funcElimRegi();
    //ocultarCodigo();
    //setTimeout('ocultarCodigo()',800);
    
}
window.onresize = function(event) {
    responsive();
};
function responsive(){
    var ancho = document.documentElement.clientWidth; 
    if(ancho > 660){
        $("#divFrm").addClass("col-md-4");
        $("#divFrm").addClass("col-xs-4");
        $("#divTbl").addClass("col-md-8");
        $("#divTbl").addClass("col-xs-8");
        
        $("#divFrm").removeClass("col-md-12");
        $("#divFrm").removeClass("col-xs-12");
        $("#divTbl").removeClass("col-md-12");
        $("#divTbl").removeClass("col-xs-12");
        
        $("div.input-group").removeClass("col-lg-12");
        $("div.input-group").addClass("col-md-12");
        
    }else if(ancho <= 660){
        $("#divFrm").removeClass("col-md-4");
        $("#divFrm").removeClass("col-xs-4");
        $("#divTbl").removeClass("col-md-8");
        $("#divTbl").removeClass("col-xs-8");
        
        $("#divFrm").addClass("col-md-12");
        $("#divFrm").addClass("col-xs-12");
        $("#divTbl").addClass("col-md-12");
        $("#divTbl").addClass("col-xs-12");
        
        $("div.input-group").removeClass("col-md-12");
        $("div.input-group").addClass("col-lg-12");
    }
}
/*
function ocultarCodigo(){
    $("#TablRegi th:nth-child(1)").attr("style", "display: none;");
    $("#TablRegi td:nth-child(1)").attr("style", "display: none;");
    $("#TablRegi th:nth-child(2)").attr("style", "display: none;");
    $("#TablRegi td:nth-child(2)").attr("style", "display: none;");
}*/