document.addEventListener('DOMContentLoaded', function () {
    const alertList = document.querySelectorAll('.alert');
    alertList.forEach(function (alert) {
        setTimeout(function () {
            alert.classList.add('fade');
            alert.classList.add('show');
        }, 50);
    });
});
