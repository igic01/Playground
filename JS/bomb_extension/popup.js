// popup.js
const b_start = document.getElementById('b_start');
b_start.addEventListener('click', () =>{
    chrome.runtime.sendMessage({ from: "popup.js", data: "now" });
});