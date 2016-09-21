function setMessage(tipo, msg) 
{
    toastr.options = {
        "closeButton": false,
        "debug": false,
        "newestOnTop": true,
        "progressBar": false,
        "positionClass": "toast-top-right",
        "preventDuplicates": false,
        "onclick": null,
        "showDuration": "300",
        "hideDuration": "1000",
        "timeOut": "5000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    }
    if (tipo === 'MESS_WARN')
    {
        toastr.warning(msg);
    }
    else if (tipo === 'MESS_ERRO')
    {
        toastr.error(msg);
    }
    else if (tipo === 'MESS_SUCC')
    {
        toastr.success(msg);
    }
    else if (tipo === 'MESS_INFO')
    {
        toastr.info(msg);
    }
}