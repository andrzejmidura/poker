var stompClient = null;
const Http = new XMLHttpRequest();
const url='/game/getCredits';

var inFormOrLink;
$('a').on('click', function() { inFormOrLink = true; });
$('form').on('submit', function() { inFormOrLink = true; });

$(window).on("beforeunload", function() {
    return inFormOrLink ? disconnect() : null;
})

function connect() {
    getCredits();
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect(
        {}, function (frame) {
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/game', function (messageToAllSubscribers) {
                    receiveMessageToAllSubscribers(JSON.parse(messageToAllSubscribers.body).content);
            });
        }
    );
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}

function receiveMessageToAllSubscribers(message) {
    console.log(message);
}

function sendPlayerMessage(name) {
    stompClient.send("/app/message", {}, JSON.stringify({ 'action': $(name).val(),
                                                                'value': $("#amount").val()}));
}

function getCredits() {
    Http.open("GET", url);
    Http.send();

    Http.onreadystatechange = () => {
        console.log(Http.responseText);
        var creditsDiv = document.getElementById("credits");
        creditsDiv.innerText = Http.responseText;
    }
}

function changeAmount(val) {
    var element = document.getElementById("amount");
    var amount = parseInt(element.innerText);
    if (amount+val>=1) amount += val;
    else amount = 1;
    element.innerText = amount;
}