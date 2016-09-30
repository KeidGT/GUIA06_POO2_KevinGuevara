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
                elimObje();
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
    INIT_OBJE();
});
function INIT_OBJE()
{
    $("#TablRegi").initBootTable();
    $("#FormRegi\\:btonElim").funcElimRegi();
    //ocultarCodigo();
    //setTimeout('ocultarCodigo()',800);
    
}
/*
function ocultarCodigo(){
    $("#TablRegi th:nth-child(1)").attr("style", "display: none;");
    $("#TablRegi td:nth-child(1)").attr("style", "display: none;");
    $("#TablRegi th:nth-child(2)").attr("style", "display: none;");
    $("#TablRegi td:nth-child(2)").attr("style", "display: none;");
}*/