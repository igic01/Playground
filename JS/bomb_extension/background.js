// background.js

let contentPort;

chrome.storage.local.clear();
chrome.runtime.onMessage.addListener((message, sender, sendResponse) => {
  // Check if the message is from a popup script
  if (message.from === "popup.js") {
   
    // Send the message to the content script (if connected)
    if (contentPort) {
      contentPort.postMessage({ from: "background.js", data: message.data });
    }
  }
});


chrome.runtime.onConnect.addListener((port) => {
  if (port.name === "content") {
    contentPort = port;

    contentPort.onDisconnect.addListener(() => {
      contentPort = null;
    });
  }
});
