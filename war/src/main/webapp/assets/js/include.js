$(function () {
    $('#menu, #top-menu').on('click', 'a[data-url]', function () {
        var url = $(this).data('url');
        var placement = $(this).data('placement');
        $(placement).load(url);
    });
});

