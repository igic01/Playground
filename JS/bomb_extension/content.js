// content.js

const port = chrome.runtime.connect({ name: "content" });

// Listen for messages from the background.js
port.onMessage.addListener((message) => {
  if (message.from === "background.js") {
    // Handle the message from background.js
    monitorSyllableChanges();
  }
});

// Function to monitor changes to the innerHTML of elements with class "syllable"
function monitorSyllableChanges() {
  const target_div = document.querySelector(".syllable");

  const observer = new MutationObserver((mutationsList) => {
    mutationsList.forEach((mutation) => {
      console.log("target_div new value: ", mutation.target.innerHTML);
    });
  });

  // Start observing changes on each syllable element
  observer.observe(target_div, { characterData: true, childList: true, subtree: true });
}
