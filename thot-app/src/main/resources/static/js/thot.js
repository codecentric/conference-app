// Used by static sessions
(function () {
    // Enables detail links for the session overview
    $("table.table tbody tr.sessions").on("click", function () {
        var url = $(this).attr("data-link");
        window.location = url;
    });
}());