async function sendButton() {

    const response = await fetch("/api/button", {
        method: "POST"
    });

    const text = await response.text();

    document.getElementById("result").innerText = text;
}