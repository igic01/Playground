// content.js

// Create a connection port
const port = chrome.runtime.connect({ name: "content" });

// Send a message to the background.js
chrome.runtime.sendMessage({ from: "content.js", data: "Hi, this is content.js! "});

// Listen for messages from the background.js
port.onMessage.addListener((message) => {
  if (message.from === "background.js") {
    // Handle the message from background.js
    console.log("Received message from background.js:", message.data);
  }
});
