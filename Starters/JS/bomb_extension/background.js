// background.js

// Communication ports
let popupPort;
let contentPort;

chrome.runtime.onMessage.addListener((message, sender, sendResponse) => {
  // Check if the message is from a content script
  if (message.from === "content.js") {
    console.log("Received message from content.js:", message.data);

    // Send the message to the popup script (if connected)
    if (popupPort) {
      popupPort.postMessage({ from: "background.js", data: message.data });
    }
  }

  // Check if the message is from a popup script
  if (message.from === "popup.js") {
    console.log("Received message from popup.js:", message.data);

    // Send the message to the content script (if connected)
    if (contentPort) {
      contentPort.postMessage({ from: "background.js", data: message.data });
    }
  }
});

chrome.runtime.onConnect.addListener((port) => {
  // Check if the connection is from the popup or content script
  // Store the reference for the communication port

  if (port.name === "popup") {
    popupPort = port;

    popupPort.onDisconnect.addListener(() => {
      popupPort = null;
    });
  } else if (port.name === "content") {
    contentPort = port;

    contentPort.onDisconnect.addListener(() => {
      contentPort = null;
    });
  }
});
