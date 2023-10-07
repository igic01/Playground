// popup.js

// Create a connection port
const port = chrome.runtime.connect({ name: "popup" });

// Send a message to the background.js
chrome.runtime.sendMessage({ from: "popup.js", data: "Hello from popup.js!" });

// Listen for messages from the background.js
port.onMessage.addListener((message) => {
  if (message.from === "background.js") {
    // Handle the message from background.js
    console.log("Received message from background.js:", message.data);
  }
});
