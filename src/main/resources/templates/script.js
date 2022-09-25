function changeAmount(val) {
    var element = document.getElementById("amount");
    var amount = parseInt(element.innerText);
    if (amount+val>=1) amount += val;
    else amount = 1;
    element.innerText = amount;
}