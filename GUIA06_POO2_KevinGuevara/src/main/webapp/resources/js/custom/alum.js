$(document).ready(function() {
    $.fn.initBootTable = function() {
        $(this).bootstrapTable('destroy');
        $(this).bootstrapTable().
        on('check.bs.table', function (e, row) {
            setMessage('MESS_SUCC', 'Atención', 'Ha seleccionado a: ' + row.nomb.trim());
        });
        return false;
    };
    
    INIT_OBJE_ALUM();
});

function INIT_OBJE_ALUM()
{
    $("#TablAlum").initBootTable();
}