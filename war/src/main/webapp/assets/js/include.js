$(function () {
    $('#menu, #top-menu').on('click', 'a[data-url]', function () {
        var url = $(this).data('url');
        var placement = $(this).data('placement');
        $(placement).load(url);
    });

    var $contextElem = $('div[data-default]');
    if ($contextElem.length) {
        var contextId = $contextElem.attr('id');
        var defaultContext = $contextElem.data('default');
        $("#" + contextId).load(defaultContext);
    }


});

function ajaxSubmit(formId, outputId) {
    var $form = $(formId);

    $.ajax({
        type: 'POST',
        url: $form.attr('action'),
        data: {data: $form.serialize()},
        dataType: 'json',
        success: function (data) {
           // if(data.result == "ok")
            console.log("Success: ", JSON.stringify(data));
//            $(outputId).text(data);
        },
        error: function (data) {
            console.log("Error: ", JSON.stringify(data));
        }});
}