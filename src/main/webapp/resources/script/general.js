function timer(){
    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth();
    var days = date.getDate();

    var hour= date.getHours();
    var minutes= date.getMinutes();
    var second= date.getSeconds();

    if (days < 10) {days = "0" + days;}
    if (hour < 10) {hour = "0" + hour;}
    if (minutes < 10) {minutes = "0" + minutes;}
    if (second < 10) {second = "0" + second;}

    document.getElementById("date").innerHTML = "Dzisiaj jest " + days + ' ' + getMonth(month) + ' ' + year + ' roku';
    document.getElementById("time").innerHTML = "Aktualny czas: " + hour + ':' + minutes + ':' + second;

    setTimeout("timer()", 1000);
}

function getMonth(month) {
    if (month === 0) {return "Styczeń"};
    if (month === 1) {return "Luty"};
    if (month === 2) {return "Marzec"};
    if (month === 3) {return "Kwiecień"};
    if (month === 4) {return "Maj"};
    if (month === 5) {return "Czerwiec"};
    if (month === 6) {return "Lipiec"};
    if (month === 7) {return "Sierpień"};
    if (month === 8) {return "Wrzesień"};
    if (month === 9) {return "Październik"};
    if (month === 10) {return "Listopad"};
    if (month === 11) {return "Grudzień"};
}